/**
 * Created by Toll on 03.07.2017.
 */

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleDateFormatExample {

    public static void main(String[] args) throws ParseException {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = null;

        dateFormat = new SimpleDateFormat();
        System.out.println("Constructor 1: " + dateFormat.format(currentDate));

        dateFormat = new SimpleDateFormat("dd//MMMM");
        System.out.println("Constructor 2: " + dateFormat.format(currentDate));

        dateFormat = new SimpleDateFormat("dd--MMMM", myDateFormatSymbols);
        System.out.println("Constructor 3: " + dateFormat.format(currentDate));

        dateFormat = new SimpleDateFormat("D-MMMM", Locale.ENGLISH);
        System.out.println("Constructor 4: " + dateFormat.format(currentDate));

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse("2012-12-24");
        System.out.println(date);

        String pattern2 = "EEEEE MMMMM yyyy HH:mm:ss.SSSZ";
        SimpleDateFormat simpleDateFormat2 =
                new SimpleDateFormat(pattern2, new Locale("da", "DK"));
        String date2 = simpleDateFormat2.format(new Date());
        System.out.println(date2);

        Locale localeUKR = new Locale("ukr", "UA");
        SimpleDateFormat simpleDateFormat3 =
                new SimpleDateFormat(pattern2,localeUKR);
        String date3 = simpleDateFormat3.format(new Date());
        System.out.println(date3);

        DateFormatSymbols myDateFormatSymbols2 = new DateFormatSymbols(localeUKR);
        dateFormat = new SimpleDateFormat("dd--MMMM", myDateFormatSymbols2);
        System.out.println(dateFormat.format(currentDate));
    }

    private static DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols() {

        @Override
        public String[] getMonths() {
            return new String[]{"января", "февраля", "марта", "апреля", "мая", "июня",
                    "июля", "августа", "сентября", "октября", "ноября", "декабря"};
        }

    };



}
