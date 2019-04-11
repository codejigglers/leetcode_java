package vardan.src.code;

public class SmallestIntegerDivisiblebyK {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestRepunitDivByK(5));
    }
    private static class Solution {
        public int smallestRepunitDivByK(int K) {
            int i = 1;
            int count = 1;

            if(K % 2 == 0) {
                return -1;
            } else {
                boolean flag = true;
                while (flag) {
                    if(i % K == 0) {
                        return count;
                    }
                    if(((i*10)+ 1) < 0) {
                        flag = false;
                        break;
                    }
                    i*=10;
                    i+=1;
                    count += 1;
                }
            }

            return -1;
        }
    }
}
