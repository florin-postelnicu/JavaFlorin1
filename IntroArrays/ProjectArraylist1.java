
import java.util.ArrayList;
import java.util.Collections;



public class ProjectArraylist1 {
    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("cat");
        animals.add("dog");
        animals.add("koala");
        animals.add("monkey");
        System.out.println(animals);


        System.out.println(animals.get(0));
        System.out.println("Change the element of index 0 to horse");
        animals.set(0, "horse");
        System.out.println(animals);

        System.out.println("Eliminate the element at index 2");
        animals.remove(2);
        System.out.println(animals);


        System.out.println("Insert a new element at a specific index");
        animals.add(2,"owl");


        System.out.println(animals);


        System.out.println("Use properties of collections to operate over Arrailist ; sort");
        Collections.sort(animals);
        System.out.println(animals);

        System.out.println("shuffle the array list");
        Collections.shuffle(animals);
        System.out.println(animals);

        System.out.println(animals.size());
        

    }

}
