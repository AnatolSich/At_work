/**
 * Created by Toll on 29.06.2017.
 */
public class GenericMethodTest {

    public static void main(String[] args) {

       // Integer[] array = {1, 2, 3, 4, 5, 6, 7};
          Character [] array = {'a','b','c','d','e','f'};
        printArray(array);
    }

    private static <E> void printArray(E[] inputArray) {
        for (E element : inputArray
                ) {
            System.out.println(element);
        }
        System.out.println("-----------");
    }
}
