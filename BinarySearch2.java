import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Toll on 27.10.2017.
 */
public class BinarySearch2 {


    public static void main(String[] args) {
        int[] massiv = {0,0, 2};

        System.out.println(searching(massiv, 1));
    }

    private static int searching(int[] array, int key) {

        if(array.length==0||array==null) return -100;
        if (array.length==1){
            if (array[0]==key) return 0;
            else return -100;
        }
        if(key>array[array.length-1]||key<array[0]) return -100;
        if (key==array[array.length-1]) return array.length-1;
        if (key==array[0]) return array[0];

         int[] zone = new int[2];
         int[] indexZone = new int[2];
        zone[0] = array[0];
        zone[1] = array[array.length - 1];

        indexZone[0] = 0;
        indexZone[1] = array.length - 1;


        int tempIndex;

        while (true) {
            tempIndex = (int) Math.round((double) (indexZone[0] + indexZone[1]) / 2);
            if (key == array[tempIndex]) return tempIndex;
            else if (key > array[tempIndex]) {
                indexZone[0] = tempIndex + 1;
                zone[0] = array[tempIndex + 1];
            } else if (key < array[tempIndex]) {
                indexZone[1] = tempIndex - 1;
                zone[1] = array[tempIndex - 1];
            }
            if(indexZone[0]==indexZone[1]) return -100;
        }
    }

}
