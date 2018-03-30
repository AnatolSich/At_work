import java.util.Arrays;

public class MixSorting {

    private static String[] input = new String[]{"g", "w", "10", "y", "0", "a", "5"};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(input));
        sorting();
        System.out.println(Arrays.toString(input));
        // System.out.println(in[0].compareTo(in[2]));
    }

    private static void sorting() {
        boolean flag = true;
        for (int i = 0; flag; i++) {
            flag = false;
            for (int j = 0; j < input.length - 1 - i; ) {
               // int next = 0;
                if (isDigit(input[j])) {
                    for (int n = j + 1; n < input.length; ) {
                        if (isDigit(input[n])) {
                            if (Integer.parseInt(input[j]) > Integer.parseInt(input[n])) {
                                swap(j, n);
                            }
                            j = n;
                            break;
                        } else n++;
                    }

                } else {
                    for (int n = j + 1; n < input.length; ) {
                        if (!isDigit(input[n])) {
                            if (input[j].compareTo(input[n]) > 0) {
                                swap(j, n);
                            }
                            j = n;
                            break;
                        } else n++;
                    }
                }
                flag = true;
            }
        }
    }


    private static boolean next(int j) {
        int next = 0;
        if (isDigit(input[j])) {
            for (int n = j + 1; n < input.length; n++) {
                if (isDigit(input[n])) next = n;
            }
            if (Integer.parseInt(input[j]) > Integer.parseInt(input[next])) {
                swap(j, next);
                return true;
            }
        } else {
            for (int n = j + 1; n < input.length; n++) {
                if (!isDigit(input[n])) next = n;
            }
            if (input[j].compareTo(input[next]) > 0) {
                swap(j, next);
                return true;
            }
        }
        return false;

    }

    private static void swap(int a, int b) {
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    private static boolean isDigit(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
