import java.util.Arrays;

public class InsertSorting {
    private static int[] input = {5, 3, 6, 9, -2, 0, 1};

    public static void main(String[] args) {
        // System.out.println(minValue(0,input));
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(insertSort(input)));

    }

    private static int[] insertSort(int[] input) {

        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0 && input[j - 1] > input[j]; j--) {
                swap(j - 1, j);
            }
        }
        return input;
    }

    private static void swap(int n1, int n2) {
        int temp = input[n1];
        input[n1] = input[n2];
        input[n2] = temp;
    }
}
