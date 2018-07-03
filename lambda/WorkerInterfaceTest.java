package lambda;

// определении функционального интерфейса
@FunctionalInterface
interface WorkerInterface {

    public void doSomeWork();

}

@FunctionalInterface
interface SomeFunc<T,O> {
    public O doFunc(T t);

}



public class WorkerInterfaceTest {

    public static void execute(WorkerInterface worker) {
        worker.doSomeWork();
    }

    public static void main(String [] args) {

        // вызов метода doSomeWork через анонимный класс
        // (классический способ)
        execute(new WorkerInterface() {
            @Override
            public void doSomeWork() {
                System.out.println("Worker вызван через анонимный класс");
            }
        });

        // вызов метода doSomeWork через Lambda-выражения
        // (нововведение Java 8)
        execute( () -> System.out.println("Worker вызван через Lambda") );


        SomeFunc <String, Integer> funcStr = (str) -> {
                return Integer.parseInt(str);
        };
        SomeFunc <Integer,String> funcInt = (i) -> {
                return String.valueOf(i);
        };

        System.out.println(funcStr.doFunc("405"));
        System.out.println(funcInt.doFunc(1036));

    }

}