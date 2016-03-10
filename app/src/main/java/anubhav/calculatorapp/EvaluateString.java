package anubhav.calculatorapp;

/**
 * Created by Anubhav on 09-03-2016.
 */
import android.util.Log;
import android.widget.Toast;

import java.util.Stack;

public class EvaluateString {
    public static Double evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        // Stack for numbers: 'values'
        Stack<Double> values = new Stack<Double>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;

            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i]=='.'))
                    sbuf.append(tokens[i++]);
                values.push(Double.parseDouble(sbuf.toString()));
            }

            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == 'x' || tokens[i] == '/') {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        // Top of 'values' contains result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2) {
        if ((op1 == 'x' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static Double applyOp(char op, Double b, Double a) {
        switch (op) {
            case '+':
                Log.i("value",(a+b)+"");
                return a + b;
            case '-':
                Log.i("value",(a-b)+"");
                return a - b;
            case 'x':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0.0;
    }
}