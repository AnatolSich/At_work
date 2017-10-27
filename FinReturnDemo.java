/**
 * Created by Toll on 03.07.2017.
 */
public class FinReturnDemo {
    public static void main(String[] args) {
        System.out.println(testing());
    }
    private static boolean testing(){
        try{

            return true;
        } finally {
            return false;
        }
    }
}
