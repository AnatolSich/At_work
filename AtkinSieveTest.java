import java.text.SimpleDateFormat;
import java.util.*;


public class AtkinSieveTest {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("ss:SSS");
    static SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss:SSS");

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Date start = new Date();
        System.out.println(dateFormat2.format(start.getTime()));
        /*Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();*/
        // BitSet primes = AtkinSieve.getPrimesUpTo(10000,99999);
        BitSet primes = AtkinSieve.getPrimesUpTo(99999);
        // Вывод последовательности
        for (int number = 10000; number <= 99999; ++number)
            if (primes.get(number))
                list.add(number);
      /*  for (int i:list
             ) {
            System.out.print(i+"  ");
        }*/

        // System.out.println(list.get(list.size()-1));

        System.out.println(maxNumber(list));
        Date finish = new Date();
        System.out.println(dateFormat2.format(finish.getTime()));
        System.out.println(dateFormat.format(finish.getTime() - start.getTime()) + " sec");
    }

    private static String maxNumber(List<Integer> list) {
        long res = 0L;
        long res1 = 0L;
        long res2 = 0L;
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                long n1 = list.get(i);
                long n2 = list.get(j);
                long proz = n1 * n2;
                String str = String.valueOf(proz);
                if (isPalindrome(str) & proz > res) {
                    res1=n1;
                    res2=n2;
                    res = proz;
                }
            }
        }
        System.out.println(res1);
        System.out.println(res2);
        return String.valueOf(res);
    }

    private static boolean isPalindrome(String str) {
        if (str == null)
            return false;
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.reverse();
        return strBuilder.toString().equals(str);
    }
}