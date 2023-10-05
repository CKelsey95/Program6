/* Colton Kelsey
    Program 6
 */

import java.io.*;
import java.util.*;

public class Program6 {
    static int index = 0;
    static int StrIndex = 0;
    static int[] bubbleIntArray = new int[20000];
    static int[] selectionIntArray = new int[20000];
    static ArrayList<Integer> ArrIntList = new ArrayList<>();

    static String[] bubbleStringArray = new String[10000];
    static String[] selectionStringArray = new String[10000];
    static ArrayList<String> ArrStringList = new ArrayList<>();

    static long bubbleIntTimeTotal;
    static long selectionIntTimeTotal;
    static long bubbleStringTimeTotal;
    static long selectStringTimeTotal;
    static long systemStringTimeTotal;


    public static void main(String[] args) throws IOException {
        readFromIntFile();   // INT reads from file and stores into arrays
        int n = bubbleIntArray.length;  // sets int to array length for sorting
        bubbleIntSort(bubbleIntArray, n);  // INT bubble sort operation
        selectionIntSort(selectionIntArray); // INT selection sort operations

        readFromStringFile();              // reads from file and stores into array
        int s = bubbleStringArray.length;  // sets int to array length for sorting
        bubbleStringSort(bubbleStringArray, s); // STRING bubble sort operation
        int a = selectionStringArray.length; // sets int to array length for sorting
        selectStringSort(selectionStringArray, a); // STRING selection sort operation
        systemStringSort();             // string collections.sort method

        writeResultsToFile("src\\results.txt", bubbleIntTimeTotal, selectionIntTimeTotal, bubbleStringTimeTotal, selectStringTimeTotal, systemStringTimeTotal);
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
            if (!swapped)
                break;
        }
        long timeEnd = System.nanoTime();
        bubbleIntTimeTotal = (timeEnd - timeStart);
    }
    static void systemStringSort(){
        long timeStart = System.nanoTime();
        Collections.sort(ArrStringList);
        long timeEnd = System.nanoTime();
        systemStringTimeTotal = (timeEnd - timeStart);
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
       selectionIntTimeTotal = (timeEnd - timeStart);
    }
    static void bubbleStringSort(String bubbleArray[], int s) {
        String temp;
        long timeStart = System.nanoTime();
        for (int j = 0; j < s -1; j++){
            for (int i = j + 1; i < s; i++) {
                if (bubbleArray[j].compareTo(bubbleArray[i]) > 0) {
                    temp = bubbleArray[j];
                    bubbleArray[j] = bubbleArray[i];
                    bubbleArray[i] = temp;
                }
            }
        }

        long timeEnd = System.nanoTime();
        bubbleStringTimeTotal = (timeEnd - timeStart);
    }
    static void selectStringSort(String selectArray[], int s) {
        long timeStart = System.nanoTime();
        for(int i = 0; i < s - 1; i++) {
            int min_index= i;
            String minStr = selectArray[i];
            for(int j = i + 1; j < s; j++){
                if(selectArray[j].compareTo(minStr) < 0) {
                    minStr = selectArray[j];
                    min_index = j;
                }
            }
            if(min_index != i) {
                String temp = selectArray[min_index];
                selectArray[min_index] = selectArray[i];
                selectArray[i] = temp;
            }
        }
        long timeEnd = System.nanoTime();
        selectStringTimeTotal = (timeEnd - timeStart);
    }

    static void readFromIntFile(){
        try {
            BufferedReader NumberFile = new BufferedReader(new FileReader("src\\NumbersInFile.txt"));
            String line;
            while ((line = NumberFile.readLine()) != null) { // only while file is not empty
                int number = Integer.parseInt(line);
                ArrIntList.add(number);
                bubbleIntArray[index] = number;
                selectionIntArray[index] = number;
                index++;
            }
            NumberFile.close();
        }
            catch (IOException e){
            System.out.println("Error reading the Int file: " + e.getMessage());
        }
    }
    static void readFromStringFile(){
        try {
            BufferedReader StringFile = new BufferedReader(new FileReader("src\\StringsInFile.txt"));
            String line;
            while ((line = StringFile.readLine()) != null) {
                ArrStringList.add(line);
                bubbleStringArray[StrIndex] = line;
                selectionStringArray[StrIndex] = line;
                StrIndex++;
            }
            StringFile.close();
        } catch (IOException e){
            System.out.println("Error reading the String file: " + e.getMessage());
        }
    }
    static void writeResultsToFile(String fileName, long bubbleIntTimeTotal, long selectionIntTimeTotal,
                                   long bubbleStringTimeTotal, long selectStringTimeTotal, long systemStringTimeTotal) {
        try {
            BufferedWriter results = new BufferedWriter(new FileWriter(fileName));

            // Write the time totals and array element counts to the file
            results.write("INTEGER: total bubble sort time is: " + bubbleIntTimeTotal + " nanoseconds\n");
            results.write("INTEGER: total selection sort time is: " + selectionIntTimeTotal + " nanoseconds\n");
            results.write("STRING: total bubble sort time is: " + bubbleStringTimeTotal + " nanoseconds\n");
            results.write("STRING: total select sort time is: " + selectStringTimeTotal + " nanoseconds\n");
            results.write("STRING: total system sort time is: " + systemStringTimeTotal + " nanoseconds\n");

            // Write the total array element counts
            results.write("Total Integer Array Elements: " + index + "\n");
            results.write("Total String Array Elements: " + StrIndex + "\n");

            // Close the writer
            results.close();

        } catch (IOException e) {
            System.out.println("Error writing results to file: " + e.getMessage());
        }
    }
}