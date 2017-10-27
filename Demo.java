import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Toll on 29.06.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", 2000);
        Car car2 = new Car("Nissan", 1800);
        Car car3 = new Car("Audi", 3500);
        Car car4 = new Car("Mersedes", 4000);
        Car car5 = new Car("Kia", 1600);
        Car car6 = new Car("Zaz", 1400);
        Car car7 = new Car("Fiat", 1800);
        Car car8 = new Car("Jaguar", 3600);

      //  Queue <Car> queue = new ArrayBlockingQueue<Car>(4); //ограничения по емкости
        Deque<Car> queue = new ArrayDeque<Car>();


       /* System.out.println(queue.element()); //the head of this queue
        System.out.println(queue.remove()); //the head of this queue*/

        for (Car car : queue) {
            System.out.println(car);
        }


       /* System.out.println("----------------");
        for (Car car:queue
             ) {
            System.out.println(car);
        }*/

        Queue<Car> lifoQueue = Collections.asLifoQueue(queue);
        lifoQueue.add(car1);
        lifoQueue.add(car2);
        lifoQueue.add(car3);
        lifoQueue.add(car4);
        lifoQueue.add(car5);
        lifoQueue.add(car6);
        lifoQueue.add(car7);
        lifoQueue.add(car8);

        System.out.println("----------------");
        for (Car car : lifoQueue
                ) {
            System.out.println(car);
        }
        System.out.println("----------------");
        System.out.println(lifoQueue.remove());
    }
}
