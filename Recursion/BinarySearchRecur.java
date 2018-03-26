package Recursion;

import java.util.Arrays;

public class BinarySearchRecur {
    private static int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {

        System.out.println(search(input, 0, 8, 9));
    }

    private static int search(int[] in, int start, int end, int k) {

        if(start>end) return -1;
        int m = (end + start) / 2;

        int temp = in[m];

        if (temp < k) return search(in, m + 1, end, k);
        else if (temp > k) return search(in, start, m - 1, k);
        else return m;
    }


    private static int searchWithArrays(int[] in, int k, int l) {
        int m = in.length / 2;
        int temp = in[m];

        if (in.length == 1 & temp != k) return -1;

        if (temp > k) return searchWithArrays(Arrays.copyOfRange(in, 0, m), k, l);
        else if (temp < k) return searchWithArrays(Arrays.copyOfRange(in, m, in.length), k, l + m);
        else return m + l;
    }
}
