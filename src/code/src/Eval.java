import com.udojava.evalex.Expression;

public class Eval {



    public static void main(String[] args) {
        Expression expression = new Expression("0.3*65");
        System.out.println(expression.eval());
    }


}
