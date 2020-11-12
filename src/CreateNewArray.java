package com.company;

public class CreateNewArray {

    private double[][] newArray;

    public double[][] setNewArray(double[][] oldArray, int mainColumn, int mainString, double mainElement){

        newArray = new double[oldArray.length][oldArray[0].length];

        newArray[mainString][mainColumn] = 1 / mainElement;

        newMainStringAndColumn(oldArray, mainColumn, mainString, mainElement);

        for(int i = 0; i < oldArray.length; i++){
            if(i != mainString){
                for(int j = 0; j < oldArray[i].length; j++){
                    if(j != mainColumn){
                        newArray[i][j] = (oldArray[i][j] * mainElement - oldArray[mainString][j]*oldArray[i][mainColumn]) / mainElement;
                    }
                }
            }
        }

        return newArray;
    }

    private void newMainStringAndColumn(double[][] oldArray, int mainColumn, int mainString, double mainElement){

        for(int i = 0; i < oldArray[mainString].length; i++){   // new string in array
            if(i != mainColumn){
                newArray[mainString][i] = oldArray[mainString][i] / mainElement;
            }
        }
        for(int i = 0; i < oldArray.length; i++){   // new column in array
            if(i != mainString){
                newArray[i][mainColumn] = oldArray[i][mainColumn] / mainElement * -1;
            }
        }
    }


}
