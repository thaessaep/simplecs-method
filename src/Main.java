package com.company;

public class Main {

    public static void main(String[] args) {

        double[][] result;
        double L;

        Decision decision = new Decision();

        result = decision.mainEl();

        L = result[0][0];

        for (double[] i: result) {
            for (double j: i) {
                System.out.print(j+"  ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Ответ: L="+L);
    }


}
