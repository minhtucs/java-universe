package juniverse.algorithm.balance;

import java.util.Arrays;

/**
 * @author tunm2
 */
public class ArrayRotation {
    
    static int[] array = { 1,2,3,4,5,6,7,8,9 };
    
    public static void main(String[] args) {
        rotateUseIntermediateArray(array, 8);
        System.out.println(Arrays.toString(array));
    }
    
    static void rotateUseIntermediateArray(int[] arr, int order) {
        int len = arr.length;
        if (order >= len) order = order % len;
        
        int arrtmp[] = new int[len];
        for (int i = 0; i < len; i++) {
            int j = i - order;
            if (j < 0) j = len + j;
            arrtmp[i] = arr[j];
        }
        
        System.arraycopy(arrtmp, 0, arr, 0, len);
    }
    
    static void bubbleRotate(int[] arr, int order) {
        for (int i = 0; i < order; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                int tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
            }
        }
    }

}
