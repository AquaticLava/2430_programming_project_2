import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Keeps track of data when profiling.
 * uses Result to store the original array, then how many compares sorting took.
 *
 * @author Eric R
 */
public class ResultTracker {
    private List<Result> worstResults = new LinkedList<>();
    private List<Result> bestResults = new LinkedList<>();
    private double totalNumOfCompares = 0;
    private int totalResults = 0;
    private double average = 0;

    /**
     * Check if a result is either best or worst of results checked.
     * if the result is best or worst then it is added to the respective list.
     * keeps each list at 10 elements.
     *
     * @param r the result to check.
     */
    public void checkBestOrWorst(Result r){
        //check for best case eligibility
        if (bestResults.size() < 10 || r.getCompares() < bestResults.get(9).getCompares()){
            ListIterator<Result> iterator = bestResults.listIterator();
            while (iterator.hasNext() || bestResults.size() < 10){
                Result currentResult;
                if (iterator.hasNext()){
                    currentResult = iterator.next();
                } else {
                    iterator.add(r);
                    break;
                }

                if (r.getCompares() <= currentResult.getCompares()){
                    iterator.previous();
                    iterator.add(r);
                    break;
                }
            }
            if (bestResults.size() > 10) {
                bestResults.remove(bestResults.size()-1);
            }
        }
        //check for worst case eligibility
        if (worstResults.size() < 10 || r.getCompares() > worstResults.get(9).getCompares()){
            ListIterator<Result> iterator = worstResults.listIterator();
            while (iterator.hasNext() || worstResults.size() < 10){
                Result currentResult;
                if (iterator.hasNext()){
                    currentResult = iterator.next();
                } else {
                    iterator.add(r);
                    break;
                }

                if (r.getCompares() >= currentResult.getCompares()){
                    iterator.previous();
                    iterator.add(r);
                    break;
                }
            }
            if (worstResults.size() > 10) {
                worstResults.remove(worstResults.size()-1);
            }
        }
    }

    /**
     * Add comparisons to the average value.
     * Each time this method is called it is assumed to be a new result.
     *
     * @param compares the number of comparisons to add.
     */
    public void addToAverage(int compares){
        totalNumOfCompares += compares;
        average = totalNumOfCompares/++totalResults;
    }

    public List<Result> getWorstResults() {
        return worstResults;
    }

    public List<Result> getBestResults() {
        return bestResults;
    }

    public double getAverage() {
        return average;
    }

    /**
     * prints out best, worst, and average data that has been collected.
     */
    public void print(){
        System.out.println("Best Results: ");
        for (Result r : getBestResults()) {
            if (r == null)
                continue;

            System.out.print(r);
        }
        System.out.println();

        System.out.println("Worst Results: ");
        for (Result r : getWorstResults()) {
            if (r == null)
                continue;

            System.out.print(r);
        }
        System.out.println();

        System.out.println("Average result: ");
        System.out.println(getAverage());
    }
}
