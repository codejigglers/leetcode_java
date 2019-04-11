package code;

public class ShuffleArray {
    public static void main(String[] args) {
        GFG cfg = new GFG();
        int[] a = new int[]{1,2,3,4,5,7,6,8};
        cfg.shufleArray(a, 9);
    }

    static class GFG {

        public static void shufleArray(int[] a, int n) {
            int temp;
            n = n / 2;

            for (int start = n + 1, j = n + 1, done = 0, i;
                 done < 2 * n - 2; done++) {
                if (start == j) {
                    start--;
                    j--;
                }

                i = j > n ? j - n : j;
                j = j > n ? 2 * i : 2 * i - 1;
                temp = a[start];
                a[start] = a[j];
                a[j] = temp;

            }

            System.out.println("");
        }

    }
}
