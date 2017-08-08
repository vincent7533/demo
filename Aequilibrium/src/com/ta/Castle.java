package com.ta;

public class Castle {
    public static int castleCounter(int [] array){
        int counter = 0;
        if(array != null && array.length > 0){
            counter++;
            boolean preGoHigh = false,currentGoHigh = false;
            for(int i = 1; i < array.length; i ++){
                if(array[i] > array[i-1]){
                    currentGoHigh = true;
                } else if (array[i] < array[i-1]){
                    currentGoHigh = false;
                } else {
                    continue;
                }
                if(preGoHigh != currentGoHigh) {
                    counter ++;
                }
                preGoHigh = currentGoHigh;
            }
        }
        return counter;
    }
}