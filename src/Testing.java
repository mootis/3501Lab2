import java.util.Arrays;

public class Testing {

    public static void main(String[] args) {
        // This is where all of our tests are going to live

        // First we'll set up all the arrays we're going to sort

        // These are all the reference arrays for the four different scenarios

        // This block generates a completely random array of TestIntegers
        TestInteger[] randomRefArray = new TestInteger[10000];

        for(int i = 0; i < 10000; i++) {
            // Inserting a new TestInteger into each slot of the array with random values
            randomRefArray[i] = new TestInteger((int) (Math.random() * 1000000));
        }

        // This block generates an array of already sorted elements
        TestInteger[] preSortedRefArray = new TestInteger[10000];

        // Fill the pre-sorted array with TestInteger's with sorted values
        for(int i = 0; i < 10000; i++) {
            preSortedRefArray[i] = new TestInteger(i);
        }

        // This generates an array of ten presorted runs of 1000 elements each
        TestInteger[] tenSequenceRefArray = new TestInteger[10000];

        int tenSequenceCounter = 0;

        for(int i = 0; i < 10; i++) {
            int tenSequenceInitialValue = (int)(Math.random() * 1000000);

            for(int k = tenSequenceInitialValue; k < tenSequenceInitialValue + 1000; k++) {
                tenSequenceRefArray[tenSequenceCounter] = new TestInteger(k);
                tenSequenceCounter++;
            }
        }

        // This generates an array of one hundred presorted runs of one hundred elements each
        TestInteger[] hundredSequenceRefArray = new TestInteger[10000];

        int hundredSequenceCounter = 0;

        for(int i = 0; i < 100; i++) {
            int hundredSequenceInitialValue = (int) (Math.random() * 1000000);

            for(int k = hundredSequenceInitialValue; k < hundredSequenceInitialValue + 100; k++) {
                hundredSequenceRefArray[hundredSequenceCounter] = new TestInteger(k);
                hundredSequenceCounter++;
            }
        }

        // Now we can start testing the sorting algorithms
        // First we'll start by getting measurements for Timsort
        System.out.println("Starting with Timsort");

        // First we copy the reference arrays so that we can use Tim sort on each one
        TestInteger[] randomTimArray = randomRefArray.clone();
        TestInteger[] presortedTimArray = preSortedRefArray.clone();
        TestInteger[] tenRunsTimArray = tenSequenceRefArray.clone();
        TestInteger[] hundredRunsTimeArray = hundredSequenceRefArray.clone();

        System.out.println("Sorting the random array");
        Arrays.sort(randomTimArray);
        System.out.println("TimSort random array counter ends at: " + TestInteger.counter);
        System.out.println("Is the array sorted? " + Boolean.toString(Main.isSorted(randomTimArray)));
        TestInteger.counter = 0;

        System.out.println("Sorting the presorted array");
        Arrays.sort(presortedTimArray);
        System.out.println("TimSort presorted array counter ends at: " + TestInteger.counter);
        System.out.println("Is the array sorted? " + Boolean.toString(Main.isSorted(presortedTimArray)));
        TestInteger.counter = 0;

        System.out.println("Sorting the array of 10 runs");
        Arrays.sort(tenRunsTimArray);
        System.out.println("TimSort 10 runs array counter ends at: " + TestInteger.counter);
        System.out.println("Is the array sorted? " + Boolean.toString(Main.isSorted(tenRunsTimArray)));
        TestInteger.counter = 0;

        System.out.println("Sorting the array of 100 runs");
        Arrays.sort(hundredRunsTimeArray);
        System.out.println("TimSort 100 runs array counter ends at: " + TestInteger.counter);
        System.out.println("Is the array sorted? " + Boolean.toString(Main.isSorted(hundredRunsTimeArray)));
        TestInteger.counter = 0;

    }
}
