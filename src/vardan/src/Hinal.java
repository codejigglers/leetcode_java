import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Hinal {

    public static void main(String[] args) {

        List<String> q = new ArrayList<>();
        List<Integer> p = new ArrayList<>();

        q.add("<>><");
        p.add(2);


        for(Integer i : balancedOrNot(q, p)) {
            System.out.println(i);
        }
    }

    public static List<Integer> balancedOrNot(List<String> expressions, List<Integer> maxReplacements) {

        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i<expressions.size(); i++) {
            int f = calculate(expressions.get(i));
            if( f != -1 && f<=maxReplacements.get(i) ) {
                answer.add(1);
            }
            else {
                answer.add(0);
            }
        }
        return answer;
    }

    public static int calculate(String expression) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<expression.length(); i++) {
            if(expression.charAt(i) == '<') {
                stack.push('<');
            }
            else {
                if(!stack.isEmpty() && stack.peek() == '<') {
                    stack.pop();
                }
                else {
                    stack.push('>');
                }
            }
        }

        while (!stack.isEmpty()) {
            if(stack.pop() == '>') {
                count += 1;
            }
            else {
                count = -1;
                break;
            }
        }

        return count;
    }

}
