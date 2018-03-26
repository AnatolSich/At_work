package Recursion;

public class NaturRecur {

    public static void main(String[] args) {
        System.out.println(natur(3));
    }

    private static String natur(int n) {
        if(n==1) return "1";
          return natur(n-1)+" "+n;
    }
}
