

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import java.util.List;


public class TwoDList {

    public static int NewVal(int old_val){
        return old_val+1;
    }
    public static void main(String[] args) {

        ArrayList<Integer> aug = new ArrayList<>();



        List<int[]> rows = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            rows.add(new int[]{0, 0, 0, 0, 0, 0, 0,});
        }

        System.out.println(rows.get(0)[0]);
      

       // Make the Augmentation array

        aug.add(0, NewVal(rows.get(0)[0]+1));

        aug.add(1,NewVal(rows.get(1)[0]+1) );

        aug.add(2, NewVal(rows.get(1)[2]+1));
        aug.add(3, NewVal(rows.get(2)[3]+1));
        aug.add(4, NewVal(rows.get(3)[4]+1));
        aug.add(5, NewVal(rows.get(4)[0]+1));
        aug.add(6,NewVal( rows.get(5)[0]+1));

        System.out.println("\nVector aug");

        for(int i =0; i< 7;i++){
            System.out.println(aug.get(i));

        }


        int rom = rows.size();

        int col = rows.get(0).length;
        for(int c = 0; c <7; c++){
            aug.add(rows.get(0)[c]+2);}
        

        System.out.println(rom);
        System.out.println(col);
        System.out.println("\nOriginal Matrix");

        for (int r = 0; r < rom; r++) {
            for (int c = 0; c < col; c++) {
                System.out.printf("%10d", rows.get(r)[c]);
            }
            System.out.println("\n");
        }

        rows.add(0, new int[]{1, 1, 1, 1, 1, 1, 1});

        System.out.println("\nAugmented Matrix");
        for (int r = 0; r < rom; r++) {
            for (int c = 0; c < col; c++) {
                System.out.printf("%10d", rows.get(r)[c]);
            }
            System.out.println("\n");

        }
        rows.set(1, new int[]{1,1,1,1,1,1,1});
        System.out.println("\nAugmented Matrix");
        for (int r = 0; r < rom; r++) {
            for (int c = 0; c < col; c++) {
                System.out.printf("%10d", rows.get(r)[c]);
            }
            System.out.println("\n");

        }

        System.out.println("\nAugmented Matrix");
        for (int r = 0; r < rom; r++) {
            for (int c = 0; c < col; c++) {
                System.out.printf("%10d", rows.get(r)[c]);
            }
            System.out.println("\n");
        }
    }
}
