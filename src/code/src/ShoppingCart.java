import java.util.HashMap;
import java.util.List;

public class ShoppingCart {

    public static int findLowestPrice(List<List<String>> products, List<List<String>> discounts) {

        HashMap<String, Integer[]> hashMap = new HashMap<>();

        for(List<String> s : discounts){
            hashMap.put(s.get(0), new Integer[]{Integer.parseInt(s.get(1)), Integer.parseInt(s.get(2))});
        }

        int finalAns;

        for(List<String> s: products){
            int totalPrice = Integer.parseInt(s.get(0));
            int minPrice = 10000000;

            for(int i=1; i<s.size()-1; i++) {
                if(s.get(i).equals("EMPTY")){
                    Math.min(minPrice, totalPrice);
                }
                else if(hashMap.get(s.get(i))[0] == 0) {

                }
            }
        }

        return 2;
    }


}
