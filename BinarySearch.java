/**
 * Created by Toll on 26.10.2017.
 */

public class BinarySearch {

    public static void main(String[] args) {
        int[] massiv = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(massiv, 0));
        //   System.out.println(Math.round((double) 5 / 2));
    }


    private static int search(int[] array, int key) {
        if (array.length == 1)
            if (key == array[0]) return 0;
            else return -100;
        boolean flag=true;
        int temp = (int) Math.round((double) array.length / 2) - 1;

        while (true) {
            if (key == array[temp]) {
                return temp;
            } else if (key < array[temp]) {
                if (!checkStart(array, lowerKey(temp))) return moveToStart(array, temp, key);
                else temp = lowerKey(temp);
            } else {
                if (!checkEnd(array, biggerKey(temp))) return moveToEnd(array, temp, key);
                else temp = biggerKey(temp);
            }
        }
    }

    private static boolean checkArray(int[] array) {
        if (array == null || array.length == 0) return false;
        else return true;
    }

    private static int lowerKey(int temp) {
        return (int) (Math.round((double) temp / 2) - 1);
    }


    private static int biggerKey(int temp) {
        return (int) Math.round((double) temp * 3 / 2);
    }


    private static int moveToStart(int[] array, int i, int key) {
        for (int j = i; j >= 0; j--) {
            if (key == array[j]) return j;
        }
        return -100;
    }

    private static int moveToEnd(int[] array, int i, int key) {
        for (int j = i; j < array.length; j++) {
            if (key == array[j]) return j;
        }
        return -100;
    }

    private static boolean checkEnd(int[] array, int i) {
        if (i < array.length) return true;
        else return false;
    }

    private static boolean checkStart(int[] array, int i) {
        if (i >= 0) return true;
        else return false;
    }

}
