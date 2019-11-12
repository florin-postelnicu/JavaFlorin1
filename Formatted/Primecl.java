import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.lang.Math;
public class Primecl {
    int msg;

    public  int checkprime(int n) {
        int detect = 0;
        int up = (int)Math.sqrt( n) + 1;
        for (int i = 2; i < up; i++) {
            if (n % i == 0) {
                detect = 1;
            }
        }
        return detect;
