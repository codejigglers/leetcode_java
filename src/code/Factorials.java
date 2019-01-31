package code;

import java.math.BigInteger;
import java.util.ArrayList;

public class Factorials {

    public static void main(String[] args) {
        System.out.println(solution(5, 3 ));
    }

    public static int solution(int n, int k) {

        ArrayList<BigInteger> arrayList = new ArrayList<>();

        BigInteger[] bigIntegers = new BigInteger[n+1];

        bigIntegers[0] = BigInteger.valueOf(1);
        for(int i=1; i<=n; i++) {
            bigIntegers[i] = (bigIntegers[i-1].multiply(BigInteger.valueOf(i)));
        }

        BigInteger answer = bigIntegers[n].divide(bigIntegers[k] .multiply(bigIntegers[n-k]));

        if(answer.compareTo(BigInteger.valueOf(1000000000) ) == 1) {
            return -1;
        }

        else {
            return Integer.valueOf(answer.intValue());
        }

    }
}
