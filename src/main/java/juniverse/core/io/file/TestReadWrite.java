package juniverse.core.io.file;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author tunm2
 */
public class TestReadWrite {
    
    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = new FileInputStream("/home/tunm2/test.in");
        Scanner scanner = new Scanner(is);
        
        int size = scanner.nextInt();
        int[][] inputList = new int[size][];
        int i = 0;
        while (i < size) {
            int iSize = scanner.nextInt();
            int[] iInput = new int[iSize];
            int j = 0;
            while (j < iSize) {
                iInput[j++] = scanner.nextInt();
            }
            inputList[i++] = iInput;
        }
        
        for (int[] input : inputList) {
            System.out.println(Arrays.toString(input));
        }
    }
    
    static void read() throws FileNotFoundException {
        InputStream is = new FileInputStream("/home/tunm2/test.in");
        InputStreamReader isReader = new InputStreamReader(is);
        
        BufferedReader bufReader = new BufferedReader(isReader);
        
        DataInputStream dis = new DataInputStream(is);
    }
}