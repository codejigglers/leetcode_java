import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AkashQ {


    public static void main(String[] args) {


        List<Integer> arraylist = new ArrayList<>();

        arraylist.add(11);
        arraylist.add(2);
        arraylist.add(7);
        arraylist.add(3);



    }


    public static int countStudents(List<Integer> height) {


        List<Integer> a = new ArrayList<>(height);
        Collections.sort(a);

        int error = 0;

        for(int i =0; i<height.size(); i++) {

            if(height.get(i) != a.get(i)) {
                error+=1;
            }
        }


        return error;
    }
}
