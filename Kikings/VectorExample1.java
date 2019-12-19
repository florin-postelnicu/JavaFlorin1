
import java.util.*;


public class VectorExample1 {

    public static void main(String[] args) {
        /* Vector if initial capacity(size) of 2*/
        Vector<String> vec = new Vector<String>(2, 5);
        /*
        Adding elements to vector vec
         */
        vec.addElement("Apple");
        vec.addElement("Banana");
        vec.addElement("Chery");
        vec.addElement("Duran");

        /*
        Check size and capacityIncrement
         */
        System.out.println("Size is " + vec.size());
        System.out.println("Capacity Increment is  " + vec.capacity());

        vec.addElement("fruit1");
        vec.addElement("fruit2");
        vec.addElement("fruit3");


         /*
        Check size and capacityIncrement after two insertions
         */
        System.out.println("Size is " + vec.size());
        System.out.println("Capacity Increment is  " + vec.capacity());

        /*
        Display Vector elements
         */
        Enumeration en = vec.elements();
        System.out.println("\nElements are :");
        while (en.hasMoreElements()) {
            System.out.println(en.nextElement() + "  ");
        }
        System.out.println(vec.firstElement());
        System.out.println(vec.elementAt(3));
        System.out.println(vec.indexOf("Duran"));
        System.out.println(vec.remove(3));


    }

}