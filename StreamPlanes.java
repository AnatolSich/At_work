import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toll on 20.11.2017.
 */





/*

*/
/* Аэропорт
1. В выполняющем классе создать метод waiting(), который отправляет нить в сон на 100мс
2. В выполняющем классе создать метод takingOff(), который отправляет нить в сон на 100мс
3. Создать класс Runway (взлетная полоса) (может отправлять 1 самолет за 1 секунду )
3.1 В классе Runway:
- создать приватную переменную типа Thread
- для переменной создать геттер и сеттер
4. В выполняющем классе создать статическую переменную RUNWAY, подумать, какой тип у данной переменной
5. Создать класс Plane, унаследовать его от Thread
6. В классе Plane:
- создать конструктор с параметром name, передать переменную name в конструктор суперкласса
- в конструкторе запустить нить
- реализовать метод run():
6.1 создать переменную isAlreadyTakenOff, подумать какой тип у переменной, инициализировать её значением по-умолчанию
6.2 пока переменная isAlreadyTakenOff имеет значение false, выполнять следующее:
- ЕСЛИ взлетная полоса свободна, занимать её
- выводить на экран надпись getName() + " взлетает"
- производить взлет самолета
- выводить на экран надпись getName() + " уже в небе"
- присвоить переменной isAlreadyTakenOff значение true
- освободить взлетную полосу
- ИНАЧЕ, если взлетная полоса занята самолетом
- выводить на экран надпись getName() + " ожидает"
- вызвать метод, который отвечает за ожидание
7. В выполняющем методе создать и запустить 3 нити(самолета)
*//*


public class StreamPlanes {
    public static int planesTakenOff = 0;

    static void waiting(Plane plane) {
        try {
            plane.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Runway extends Thread {
    boolean checking = false;
    Plane plane;

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @Override
    public void run() {
        while (true) {
            if (plane.isAlreadyTakenOff) {
                StreamPlanes.planesTakenOff++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Plane extends Thread {
    boolean isAlreadyTakenOff;
    Runway runway;

    public Plane(String name, Runway runway) {
        super(name);
        this.start();
        this.runway = runway;
    }

    @Override
    public void run() {
        while (!isAlreadyTakenOff) {
            if (!runway.checking) {
                runway.setPlane(this);
                System.out.println(getName() + " взлетает");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + " уже в небе");
                this.isAlreadyTakenOff = true;

                runway.setPlane(null);


            } else {
                StreamPlanes.waiting(this);
                System.out.println(getName() + " ожидает");
            }
        }
    }
}*/
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
