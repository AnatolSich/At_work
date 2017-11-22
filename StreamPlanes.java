import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Toll on 20.11.2017.
 */

/* Control tower Диспетчерская вышка
1. Самолеты и взлетные полосы - потоки
2. Самолет занимает свободную полосу и взлетает (взлет длится 2 сек)
3. После взлета вышка проводит самопроверку состояния (1 сек) и после этого готова к новому взлету

4. Башня контролирует взлеты (начинает взлеты, ищет свободную полосу и тд)

*/
public class StreamPlanes {
    static int rithm = 500;
    static int planeOff = 4 * rithm;
    static int runwayCheck = 3 * rithm;
    static int planeWait = 3 * rithm;
    //static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SSS");
    static SimpleDateFormat dateFormat = new SimpleDateFormat("ss:SSS");

    public static void main(String[] args) {



        List<Plane> planes = new ArrayList<>();
        List<Runway> runways = new ArrayList<>();
        FlightTower flightTower = new FlightTower(planes, runways);
        Plane An225 = new Plane("An-225", flightTower);
        Plane An148 = new Plane("An-148", flightTower);
        Plane An158 = new Plane("An-158", flightTower);
        Plane An178 = new Plane("An-178", flightTower);
        Plane An124 = new Plane("An-124", flightTower);
        Plane An70 = new Plane("An-70", flightTower);

        planes.add(An225);
        planes.add(An148);
        planes.add(An158);
        planes.add(An178);
        planes.add(An124);
        planes.add(An70);

        Runway runway001 = new Runway("Runway001", flightTower);
        Runway runway002 = new Runway("Runway002", flightTower);
        Runway runway003 = new Runway("Runway003", flightTower);



        runways.add(runway001);
        runways.add(runway002);
        runways.add(runway003);



        Date start = new Date();
        flightTower.startFlying();

        while (!flightTower.isEveryPlaneAway()) {

        }
        Date finish = new Date();

        System.out.println("Полеты длились  " + (finish.getTime() - start.getTime()) + "ms");


    }

}

class FlightTower {
    List<Plane> planes;
    List<Runway> runways;

    public boolean stop;

    public FlightTower(List<Plane> planes, List<Runway> runways) {
        this.planes = planes;
        this.runways = runways;
    }

    public void waiting(Thread thread) {
        System.out.println(StreamPlanes.dateFormat.format(new Date().getTime())+" "+thread.getName() + " waiting...");
        try {
            Thread.sleep(StreamPlanes.planeWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized Runway freeRunway() {
        for (Runway runway : runways
                ) {
            if (runway.isReady == true && runway.plane == null) {
                return runway;
            }
        }
        Runway nullRunway = new Runway("NULL", this);
        return nullRunway;
    }

    public boolean isEveryPlaneAway() {
        for (Runway runway : runways
                ) {
            if (!runway.isReady) {
                return false;
            }
        }

        for (Plane plane : planes
                ) {
            if (!plane.isAlreadyTakenOff) {
                return false;
            }
        }
        return true;
    }

    public void startFlying() {
        for (Runway runway : runways
                ) {
            runway.start();
        }
        for (Plane plane : planes
                ) {
            plane.start();
        }
    }

}

class Plane extends Thread {
    boolean isAlreadyTakenOff;
    FlightTower flightTower;

    public Plane(String name, FlightTower flightTower) {
        super(name);
        this.flightTower = flightTower;

    }

    @Override
    public void run() {


        while (!isAlreadyTakenOff) {

            Runway runway = flightTower.freeRunway();
            if (!runway.getName().equals("NULL")) {
                runway.plane = this;
                runway.isReady = false;
                System.out.println(StreamPlanes.dateFormat.format(new Date().getTime()) + " " + this.getName() + " взлетает на полосе " + runway.getName());
                takingAway();
                runway.plane = null;
            } else
                flightTower.waiting(this);

        }
    }

    private void takingAway() {

        try {
            Thread.sleep(StreamPlanes.planeOff);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.isAlreadyTakenOff = true;
        System.out.println(StreamPlanes.dateFormat.format(new Date().getTime()) + " " + this.getName() + " is away");
    }

}

class Runway extends Thread {
    boolean isReady;
    Plane plane;
    FlightTower flightTower;

    public Runway(String name, FlightTower flightTower) {
        super(name);
        this.flightTower = flightTower;
    }

    @Override
    public void run() {
        this.selfchecking();
        while (!flightTower.isEveryPlaneAway()) {
            if (this.plane == null && this.isReady == false) {
                System.out.println(StreamPlanes.dateFormat.format(new Date().getTime()) + " " + this.getName() + " занята...");
                this.selfchecking();
            } else if (this.plane != null && this.isReady == false) {
                System.out.println(StreamPlanes.dateFormat.format(new Date().getTime()) + " " + this.getName() + " занята...");
                try {
                    Thread.sleep(StreamPlanes.rithm);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (this.plane == null && this.isReady == true) {
                System.out.println(StreamPlanes.dateFormat.format(new Date().getTime()) + " " + this.getName() + " свободна...");
                try {
                    Thread.sleep(StreamPlanes.rithm);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void selfchecking() {
        try {
            Thread.sleep(StreamPlanes.runwayCheck);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.isReady = true;
    }
}
