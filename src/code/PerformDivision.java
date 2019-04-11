package code;

public class PerformDivision {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.divide(21, 7);
    }

    static class Solution
    {
        public int divide(int dividend, int divisor)
        {
            // make sure it can work when both the dividend and the divisor are the Integer.MIN_VALUE
            if (dividend == divisor)
            {
                return 1;
            }

            // make sure it can work when judging and setting the divisor to a positive number
            if (divisor == Integer.MIN_VALUE)
            {
                return 0;
            }

            int count = 0;
            int sign = 1;
            // make sure the divisor to be a positive number
            if (divisor < 0)
            {
                sign = -sign;
                divisor = -divisor;
            }

            // make sure the dividend to be a positive number
            if (dividend < 0)
            {
                sign = -sign;
                // make sure it can work when change the dividend from the Integer.MIN_VALUE to a positive  number
                if (dividend == Integer.MIN_VALUE)
                {
                    dividend += divisor;
                    count++;
                }
                dividend = -dividend;
            }

            int quotient = dividePositiveNum(dividend, divisor);
            // make sure it will not exceed the range of Integer
            if (quotient > Integer.MAX_VALUE - count)
            {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            quotient = count + quotient;
            return sign > 0 ? quotient: -quotient;
        }

        private int dividePositiveNum(int dividend, int divisor)
        {
            if (dividend < divisor)
            {
                return 0;
            }

            if (dividend == divisor)
            {
                return 1;
            }

            int powCount = -1;
            int tempDividend = dividend;
            while (tempDividend > divisor)
            {
                tempDividend = tempDividend >> 1;
                powCount++;
            }

            int partQuotient = 1 << powCount;
            int partMultiNum = divisor << powCount;
            int remaindDividend = dividend - partMultiNum;
            return partQuotient + dividePositiveNum(remaindDividend, divisor);
        }
    }
}
