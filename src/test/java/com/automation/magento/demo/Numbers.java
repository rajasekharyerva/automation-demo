package com.automation.magento.demo;

import java.util.Arrays;

public class Numbers {
    static int counter =0;
    public static void main(String[] args) {
        int[] intArray = new int[]{4,5,6,-8,0,-6,7,-3,0,9,-5};
        //move right check 0
        int counter =0;
        int isZero = 0;
        for(int i=0; i<intArray.length; i++){
            if(isZero == intArray[i]) {
                // function call
                counter++;
                reorder(intArray, i);
            }
        }
        counter = counter-1;
        while(counter>=0) {
            intArray[counter--]=0;
        }
        Arrays.stream(intArray).forEach(System.out::println);
    }

    private static void reorder(int[] intArray, int index) {
        for(int i =index; i>counter; i--) {
            // 4,5,6,-8,0,-6,7,-3,0,9,-5
            intArray[i] = intArray[i-1];
        }

    }
}
