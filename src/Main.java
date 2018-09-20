import java.util.Arrays;
import java.util.Random;

public class Main {

    // Randomized-Quicksort method based on psudocode from book
    public static void randQuicksort(TestInteger[] rQuickArray, int start, int end){
        if (start < end){
            int q = randPartition(rQuickArray, start, end);
            randQuicksort(rQuickArray, start, q-1);
            randQuicksort(rQuickArray, q+1, end);
        }
    }

    // Randomized-Partition method based on psudocode from book
    // Partitions array into smaller parts for randomized-quicksort
    public static int randPartition(TestInteger[] rPartArray, int start, int end){
        Random i = new Random();
        int result = i.nextInt(end-start) + start;
        exchange(result, end, rPartArray);
        return partition(rPartArray, start, end);
    }

    // Quicksort method based on psudocode from book
    public static void quicksort(TestInteger[] quickArray, int start, int end){
        if (start < end){
            int q = partition(quickArray, start, end);
            quicksort(quickArray, start, q-1);
            quicksort(quickArray, q+1, end);
        }
    }

    // Partitions array into smaller parts for quicksort based on psudocode from book
    public static int partition(TestInteger[] partArray, int start, int end){
        TestInteger x = partArray[end];
        int i = start - 1;

        for (int count = start; count <= end - 1; count++){
            if (partArray[count].compareTo(x) <= 0){
                i++;
                exchange(i, count, partArray);
            }
        }

        exchange(i+1, end, partArray);

        return i+1;
    }

    // Returns if an array is sorted or not
    public static boolean isSorted(TestInteger[] boolArray){
        for (int i = 1; i < boolArray.length; i++){
            if (boolArray[i-1].compareTo(boolArray[i]) == 1){
                return false;
            }
        }
        return true;
    }

    // Exchange - swap two elements in an array
    public static void exchange(int arrayPositionOne, int arrayPositionTwo, TestInteger[] Array){
        TestInteger temp = Array[arrayPositionOne];
        Array[arrayPositionOne] = Array[arrayPositionTwo];
        Array[arrayPositionTwo] = temp;
    }

    // Array generation and info output
    public static void main(String[] args) {
        // Create array - Generate 10,000 random TestIntegers in range 1-1,000,000 using Math.random
        TestInteger[] timArray = new TestInteger[10000];

        // Used in last two array generators
        int counter = 0;

        // Populate array - Change i to modify number of sorted sequences
        // Make sure only one section is active at a time!

        for (int i = 0; i < 10000; i++){
            // Random sequence - default
            timArray[i] = new TestInteger((int)(Math.random()*100000));

            // Increasing order
            // timArray[i] = new TestInteger((i));

            // Initial value used for starting sequence - only used for following two array generators
            int initialValue = (int) (Math.random() * 1000000);

            // 10 sorted sequences of 1,000 elements - change c to modify number of elements
            /*
            for(int k = initialValue; k < initialValue + 1000; k++){
                timArray[counter] = new TestInteger(k);
                counter++;
            }
            */

            // 100 sorted sequences of 100 elements - change c to modify number of elements
            /*
            for(int k = initialValue; k < initialValue + 100; k++){
                timArray[counter] = new TestInteger(k);
                counter++;
            }
            */
        }

        // Clone array using .clone
        TestInteger[] quickArray = timArray.clone();

        // Sort the array using Random-Quicksort
        randQuicksort(quickArray, 0, quickArray.length-1);
        System.out.println("Random-Quicksort counter output: " + TestInteger.counter);
        System.out.println("Is the array sorted? " + Boolean.toString(isSorted(quickArray)));
        TestInteger.counter = 0;

        /*
        // Sort the array using Tim Sort
        Arrays.sort(timArray);
        System.out.println("TimSort counter output: " + TestInteger.counter);
        System.out.println("Is the array sorted? " + Boolean.toString(isSorted(timArray)));
        TestInteger.counter = 0;

        // Sort the array using Quicksort
        quicksort(quickArray, 0, quickArray.length - 1);
        System.out.println("QuickSort counter output: " + TestInteger.counter);
        System.out.println("Is the array sorted? " + Boolean.toString(isSorted(quickArray)));
        */
    }
}
