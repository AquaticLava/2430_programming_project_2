import java.util.ArrayList;
import java.util.Arrays;

// Java program for implementation of Cocktail Sort
//source: https://www.geeksforgeeks.org/cocktail-sort/

/**
 * Using the Shaker sort algorithm (Cocktail sort) to sort integer arrays.
 *
 * @author sione
 */
public class Cocktail {
    int count;

    /**
     * Sorts unsorted array and returns count of comparisons. Iterates through
     * integer array and sorts the array using shaker sort algorithm. The shaker sort algorithm sorts by iterating through
     * an array and placing the largest integer at the end of the array. Then it will reiterate backwards while skipping
     * over the (already sorted) largest array. The smallest Item will be place in the front of the array. As you iterate
     * back and forth, you only iterate through those values that are not sorted.
     *
     * @param b integer array
     * @return int comparison count
     */
    public int sort(Integer[] b) {

        Integer[] a = Arrays.copyOf(b, b.length);
        count = 0;
        boolean swapped = true;

        // Start and Ending Indexes
        int start = 0;
        int end = a.length;

        while (swapped == true) {

            // reset the swapped flag on entering the
            // loop, because it might be true from a
            // previous iteration.
            swapped = false;

            // loop from bottom to top
            for (int i = start; i < end - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
                count++;
            }

            // if nothing moved, then array is sorted.
            if (swapped == false)
                break;

            // otherwise, reset the swapped flag so that it
            // can be used in the next stage
            swapped = false;

            // move the end point back by one, because
            // item at the end is in its rightful spot
            end = end - 1;

            // from top to bottom, doing the
            // same comparison as in the previous stage
            for (int i = end - 1; i >= start; i--) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
                count++;
            }

            // increase the starting point, because
            // the last stage would have moved the next
            // smallest number to its rightful spot.
            start = start + 1;
        }
        return count;

    }

    public int getComparisonCount() {
        return count;
    }

    /* Prints the array */
    void printArray(Integer a[]) {
        int n = a.length;
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {

        // PART 4
        // Code to Generate all required permutations according to Part 4
        for (int i = 4; i < 9; i += 2) {
            ResultTracker tracker = new ResultTracker();
            ArrayList<Integer[]> ints = ArrayGenerator.generatePermutation(i);

            for (Integer[] arr : ints) {
                Cocktail ob = new Cocktail();
                Result currentResult = new Result(Arrays.copyOf(arr, arr.length), ob.sort(arr));
                System.out.print(currentResult);

                tracker.checkBestOrWorst(currentResult);
                tracker.addToAverage(currentResult.getCompares());
            }
            tracker.print();
        }
    }
}
