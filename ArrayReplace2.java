/**
 * Created by Toll on 07.11.2017.
 */
public class ArrayReplace2 {

    public static void main(String[] args) {
        int[] arrayInput = new int[]{3, 4, 5, 1, 2, 3, 4, 6, 3, 4, 5};
        int[] arrayFind = new int[]{3, 4, 5};
        int[] arrayReplace = new int[]{7, 8, 9, 0};
        int[] arrayOut = replace(0, arrayInput, arrayFind, arrayReplace);

        for (int i = 0; i < arrayOut.length; i++) {
            System.out.print(arrayOut[i] + " ");
        }
    }

    private static int[] replace(int index, int[] arrayInput, int[] arrayFind, int[] arrayReplace) {
        int[] arrayOut = new int[arrayInput.length - arrayFind.length + arrayReplace.length];

        int stage = 0;
        int count = 0;

        for (int i = 0, j = 0; i < arrayInput.length + (arrayReplace.length - arrayFind.length) * (stage+1) &&
                j < arrayOut.length + (arrayReplace.length - arrayFind.length) * (stage+1); ) {

            if (arrayInput[i] != arrayFind[count] && count == 0) {
                arrayOut[j] = arrayInput[i];
                j++;
                i++;
                continue;
            }
            if (arrayInput[i] == arrayFind[count] && count == arrayFind.length - 1) {

                for (int k = 0; k < arrayReplace.length; k++) {
                    arrayOut[j] = arrayReplace[k];
                    j++;
                }
                i++;
                count = 0;
                stage++;
                continue; //break;
            }
            if (arrayInput[i] == arrayFind[count] && count != arrayFind.length) {
                count++;
                i++;
                continue;
            }

            if (arrayInput[i] != arrayFind[count] && count != 0) {
                for (int k = i - count; k <= i; k++) {
                    arrayOut[j] = arrayInput[k];
                    j++;
                }
                i++;
                count = 0;
                continue;
            }


        }

        return arrayOut;
    }
}
