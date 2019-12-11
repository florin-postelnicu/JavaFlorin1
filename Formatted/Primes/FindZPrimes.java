
import java.util.ArrayList;


public class FindZPrimes {

    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<>();

        for (int i = 2; i <= 1000; i++) {
            CheckPrimes checkPrimes = new CheckPrimes();
            if(checkPrimes.checdamnums(i) == 0){
                array1.add(i);
            }
        }
        int k = 0;
        for (Integer integer : array1) {
            k = k + 1;
            if (k % 7== 0) {

                System.out.println("\n");
            } else {
                System.out.printf("%10d", integer);
            }
        }
    }}




