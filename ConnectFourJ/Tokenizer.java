/**
 * http://cogitolearning.co.uk/2013/04/writing-a-parser-in-java-the-tokenizer/
 */

import jdk.nashorn.internal.runtime.ParserException;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    public Tokenizer(){
        tokenInfos = new LinkedList<>();
        tokens = new LinkedList<Token1>();
    }

    private class TokenInfo{
        public final Pattern regex;
        public final int token;

        public TokenInfo(Pattern regex, int token){
            super();
            this.regex = regex;
            this.token = token;
        }
    }
    /**
     *
     * As you can see TokenInfo contains two fields.
     * The regular expression that is used to match the input string against the token
     * is stored in the Pattern regex.
     * We store Pattern objects instead of the regular expression string to improve performance.
     * Regular expressions have to be compiled which takes time.
     * Pattern stores the regular expression in compiled form.
     * The code of the token is given by the integer value ‘token’.
     * Each type of token should have its own code.
     */


    private LinkedList<TokenInfo> tokenInfos;

    /**
     * We define a linked list, called tokenInfos, to hold the information for all the tokens.
     * The linked list is created in the constructor of our Tokenizer class.
     * Next we need to add the token information in our list. We do this via the add() method.
     */

    public void add(String regex, int token){
        tokenInfos.add(
        new TokenInfo(
                Pattern.compile("^("+ regex +")"), token));
    }

    /**
     * The user can pass a regular expression string and a token code to the method.
     * The method will then the “^” character to the user supplied regular expression.
     * It causes the regular expression to match only the beginning of a string.
     * This is needed because we will be removing any token
     * always looking for the next token at the beginning of the input string.
     *
     * We also want to store the information about the tokens we have seen.
     * We need to store the token code and the string that corresponds to the token.
     * The string is needed because the token code does not retain the full information about the input.
     * When we have found a variable we will give the token a special code for variable tokens
     * but we need to also keep the name of the variable so that we can later use it to store or
     * retrieve information.
     * To this end we define another internal class called Token and a linked list of these tokens.
     */

    public class Token1 {
        public final int token;
        public final String sequence;

        public Token1(int token, String sequence) {
            super();
            this.token = token;
            this.sequence = sequence;
        }
    }
    private LinkedList<Token1> tokens;

    /*
    In our constructor of Tokenizer we now also have to initialize the tokens list.
     */


    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.add("sin|cos|exp|ln|sqrt", 1); // function
        tokenizer.add("\\(", 2); // open bracket
        tokenizer.add("\\)", 3); // close bracket
        tokenizer.add("[+-]", 4); // plus or minus
        tokenizer.add("[*/]", 5); // mult or divide
        tokenizer.add("\\^", 6); // raised
        tokenizer.add("[0-9]+",7); // integer number
        tokenizer.add("[a-zA-Z][a-zA-Z0-9_]*", 8); // variable
    }
    /**
    The code above adds regular expressions that match functions, brackets, mathematical operators,
    integer numbers and variables. Note how each type of token gets a unique code.
     Note also how we have to escape special characters in the regular expressions with a double backslash.


     We are now ready to tokenize an input string.
     This is done in the tokenize method.
     In this method we first define a local string that contains the input string
     but without any leading or trailing spaces. Also we clear the tokens list from any previous data.
     */

    public void tokenize(String str) {
        String s = new String(str);
        tokens.clear();

        /**
         * The main loop is carried out until the local input string is empty.
         * When we find a token we will remove it from the front of the string.
         * If we are successful and the whole string could be tokenized then we will eventually end up
         * with an empty string.
         */
        while (!s.equals("")) {
            boolean match = false;
            /**
             * The match variable indicates if any of the tokens provided a match with the beginning
             * of the input string. Initially we have no match.
             * We now loop through all the token infos. and create a Matcher for the input string.
             */


            for (TokenInfo info : tokenInfos) {
                Matcher m = info.regex.matcher(s);
                if (m.find()) {
                    match = true;

                    String tok = m.group().trim();
                    tokens.add(new Token1(info.token, tok));

                    s = m.replaceFirst("");
                    break;
                }
            }
            /**
             * If the pattern is found in the input string then match is set to true.
             * The group() method of the Matcher returns the string of the last match.
             * A new Token object is appended to the list of tokens.
             * The token object contains the code of the token that resulted in the match and the matched string.
             * In the next step, the matcher is used to remove the token from the beginning of the input string.
             * We do this with the replaceFirst() method which replaces the first (and only) match with an empty string.
             * Finally we break out of the loop over the token infos because we don’t need to check any other token
             * types in this round.
             *
             * After the loop has finished we check if a match was found.
             * If not we throw an exception. We are using a ParserException which is extends
             * RuntimeException without adding new functionality to it.
             */
            if (!match) throw new ParserException(
                    "Unexpected character in input: "+s);
        }
    }


        }
