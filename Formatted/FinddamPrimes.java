import org.w3c.dom.ls.LSOutput;
import java.util.Iterator;
import java.util.Formatter;

import java.util.ArrayList;

public class FinddamPrimes {
    public static void main(String[] args) {
        ArrayList array1 = new ArrayList();
        Formatter fmt = new Formatter();
        ;
        for ( int i = 2; i<= 100; i++){
            CheckPrimes checkPrimes = new CheckPrimes();
            if(checkPrimes.checdamnums(i) == 0){
                array1.add(i);
            }
        }

        for (Iterator<Integer> iter= array1.iterator();iter.hasNext();) {



            fmt.format("%10d", iter.next());





        }


        System.out.print(fmt);

        System.out.println();





    }}




