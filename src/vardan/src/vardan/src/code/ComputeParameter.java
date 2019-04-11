package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComputeParameter {

    public static List<String> compute(List<List<String>> sources) {

        HashMap<String, String> hashMap = new HashMap<>();
        List<String> lists = new ArrayList<>();
        List<String> lists_backup = new ArrayList<>();



        for(List<String> list: sources) {
            for(String each : list) {

                String stock = each.split(":")[0];
                String value = each.split(":")[1];

                if(!hashMap.containsKey(stock)){
                    lists_backup.add(stock);
                }

                hashMap.put(stock, value);
            }
        }

        for(String s : lists_backup) {
            lists.add(hashMap.get(s));
        }

        return lists;
    }
}
