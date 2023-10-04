/* Colton Kelsey
    Program 6
 */

import java.io.*;
import java.util.*;

public class Program6 {
    static int index = 0;
    static int[] bubbleIntArray = new int[20000];
    static int[] selectionIntArray = new int[20000];
    static ArrayList<Integer> ArrIntlist = new ArrayList<Integer>();

    public Program6() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        readFromIntFile();   // reads from file and stores into arrays
        int n = bubbleIntArray.length;  // sets int to array length for sorting
        bubbleIntSort(bubbleIntArray, n);  // INT bubble sort operation
        selectionIntSort(selectionIntArray); // INT selection sort operations
        // below is a test to confirm that the sorting is working correctly
        BufferedWriter bubbleOutput = new BufferedWriter(new FileWriter("src\\bubOutput.txt"));
            bubbleOutput.write(Arrays.toString(bubbleIntArray));
        BufferedWriter selectionOutput = new BufferedWriter(new FileWriter("src\\selOutput.txt"));
            selectionOutput.write(Arrays.toString(selectionIntArray));
    }
    static void bubbleIntSort(int bubbleArray[],int n){
        long timeStart = System.nanoTime();
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
        long timeEnd = System.nanoTime();
        long bubbleTimeTotal = (timeEnd - timeStart);
        System.out.println("total bubble time is: " + bubbleTimeTotal + " nanoseconds");
    }
    static void selectionIntSort(int selectionArray[]){
       int n = selectionArray.length;
       long timeStart = System.nanoTime();
       for (int i = 0; i < n - 1; i++)
       {
           int min_idx = i;
           for (int j = i + 1; j < n; j++)
               if (selectionArray[j] < selectionArray[min_idx])
                   min_idx = j;

           int temp = selectionArray[min_idx];
           selectionArray[min_idx] = selectionArray[i];
           selectionArray[i] = temp;
       }
       long timeEnd = System.nanoTime();
       long selectionTimeTotal = (timeEnd - timeStart);
       System.out.println("total selection time is: " + selectionTimeTotal + " nanoseconds");
    }

    static void readFromIntFile(){
        try {
            BufferedReader NumberFile = new BufferedReader(new FileReader("src\\NumbersInFile.txt"));
            String line;
            while ((line = NumberFile.readLine()) != null) { // only while file is not empty
                int number = Integer.parseInt(line);
                ArrIntlist.add(number);
                bubbleIntArray[index] = number;
                selectionIntArray[index] = number;
                index++;
            }
        } catch (IOException e){
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
