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
    public static void test() {
        double cost1 = 0;
        double cost2 = 0;
        double pay = 25000;
        double summaPay = 0;
        double credit = 0;
        double summaFinal = 0;
        double summa = 4040000;
        double firstSumma = 300000;
        double percent = 11;
        int years = 10;
        double pay2 = 20000;
        int yearsPay = 0;
        credit = (summa - firstSumma) * (((percent) * 0.01) * years);
        summaPay = (pay * 12) * years;
        while ((summaPay - credit) < 0) {
            firstSumma += pay2 * 12;
            credit = (summa - firstSumma) * (((percent) * 0.01) * years);
            summaPay = (pay * 12) * years; // сумма с аренды
            yearsPay += 1;

        }
        System.out.println(summaPay - credit);
        System.out.println(yearsPay);
    }

    public static void main(String[] args) {
        int years = 10;
        double month = 60000;
        double p = 0.065;
        double summa = 0;
        double summa2 = 0;
        for (int i = 0; i != years; i++) {
            summa += summa * p;
            summa += month * 12;
            summa2 += month * 12;
        }
        System.out.print(summa);

    }

}
