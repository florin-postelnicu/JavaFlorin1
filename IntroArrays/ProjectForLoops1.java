

import java.util.Arrays;
import java.util.List;

public class ProjectForLoops1 {


    public static int[] ar = new int[]{11, 12, 13, 14, 15, 16, 17, 18};

    public static void main(String[] args) {


    // using for loops with iterator
    for(int iter = 0; iter < ar.length; iter ++  ){


        System.out.println("At index  :"+ iter +" is the element : "+  ar[iter]);}

    // Using for loop with collection


     for( int element: ar)   {
         System.out.println(element);
     }


     String word = "anticonstitutional";
     char[] starr =word.toCharArray();

     for (char letter : starr){
         System.out.print(letter + " , ");
     }
}
}