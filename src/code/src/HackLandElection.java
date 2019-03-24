import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class HackLandElection {

    public static void main(String[] args) {
        String[] s = new String[] {"AB", "AB", "A", "A"};
        System.out.println(electionWinner(s));
    }

    static String electionWinner(String[] str) {

        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int maxOccur = -1;
        for(String val : str) {
            if(hashMap.containsKey(val)) {
                hashMap.put(val, hashMap.get(val) + 1);
            }
            else {
                hashMap.put(val, 1);
            }
            if(maxOccur<hashMap.get(val)){
                maxOccur = hashMap.get(val);
            }
        }

        for(String s : hashMap.keySet()) {
            if(hashMap.get(s) == maxOccur) {
                arrayList.add(s);
            }
        }

        Collections.sort(arrayList.subList(1, arrayList.size()));

        return arrayList.get(arrayList.size() - 1);
    }
}
