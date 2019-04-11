import java.util.ArrayList;

public class nullChecker {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);

        ArrayList<Integer> b = arrayList;

        arrayList = null;

        for(int i : b) {
            System.out.println(i);
        }

        System.out.println(arrayList == null);
    }
}
