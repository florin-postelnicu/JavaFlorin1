
import java.util.Arrays;

public class ProjectArray2 {

    public static void main(String[] args) {
        String[] strings = new String[5];
        strings[0] = "apple";
        strings[1] = "banana";
        strings[2] = "orange";
        strings[3] = "blueberries";
        strings[4] = "Strawberries";
        strings[0] = "melon";
        System.out.println("Elements of the Array strings");
        for(String elem : strings){
            System.out.println(elem);
        }
        for( int index = 0; index < strings.length; index ++){
            System.out.printf("%20s,%3d",strings[index], index);
            System.out.println("\n");
        }
    }
}
