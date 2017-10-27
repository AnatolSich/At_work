import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Toll on 29.06.2017.
 */
public class DateDay {
    Date date;

    public Date getDate() {
        return date;
    }

    public DateDay()   {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = new Date();
        try {
            startDate= simpleDateFormat.parse("2000-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date nowDate = new Date();

        this.date = new Date(startDate.getTime() + (long)(Math.random() * (nowDate.getTime()-startDate.getTime())));

        System.out.println("Creation:  "+this.date);
    }


}
