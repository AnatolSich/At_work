import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toll on 26.10.2017.
 */


public class arrayReplace {

    public static void main(String[] args) {
        int[] arrayInput = new int[]{1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4};
        int[] arrayFind = new int[]{1,2};
        int[] arrayReplace = new int[]{8, 8, 8};
        int[] arrayReplace2 =

                sweep(arrayInput, 4, arrayReplace, arrayFind);


        //       finding(arrayInput, arrayFind, arrayReplace);


        for (int i = 0; i < arrayReplace2.length; i++) {
            System.out.print(arrayReplace2[i] + " ");
        }


    }

    /*private static int[] replace(int[] arrayInput, int[] arrayFind, int[] arrayReplace) {

        List<Integer> list = finding(arrayInput, arrayFind);
        int n = arrayFind.length;


    }
*/
    private static int[] sweep(int[] arrayIn, int index, int[] arrayReplace, int[] arrayFind) {
        int[] out = new int[arrayIn.length + arrayReplace.length - arrayFind.length];
        int j = 0;
        int k = 0;
        for (int i = 0; i < out.length; i++) {
            if (i >= index & i < index + arrayReplace.length) {

                out[i] = arrayReplace[k++];

            } else {
                if (k != 0) out[i] = arrayIn[k - 1 + j++];
                else out[i] = arrayIn[k + j++];
            }
        }
        return out;
    }


    private static int[] finding(int[] arrayInput, int[] arrayFind, int[] arrayReplace) {

        int[] out = new int[arrayInput.length];
        System.arraycopy(arrayInput, 0, out, 0, arrayInput.length);


        int insertCount = 0;
        int count = 0;

        for (int i = 0; i <= arrayInput.length - (arrayFind.length - count); ) {


            if (arrayInput[i] == arrayFind[count]) {
                count++;

                if (count == arrayFind.length) {
                    // out[](i - (count - 1));
                    //                  System.out.println(i - (count - 1) + insertCount * (arrayReplace.length - arrayFind.length));
                    out = sweep(out, i - (count - 1) + insertCount * (arrayReplace.length - arrayFind.length), arrayReplace, arrayFind);
                    insertCount++;
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

        return out;
    }

}