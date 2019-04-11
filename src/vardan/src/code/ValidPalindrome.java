package code;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    private static class Solution{
        public boolean isPalindrome(String s) {

            if(s.length()==0){
                return true;
            }

            int start=0;
            int end=s.length()-1;

            while (start<=end){
                if(!isValid(s.charAt(start))){
                    start+=1;
                    continue;
                }
                if(!isValid(s.charAt(end))){
                    end-=1;
                    continue;
                }

                if(!isEqual(s.charAt(start), s.charAt(end))){
                    return false;
                }
                else {
                    start+=1;
                    end-=1;
                }

            }
            return true;
        }

        public boolean isValid(Character c){
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c<='9' && c>='0')){
                return true;
            }
            return false;
        }

        public boolean isEqual(Character c1, Character c2){
            if(c1==c2){
                return true;
            }
            if (c1>c2){
                if(c2 + 32 == c1){
                    return true;
                }
            }
            else {
                if(c1>=65 && c1 + 32 == c2){
                    return true;
                }
            }
            return false;
        }
    }
}
