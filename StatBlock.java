import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toll on 21.11.2017.
 */
public class StatBlock {
    static List<String> list = new ArrayList<>();
    static {
        for (int i = 0; i <5 ; i++) {
            StatBlock.list.add("Строка "+i);
        }
    }

    public static void main(String[] args) {
Thread thread = new Thread();
    }
}
