public class MaxRepetetionInArray {

    public static void main(String[] args) {

        int[] ans = new int[]{1, 2, 3, 3, 4, 4, 4};
        int start = 0;
        int count = -1;
        int anss = -1;

        while (start < ans.length) {
            int i = start;
            int temp = start;
            while (i < ans.length) {
                if (ans[i] >= 0) {

                    if (ans[ans[i]] < 1) {
                        ans[ans[i]] -= ans[i];
                        int y = Math.abs(ans[ans[i]] / ans[i]);
                        if (y > count) {
                            anss = ans[i];
                            count = y;
                        }
                        break;
                    } else {
                        temp = ans[ans[i]];
                        ans[ans[i]] = -ans[i];
                        if (count < 1) {
                            anss = ans[i];
                            count = 1;
                        }
                        i = temp;
                    }
                } else {
                    break;
                }
            }
            start += 1;
        }

        System.out.println(anss);
    }
}
