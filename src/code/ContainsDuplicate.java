package code;

import java.util.HashSet;

public class ContainsDuplicate {

    public static Boolean containsDuplicate(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();

        for(int i:nums){
            if(hashSet.contains(i)){
                return true;
            }
            else {
                hashSet.add(i);
            }
        }
        return false;
    }
}
