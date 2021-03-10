package cardgame;

import java.util.Arrays;

/**
 * ScoreCard - Maintains one integer score per player, for any number of players
 * Caution: invalid playernumbers result in run-time exception!
 * 
 * @author Selim Can Güler
 * @version 22 February 2021
 */
public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructors
    /**
     * Creates a score board with 0 points for each player.
     * 
     * @param noOfPlayers Number of players. Each player's score will be
     *                    stored in an array. 
     */
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    // methods

    /**
     * 
     * @param playerNo Number of the player.
     * @return Score of the player with the given number.
     */
    public int getScore( int playerNo)
    {
        return scores[playerNo];
    }
    
    /**
     * Updates the score of the player by an amount
     * 
     * @param playerNo Number of the player.
     * @param amount The amount that will be added to the score of the player
     */
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++ )
        {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
    
    /**
     * Winner is determined by the scores of the players. The player who has
     * the greatest score is the winner of the game. If more than 1 player have
     * the greatest score then each player with the greatest score is considered
     * as a winner.
     * 
     * @return The current winner(s) of the game. 
     */
    public int[] getWinners()
    {
        // ToDo
        int highestScore;
        int currentLengthOfResult;
        int[] result;

        result = new int[scores.length];
        
        // Find the highest score
        highestScore = 0;
        for ( int i = 0; i < scores.length; i++ ) {
            if ( getScore( i ) > highestScore ) {
                highestScore = getScore(i);
            }
        }

        currentLengthOfResult = 0;
        // Add each winner to the array
        for ( int i = 0; i < scores.length; i++ ) {
            if ( getScore( i ) == highestScore ) {
                result[currentLengthOfResult] = i;
                currentLengthOfResult++;
            }
        }

        // Get rid of the unnecessary elements in the array
        result = Arrays.copyOf( result, currentLengthOfResult );

        return result;
    }
    
} // end class ScoreCard
