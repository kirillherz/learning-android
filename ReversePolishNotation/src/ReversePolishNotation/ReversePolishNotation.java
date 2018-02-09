/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReversePolishNotation;

enum Type{
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
       for(int i = 0; i != s.length();i++){
           t = reader.getTypeSymbol(s.charAt(i));
           switch(t){
               case OPERAND:
                   System.out.print("o");
                   break;
               case OPERATION:
                   System.out.print("+");
                   break;
               case OPENBRACKET:
                   System.out.print("(");
                   break;
               case CLOSEBRACKET:
                   System.out.print(")");
                   break;
                   
           }
       }
    }
}
