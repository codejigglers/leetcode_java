public class RecursionComplexity {

    public static void main(String[] args) {
        System.out.println(method(100));
    }

    public static int method(int n) {
        if(n <= 1) {
            return 1;
        } else {
            return method(n - 1) + method(n - 1);
        }
    }
}
