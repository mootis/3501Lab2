import java.util.Arrays;

public class Testing {

    public static void main(String[] args) {
        // This is where all of our tests are going to live

	// First we'll set up some results arrays just to make them easier to read at the end

    /*
	long[] timsortRandomArrayResults = new long[5];
	long[] timsortPresortedArrayResults = new long[5];
	long[] timsortTenRunsArrayResults = new long[5];
	long[] timsortOneHundredRunsArrayResults = new long[5];

	long[] quicksortRandomArrayResults = new long[5];
	long[] quicksortPresortedArrayResults = new long[5];
	long[] quicksortTenRunsArrayResults = new long[5];
	long[] quicksortOneHundredRunsArrayResults = new long[5];
    */

	long[] randomquicksortRandomArrayResults = new long[5];
	long[] randomquicksortPresortedArrayResults = new long[5];
	long[] randomquicksortTenRunsArrayResults = new long[5];
	long[] randomquicksortOneHundredRunsArrayResults = new long[5];

	long[] medianof3quicksortRandomArrayResults = new long[5];
	long[] medianof3quicksortPresortedArrayResults = new long[5];
	long[] medianof3quicksortTenRunsArrayResults = new long[5];
	long[] medianof3quicksortOneHundredRunsResults = new long[5];

	long[] quicksortinsertionsortRandomArrayResults = new long[5];
	long[] quicksortinsertionsortPresortedArrayResults = new long[5];
	long[] quicksortinsertionsortTenRunsArrayResults = new long[5];
	long[] quicksortinsertionsortOneHundredRunsResults = new long[5];

        // Next we'll set up all the arrays we're going to sort

	// We'll do most of the rest of the code in one for loop so that it's easier to get all five results for each sorting algorithm
	// We'll return all the results at the end in a easier to read format

	for(int i = 0; i < 5; i++){
        // These are all the reference arrays for the four different scenarios

        // This block generates a completely random array of TestIntegers
        TestInteger[] randomRefArray = new TestInteger[10000];

        for(int j = 0; j < 10000; j++) {
            // Inserting a new TestInteger into each slot of the array with random values
            randomRefArray[j] = new TestInteger((int) (Math.random() * 1000000));
        }

        // This block generates an array of already sorted elements
        TestInteger[] preSortedRefArray = new TestInteger[10000];

        // Fill the pre-sorted array with TestInteger's with sorted values
        for(int j = 0; j < 10000; j++) {
            preSortedRefArray[j] = new TestInteger(i);
        }

        // This generates an array of ten presorted runs of 1000 elements each
        TestInteger[] tenSequenceRefArray = new TestInteger[10000];

        int tenSequenceCounter = 0;

        for(int j = 0; j < 10; j++) {
            int tenSequenceInitialValue = (int)(Math.random() * 1000000);

            for(int k = tenSequenceInitialValue; k < tenSequenceInitialValue + 1000; k++) {
                tenSequenceRefArray[tenSequenceCounter] = new TestInteger(k);
                tenSequenceCounter++;
            }
        }

        // This generates an array of one hundred presorted runs of one hundred elements each
        TestInteger[] hundredSequenceRefArray = new TestInteger[10000];

        int hundredSequenceCounter = 0;

        for(int j = 0; j < 100; j++) {
            int hundredSequenceInitialValue = (int) (Math.random() * 1000000);

            for(int k = hundredSequenceInitialValue; k < hundredSequenceInitialValue + 100; k++) {
                hundredSequenceRefArray[hundredSequenceCounter] = new TestInteger(k);
                hundredSequenceCounter++;
            }
        }

        // Now we can start testing the sorting algorithms
        // First we'll start by getting measurements for Timsort

        /*
        // First we copy the reference arrays so that we can use Tim sort on each one
        TestInteger[] randomTimArray = randomRefArray.clone();
        TestInteger[] presortedTimArray = preSortedRefArray.clone();
        TestInteger[] tenRunsTimArray = tenSequenceRefArray.clone();
        TestInteger[] hundredRunsTimeArray = hundredSequenceRefArray.clone();

        Arrays.sort(randomTimArray);
        timsortRandomArrayResults[i] = TestInteger.counter;
        //System.out.println("Did timsort sort the random array? " + Boolean.toString(Main.isSorted(randomTimArray)));
        TestInteger.counter = 0;

        Arrays.sort(presortedTimArray);
        timsortPresortedArrayResults[i] = TestInteger.counter;
        //System.out.println("Did timsort sort the presorted array? " + Boolean.toString(Main.isSorted(presortedTimArray)));
        TestInteger.counter = 0;

        Arrays.sort(tenRunsTimArray);
        timsortTenRunsArrayResults[i] = TestInteger.counter;
        //System.out.println("Is the array sorted? " + Boolean.toString(Main.isSorted(tenRunsTimArray)));
        TestInteger.counter = 0;

        Arrays.sort(hundredRunsTimeArray);
        timsortOneHundredRunsArrayResults[i] = TestInteger.counter;
        //System.out.println("Is the array sorted? " + Boolean.toString(Main.isSorted(hundredRunsTimeArray)));
        TestInteger.counter = 0;
        */

	// Now we move onto quicksort
        /*
        TestInteger[] randomQuickArray = randomRefArray.clone();
        TestInteger[] presortedQuickArray = preSortedRefArray.clone();
        TestInteger[] tenRunsQuickArray = tenSequenceRefArray.clone();
        TestInteger[] hundredRunsQuickArray = hundredSequenceRefArray.clone();

        Main.quicksort(randomQuickArray, 0, randomQuickArray.length -1);
        quicksortRandomArrayResults[i] = TestInteger.counter;
        //System.out.println("Did quicksort sort the random array? " + Boolean.toString(Main.isSorted(randomQuickArray)));
        TestInteger.counter = 0;

        Main.quicksort(presortedQuickArray, 0, presortedQuickArray.length -1);
        quicksortPresortedArrayResults[i] = TestInteger.counter;
        //System.out.println("Did quicksort sort the presorted array? " + Boolean.toString(Main.isSorted(presortedQuickArray)));
        TestInteger.counter = 0;

        Main.quicksort(tenRunsQuickArray, 0, tenRunsQuickArray.length -1);
        quicksortTenRunsArrayResults[i] = TestInteger.counter;
        //System.out.println("Did quicksort sort the array of ten runs? " + Boolean.toString(Main.isSorted(tenRunsQuickArray)));
        TestInteger.counter = 0;

        Main.quicksort(hundredRunsQuickArray, 0, hundredRunsQuickArray.length -1);
        quicksortOneHundredRunsArrayResults[i] = TestInteger.counter;
        //System.out.println("Is the array sorted? " + Boolean.toString(Main.isSorted(hundredRunsQuickArray)));
        TestInteger.counter = 0;
        */

	// Moving on to randomized quicksort

	    TestInteger[] randomRandomizedQuickArray = randomRefArray.clone();
        TestInteger[] presortedRandomizedQuickArray = preSortedRefArray.clone();
        TestInteger[] tenRunsRandomizedQuickArray = tenSequenceRefArray.clone();
        TestInteger[] hundredRunsRandomizedQuickArray = hundredSequenceRefArray.clone();

        Main.randQuicksort(randomRandomizedQuickArray, 0, randomRandomizedQuickArray.length -1);
        randomquicksortRandomArrayResults[i] = TestInteger.counter;
        //System.out.println("Did randomized quicksort sort the random array? " + Boolean.toString(Main.isSorted(randomRandomizedQuickArray)));
        TestInteger.counter = 0;

        Main.randQuicksort(presortedRandomizedQuickArray, 0, presortedRandomizedQuickArray.length-1);
        randomquicksortPresortedArrayResults[i] = TestInteger.counter;
        //System.out.println("Did randomized quicksort sort the presorted array? " + Boolean.toString(Main.isSorted(presortedRandomizedQuickArray)));
        TestInteger.counter = 0;

        Main.randQuicksort(tenRunsRandomizedQuickArray, 0, tenRunsRandomizedQuickArray.length -1);
        randomquicksortTenRunsArrayResults[i] = TestInteger.counter;
        //System.out.println("Did randomized quicksort sort the array of ten runs? " + Boolean.toString(Main.isSorted(tenRunsRandomizedQuickArray)));
        TestInteger.counter = 0;

        Main.randQuicksort(hundredRunsRandomizedQuickArray, 0, hundredRunsRandomizedQuickArray.length -1);
        randomquicksortOneHundredRunsArrayResults[i] = TestInteger.counter;
        //System.out.println("Did randomized quicksort sort the array of one hundred runs? " + Boolean.toString(Main.isSorted(hundredRunsRandomizedQuickArray)));
        TestInteger.counter = 0;

    // Moving on to median-of-three pivot selection

        TestInteger[] randomMedian3Array = randomRefArray.clone();
        TestInteger[] presortedMedian3Array = preSortedRefArray.clone();
        TestInteger[] tenRunsMedian3Array = tenSequenceRefArray.clone();
        TestInteger[] hundredRunsMedian3Array = hundredSequenceRefArray.clone();

        Main.medianOf3sort(randomMedian3Array, 0, randomMedian3Array.length -1);
        medianof3quicksortRandomArrayResults[i] = TestInteger.counter;
        //System.out.println("Did Median3 sort the random array? " + Boolean.toString(Main.isSorted(randomMedian3Array)));
        TestInteger.counter = 0;

        Main.medianOf3sort(presortedMedian3Array, 0, presortedMedian3Array.length-1);
        medianof3quicksortPresortedArrayResults[i] = TestInteger.counter;
        //System.out.println("Did Median3 sort the presorted array? " + Boolean.toString(Main.isSorted(presortedMedian3Array)));
        TestInteger.counter = 0;

        Main.medianOf3sort(tenRunsMedian3Array, 0, tenRunsMedian3Array.length -1);
        medianof3quicksortTenRunsArrayResults[i] = TestInteger.counter;
        //System.out.println("Did Median3 sort the array of ten runs? " + Boolean.toString(Main.isSorted(tenRunsMedian3Array)));
        TestInteger.counter = 0;

        Main.randQuicksort(hundredRunsMedian3Array, 0, hundredRunsMedian3Array.length -1);
        medianof3quicksortOneHundredRunsResults[i] = TestInteger.counter;
        //System.out.println("Did Median3 sort the array of one hundred runs? " + Boolean.toString(Main.isSorted(hundredRunsMedian3Array)));
        TestInteger.counter = 0;
	}

	// Now we print out all the results

    /*
	System.out.println("The results of the five runs on each sorting algorithm with the different data sets:");
	System.out.println("Timsort random array results: " + java.util.Arrays.toString(timsortRandomArrayResults));
	System.out.println("Timsort presorted array results: " + java.util.Arrays.toString(timsortPresortedArrayResults));
	System.out.println("Timsort array of ten runs results: " + java.util.Arrays.toString(timsortTenRunsArrayResults));
	System.out.println("Timsort array of one hundred runs results: " + java.util.Arrays.toString(timsortOneHundredRunsArrayResults));

	System.out.println();

	System.out.println("Quicksort random array results: " + java.util.Arrays.toString(quicksortRandomArrayResults));
	System.out.println("Quicksort presorted array results: " + java.util.Arrays.toString(quicksortPresortedArrayResults));
	System.out.println("Quicksort array of ten runs results: " + java.util.Arrays.toString(quicksortTenRunsArrayResults));
	System.out.println("Quicksort array of one hundred runs results: " + java.util.Arrays.toString(quicksortOneHundredRunsArrayResults));

	System.out.println();
    */

	System.out.println("Randomized quicksort random array results: " + java.util.Arrays.toString(randomquicksortRandomArrayResults));
	System.out.println("Randomized quicksort presorted array results: " + java.util.Arrays.toString(randomquicksortPresortedArrayResults));
	System.out.println("Randomized quicksort array of ten runs results: " + java.util.Arrays.toString(randomquicksortTenRunsArrayResults));
	System.out.println("Randomized quicksort array of one hundred runs results: " + java.util.Arrays.toString(randomquicksortOneHundredRunsArrayResults));

    System.out.println("Median3 random array results: " + java.util.Arrays.toString(medianof3quicksortRandomArrayResults));
    System.out.println("Median3 presorted array results: " + java.util.Arrays.toString(medianof3quicksortPresortedArrayResults));
    System.out.println("Median3 array of ten runs results: " + java.util.Arrays.toString(medianof3quicksortTenRunsArrayResults));
    System.out.println("Median3 array of one hundred runs results: " + java.util.Arrays.toString(medianof3quicksortOneHundredRunsResults));
    }
}
