

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreateHashMapExample {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Creating a HashMap
        Map< String, Integer> numberMapping = new HashMap<>();

        //Adding key-value pairs to HashMap
        numberMapping.put("One", 1);
        numberMapping.put("Two", 2);
        numberMapping.put("Three", 3);
        numberMapping.put("Four", 2);
        System.out.println(numberMapping);
        System.out.println("Enter a Key to check if it is in your HashMap");
        String keyhm = scan.next();
        if (numberMapping.containsKey(keyhm)){
            System.out.println("Key is " + keyhm +"  and the value of it is " + numberMapping.get(keyhm));
        }
        else {
            System.out.println("Not a key!");
        }

        System.out.println("Enter a Value to check if it is in your HashMap");
        int valhm = scan.nextInt();

        if (numberMapping.containsValue(valhm)) {
            for (String k : numberMapping.keySet()) {

                if (numberMapping.get(k).equals(valhm)) {


                    System.out.println("Value is " + valhm + "  and the keys of it are " + k);
                }
            }
        }
        else {
            System.out.println("Not a value!");
        }

    }
}
