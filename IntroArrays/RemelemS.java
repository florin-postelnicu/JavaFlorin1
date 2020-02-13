/*
the text for trial
A Bottm u linneragee e altteraaashhh o hhurricanee
 */
import java.util.Scanner;

public class RemelemS {

    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));
        System.out.println("Enter your statement");
        String stateOrig = scan.nextLine();
        // Convert to lower case
        String stateCon = stateOrig.toLowerCase();

        //Create an char array
        char[] statechar = stateCon.toCharArray();
        int len = statechar.length;
        if(len <= 10){
            // do nothing to statechar
            System.out.println(statechar);
        }
        else {
            System.out.println("Gime a sign !");


            // eliminate the repeats from the statechar
            // make another char[] norepeats populated with the
            //elements of statechar that do not repeat

            char[] norepaets = new char[len];

            // generate the index for the new array
            int index = 0;
            for( int i = 0; i < len-1; i++){
                if(statechar[i] == statechar[i+1] ){
                    continue;
                }
                else{
                    norepaets[index]= statechar[i];
                    index++;
                }
                norepaets[index]= statechar[len-1];
            }
            // eliminate the blanks at the end of norepeats
            char[] singles = new char[index+1];
            System.arraycopy(norepaets, 0, singles, 0, index + 1);
            System.out.println(norepaets);
            System.out.println(singles);

            //eliminate the vowels inside the words, but leave the singletons

            int lens = index +1;
            char[] novoelsing = new char[lens];
            int indnov = 1;
            novoelsing[0]= singles[0];
            for(int k = 1; k <index; k++){
                if(singles[k-1] == singles[k+1] && singles[k+1] ==' '){
                    novoelsing[indnov] = singles[k];
                    indnov ++;
                }
                else if (singles[k]!='a'&& singles[k]!='e'&& singles[k]!='i' && singles[k]!='o' && singles[k]!='u'){
                    novoelsing[indnov]= singles[k];
                    indnov++;
                }
            }
            System.out.println(novoelsing);
            char[] novelnorep = new char[indnov];
            System.arraycopy(novoelsing, 0, novelnorep, 0, indnov);
            System.out.println(novelnorep);
        }

    }
}
