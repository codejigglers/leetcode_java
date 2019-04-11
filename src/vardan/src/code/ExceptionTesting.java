package code;

import java.util.ArrayList;

public class ExceptionTesting {

    public static void main(String[] args) {


        ArrayList<String> ans = new ArrayList<>();
        ans.add(null);
        Integer x = null;
        System.out.println(x - 2);
        System.out.println(ans.size());
        String s = null;
            try {
                divideZero();
            }
            catch (ArithmeticException e) {
                System.out.println("Yahop");
            }
            catch (NullPointerException e) {
                System.out.println("Vardan");
            }

    }

    public static void divideZero() {
        try {
            int s = 2/0;
        }
        catch (Exception e) {
            System.out.println("Cannot process this");
        }
    }
}
