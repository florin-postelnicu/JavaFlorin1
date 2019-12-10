

public class TestStringSeparation {


    public static void main(String[] args) {
        int k = 0;

        for( int i = 10101; i<=1010101; i++) {


            ConvertNumberIntoCharArray cvna = new ConvertNumberIntoCharArray();
            char[] newList = cvna.ZArrayList(i);

            if (cvna.CheckPoly(newList) == 0) {
                    k = k+1;
                    if(k%10 == 0){
                        System.out.println("\n");


                    }else{
                    System.out.printf("%10d",i);
                }

        }

    }}}












