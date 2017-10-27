/**
 * Created by Toll on 27.10.2017.
 */
public class BinarySearch2 {

    public static void main(String[] args) {
        int[] massiv = {0, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(sorting(massiv,1));
    }

    private static int sorting(int[] array, int key) {
        int[] zone = new int[2];
        zone[0] = array[0];
        zone[1] = array[array.length - 1];
        int[] indexZone = new int[2];
        indexZone[0] = 0;
        indexZone[1] = array.length - 1;

        int temp = (int) Math.round((double) (indexZone[1] - indexZone[0]) / 2);

        while (true) {
            if (checkIndexZone(indexZone, temp))
            {
                if (key == array[temp]) return temp;
                else if (key > array[temp]) {
                    indexZone[0] = temp;
                    zone[0] = array[temp];
                    temp = temp + (int) Math.round((double) (indexZone[1] - temp) / 2);

                } else if (key < array[temp]) {
                    indexZone[1] = temp;
                    zone[1] = array[temp];
                    temp = temp - (int) Math.round((double) (temp - indexZone[0]) / 2);
                }


            }
            else return -100;
        }



    }

    private static boolean checkIndexZone(int[] indexZone, int temp) {
        if (temp >= indexZone[0] & temp <= indexZone[1]) return true;
        else return false;
    }

    private static boolean checkArray(int[] array) {
        if (array == null || array.length == 0) return false;
        else return true;
    }
}
