package com.trungdo.task2;

public class Task2 {

    /**
     *
     * @param array
     * @param subArray
     * @return index of subArray within array if found. else return -1
     */
    public static int findSubArray(int[] array, int[] subArray) {

        for (int start = 0; start <= array.length - subArray.length; start++) {
            boolean isSubArray = true;
            for (int i = 0; i < subArray.length; i++) {
                if (subArray[i] != array[start + i]) {
                    isSubArray = false;
                    break;
                }
            }
            if (isSubArray) {
                return start;
            }
        }

        return -1;
    }
}
