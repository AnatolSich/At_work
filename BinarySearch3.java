import java.util.Arrays;

/**
 * Created by Toll on 03.11.2017.
 */
public class BinarySearch3 {


    public static void main(String[] args) {
        Integer[] massiv = {null,null,null,null,7,9,13,79,1334};

        System.out.println(searching(massiv, 9));
    }

    private static Integer searching(Integer[] array, Integer key) {
        Integer[] arrayNew = new Integer[array.length];
        int k = 0;
        if (array.length == 0 || array == null) return -100;
        if (array.length == 1) {
            if (array[0] != key) return -100;
        }

        if (key == array[0]) return 0;


        if (key == array[array.length - 1]) return array.length - 1;

        if (array[0] == null && key != null) {


            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == null) {
                    k = i;
                    break;
                }
            }

            arrayNew = new Integer[array.length - (k+1)];
            int j = 0;
            for (int i = k+1; i < array.length; i++) {
                arrayNew[j++] = array[i];
            }
        }
        if (arrayNew.length == 1) {
            if (arrayNew[0] != key) return -100;
        }

        if (key == arrayNew[0]) return k+1;

        if (key > arrayNew[arrayNew.length - 1]) return -100;
        if (arrayNew[0] != null)
            if (key < arrayNew[0]) return -100;


        Integer[] zone = new Integer[2];
        Integer[] indexZone = new Integer[2];


        zone[0] = arrayNew[0];
        zone[1] = arrayNew[arrayNew.length - 1];

        indexZone[0] = 0;
        indexZone[1] = arrayNew.length - 1;


        Integer tempIndex;

        while (true) {
            tempIndex = Integer.valueOf((int) Math.round((double) (indexZone[0] + indexZone[1]) / 2));
            if (key == array[tempIndex]) return tempIndex+k;
            else if (key > arrayNew[tempIndex]) {
                indexZone[0] = tempIndex + 1;
                zone[0] = arrayNew[tempIndex + 1];
            } else if (key < arrayNew[tempIndex]) {
                indexZone[1] = tempIndex - 1;
                zone[1] = arrayNew[tempIndex - 1];
            }
            if (indexZone[0] == indexZone[1]) return -100;
        }
    }

}
