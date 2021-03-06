package DS_ALGO.Arrays;

import java.util.Arrays;

public class MergeSortedArrays {

    static Integer[] mergeStored(Integer[] array1, Integer[] array2) {
        Integer merged[] = new Integer[array1.length + array2.length];
        int i=0, j=0, index=0;
        while( i < array1.length && j < array2.length) {
            if(array1[i] < array2[j]) {
                merged[index++] = array1[i++];
            }
            else {
                merged[index++] = array2[j++];
            }

        }

        if(i < array1.length) {
            for(;i<array1.length; i++)
                merged[index++] = array1[i];
        }

        else if ( j < array2.length) {
            
            for(;j<array2.length; j++)
                merged[index++] = array2[j];
        }

        return merged;
    }

    public static void main(String args[]) {

        Integer[] arr1 = {2,4,6,8,10};
        Integer[] arr2 = {1,3,5,7};


        Integer[] merged = mergeStored(arr1, arr2);
        System.out.println(Arrays.toString(merged));

    }
    
}
