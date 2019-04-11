import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DJCode {

    public static void main(String[] args) {
        for (String s : missingWords("A B M A A", "B A")) {
            System.out.println(s);
        }
    }


    public static List<String> missingWords(String s, String t) {
        String ss[] = s.split(" ");
        String tt[] = t.split(" ");
        List<String> answer = new ArrayList<>();
        int indexs = 0;
        int indext = 0;

        while (indext < tt.length && indexs < ss.length) {

            if (ss[indexs].equals(tt[indext])) {
                indexs += 1;
                indext += 1;
            } else {
                answer.add(ss[indexs]);
                indexs += 1;
            }

        }
        if(indexs < ss.length ) {
            while (indexs < ss.length) {
                answer.add(ss[indexs]);
                indexs+=1;
            }
        }
        return answer;
    }
}
