/**
 * Created by Toll on 03.07.2017.
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DataFormat {

    public static void main(String[] args) {
      //  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        //  System.out.println("date: " + dateFormat.format(new Date()));
        System.out.println(dateFormat.format(new Date()));

    }
}
