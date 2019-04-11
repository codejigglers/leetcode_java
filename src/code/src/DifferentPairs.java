import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DifferentPairs {

    public static void main(String[] args) {
        System.out.println(differentPair(new ArrayList<>(), 6));
    }

    public static int differentPair(List<Integer> input, int target) {

        HashMap<Integer, Integer> record = new HashMap<>();
        int count = 0;

        for(int i : input) {
            if(record.containsKey(i)) {
                record.put(i, record.get(i) + 1);
            }
            else {
                record.put(i, 1);
            }
        }

        for(int i : input) {
            if(record.containsKey(target - i) && record.containsKey(i) ) {
                if(target - i == i) {
                    if(record.get(i) >= 2) {
                        count += 1;
                        record.remove(i);
                    }
                }

                else {
                    record.remove(i);
                    record.remove(target - i);
                    count += 1;
                }
            }
        }

        return count;

    }
}
