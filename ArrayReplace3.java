/**
 * Created by Toll on 08.11.2017.
 */
public class ArrayReplace3 {
    public static void main(String[] args) {
        int[] arrayInput = new int[]{3, 4, 6, 3, 4, 5, 3, 4, 5};
        int[] arrayFind = new int[]{3, 4, 5, 7};
        int[] arrayReplace = new int[]{7};
        int[] arrayOutt = replace(arrayInput, arrayFind, arrayReplace);

        for (int i = 0; i < arrayOutt.length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < arrayInput.length; i++) {
            System.out.printf("%3d", arrayInput[i]);

        }
        System.out.println();


        for (int i = 0; i < arrayOutt.length; i++) {
            System.out.printf("%3d", arrayOutt[i]);
        }
    }

    private static int[] replace(int[] arrayInput, int[] arrayFind, int[] arrayReplace) {
        int[] arrayIn = new int[arrayInput.length + 1];
        arrayIn[0] = 1;
        for (int i = 1; i < arrayIn.length; i++) {
            arrayIn[i] = arrayInput[i - 1];
        }


        int[] arrayOutTemp = arrayIn;


        do {
            arrayOutTemp = replaceOneTime(arrayOutTemp, arrayFind, arrayReplace);
        } while (arrayOutTemp[0] != -1);


        int[] arrayOut = new int[arrayOutTemp.length - 1];

        for (int i = 1; i < arrayOutTemp.length; i++) {
            arrayOut[i - 1] = arrayOutTemp[i];
        }


        return arrayOut;
    }


    private static int[] replaceOneTime(int[] arrayInput, int[] arrayFind, int[] arrayReplace) {

        if (arrayInput[0] > arrayInput.length - 1) {
            arrayInput[0] = -1;
            return arrayInput;
        }

        int[] arrayOut = new int[arrayInput.length + Math.abs(arrayReplace.length - arrayFind.length)];


        arrayOut[0] = -1;
        for (int k = 1; k < arrayInput[0]; k++) {
            arrayOut[k] = arrayInput[k];
        }

        //      int index = arrayInput[0];
        int count = 0;
        int i, j;


        for (i = arrayInput[0], j = arrayInput[0]; i < arrayInput.length &&
                j < arrayOut.length; ) {


            if (arrayInput[i] != arrayFind[count] && count == 0) {
                arrayOut[j] = arrayInput[i];
                j++;
                i++;

                if (i == arrayInput.length) {
                    arrayOut[0] = -1;
                }


                continue;
            }

            if (arrayInput[i] == arrayFind[count] && (count == arrayFind.length - 1)) {

                for (int k = 0; k < arrayReplace.length; k++) {
                    arrayOut[j] = arrayReplace[k];
                    j++;
                }

                if (j < arrayOut.length) {
                    arrayOut[0] = j;
                } else {
                    arrayOut[0] = -1;
                }

                for (int k = i + 1; k < arrayInput.length; k++) {
                    arrayOut[j] = arrayInput[k];
                    j++;
                }


                break;

            }

            if (arrayInput[i] == arrayFind[count] && count != arrayFind.length) {

                if (i == arrayInput.length - 1) {
                    for (int k = i - count; k < arrayInput.length; k++) {
                        arrayOut[j] = arrayInput[k];
                        j++;
                    }
                }

                count++;
                i++;


                continue;
            }

            if (arrayInput[i] != arrayFind[count] && count != 0) {
                arrayOut[j] = arrayInput[i - count];
                j++;

                if ((i + 1) == arrayInput.length) {
                    arrayOut[0] = -1;
                }

                i = i - count + 1;
                count = 0;


                continue;
            }


        }

       /* if ((j > arrayInput.length - 1) && arrayOut.length > j && arrayOut[j] == 0 && arrayOut[0] == -1)

        {
            int arrayTemp[] = new int[j];
            for (int k = 0; k < arrayTemp.length; k++) {
                arrayTemp[k] = arrayOut[k];
            }
            arrayOut = arrayTemp;
        }*/

        if (arrayOut[0] == -1) {
            int arrayTemp[] = new int[arrayInput.length];
            arrayTemp[0] = -1;
            for (int k = 1; k < arrayInput.length; k++) {
                arrayTemp[k] = arrayInput[k];
            }
            arrayOut = arrayTemp;


        } else {
            if (arrayReplace.length > arrayFind.length) {
                int arrayTemp[] = new int[j];
                for (int k = 0; k < arrayTemp.length; k++) {
                    arrayTemp[k] = arrayOut[k];
                }
                arrayOut = arrayTemp;
            } else {
                int arrayTemp[] = new int[arrayOut.length - 2 * Math.abs(arrayReplace.length - arrayFind.length)];

                for (int k = 0; k < arrayTemp.length; k++) {
                    arrayTemp[k] = arrayOut[k];
                }

                arrayOut = arrayTemp;
            }
        }


        return arrayOut;

    }
}
