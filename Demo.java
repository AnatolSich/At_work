import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Toll on 29.06.2017.
 */
public class Demo {
    final public static void main(String[] args) {
        System.out.println(1L>>2L);
        /*Car car1 = new Car("Toyota", 2000);
        Car car2 = new Car("Nissan", 1800);
        Car car3 = new Car("Audi", 3500);
        Car car4 = new Car("Mersedes", 4000);
        Car car5 = new Car("Kia", 1600);
        Car car6 = new Car("Zaz", 1400);
        Car car7 = new Car("Fiat", 1800);
        Car car8 = new Car("Jaguar", 3600);

      //  Queue <Car> queue = new ArrayBlockingQueue<Car>(4); //ограничения по емкости
        Deque<Car> queue = new ArrayDeque<Car>();


       *//* System.out.println(queue.element()); //the head of this queue
        System.out.println(queue.remove()); //the head of this queue*//*

        for (Car car : queue) {
            System.out.println(car);
        }


       *//* System.out.println("----------------");
        for (Car car:queue
             ) {
            System.out.println(car);
        }*//*

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
        System.out.println(lifoQueue.remove());*/

        int[][] x  = new int[2][5];
        int[][] y = new int[2][5];
        System.out.println(x[1][3]);
        System.arraycopy(x, 0, y, 0, x.length);
        x[1][3] = 55;
        System.out.println(y[1][3]);

       // int[][] a = new int[3][]; // line 1
       /* a[0] = new int[2];        // line 2
        a[1] = new int[4];        // line 3
        a[2] = new int[3];        // line 4*/

      //
        //
        // System.out.println(a[0]);

        /*int i=2;
        switch (i){
            case 1 : System.out.println(1);
            case 2 : System.out.println(2);
            default : System.out.println("d");

            case 3 : System.out.println(3);*/

     //   }


    }
}
