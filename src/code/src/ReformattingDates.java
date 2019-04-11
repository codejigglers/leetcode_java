import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReformattingDates {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("20th Oct 2052");
        arrayList.add("6th Jun 1933");
        arrayList.add("26th May 1960");

        for(String s : reformatDate(arrayList)) {
            System.out.println(s);
        }
    }

    public static List<String> reformatDate(List<String> dates) {

        HashMap<String, String> month = new HashMap<>();
        month.put("Jan", "01");
        month.put("Feb", "02");
        month.put("Mar", "03");
        month.put("Apr", "04");
        month.put("May", "05");
        month.put("Jun", "06");
        month.put("Jul", "07");
        month.put("Aug", "08");
        month.put("Sep", "09");
        month.put("Oct", "10");
        month.put("Nov", "11");
        month.put("Dec", "12");

        ArrayList<String> ans = new ArrayList<>();
        for(String date : dates) {
            String[] a = date.split(" ");
            String dt1 = a[0].substring(0, a[0].length() - 2);;
            String mn = a[1];
            String yy = a[2];
            String acDt;
            if(dt1.length() == 1) {
                acDt = "0".concat(dt1);
            }
            else {
                acDt = dt1;
            }
            ans.add(yy+"-"+month.get(mn)+"-"+acDt);
        }
        return ans;
    }

}
