import java.util.Arrays;

public class ProjectArray1 {
    public static void main(String[] args) {
        // State the type of elements in the array,and how many of them are
        int [] ar = new int[10];
        ar[0] =1;
        ar[1]= 2;
        ar[2] =3;
        ar[3] =4;

        for(  int el : ar){
            System.out.println(el);
        }
        ar[4] = 5;
        for( int el : ar){
            System.out.println(el);
        }
        System.out.println("Array's length : "+ ar.length);

        System.out.println("print the whole array" + Arrays.toString(ar));

        for(int el: ar){
            if(el == 0){
                System.out.println("Zero!");
            }
        }
        System.out.println(Arrays.toString(ar));

        for( int index = 0; index< ar.length; index++){
            if( ar[index]== 0){
                ar[index]= index +1 ;
            }
        }
        System.out.println(Arrays.toString(ar));
    }
}
