import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
    }

    // Complete the hasVowels function below.
    static List<Integer> hasVowels(List<String> strArr, List<String> query) {

        HashMap<Integer, Integer> hMap = new HashMap<>();
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        List<Integer> toReturn = new ArrayList<>();

        for(int i = 0; i < strArr.size(); i++){

            if(vowelSet.contains(strArr.get(i).charAt(0)) && vowelSet.contains(strArr.get(i).charAt(strArr.get(i).length() - 1))){
                if(hMap.isEmpty()){
                    hMap.put(i + 1, 1);
                }else{
                    hMap.put(i + 1, hMap.get(i) + 1);
                }
            }else{
                if(hMap.isEmpty()){
                    hMap.put(i + 1, 0);
                }else{
                    hMap.put(i + 1, hMap.get(i) + 0);
                }
            }
        }

        for(int i = 0; i < query.size(); i++){
            String[] index = query.get(i).split("-");
            System.out.println(index[0]);
            if(index[0] == index[1]){
                int n = (int)hMap.get(index[0]);
                toReturn.add(n);
            }
            else{
                int n = (int)hMap.get(index[1]);
                int m = (int)hMap.get(index[0]);
                toReturn.add(n - m + 1);

            }
        }

        return toReturn;
    }
}
