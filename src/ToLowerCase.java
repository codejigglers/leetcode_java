public class ToLowerCase {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.toLowerCase("Vardan"));
    }

    private static class Solution {
        public String toLowerCase(String str) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)>='A' && str.charAt(i)<='Z') {
                    sb.append((char) (str.charAt(i) + ('a'-'A')));
                }
                else {
                    sb.append(str.charAt(i));
                }
            }

            return sb.toString();
        }
    }
}
