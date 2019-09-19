
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.Math;
import java.util.Scanner;

public class SelectWord {

    ConvertArrayList cov =new  ConvertArrayList();


    public String get_a_new_Word(){
        cov.creatArray();
        int limit = cov.stringArrayList.size();
        int max = limit;
        int min = 0;
        int range = max - min + 1 ;
        int index = (int)(Math.random()* range + min);
        return  cov.stringArrayList.get(index);

    }
}

