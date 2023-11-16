package Etapa3;

import java.util.Stack;

public class Etapa3 {

    public static void main(String args[]) {
        Stack<Character> expression = new Stack<>();
        String exp = "(((a + b)) - (c + a))";

        for (char c : exp.toCharArray()) {
            expression.push(c);
        }

        boolean isOk = checkBrackets(expression);

        System.out.println(isOk);

    }

    public static boolean checkBrackets(Stack<Character> s) {

        Stack<Character> parentheses = new Stack<>();

        int size = s.size();

        for (int i = 0; i < size; i++) {
            char c = s.pop();
            if (c == '(' || c == ')') {
                parentheses.push(c);
            }
        }

        if (parentheses.size() % 2 != 0) {
            return false;
        }

        return true;
    }
}
