
/*
Use printf to create the format you need, without invoking java.util.Formatter
https://www.geeksforgeeks.org/understanding-array-indexoutofbounds-exception-in-java/
 */

import java.util.ArrayList;
//import java.util.Formatter;
import java.util.Iterator;
import java.lang.IndexOutOfBoundsException;

public class FinddamPrimes {

    public static void main(String[] args) {
        ArrayList array1 = new ArrayList<Integer>();
//        Formatter fmt = new Formatter();


        for (int i = 2; i <= 100000; i++) {
            Primecl primecl = new Primecl();

            if (primecl.checkprime(i) == 0) {
                array1.add(i);
            }
        }
        System.out.println(array1.size());
        System.out.println(array1.get(3));
        try {
            for (int i = 0; i <= array1.size() / 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.printf("%10d", array1.get(i * 5 + j));
                }

                System.out.println("\n");

            }
        }catch( IndexOutOfBoundsException e){
            System.out.println("");
        }


//        for (Iterator<Integer> iter= array1.iterator();iter.hasNext();) {
//
//            fmt.format("%10s", iter.next());
//
//    }
//
//
//        System.out.print(fmt);

}
}











