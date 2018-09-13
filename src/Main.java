import java.util.Arrays;

public class Main {

    public static void quicksort(TestInteger[] quickArray, int start, int end){
        if (start < end){
            int q = partition(quickArray, start, end);
            quicksort(quickArray, start, q-1);
            quicksort(quickArray, q+1, end);
        }
    }

    public static int partition(TestInteger[] partArray, int start, int end){
        TestInteger x = partArray[end];
        int i = start-1;

        for (int count = start; count >= end-1; count++){
            if (partArray[count].compareTo(x) == -1 || partArray[count].compareTo(x) == 0){
                i++;
                exchange(i, count, partArray);
            }
        }

        exchange(i++, end, partArray);

        return i++;
    }

    public static boolean isSorted(TestInteger[] boolArray){
        for (int i = 0; i <= boolArray.length; i++){
            if (boolArray[i].compareTo(boolArray[i+1]) == 1){
                return false;
            }
        }
        return true;
    }

    public static void exchange(int arrayPositionOne, int arrayPositionTwo, TestInteger[] Array){
        TestInteger temp = Array[arrayPositionOne];
        Array[arrayPositionOne] = Array[arrayPositionTwo];
        Array[arrayPositionTwo] = temp;
    }

    public static void main(String[] args) {
        // Create array - Generate 10,000 random TestIntegers in range 1-1,000,000 using Math.random
        TestInteger[] timArray = new TestInteger[10000];

        // Populate array
        for (TestInteger testInteger : timArray) {
            testInteger = new TestInteger((int)(Math.random() * 1000000));
        }

        // Clone array using .clone
        TestInteger[] quickArray = timArray.clone();

        // Sort the array using Tim Sort
        Arrays.sort(timArray);
        System.out.println("TimSort counter output: " + TestInteger.counter);
        System.out.println("Is the array sorted?" + Boolean.toString(isSorted(timArray)));
        TestInteger.counter = 0;

        // Sort the array using Quicksort
        quicksort(quickArray, 0, quickArray.length);
        System.out.println("Is the array sorted?" + Boolean.toString(isSorted(quickArray)));
        System.out.println("QuickSort counter output: " + TestInteger.counter);
    }
}
