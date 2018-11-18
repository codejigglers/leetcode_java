import java.util.Arrays;

public class ClosestHouse {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] houses = new int[]{5, 10, 17};
        int[] shops = new int[]{1, 5, 20, 11, 16};

        for (int i : solution.solution(shops, houses)) {
            System.out.println(i);
        }

    }

    private static class Solution {
        public int[] solution(int[] stores, int[] houses) {
            Arrays.sort(stores);
            int[] answer = new int[houses.length];
            int count = 0;
            for (int target : houses) {
                answer[count] = findClosest(stores, stores.length, target);
                count+=1;
            }
            return answer;
        }

        int findClosest(int arr[], int n, int target) {
            if (target <= arr[0])
                return arr[0];
            if (target >= arr[n - 1])
                return arr[n - 1];
            int i = 0, j = n, mid = 0;
            while (i < j) {
                mid = (i + j) / 2;
                if (arr[mid] == target)
                    return arr[mid];
                if (target < arr[mid]) {
                    if (mid > 0 && target > arr[mid - 1])
                        return getClosest(arr[mid - 1],
                                arr[mid], target);
                    j = mid;
                } else {
                    if (mid < n - 1 && target < arr[mid + 1])
                        return getClosest(arr[mid],
                                arr[mid + 1], target);
                    i = mid + 1;
                }
            }
            return 7;
        }

        public static int getClosest(int val1, int val2,
                                     int target) {
            if (target - val1 >= val2 - target)
                return val2;
            else
                return val1;
        }
    }
}