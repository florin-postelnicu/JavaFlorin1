




public class EddieSmartyPantsy {

    /**
     * Eddie's Memory
     * public Array[][] EddieMem[7][6]{
     *     Array to hold the values for winning fields
     * }
     * public Array[][] UpdateEM{
     *     After each game update the winning fields with + 1
     * }
     *
     */

    /**
     * Winning Fields
     * public ArrayList ListPlayer1{
     *     if player1 plays at board[column][row]{
     *         ListPlayer1.add(Player1UpdateMem[column][row])
     *     }
     *
     * }
     *
     * public ArrayList ListPlayer0{
     *     if player0 plays at board[column][row]{
     *         ListPLayer0.add(Player0UpdateMem[column][row])
     *     }
     * }
     * public ArrayList Winning{
     *     if (player1 won){
     *         ListPlayer1 to UpdateEM (Eddie's Memory)
     *     }
     *     else{
     *        ListPlayer0 to UpdateEM (Eddie's Memory)
     *     }
     *
     * }
     *
     * /**
     *
     * Eddie is time to move
     *
     * public Token EddieChoice{
     *      {
     *         Check the availability of moves on board[column][row];
     *         Make a list ArrayList[][] AvailableMoves as a subset of EddieMem;
     *         Find the Maximum value in AvailableMoves, by getting
     *          int  max = max of AvailableMoves
     *         Get the column and row for the max
     *
     *     }return board[column][row](Eddie would play at this position )
     * }
     *
     * public Token EddieSeeZFuture{
     *
     *
     *     Do EddieChoice for all AvailableMoves:
     *     int val1 = EddieChoice(when Eddie made move1 out of AvailableMoves);
     *     int val2 = EddieChoice(when Eddie made move2 out of AvailableMoves);
     *     .
     *     .
     *     .
     *     int valk = EddieChoice(when Eddie made movek out of AvailableMoves);
     *     Get FutureMove = Movej if valj is minimum:
     *
     *
     *     return FutureMove;
     *
     *
     * }
     */
}
