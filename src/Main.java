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

    // Median-of-three pivot selection sort method
    public static void medianOf3sort(TestInteger[] medQuickArray, int start, int end){
        if (start < end){
            int q = partitionMedian(medQuickArray, start, end);
            medianOf3sort(medQuickArray, start, q-1);
            medianOf3sort(medQuickArray, q+1, end);
        }
    }

    // Median-of-three pivot selection sort partition method
    public static int partitionMedian(TestInteger[] mPartArray, int subStart, int subEnd) {
        int result =  findMedianIndex(mPartArray, subStart, subEnd);
        exchange(subEnd, result, mPartArray);
        TestInteger x = mPartArray[subEnd];
        int i = subStart - 1;

        for (int count = subStart; count <= subEnd - 1; count++) {
            if (mPartArray[count].compareTo(x) <= 0) {
                i++;
                exchange(i, count, mPartArray);
            }
        }

        exchange(i+1, subEnd, mPartArray);

        return i+1;
    }

    public static int findMedianIndex(TestInteger[] medQuickArray, int subStart, int subEnd){
        int index1;
        int index2;
        int index3;

        index1 = (int)(Math.random() *(subEnd-subStart) + subStart);
        index2 = (int)(Math.random() * (subEnd-subStart) + subStart);
        index3 = (int)(Math.random() * (subEnd-subStart) + subStart);

        int[] indexArray = new int[3];
        indexArray[0] = index1;
        indexArray[1] = index2;
        indexArray[2] = index3;

        // Initial attempt at finding correct median. Does not sort properly
        int result = medQuickArray[indexArray[0]].compareTo(medQuickArray[indexArray[1]]);
        if (result == -1){
            exchangeInt(0, 1, indexArray);
        }

        result = medQuickArray[indexArray[1]].compareTo(medQuickArray[indexArray[2]]);
        if (result == -1){
            exchangeInt(1, 2, indexArray);
        }

        result = medQuickArray[indexArray[0]].compareTo(medQuickArray[indexArray[1]]);
        if (result == -1){
            exchangeInt(0, 1, indexArray);
        }
        return indexArray[1];
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

    public static void exchangeInt(int arrayPositionOne, int arrayPositionTwo, int[] Array){
        int temp = Array[arrayPositionOne];
        Array[arrayPositionOne] = Array[arrayPositionTwo];
        Array[arrayPositionTwo] = temp;
    }

    // Array generation and info output - This functionality has been moved to testing
    public static void main(String[] args) {
        TestInteger[] testingArray = new TestInteger[5];
        testingArray[0] = new TestInteger(5);
        testingArray[1] = new TestInteger(0);
        testingArray[2] = new TestInteger(-2);
        testingArray[3] = new TestInteger(10);
        testingArray[4] = new TestInteger(3);

        medianOf3sort(testingArray, 0 , 4);
        for (TestInteger temp : testingArray) {
            System.out.println(temp.value);
        }
        System.out.println(isSorted(testingArray));
    }
}
