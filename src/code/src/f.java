import java.util.ArrayList;
import java.util.Collections;

public class f {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(2);

        int i = Collections.max(a);

        if(Collections.frequency(a, i)>1){
            return;
        }
    }
}
