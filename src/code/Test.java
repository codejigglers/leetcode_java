package code;

public class Test {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 3, 7, 3, 6, 2};
        int x = 0;
        for (int i = 0; i < arr.length ; i++) {
            if ( arr[i] >= 6 ) {
                i++;
            } else {
                x += arr[i];
            }
        }

        System.out.println(result(4));
    }

    static int result(int n) {
        if (n == 1) {
            return 2;
        } else {
            return 2 * result(n-1);
        }
    }
}
