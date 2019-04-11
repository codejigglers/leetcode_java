import java.util.List;

public class GasStation {

    static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
            int fuel = 0;
            int cost = 0;

            for (int i = 0; i < A.size(); i++) {
                fuel += A.get(i);
                cost += B.get(i);
            }
            if (fuel < cost) {
                return -1;
            }

            fuel = 0;
            cost = 0;

            int start = -1;

            for (int i = 0; i < A.size(); i++) {

                if(fuel == 0 && cost == 0 && A.get(i) >= B.get(i)) {
                    start = i;
                }
                fuel += A.get(i);
                cost += B.get(i);


                if (fuel < cost) {
                    fuel = 0;
                    cost = 0;
                }
            }

            return start;
        }
    }

}
