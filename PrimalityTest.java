import java.math.BigInteger;

public class PrimalityTest {
    public static void main(String[] args) {
        System.out.println(isPrime(BigInteger.valueOf(91)));
       /* for (int i = 2; i < 70; i++) {
            System.out.print(i+"   ");
            System.out.println(isPrime(BigInteger.valueOf(i)));
        }*/

    }

    private static boolean isPrime(BigInteger n){
        int[] shablon = {2,3,5,7,11,13,23,29,31,37,41,43,47,53,59,61};

        for (int i = 0; i < shablon.length; i++) {
            if(n.equals(BigInteger.valueOf(shablon[i]))) return true;
        }
        BigInteger a2= BigInteger.valueOf(2);
        BigInteger a3= BigInteger.valueOf(3);

        if(n.mod(a2).equals(BigInteger.ZERO)||n.mod(a3).equals(BigInteger.ZERO)) return false;
        else {
            int init = 6;
            int max=  (int)Math.sqrt(n.doubleValue());



            for (int i = init; i < max; i+=6) {
                BigInteger niz=BigInteger.valueOf(i-1);
                BigInteger verh=BigInteger.valueOf(i+1);

                if((n.mod(niz).equals(BigInteger.ZERO) & !n.equals(niz)) || (n.mod(verh).equals(BigInteger.ZERO) & !n.equals(verh))) return  false;
            }
            return true;
        }
    }
}
