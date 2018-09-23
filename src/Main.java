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

    // Array generation and info output - This functionality has been moved to testing
    public static void main(String[] args) {
    }
}
