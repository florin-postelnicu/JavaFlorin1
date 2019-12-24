
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

/*
Sorting a vector
 */

public class VectorCollection {


    public static void main(String[] args) {
        Vector<String> vector = new Vector<String>() ;
        for(int i=0 ; i< 10; i++){
            vector.add("Element"+i);

        }
        Enumeration en = vector.elements();
        System.out.println("\nVector's Elements");
        while (en.hasMoreElements()){
            System.out.println(en.nextElement()+ " ");
        }

        Collections.reverseOrder();
        for(int i =0; i< vector.size();i ++){
            System.out.println(vector.get(i));

        }
        Collections.reverse(vector);
        for(int i =0; i< vector.size();i ++){
            System.out.println(vector.get(i));

        }
        Collections.sort(vector);
        for(int i =0; i< vector.size();i ++){
            System.out.println(vector.get(i));
        }

        System.out.println(Collections.max(vector));
        System.out.println(Collections.min(vector));
    }}
