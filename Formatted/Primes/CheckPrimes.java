
import java.lang.Math;

public class CheckPrimes {

    public int checdamnums(int n){
        int up = (int)Math.sqrt(n) + 1;
        int mark = 0;
        for (int d = 2; d< up; d++){
            if(n%d == 0){
                mark = 1;
                break;
            }
        }
        return mark;


    }

}
