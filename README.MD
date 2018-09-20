Authors: David Chong, Ethan Hamer, Abe Monjor<br/>
CSci 3501 Lab 3<br/>
Due Monday, September 24th by midnight<br/>
60 points between Lab 2 and Lab 3<br/>
Work in pairs<br/>

Results of sorting - five trials
-
Randomized-Quicksort {166369, 157144, 155266, 156436, 159848}<br/>
Median-of-three {, , , , }

Results of sorting - increasing order
-
Randomized-Quicksort {}<br/>
Median-of-three {}

Results of sorting - five trials with 10 sorted sequences of 1,000 elements each
-
Randomized-Quicksort {, , , , }<br/>
Median-of-three {, , , , }

Results of sorting - five trials with 100 sorted sequences of 100 elements each
-
Randomized-Quicksort {, , , , }<br/>
Median-of-three {, , , , }

• All lab submissions should be done by canvas. Please be sure to include
your group members.<br/>
• When working on the lab, please comment your work so that it is clear
what the contributions from each person are.<br/>
• At the end of the lab each group should submit the results of their
in-class work. Please indicate if this is your final submission. Don’t
forget to answer all the questions below.<br/>
• If your submission at the end of the lab time was not final, please
submit a final copy before the due time.<br/>

Grading
1. Implementation of quicksort: 15 pts
2. Correct setup (using Comparable, using the standard Java sorting, etc):
10 pts
3. Test data and setup: 10 pts
4. Randomized quicksort: 6 pts
5. Median-of-three pivot: 6 pts
6. Switching to insertion sort: 6 pts
7. Observations and conclusions: 7 pts

Overview and goals<br/>
In this lab we will continue studying efficiency of quicksort
(see http://en.wikipedia.org/wiki/Quicksort). The goal is to develop and
study approaches to make the quicksort split data as evenly as possible. The
approaches include a randomized pivot selection, a median-of-three pivot selection,
and use of insertion sort when the array is nearly sorted. You will
continue experimenting with quicksort on different types of data (completely
random, ordered, partially ordered) and compare it to the pre-defined sort
(Timsort) in the number of comparisons. The goal is to learn practical approaches
to efficient algorithm implementation.
Note that other ways of speeding up quicksort may reduce the program’s
running time by cutting down on recursive calls or by providing more efficient
memory usage. However, they do not reduce the number of element
comparisons, and thus will not be included in this lab.
Tasks
Use your implementation of quicksort and the testing code from the previous
lab. As in the last lab, you will be using arrays of 10,000 elements filled as
follows:
1. Generated at random
2. Sorted in increasing order (if this creates a stack overflow, use 1,000
elements)
3. 10 sorted sequences of 1,000 elements each
4. 100 sorted sequences of 100 elements each
Run all your tests (see below) 5 times on each of these sets.
You need to implement the modifications of quicksort listed below. Please
write a new copy of quicksort for each of the three modifications. Then compare
the results to the original quicksort and to the standard sorting (use
the same data for all three sorting algorithms). Make sure to test (for each
modification!) that the resulting array is sorted. Record the results (the
2
number of comparisons).
• Randomized quicksort: choose the pivot at random at every step of
the algorithm. For simplicity just exchange the randomly chosen pivot
with the element in the position r before doing anything else, this way
you don’t have to rewrite your algorithm (see p. 179 for more details).
• The median-of-three pivot selection: to select a pivot, pick three
subarray elements at random, then choose their median as the pivot
(see exercise 7-5 p. 188). Use compareTo for comparison of the three
elements since their comparison contributes to the total cost. Note that
this approach becomes less efficient as the array size decreases. Use a
threshold value k to switch to the usual pivot choice when the portion
of the array passed to quicksort is less than k. Try different values of
k and choose an optimal one (approximately).
• Switching to insertion sort at the end: when the array is nearly
sorted, stop the quicksort without finishing the sorting, and then use
insertion sort on the entire array to finish the process. As in the previous
problem, choose a threshold subarray size to leave the array for
the insertion sort. You will need to implement insertion sort (p. 18).
Make sure to include the comparisons made by the insertion sort into
the total.
In case you are getting a Stack Overflow exception: numbers in increasing
order may generate a stack overflow because there are 10000 calls (that’s the
worst case of quicksort when there is one call per element) which is more
than the default stack size. You need to increase the stack size in the JVM
(Java Virtual Machine) which you can do by setting a JVM flag in Eclipse:
http://stackoverflow.com/questions/2127217/java-stack-overflow-error-how-toincrease-the-stack-size-in-eclipse.
3



Last lab info<br/>
CSci 3501 Lab 2<br/>
Due Friday, September 14th by midnight<br/>
30 points
Work in pairs

Results of sorting - five trials
-
Tim sort {120401, 120436, 120345, 120393, 120467}

Quicksort {162620, 161465, 159754, 155558, 151760}

Results of sorting - increasing order
-
Tim sort {9999}

Quicksort {49995000}

Results of sorting - five trials with 10 sorted sequences of 1,000 elements each
-
Tim sort {10337, 10259, 10257, 10293, 10286}

Quicksort {15005000, 20003000, 25001000, 16011000, 27001000}

Results of sorting - five trials with 100 sorted sequences of 100 elements each
-
Tim sort {14793, 14384, 14254, 14479, 14505}

Quicksort {3175770, 4352700, 4443373, 3812800, 2360613}

- All lab submissions should be done by canvas. Please be sure to include
your group members.
- When working on the lab, please comment your work so that it is clear
what contributions of each person are.
- At the end of the lab each group should submit the results of their
in-class work. Please indicate if this is your final submission. Don’t
forget to answer all the questions below.
- If your submission at the end of the lab time was not final, please
submit a final copy before the due time.

Overview and goals

In this lab you will study the efficiency of the standard Java algorithms
for objects(Tim Sort) and quicksort (see http://en.wikipedia.org/wiki/
Quicksort ) for different types of data (such as completely random, ordered,
partially ordered). The efficiency of the algorithms is measured in the num-
ber of comparisons. Your program will call both sorting methods on the
same data and measure the number of comparison operations performed by
each sorting algorithm. The goal is to observe and analyze practical aspects
of sorting. The lab also helps you learn testing methodology for algorithms
analysis.

Technical details

You will use a predefined method sort that implements Tim Sort which
is specifically designed ot produce high efficiency on partially sorted arrays.
Note that this is a static method of a class Arrays which works on arrays of
objects.

1) You will need to write your own implementation of quicksort according
to the algorithm in the book (p. 171). Make sure that you implement the
in-place quicksort given in the book (i.e. your algorithm should not create
additional arrays). Your quicksort should take an array of TestInteger type
(see below). Use compareTo method to compare elements, do not use <. Try
to minimize the number of comparisons.

In addition, please write a method isSorted that takes an array of
TestInteger and returns true if it is sorted and false otherwise. Use
this method to test your quicksort.

In order to count the number of comparisons you need to create your
own class TestInteger that has an integer field value for comparison and a
static long field counter to count the number of comparisons performed on
all TestInteger objects.

Your class TestInteger should have the following components:
- Implements Comparable<TestInteger> interface
- Have an integer field value (which is used by compareTo for the com-
parison)
- A static long field called counter to counter the number of comparisons
performed on all TestInteger objects
- The compareTo mehtod returns the result of comparison of value
of “this” TestIntetger and the parameter TestInteger according
to the specification in https://docs.oracle.com/javase/8/docs/api/
java/lang/Comparable.html (see https://docs.oracle.com/javase/8/
docs/api/java/lang/Comparable.html\#compareTo-T- )
When generating arrays to be sorted, create two arrays and insert the
same elements in both in the same order. Sort one array using Tim Sortt
and the other one using quicksort. Make sure to record and reset the
TestInteger counter between the two sortings.

Tasks

2) Implement TestInteger and quicksort method as described above.
Test your implementation using isSorted method.
- Generate 10,000 random TestIntegers in the range from 1 to 1,000,000
and put them (in the same order) into two arrays. Use Java random
number generator Random (Math.random). Make sure to use only
one Random object in your program - create it in the very begin-
ning outside of any loops. Sort one using the Tim Sort and the other
using a quicksort. Run the program 5 times measuring the time to
sort the two arrays (separately) in the number of comparisons. Record
your results.
- Repeat the sorting, but instead of random elements use the arrays
where elements are stored in increasing order. Record the results.
- Repeat the measurements for arrays that consist of 10 sorted sequences
of 1,000 elements each (randomly choose the starting number in each
sequence). Record the results of 5 measurements.
- Repeat the measurements for arrays that consist of 100 sorted se-
quences of 100 elements each (randomly choose the starting number
in each sequence). Record the results of 5 measurements.
For each kind of data, which of the two algorithms performs better? Submit
your program, the results of measurements, and noted on your observations.
In case you are getting a Stack Overflow exception: numbers
in increasing order may generate a stack overflow because there are 10,000
calls (that’s the worse case of quicksort when there is one call per ele-
ment) which is more than the default stack size. You need to increase the
stack size in the JVM (Java Virtual Machine) which you can do by set-
ting a JVM flag in Eclipse: <br/>
http://stackoverflow.com/questions/15313393/how-to-increase-heap-size-in-eclipse3