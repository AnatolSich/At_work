import java.util.Arrays;

public class QuickSorting {
    private static int[] input = {5, 3, 6,1, 9, -2, 0, 1};

    public static void main(String[] args) {
        // System.out.println(minValue(0,input));
        System.out.println(Arrays.toString(input));
       qSort();
        System.out.println(Arrays.toString(input));



    }

    private static void qSort() {

       dividing(0,input.length-1);
    }

    private static void   dividing(int start, int end) {

        int res=-1;
        for (int i = start, j = end; i != j; ) {
            if (input[i] >= input[j]) {
                swap(j - 1, j);
                if (i!=j-1) swap(i, j);
                j--;
            } else i++;
            res=i;
        }
        if (start<res-1) dividing(start,res-1);
        if (end>res+1) dividing(res+1,end);
    }

    private static void swap(int n1, int n2) {
        int temp = input[n1];
        input[n1] = input[n2];
        input[n2] = temp;
    }
}
