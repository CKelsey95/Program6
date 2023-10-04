/* Colton Kelsey
    Program 6
 */

import java.io.*;
import java.util.*;

public class Program6 {

    public static void main(String[] args) throws IOException {
        int index = 0;
        int bubbleArray[] = new int[20000];
        int selectionArray[]= new int[20000];
        ArrayList<Integer> Arrlist = new ArrayList<Integer>();
        try {
            BufferedReader NumberFile = new BufferedReader(new FileReader("src\\NumbersInFile.txt"));
            String line;
            while ((line = NumberFile.readLine()) != null) { // only while file is not empty
                int number = Integer.parseInt(line);
                Arrlist.add(number);
                bubbleArray[index] = number;
                selectionArray[index] = number;
                index++;
            }
        } catch (IOException e){
            System.out.println("Error reading the file: " + e.getMessage());
        }

        bubbleSort(bubbleArray, index);

    }
    static void bubbleSort(int bubbleArray[], int n){
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (bubbleArray[j] > bubbleArray[j + 1]) {
                    temp = bubbleArray[j];
                    bubbleArray[j] = bubbleArray[j + 1];
                    bubbleArray[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }
}
