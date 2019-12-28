




public class EddieSmartyPantsy {

    /**
     * Eddie's Memory
     *
     * It might be necessary to have two memory boards recorded:
     * - One for player0
     * - Another for player1
     * public Array[][] EddieMem0[7][6]{
     *     Array to hold the values for winning fields
     * }
     * public Array[][] EddieMem0[7][6]{
     *      *     Array to hold the values for winning fields
     *      * }
     * public Array[][] UpdateEM{
     *     After each game update the winning fields of the corresponding memory  with + 1
     *     if(player0 won){
     *         update EddieMemory0;
     *     }else{
     *         update EddieMemory1;
     *     }
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
     * Eddie ,it's time to move
     *
     * public Token EddieChoice{
     * // here Eddie is gaging his best move
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
     *     int val1 = EddieChoice(when the AvailableMoves is updated considering first field occupied);
     *     int val2 = EddieChoice(when the AvailableMoves is updated considering second field occupied);
     *     .
     *     .
     *     .
     *     int valk = EddieChoice(when the AvailableMoves is updated considering k field occupied);
     *     Get FutureMove = Movej if valj is minimum:
     *
     * @ Update AvailableMoves
     * *
     * *AvailableMoves is ann ArrayList[col][row], where 1<= col<= 7, and 1<= row<= 6,
     * * if Avmove[i][j] be the element eliminated, to update the AvailableMoves{
     *     if 1<= i < 7 {
     *         AvailableMoves.remove(EddieMem[i][j])
     *         i = i+ 1;
     *
     *         AvailableMoves.add(EddieMem[i][j]);
     *     }
     *     else{
     *         AvailableMoves.remove(EddieMem[i][j]);
     *     }
     *
     * }
     *
     *
     *     return FutureMove[column][row];
     *
     *
     * }
     */
}
