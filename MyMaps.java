import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Toll on 29.06.2017.
 */
public class MyMaps {

    public static void main(String[] args) {
        //       Map<Double, Car> map = new HashMap<>();
        Map<Car, Double> map = new LinkedHashMap<>();

        Car car1 = new Car("Toyota", 2000);
        Car car2 = new Car("Nissan", 1800);
        Car car3 = new Car("Audi", 3500);
        Car car4 = new Car("Mersedes", 4000);
        Car car5 = new Car("Kia", 1600);

        Car[] carArray = {car1, car2, car3, car4, car5};
        Double d = 2.50;
        int i = 2;
        for (Car car : carArray
                ) {
            map.put(car, d + d * i++);
        }

        printing(map);

        System.out.println("Размер: " + map.size());


    }

    private static void printing(Map <Car,Double> map) {
        Iterator<Map.Entry<Car,Double>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Car,Double> entry = iter.next();
            //  Car car = entry.getValue();
            System.out.println(entry.getKey().getModelName() + " " + entry.getKey().getEngineVolume() + " | " + entry.getValue());
        }
    }

}
