import java.text.ParseException;
import java.util.*;

/**
 * Created by Toll on 29.06.2017.
 */
public class DayDemo {
    public static void main(String[] args) {
       /* Date date = new Date();
        System.out.println(date.getTime());*/
       /*DateDay dateDay1 = new DateDay();
       DateDay dateDay2 = new DateDay();
       DateDay dateDay3 = new DateDay();
       DateDay dateDay4 = new DateDay();

        EnumSet <DayOfWeek> workDaysOfWeek = EnumSet.range(DayOfWeek.MONDAY,DayOfWeek.FRIDAY);
        for (DayOfWeek day:workDaysOfWeek
             ) {
            System.out.println(day);
        }*/

      //  EnumMap<DayOfWeek, DateDay> enumMap = new EnumMap<DayOfWeek, DateDay>(DayOfWeek.class);

        /*List<DateDay> listMon = new ArrayList<>();
        List<DateDay> listTue = new ArrayList<>();
        List<DateDay> listWed = new ArrayList<>();
        List<DateDay> listThue = new ArrayList<>();
        List<DateDay> listFri = new ArrayList<>();
        List<DateDay> listSat = new ArrayList<>();
        List<DateDay> listSun = new ArrayList<>();*/


       /* for (int i = 0; i < 5; i++) {
            DateDay dateDay = new DateDay();
            DayOfWeek dayOfWeek = DayOfWeek.values()[(dateDay.getDate().getDay()-1)];

            enumMap.put(dayOfWeek, dateDay);
        }*/

        /*for (int i = 0; i < 15; i++) {
            DateDay dateDay = new DateDay();
            switch (dateDay.getDate().getDay()) {
                case 1:
                    listMon.add(dateDay);
                    break;
                case 2:
                    listTue.add(dateDay);
                    break;
                case 3:
                    listWed.add(dateDay);
                    break;
                case 4:
                    listThue.add(dateDay);
                    break;
                case 5:
                    listFri.add(dateDay);
                    break;
                case 6:
                    listSat.add(dateDay);
                    break;
                case 7:
                    listSun.add(dateDay);
                    break;

            }
        }*/
        EnumMap<DayOfWeek, List<DateDay>> enumMap2 = new EnumMap<DayOfWeek, List<DateDay>>(DayOfWeek.class);

        for (DayOfWeek dayOfWeek :DayOfWeek.values()
                ) {
            System.out.println(dayOfWeek);
            List<DateDay> list = new ArrayList<>();


            for (int i = 0; i < 3; i++) {
                DateDay dateDay = new DateDay();
                if (DayOfWeek.values()[dateDay.getDate().getDay()].equals(dayOfWeek)) list.add(dateDay);
            }

            enumMap2.put(dayOfWeek, list);


        }

        /*enumMap2.put(DayOfWeek.MONDAY, listMon);
        enumMap2.put(DayOfWeek.TUESDAY, listMon);
        enumMap2.put(DayOfWeek.WEDNESDAY, listWed);
        enumMap2.put(DayOfWeek.THURSDAY, listWed);
        enumMap2.put(DayOfWeek.FRIDAY, listWed);
        enumMap2.put(DayOfWeek.SATUDAY, listWed);
        enumMap2.put(DayOfWeek.SUNDAY, listWed);*/

        System.out.println("--------------------");
        Iterator<EnumMap.Entry<DayOfWeek, List<DateDay>>> iter = enumMap2.entrySet().iterator();
        while (iter.hasNext()) {
            EnumMap.Entry<DayOfWeek, List<DateDay>> entry = iter.next();
            for (DateDay dateDay2 : entry.getValue()
                    ) {
                System.out.println(entry.getKey() + "=====" + dateDay2.getDate());
            }
        }


    }
}
