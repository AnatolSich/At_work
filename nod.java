import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Toll on 01.09.2017.
 */
public class nod {
    public static void main(String[] args) throws IOException {
        int []A = creating();
        System.out.println(maxNod(A[0],A[1]));
    }

    private static int maxNod(int a, int b) {
        if (b == 0) return a;
        return maxNod(b, a % b);
    }

    private static int[] creating() throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int[] A = {0, 0};
        for (int i = 0; i < 2; i++) {
            A[i] = Integer.parseInt(bfr.readLine());
        }
        return A;
    }
}
