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
//        ResultTracker tracker = new ResultTracker();
//        IterableArrayGenerator permutations = new IterableArrayGenerator(8);
//        for (Integer[] i : permutations) {
//            Result currentResult = new Result(Arrays.copyOf(i,i.length),Heap.sort(i));
//            //System.out.print(currentResult);
//
//            tracker.checkBestOrWorst(currentResult);
//            tracker.addToAverage(currentResult.getCompares());
//        }
//        tracker.print();
        for (int i = 0; i < 3; i++) {
            System.out.println("Sorting algorithm Heap, Array of length " + (4+(i*2)) + "\n");
            ResultTracker tracker = new ResultTracker();
            List<Integer[]> ints = ArrayGenerator.generatePermutation(4+(i*2));
            for (Integer[] array : ints) {
                Result currentResult = new Result(Arrays.copyOf(array,array.length),Heap.sort(array));
                //System.out.print(currentResult);
                tracker.checkBestOrWorst(currentResult);
                tracker.addToAverage(currentResult.getCompares());
            }
            tracker.print();
        }
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Sorting algorithm Merge, Array of length " + (4+(i*2)) + "\n");
//            ResultTracker tracker = new ResultTracker();
//            IterableArrayGenerator permutations = new IterableArrayGenerator(4+(i*2));
//            for (Integer[] array : permutations) {
//                Result currentResult = new Result(Arrays.copyOf(array,array.length),Merge.sort(array));
//                //System.out.print(currentResult);
//                tracker.checkBestOrWorst(currentResult);
//                tracker.addToAverage(currentResult.getCompares());
//            }
//            tracker.print();
//        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Sorting algorithm Quick, Array of length " + (4+(i*2)) + "\n");
            ResultTracker tracker = new ResultTracker();
            List<Integer[]> ints = ArrayGenerator.generatePermutation(4+(i*2));
            for (Integer[] array : ints) {
                Result currentResult = new Result(Arrays.copyOf(array,array.length),Quick.sort(array));
                //System.out.print(currentResult);
                tracker.checkBestOrWorst(currentResult);
                tracker.addToAverage(currentResult.getCompares());
            }
            tracker.print();
        }
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Sorting algorithm Cocktail, Array of length " + (4+(i*2)) + "\n");
//            ResultTracker tracker = new ResultTracker();
//            IterableArrayGenerator permutations = new IterableArrayGenerator(4+(i*2));
//            for (Integer[] array : permutations) {
//                Result currentResult = new Result(Arrays.copyOf(array,array.length),Cocktail.sort(array));
//                //System.out.print(currentResult);
//                tracker.checkBestOrWorst(currentResult);
//                tracker.addToAverage(currentResult.getCompares());
//            }
//            tracker.print();
//        }
    }
}
