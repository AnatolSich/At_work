package defaultMethod;


public class Car implements Vehicle, FourWheeler {


   /* //Own implementation
    @Override
    public boolean print() {
        System.out.println("FourWheeler vehicle!");
        return false;
    }*/

   //Call the default method of the specified interface using super
    @Override
    public boolean print() {
        Vehicle.super.print();
        return false;
    }
}

interface Vehicle{
    default boolean print(){
        System.out.println("Vehicle!");
        return true;
    }
}

interface FourWheeler{
    default boolean print(){
        System.out.println("FourWheeler!");
        return true;
    }
}

