import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toll on 26.10.2017.
 */


public class arrayReplace {

    public static void main(String[] args) {
        int[] arrayInput = new int[]{21, 20, 50, 21, 20, 50, 21, 20, 50, 21, 20};
        int[] arrayFind = new int[]{21, 20, 50, 21, 20};
        int[] arrayReplace = new int[]{70, 465, 23, 23};
        int[] arrayReplace2 = sweep(arrayInput, 4,5);

        for (int i = 0; i < arrayReplace2.length; i++) {
            System.out.print(arrayReplace2[i]+" ");
        }



    }

    /*private static int[] replace(int[] arrayInput, int[] arrayFind, int[] arrayReplace) {

        List<Integer> list = finding(arrayInput, arrayFind);
        int n = arrayFind.length;


    }
*/
    private static int[] sweep(int[] arrayIn, int index, int length) {
        int[] out = new int[arrayIn.length + length];
        int j=0;
        for (int i = 0; i < out.length; i++) {
            if (i >= index & i < index + length)
                out[i] = 0;
            else {
                out[i]=arrayIn[j++];
            }
        }
        return out;
    }


    private static List<Integer> finding(int[] arrayInput, int[] arrayFind) {

        int[] out = new int[arrayInput.length/arrayFind.length+1];
        int count = 0;

        for (int i = 0; i <= arrayInput.length - (arrayFind.length - count); ) {


            if (arrayInput[i] == arrayFind[count]) {
                count++;

                if (count == arrayFind.length) {
                   // out[](i - (count - 1));
                    System.out.println(i - (count - 1));
                    // i = i - (count - 1) + 1;
                    count = 0;
                    continue;
                }


            } else {
                if (count != 0) {
                    i = i - count + 1;
                    count = 0;
                    continue;
                }
            }

            i++;

        }


    }

}