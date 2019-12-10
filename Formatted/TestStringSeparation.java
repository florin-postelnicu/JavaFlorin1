

public class TestStringSeparation {


    public static void main(String[] args) {

        for( int i = 10101; i<=1010101; i++) {


            ConvertNumberIntoCharArray cvna = new ConvertNumberIntoCharArray();
            char[] newList = cvna.ZArrayList(i);
            int k = 0;
            if (cvna.CheckPoly(newList) == 0) {

                for(int j = 0; j<= 10; j++){
                    k = k+1;
                    if(k%10 == 0){
                        System.out.println("\n");


                    }else{
                    System.out.printf("%10d",i);
                }
                    
        }

    }}}}












