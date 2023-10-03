/* Colton Kelsey
    Program 6
 */

import java.io.*;
import java.util.*;

public class Program6 {

    public static void main(String[] args) throws IOException {
        int BubbleArray[] = new int[0];
        int SelectionArray[]= new int[0];
        ArrayList<Integer> Arrlist = new ArrayList<Integer>();
        try {
            BufferedReader NumberFile = new BufferedReader(new FileReader("src\\NumbersInFile.txt"));
            while ((NumberFile.readLine()) != null) { // only while file is not empty
                BubbleArray[0] = Integer.parseInt(NumberFile.readLine());   // loads to bubble array.
                SelectionArray[0] = Integer.parseInt(NumberFile.readLine()); // loads to selection array
                Arrlist.set(0, Integer.valueOf(NumberFile.readLine()));  // loads to ArrayList
            }
        } catch (IOException e){
            System.out.println("Bad data!");
        }

    }
}
