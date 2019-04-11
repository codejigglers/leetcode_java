import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Solution by Jeff Kirby. I wrote this after I was hired to evaluate the question and recent responses.
 *
 * Note that this doesn't truly find the "optimal set". For the given data it's good enough just to sort the combos
 * by discount and start by evaluating the combo with best discount.
 *
 * However it would easily be possible to construct an example where a thousand $1 discounts would be better than
 * one $500 discount. This would be pretty tough to code a solution for.
 */
public class OptimalSet {

    public static class Item {

        String id;
        String name;
        Long price;
    }

    public static class Category {

        String id;
        String name;
        List<Item> items;
    }

    public static class Combo {

        String id;
        String name;
        Long discount;
        List<String> categories;
        Map<String, Integer> categoryCounts = new HashMap<>();
    }

    public static class Inventory {

        List<Category> categories;
        List<Combo> combos;
    }

    public static class OrderInfo {

        Long id;
        List<String> items;
    }

    public static class InputData {

        Inventory inventory;
        List<OrderInfo> orders;
    }

    public static void main(String[] args) {
        try {
            Gson gson = new GsonBuilder().create();

            // Read in the inventory and the orders
            InputStreamReader inp = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(inp);
            InputData input = gson.fromJson(br, InputData.class);

            // Create some objects that contain the categories and combos for possible use
            List<Category> categories = input.inventory.categories;
            List<Combo> combos = input.inventory.combos;

            // map item id's to their category id
            final Map<String, String> itemToCategoryMap = new HashMap<>(categories.size());
            final Map<String, Category> categoryMap = new HashMap<>(categories.size());
            final Map<String, Item> itemMap = new HashMap<>(categories.size());
            for (final Category category : categories) {
                for (final Item item : category.items) {
                    itemToCategoryMap.put(item.id, category.id);
                    categoryMap.put(category.id, category);
                    itemMap.put(item.id, item);
                }
            }
            // map of combos and how many categories they require by id
            final Map<String, Combo> comboMap = new HashMap<>(combos.size());
            for (final Combo combo : combos) {
                for (final String id : combo.categories) {
                    increment(combo.categoryCounts, id);
                }
                comboMap.put(combo.id, combo);
            }
            // Loop over each test order and construct it
            for (OrderInfo order : input.orders) {
                final Map<String, Integer> ordersCategoryCounts = new HashMap<>(order.items.size());
                System.out.println("Order : " + order.id);
                for (String itemId : order.items) {
                    final Set<Combo> possibleCombos = new HashSet<>(combos.size());
                    Collection<String> currentComboIds = Collections.emptyList();
                    System.out.println("  Adding item : " + itemId);
                    // Calculate the current combos

                    // Add code here, feel free to add / edit any other code (apart from these two printlns)

                    // get the category
                    final String categoryId = itemToCategoryMap.get(itemId);
                    if (categoryId != null) {
                        debug(categoryMap.get(categoryId).name + " (" + itemMap.get(itemId).name + ")");
                        // increment our counts of categories in the order
                        increment(ordersCategoryCounts, categoryId);
                        // Go through each combo and see if we have enough categories to qualify.
                        // See how many times we can re-use just this combo. We'll optimize sets of combos later.
                        for (Combo possibleCombo : combos) {
                            final Map<String, Integer> copyCounts = new HashMap<>(ordersCategoryCounts);
                            // see if we qualify for the combo until we run out of categories
                            while (isQualifiedCombo(possibleCombo, copyCounts, categoryMap)) {
                                // construct a new Combo so that the Set can contain duplicate combo ids
                                final Combo copy = new Combo();
                                copy.discount = possibleCombo.discount;
                                copy.id = possibleCombo.id;
                                possibleCombos.add(copy);
                            }
                        }
                        // now look at all possible sets and find the one with the best discount
                        currentComboIds = findOptimalComboSets(possibleCombos, ordersCategoryCounts, categoryMap);
                    }
                    System.out.println("  Combos : " + currentComboIds);
                    printDiscount(possibleCombos);
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error " + e.getLocalizedMessage());
        }
    }

    /**
     * Increment the value at the given id
     */
    private static void increment(Map<String, Integer> counts, String id) {
        Integer count = counts.get(id);
        if (count == null) {
            count = 0;
        }
        counts.put(id, count + 1);
    }

    /**
     * Find the optimal set of combos. From the given set of possible combos, see which combinations qualify as a set
     * and which one gives the best discount
     * @param combos all possible combos. includes duplicates to represent that some combos can be used more than once
     * @param ordersCategoryCounts what's in the current order
     * @return list of combo ids. can contain duplicates to represent re-using a combo
     */
    private static Collection<String> findOptimalComboSets(final Set<Combo> combos,
                                                           final Map<String, Integer> ordersCategoryCounts, Map<String, Category> categoryMap
    ) {
        long maxDiscount = 0;
        Collection<Combo> optimal = Collections.emptySet();
        // generate all combinations of the combos
        for(Set<Combo> set : Sets.powerSet(combos)) {
            // Make sure that we qualify for all the combos in the set
            final long discount = sumQualifiedSet(set, ordersCategoryCounts, categoryMap);
            if(discount < maxDiscount) {
                maxDiscount = discount;
                optimal = set;
            }
        }
        return optimal.stream().map(combo -> combo.id).collect(Collectors.toList());
    }

    private static long sumQualifiedSet(Iterable<Combo> set, Map<String, Integer> ordersCategoryCounts, Map<String, Category> categoryMap) {
        long discount = 0;
        final Map<String, Integer> copy = new HashMap<>(ordersCategoryCounts);
        for(Combo combo : set) {
            if(!isQualifiedCombo(combo, copy, categoryMap)) {
                return 0;
            }
            discount += combo.discount;
        }
        return discount;
    }

    /**
     * @return whether the order qualifies for the given combo
     */
    private static boolean isQualifiedCombo(Combo combo,
                                            Map<String, Integer> ordersCategoryCountsCopy, Map<String, Category> categoryMap
    ) {
        for (Map.Entry<String, Integer> categoryCount : combo.categoryCounts.entrySet()) {
            final Integer have = ordersCategoryCountsCopy.get(categoryCount.getKey());
            if (have == null || have < categoryCount.getValue()) {
                return false;
            }
        }
//    debug("    qualifies for " + combo.discount + " " + combo.id + " " + combo.name);
        // decrement the remaining categories used
        for (Map.Entry<String, Integer> categoryCount : combo.categoryCounts.entrySet()) {
            final Integer amount = ordersCategoryCountsCopy.get(categoryCount.getKey());
            ordersCategoryCountsCopy.put(categoryCount.getKey(), amount - categoryCount.getValue());
//      debug("    " + categoryCount.getValue() + " " + categoryMap.get(categoryCount.getKey()).name);
        }
        return true;
    }

    /////// debug helpers //////////////////////////////////////////////////////////////////////////////////////////

    private static void printDiscount(Iterable<Combo> currentComboIds) {
        long discount = 0;
        for(Combo combo : currentComboIds) {
            discount += combo.discount;
        }
        debug("total discount: " + discount);
    }

    private static void debug(Object o) {
        System.out.println("         " + o);
    }
}
