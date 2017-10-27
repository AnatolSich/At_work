import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Toll on 29.06.2017.
 */
public class DateTest {
    public static void main(String[] args) {
     //   System.out.println(new Date().getDay());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date= simpleDateFormat.parse("2017-07-02");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date.getDay());
    }
}
