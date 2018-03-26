package Recursion;

public class AtoBRecur {

    public static void main(String[] args) {
      fromAtoB(10,5);
    }


    private static void fromAtoB(int a, int b) {
        System.out.println(a);
        if(a==b) return;
        if (a < b) {
            fromAtoB(a + 1, b);
        } else if (a > b) {
            fromAtoB(a - 1, b);
        }
    }
}
