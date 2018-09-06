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
        System.out.println("Hello World!");
    }
}
