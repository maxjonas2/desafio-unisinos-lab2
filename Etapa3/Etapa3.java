package Etapa3;

import java.util.Stack;

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

        // cria stack temporario para auxiliar a verificacao
        Stack<Character> stack = new Stack<>();

        // enquanto a stack recebida nao foi esvaziada, reitera
        while (!s1.isEmpty()) {
            // retira o char to topo do stack recebido
            char current = s1.pop();

            // se for ')', joga para a stack auxiliar
            if (current == ')') {
                stack.push(current);
            } else if (current == '(') {
                // caso nao, se for '(' e a stack auxiliar estiver fazia, significa que há erro
                // e retorna falso
                if (stack.isEmpty()) {
                    return false;
                }

                // verifica se o topo da stack auxiliar é ')' e o atual da stack passada é '('
                // se sim, tira o primeiro da stack auxiliar
                // isso signica que houve 'match' e a iteracao continua
                char top = stack.peek();
                if ((current == '(' && top == ')')) {
                    stack.pop();
                } else {
                    // caso nao, significa que há erro no match e retorna falso
                    return false;
                }
            }
        }

        // retorna true se a stack auxiliar estiver fazia, o que significa que todos os
        // parenteses deram "match" e foram retirados
        // se sobrou item na pilha, significa que houve falta de match ou sobra de
        // parenteses
        return stack.isEmpty();
    }

}
