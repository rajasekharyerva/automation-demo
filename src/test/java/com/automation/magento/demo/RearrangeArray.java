package com.automation.magento.demo;

import java.util.Arrays;

public class RearrangeArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, -8, 0, -6, 7, -3, 0, 9, -5};

        // Call the rearrange function to move 0's to the left
        rearrangeArray(arr);

        // Output the rearranged array
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrangeArray(int[] arr) {
        int index = arr.length - 1; // Pointer to track the position of non-zero elements

        // Move all non-zero elements to the end while maintaining their relative order
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[index--] = arr[i];
            }
        }

        // Fill the remaining positions with zeroes
        while (index >= 0) {
            arr[index--] = 0;
        }
    }
}
