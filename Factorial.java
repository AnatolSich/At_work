import java.math.BigInteger;

/**
 * Created by Toll on 30.11.2017.
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(fact((BigInteger.valueOf(5))));
        System.out.println(double_fact((BigInteger.valueOf(5))));
        System.out.println(double_fact((BigInteger.valueOf(6))));
       // System.out.println(BigInteger.ONE.equals(BigInteger.valueOf(1)));
    }

    private static BigInteger fact(BigInteger n){
        if(n.equals(BigInteger.ZERO)||n.equals(BigInteger.ONE)) return BigInteger.ONE;

        BigInteger res = n.multiply(fact(n.subtract(BigInteger.ONE)));
        return res;
    }

     private static BigInteger double_fact(BigInteger n){
        if(n.equals(BigInteger.ZERO)||n.equals(BigInteger.ONE)) return BigInteger.ONE;

        BigInteger res = n.multiply(double_fact(n.subtract(BigInteger.valueOf(2))));
        return res;
    }



}
