/**
 * Created by Toll on 30.11.2017.
 */
public class Fibonachi {
    public static void main(String[] args) {
        System.out.println(fibo(8));
    }


    private static int fibo(int n){
        if(n==0) return 0;
        if (n==1) return 1;
        int res = fibo(n-1)+fibo(n-2);
        return res;
    }
}
