package code;

public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{4,3,2,1,0};
        System.out.println(solution.maxChunksToSorted(a));
    }

    static class Solution {
        public int maxChunksToSorted(int[] arr) {
            int count = 0;
            int interim = -1;
            int i = 0;
            int max = -1;
            while (i < arr.length) {
                if(arr[i] > max) {
                    max = arr[i];
                    interim +=1;
                    if(interim == max) {
                        count+=1;
                    }
                    i+=1;
                    continue;
                }
                if(arr[i] < max) {
                    interim += 1;
                } if(interim == max) {
                    count += 1;
                }
                i++;
            }
            return count;
        }
    }
}
