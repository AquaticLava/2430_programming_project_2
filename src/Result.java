import java.util.Arrays;

/**
 * Holds the originally tested array and number of comparisons took to sort the array.
 * has custom toString method.
 *
 * @author Eric R
 */
public class Result {
    private Integer[] result;
    private int compares;

    /**
     * Instantiates Result fields.
     *
     * @param result   the unsorted integer array
     * @param compares the number of compares taken to sort the unsorted array.
     */
    public Result(Integer[] result, int compares) {
        this.result = result;
        this.compares = compares;
    }

    public Integer[] getResult() {
        return result;
    }

    public int getCompares() {
        return compares;
    }

    @Override
    public String toString() {
        return Arrays.toString(result) +
                " with " + compares + " compares\n";
    }
}
