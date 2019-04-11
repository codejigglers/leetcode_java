import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lytx {

    public static int minMoves(List<Integer> avg) {
        int N = avg.size();
        int left = 0;
        int right = avg.size() - 1;
        int res = 0;
        while (left < right) {
            if (avg.get(left) == 1) {
                left++;
                continue;
            }
            if (avg.get(right) == 0) {
                right--;
                continue;
            }
            res += (right - left);
            swap(avg, left, right);
            left++;
            right--;
        }
        return res;
    }

    private static void swap(List<Integer> avg, int i, int j) {
        // TODO Auto-generated method stub
        int temp = avg.get(i);
        avg.set(i, avg.get(j));
        avg.set(j, temp);
    }
    // Driver Code
    public static void main(String args[])
    {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0,0,1));
        System.out.println(minMoves(a));
    }

}
