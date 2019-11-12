


/*
Use printf to create the format you need, without invoking java.util.Formatter
https://www.geeksforgeeks.org/understanding-array-indexoutofbounds-exception-in-java/
 */

import java.util.ArrayList;


public class FindZPrimes {

    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<>();

        for (int i = 2; i <= 1000; i++) {
            Primecl primecl = new Primecl();

            if (primecl.checkprime(i) == 0) {
                array1.add(i);
            }
        }
        System.out.println(array1.size());
        System.out.println(array1.get(3));

        int k = 0;
        for (Integer integer : array1) {
            k = k + 1;
            if (k % 10 == 0) {
                System.out.println("\n");
            } else {
                System.out.printf("%10d", integer);
            }
        }
    }}













