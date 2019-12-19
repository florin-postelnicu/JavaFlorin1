
/*
hashCode of an object

The hashcode of a Java Object is simply a number,
 it is 32-bit signed int, that allows an object to be managed by a hash-based data structure.
 We know that hash code is an unique id number allocated to an object by JVM. ...
 If two objects are equals then these two objects should return same hash cod

  System.out.println(rows.hashCode());

 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;


public class TwoDArlist {
    public static void main(String[] args) {


        ArrayList<Integer> WinList = new ArrayList<>();
        List<int[]> rows = new ArrayList<>();
        rows.add(new int[]{0,0,0,0,0,0,0});
        rows.add(new int[]{0,0,0,0,0,0,0});
        rows.add(new int[]{0,0,0,0,0,0,0});
        rows.add(new int[]{0,0,0,0,0,0,0});
        rows.add(new int[]{0,0,0,0,0,0,0});
        rows.add(new int[]{0,0,0,0,0,0,0});

        int rom = rows.size();
        int col = rows.get(0).length;


        // get element at row :0 , column : 0
        System.out.println("[0][0] : "+ rows.get(0)[0]);

        // get element at row : 1, column :1

        System.out.println("[1][1]  : "+ rows.get(1)[1]);

        // get element at row :0, column : 2
        System.out.println("[0][2]  :"+ rows.get(0)[2]);
        for( int r = 0; r< rom;r++){
            for(int c = 0; c < col;c++){
                System.out.printf("%10d", rows.get(r)[c]);

            }
            System.out.println("\n");
        }
        WinList.add(rows.get(0)[0]);
        WinList.add(rows.get(0)[1]);
        WinList.add(rows.get(0)[2]);
        WinList.add(rows.get(0)[3]);
        WinList.add(rows.get(0)[4]);
        WinList.add(rows.get(0)[5]);
        WinList.add(rows.get(0)[6]);


        System.out.println("\nWinList before Augmentation");


        System.out.println("\nModify the elements of the WinList by augmenting each value with + 1");
        for(int w = 0; w< WinList.size(); w++){
            int buss = WinList.get(w) +1;
            WinList.set(w, buss) ;


        }


        rows.set(0, [WinList.get(0),WinList.get(1)]);








    }
}
