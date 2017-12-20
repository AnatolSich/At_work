import java.util.Arrays;

public class SelectSorting {
    private static int[] input = {5,3,6,9,-2,0,1};

    public static void main(String[] args) {
       // System.out.println(minValue(0,input));
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(SelectSort(input)));

    }

    private static int[] SelectSort(int[] input){
        //int res[]=new int[input.length];
        for (int i = 0; i <input.length ; i++) {
            int indexMin = minValue(i,input);
            if(indexMin!=i) {
                int temp=input[i];
                input[i]=input[indexMin];
                input[indexMin]=temp;
            }
        }
return input;
    }
    private  static  int  minValue(int from,int [] input){
        int res=from;
        for (int i = from; i < input.length; i++) {
            if(input[res]>input[i]) res=i;
        }
        return res;
    }
}
