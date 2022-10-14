import java.util.*;

/**
 * Main class that controls and prints out profiling data for each sorting algorithm.
 * @author Eric R
 */
public class TestClass {
    private static int getMethodUsingInt(int i, Integer[] array){
        switch(i){
            case 0 -> {return Heap.sort(array);}
            case 1 -> {return Quick.sort(array);}
            case 2 -> {return Merge.sort(array);}
            case 3 -> {return new Cocktail().sort(array);}
            default -> {return -1;}
        }

    }
    /**
     * Uses ArrayGenerator to generate data to sort.
     * Calls each sort method to sort the generated data then
     * uses ResultTracker to keep track of profiling data.
     */
    public static void main(String[] args) {
        String[] algorithmNames = {
                "Heap Sort",
                "Quick Sort",
                "Merge Sort",
                "Cocktail Sort"
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                ResultTracker tracker = new ResultTracker();
                List<Integer[]> ints = ArrayGenerator.generatePermutation(4+(j*2));

                System.out.println("Sorting algorithm " + algorithmNames[i] + ", Array of length " + (4+(j*2)) + "\n");

                for (Integer[] array : ints) {
                    Result currentResult = new Result(
                            Arrays.copyOf(array,array.length),
                            getMethodUsingInt(i,array));

                    tracker.checkBestOrWorst(currentResult);
                    tracker.addToAverage(currentResult.getCompares());
                }
                tracker.print();
            }
        }
    }
}
