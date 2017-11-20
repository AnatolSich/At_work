import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toll on 20.11.2017.
 */

/* Control tower Диспетчерская вышка
1. Самолеты и взлетные полосы - потоки
2. Самолет занимает свободную полосу и взлетает (взлет длится 2 сек)
3. После взлета вышка проводит самопроверку состояния (1 сек) и после этого готова к новому взлету

4. Башня контролирует взлеты (начинает/заканчивает взлеты, ищет свободную полосу и тд)

*/
public class StreamPlanes {
    public static void main(String[] args) {
        List<Plane> planes = new ArrayList<>();
        List<Runway> runways = new ArrayList<>();
        planes.add(new Plane("An-225"));
        planes.add(new Plane("An-148"));

        runways.add(new Runway("Runway001"));

        FlightTower flightTower = new FlightTower(planes, runways);

        flightTower.startFlying();

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
        System.out.println(thread.getName() + " waiting...");
        try {
            thread.wait(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Runway freeRunway() {
        for (Runway runway : runways
                ) {
            if (runway.isReady) {
                return runway;
            }
        }
        return null;
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

    public Plane(String name) {
        super(name);
    }

    @Override
    public void run() {



        while (!isAlreadyTakenOff) {
            Runway runway;
            try {
                runway = flightTower.freeRunway();
                runway.plane = this;
                runway.isReady = false;
                takingAway();
                runway.plane = null;
            } catch (NullPointerException e) {
                flightTower.waiting(this);
            }
        }
    }

    private void takingAway() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.isAlreadyTakenOff = true;
        System.out.println(this.getName() + " is away");
    }

}

class Runway extends Thread {
    boolean isReady;
    Plane plane;
    FlightTower flightTower;

    public Runway(String name) {
        super(name);
    }

    @Override
    public void run() {
        this.selfchecking();
        while (!flightTower.isEveryPlaneAway()) {
            if (this.plane == null && this.isReady == false) {
                this.selfchecking();
            }

        }
    }

    private void selfchecking() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.isReady = true;
    }
}
