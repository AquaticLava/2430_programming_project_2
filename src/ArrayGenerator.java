import java.util.ArrayList;

public class ArrayGenerator {


    /*
     * @param int[] data is the original input array.
     */
    private static void permutation(Integer[] arr, Integer[] data, ArrayList<Integer[]> list) {
        if (data.length == 0)
            list.add(arr);

        for (int i = 0; i < data.length; ++i) {
            Integer[] concatArr = new Integer[arr.length + 1];
            for (int j = 0; j < arr.length; ++j) {
                concatArr[j] = arr[j];
            }
            concatArr[concatArr.length - 1] = data[i];
            int index = 0;
            Integer[] subData = new Integer[data.length - 1];
            for (int j = 0; j < data.length; ++j) {
                if (j == i)
                    continue;
                subData[index] = data[j];
                ++index;
            }
            permutation(concatArr, subData, list);
        }
    }


    public static ArrayList<Integer[]> generatePermutation(int number) {
        Integer[] arr = new Integer[0];
        Integer[] data = new Integer[number];
        ArrayList<Integer[]> list = new ArrayList<>();
        for(int i = 0; i < number; ++i) {
            data[i] = i + 1;
        }
        permutation(arr, data, list);
        return list;

    }
    public static void main(String[] args) {

        for(Integer[] el : ArrayGenerator.generatePermutation(5)) {
            System.out.println(java.util.Arrays.toString(el));
        }
        System.out.println("______________");
        for(Integer[] el : ArrayGenerator.generatePermutation(4)) {
            System.out.println(java.util.Arrays.toString(el));
        }
    }

}
