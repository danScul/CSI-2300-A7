import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class BubbleSort {
    
    public static void main(String[] args) throws IOException{
        int[] randArr = createRandomArray(5);
        writeArrayToFile(randArr, "test.txt");
        int[] testArr = readFileToArray("test.txt");
        bubbleSort(testArr);
    }

    public static int[] createRandomArray(int arrayLength){
        Random rand = new Random();
        int[] arr = new int[arrayLength];

        for(int i = 0; i < arrayLength; i++){
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }
    public static void writeArrayToFile(int[] array, String filename) throws IOException{
        FileWriter writer = new FileWriter(filename);
        BufferedWriter buffer = new BufferedWriter(writer);
        for(int i = 0; i < array.length; i++){
            buffer.write(String.format("%d\n", array[i]));
        }
        buffer.close();
    }
    public static int[] readFileToArray(String filename) throws IOException{
        FileReader reader = new FileReader(filename);
        BufferedReader br = new BufferedReader(reader);
        int[] arr = new int[100];
        int count = 0;
        String currLine;
        while((currLine = br.readLine()) != null){
            String[] content = currLine.split(" ");
            for(int i = 0; i < content.length; i++)
                arr[count] = Integer.parseInt(content[i]);
        }
        br.close();
        return arr;
    }
    public static void bubbleSort(int[] array){
        int length = array.length;
        for(int j = 0; j < array.length-1; j++)
        for(int i = 0; i < length-1; i++){
            if(array[i] > array[i+1]){
               int placeholder = array[i];
               array[i] = array[i+1];
               array[i+1] = placeholder;
            }
        }
    }
}
