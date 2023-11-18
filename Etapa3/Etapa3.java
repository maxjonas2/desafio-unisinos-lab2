package Etapa3;

import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Etapa3 {

    public static void main(String args[]) {
        Stack<Character> expression = new Stack<>();
        String exp = "(((a + b) * (c + a)) * (c + d))";

        for (char c : exp.toCharArray()) {
            expression.push(c);
        }

        boolean isOk = checkBrackets(expression);

        System.out.println("A sequencia esta " + (isOk ? "correta" : "incorreta"));

    }

    public static boolean checkBrackets(Stack<Character> s1) {

        Stack<Character> stack = new Stack<>();

        while (!s1.isEmpty()) {
            char current = s1.pop();

            if (current == ')') {
                stack.push(current);
            } else if (current == '(') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();
                if ((current == '(' && top == ')')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
