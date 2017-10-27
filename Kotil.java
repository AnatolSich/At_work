import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toll on 30.08.2017.
 */
public class Kotil {

    public int i = 0;

    static class Df {
        private Df() {
        }

        List<Integer> list = new ArrayList();
        Kotil.Df k = new Kotil.Df();


        //  i=9;
    }

    class Df2 {
        public Df2() {
            i = i + 1;
            Kotil f = Kotil.this;

        }

    }

    public static void main(String[] args) {
        new Df();
        //   new Df2();
    }
}
