

public class TestStringSeparation {


    public static void main(String[] args) {


        ConvertNumberIntoCharArray cvna = new ConvertNumberIntoCharArray();
        char[] newList = cvna.ZArrayList(203406043);
        if (cvna.CheckPoly(newList) == 0){
            System.out.println("POLY");

        }
        else{
            System.out.println("Nope");
        }
        System.out.println(newList);
        System.out.println(newList.length);

    }
        }











