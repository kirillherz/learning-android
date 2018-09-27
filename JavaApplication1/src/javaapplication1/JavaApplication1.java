/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Кирилл
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int years = 10;
        double month = 60000;
        double p = 0.065;
        double summa = 0;
        double summa2 = 0;
        for(int i = 0; i != years; i++){          
            summa += summa * p;
            summa += month * 12;
            summa2 += month * 12;
        }
        System.out.print(summa);
    }
    
}
