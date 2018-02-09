/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReversePolishNotation;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {

    String string;
    Pattern patternOperand;
    Pattern patternOperation;
    Pattern patternOpenBracket;
    Pattern patternCloseBracket;
    int index;

    Reader(String string) {
        this.string = string;
        this.patternOperand = Pattern.compile("^[0-9a-z]$");
        this.patternOperation = Pattern.compile("^[\\Q+-*/\\E]$");
        this.patternOpenBracket = Pattern.compile("^[(]$");
        this.patternCloseBracket = Pattern.compile("^[)]$");
        this.index = 0;

    }

    public Type read() {
        Matcher m;
        Type t;
        String cs = new Character(this.string.charAt(index)).toString();
        this.patternOperand.matcher(cs);
        if (this.patternOperand.matcher(cs).matches()) {
            t = Type.OPERAND;
        } else if (this.patternOperation.matcher(cs).matches()) {
            t = Type.OPERATION;
        } else if (this.patternOpenBracket.matcher(cs).matches()) {
            t = Type.OPENBRACKET;
        } else if (this.patternCloseBracket.matcher(cs).matches()) {
            t = Type.CLOSEBRACKET;
        } else {
            t = Type.ERRORS;
        }
        this.index += 1;
        return t;
    }
}
