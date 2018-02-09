/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReversePolishNotation;

import java.util.Stack;

enum Type {
    OPERAND,
    OPERATION,
    OPENBRACKET,
    CLOSEBRACKET,
    ERRORS
}

public class ReversePolishNotation {

    public static void main(String[] args) {

        String s = "2*a+(2+5)";
        Reader reader = new Reader();
        Type t;
        Stack<Character> stackOperands = new Stack();
        Stack<Character> stackOperations = new Stack();
        for (int i = 0; i != s.length(); i++) {
            t = reader.getTypeSymbol(s.charAt(i));
            switch (t) {
                case OPERAND:
                    stackOperands.push(s.charAt(i));
                    break;
                case OPERATION:
                    if (stackOperations.empty()) {
                        stackOperations.push(s.charAt(i));
                    } else {
                        if (reader.getPriority(s.charAt(i)) <= reader.getPriority(stackOperations.lastElement())) {
                            char temp = stackOperations.pop();
                            stackOperands.push(temp);
                            stackOperations.push(s.charAt(i));
                        } else {
                            stackOperations.push(s.charAt(i));
                        }
                    }

                    break;
                case OPENBRACKET:

                    stackOperations.push(s.charAt(i));
                    break;
                case CLOSEBRACKET:
                    while (true) {
                        char opr = stackOperations.pop();
                        if (opr == '(') {
                            break;
                        } else {
                            stackOperands.push(opr);
                        }
                    }
                    break;

            }
        }
        while (!stackOperations.isEmpty()) {
            char ch = stackOperations.pop();
            if (ch == '(') {
                System.out.print("erorr '(' ");
            } else {
                stackOperands.push(ch);
            }
        }
        for (int i = 0; i != stackOperands.size(); i++) {
            System.out.print(stackOperands.get(i));
        }
    }

}
