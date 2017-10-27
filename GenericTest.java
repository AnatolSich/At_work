import java.util.ArrayList;

/**
 * Created by Toll on 06.09.2017.
 */
public class GenericTest {
    public static void main(String[] args) {
        ArrayList myList = new ArrayList();
        double g = 10d;
        myList.add(g);
        double d = (double)myList.get(0);

      //  List<double> myList1 = new ArrayList<>();
       // double g = 10d;
        myList.add(g);
       // double d = (double)myList.get(0);
    }
}