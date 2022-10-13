import java.util.*;

/**
 * Main class that controls and prints out profiling data for each sorting algorithm.
 * @author Eric R
 */
public class TestClass {
    /**
     * Uses ArrayGenerator to generate data to sort.
     * Calls each sort method to sort the generated data then
     * uses ResultTracker to keep track of profiling data.
     */
    public static void main(String[] args) {
        //TODO add other algorithms and array sizes.
        ArrayList<Integer[]> ints = ArrayGenerator.generatePermutation(3);
        ResultTracker tracker = new ResultTracker();
        for (Integer[] i : ints) {
            Result currentResult = new Result(Arrays.copyOf(i, i.length), Heap.sort(i));
            System.out.print(currentResult);

            tracker.checkBestOrWorst(currentResult);
            tracker.addToAverage(currentResult.getCompares());
        }
        tracker.print();

        // added Results for QuickSort
        ints = ArrayGenerator.generatePermutation(3);
        ResultTracker quickTracker = new ResultTracker();
        for (Integer[] i : ints) {
            Result currentResult = new Result(Arrays.copyOf(i, i.length), Quick.sort(i));
            System.out.print(currentResult);
            quickTracker.checkBestOrWorst(currentResult);
            quickTracker.addToAverage(currentResult.getCompares());
        }
        quickTracker.print();
    }
}
