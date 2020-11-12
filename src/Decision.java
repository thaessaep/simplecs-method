package com.company;

import java.util.Scanner;

public class Decision {

    private double[][] arr = {  {-4, 1, -2},
                                {2, 1, 1},
                                {5, 2, 0},
                                {1, 2, 1}};

    private double mainElement = Double.MIN_VALUE;

    private String L="";

    private int mainString = -1, mainColumn = -1;

    public double[][] mainEl(){ // main Element of matrix


        Scanner in = new Scanner(System.in);
        while (!L.equals("max") && !L.equals("min")){
            System.out.print("Input function direction: L-> ");
            setL(in.nextLine());
        }
        boolean check = true;
        while (check != false){

            setMainColumn();
            setMainString();

            mainElement = arr[mainString][mainColumn];

            CreateNewArray newArray = new CreateNewArray();
            arr = newArray.setNewArray(arr, mainColumn, mainString, mainElement);

            check = checkMatrixForNegativeElements();
        }

        return arr;
    }

    private void setL(String L){
        this.L = L;
    }

    private boolean checkMatrixForNegativeElements(){

        int amountNormalElements = 0;

        if(L.equals("max")) {
            for (int i = 1; i < arr[0].length; i++) {    // i = 1 - check El without function value
                if (arr[0][i] < 0) {
                    amountNormalElements += 1;
                }
            }
        }
        else {
            for (int i = 1; i < arr[0].length; i++) {
                if(arr[0][i] > 0){
                    amountNormalElements += 1;
                }
            }
        }

        return amountNormalElements > 0;
    }


    private void setMainColumn() throws ArrayIndexOutOfBoundsException{   // main column of matrix

        if(L.equals("max")){
            for (int i = 0; i < arr[0].length; i++){
                if(arr[0][i] < 0){
                    if (Math.abs(mainElement) < Math.abs(arr[0][i])){
                        mainColumn = i;
                    }
                }
            }
        }
        else {
            for (int i = 0; i < arr[0].length; i++){
                if(arr[0][i] > 0){
                    if (mainElement < arr[0][i]){
                        mainElement = arr[0][i];
                        mainColumn = i;
                    }
                }
            }
        }
    }


    private void setMainString(){

        double numberOfMatrix = Double.MIN_VALUE;

        for (int i = 1; i < arr.length; i++){    // main string of matrix (arr.length consider column length)
            //  i = 1 - start with 2 column of matrix
            if(arr[i][mainColumn] >= 0){
                if(arr[i][mainColumn] / arr[i][0] > numberOfMatrix){
                    numberOfMatrix = arr[i][mainColumn] / arr[i][0];
                    mainString = i;
                }
            }
        }
    }

}
