package code;

public class PrefixCalculate {

    public static void main(String[] args) {
        System.out.println(helperMethod("+1*34"));
    }

    public static int helperMethod(String expression) {
        if(expression.length() == 1) {
            return Integer.parseInt(expression);
        }
        if(expression.length() == 0) {
            return 0;
        }
        int start = -1;
        for(int i = expression.length() - 1; i >= 0; i--) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '*' || expression.charAt(i) == '-') {
                start = i;
                break;
            }
        }
        int ans = calculate((expression.charAt(start + 1) - '0'), (expression.charAt(start + 2) - '0'), expression.charAt(start)) ;
        return helperMethod(expression.substring(0, start) + String.valueOf(ans) + expression.substring(start + 3, expression.length()));
    }

    public static int calculate(int a, int b, char x) {
        if(x == '+') {
            return a + b;
        } else if(x == '-') {
            return a-b;
        } else if(x == '*') {
            return a*b;
        }
        return 1;
    }
}
