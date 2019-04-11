public class StudentAttendanceRecord {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.checkRecord("LALL");

    }

    private static class Solution {

        public boolean checkRecord(String s) {

            int aCount = 0;
            int lCount = 0;

            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i)=='A') {
                    aCount+=1;
                    if(aCount==2) {
                        return false;
                    }
                    lCount=0;
                }
                else if(s.charAt(i) == 'L') {
                    lCount+=1;
                    if(lCount==3) {
                        return false;
                    }
                }

                else {
                    lCount=0;
                    continue;
                }

            }
            return true;
        }

    }

}


