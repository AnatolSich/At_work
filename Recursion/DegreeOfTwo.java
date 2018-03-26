package Recursion;

public class DegreeOfTwo {

    public static void main(String[] args) {
        System.out.println(isDegreeOfTwo(120));
    }

    private static String isDegreeOfTwo(int n){
        if(n==1) return "y";
        else if((n%2)!=0) return "n";
        return isDegreeOfTwo(n/2);
    }
}
