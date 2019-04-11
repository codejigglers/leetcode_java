package code;

public class BooleanTest {

    public static void main(String[] args) {
        method();
    }

    public static void method() {
        Boolean a = null;

        try {
            if (2>1 && a) {
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


}
