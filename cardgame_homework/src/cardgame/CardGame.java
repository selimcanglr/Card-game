package cardgame;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Cardgame - Initializes the game and keeps track of the variables of the
 * game such as the score, winners, cards on table, round number, turn number...
 *  
 * @author Selim Can Güler
 * @author Alperen Yılmazyıldız
 * @version 22 February 2021
 */
public class CardGame {
    final int NUMBER_OF_PLAYERS = 4;
    final int NO_OF_CARDS_IN_FULL_PACK = 52;
    final int NO_OF_CARDS_A_PLAYER_HAS = NO_OF_CARDS_IN_FULL_PACK / NUMBER_OF_PLAYERS;
    final int NUMBER_OF_TOTAL_CARDS = NUMBER_OF_PLAYERS * NO_OF_CARDS_IN_FULL_PACK;

    // properties
    Cards               fullPack;
    ArrayList<Player>   players;
    ScoreCard           scoreCard;
    Cards[]             cardsOnTable;
    int                 roundNo;
    int                 turnOfPlayer;

    // Constructors
    /**
     * Initializes the game.
     * 
     * @param p1 Player 1
     * @param p2 Player 2
     * @param p3 Player 3
     * @param p4 Player 4
     */
    public CardGame( Player p1, Player p2, Player p3, Player p4 ) {
        // ToDo
        initGame(p1, p2, p3, p4);

    }

    /**
     * Initializes the game. Creates a full pack and shuffles it. Deals the cards
     * to players and creates a score card. Sets the round no and turn of player 
     * to 0
     * 
     * @param p1 Player 1
     * @param p2 Player 2
     * @param p3 Player 3
     * @param p4 Player 4
     */
    public void initGame( Player p1, Player p2, Player p3, Player p4 ) {
        // Create new pack & shuffle
        fullPack = new Cards( true );
        fullPack.shuffle();

        // Add players to the list and deal all cards to players
        players = new ArrayList<>();
        players.add( p1 );
        players.add( p2 );
        players.add( p3 );
        players.add( p4 );

        for ( int i = 0; i < players.size(); i++ ) {
            for ( int j = 0; j < 13; j++ ) {
                players.get( i ).add( fullPack.getTopCard() );
            }
        }

        // Create score card
        scoreCard = new ScoreCard( NUMBER_OF_PLAYERS);

        // Create piles of cards on table
        cardsOnTable = new Cards[ NUMBER_OF_PLAYERS];
        for ( int i = 0; i < cardsOnTable.length; i++ ) {
            cardsOnTable[i] = new Cards( false );
        }

        // Set round no to 0 and player no to 0
        roundNo = 0;
        turnOfPlayer = 0;
    }

    // Methods
    
    /**
     * The player gets the card on top of his/her hand and puts the card
     * on the table. After the card is played if it is not the end of the round
     * then the it is next players turn. If it is the end of the round scores are 
     * updated and the game moves to the next round if the game is not over.
     * 
     * @param p The player who is going to play the card
     * @param c The card that the player is going to play
     * @return false if the game is over or it is not the turn of the player
     */
    public boolean playTurn( Player p, Card c ) {
        // Todo
        if ( isGameOver() ) {
            return false;
        }

        if ( ! isTurnOf( p ) ) {
            return false;
        }

        // It is p's turn so put p's card on table
        cardsOnTable[ getTurnOfPlayerNo() ].addTopCard( c );

        // If not end of round (it is the end of round when turnOfPlayer is 3)
        if ( turnOfPlayer < 3 ) {
            turnOfPlayer++;
        }
        // End of round, so update scores and move to the next round if the game is not over
        else {
            updateScores();
            if ( ! isGameOver() ) {
                roundNo++;
                turnOfPlayer = 0;
            }
        }

        return true;
    }

    /**
     * Checks if it's the turn of the player. It is the turn of the player
     * if the turn number is equal to the index of the player.
     * 
     * @param p Player
     * @return Whether it is the turn of the player.
     */
    public boolean isTurnOf( Player p ) {
        // ToDo
        return players.indexOf( p ) == getTurnOfPlayerNo();
    }

    /**
     * The game is over if the round number is 13 since there will be no cards left
     * at the hands of the players after turn 13
     * 
     * @return Whether the game is over or not.
     */
    public boolean isGameOver() {
        // ToDo
        return getRoundNo() == NO_OF_CARDS_A_PLAYER_HAS;
    }
    

    /**
     * Gets the score of the player. Number of the player is determined by the 
     * index of the player on the Players list.
     * 
     * @param playerNumber Number of the player whose score is going to be checked
     * @return The score of the player.
     */
    public int getScore( int playerNumber ) {
        // ToDo
        return scoreCard.getScore(playerNumber);
    }

    /**
     * Gets the name of the player. Number of the player is determined by the 
     * index of the player on the Players list.
     * 
     * @param playerNumber Number of the player whose name is going to be returned.
     * @return The name of the player.
     */
    public String getName( int playerNumber ) {
        // ToDo
        return players.get( playerNumber ).getName();
    }

    /**
     * Round numbers are zero indexed therefore if the method returns some number i,
     * it means that the round number is actually i + 1.
     * 
     * @return The current round number.
     */
    public int getRoundNo() {
        // ToDo
        return roundNo;
    }

    /**
     * Turn numbers are zero indexed therefore if the method returns some number i,
     * it means that the turn number is actually i + 1.
     * 
     * @return Turn number in the current round. 
     */
    public int getTurnOfPlayerNo() {
        // ToDo
        return turnOfPlayer;
    }

    /**
     * Players with the highest score are the winners. If there are multiple 
     * players with the same highest score than all of them are considered
     * as winners.
     * 
     * @return The winners of the game.
     */
    public Player[] getWinners() {
        // ToDo
        Player[] winners;
        int currentLength;
        int[] winnersIndexes;

        // Get the indexes of the winners
        winnersIndexes = scoreCard.getWinners();
        
        // Create a Player array which has the size of the number of players
        winners = new Player[ NUMBER_OF_PLAYERS ];

        // Find & add the players to the winners
        currentLength = 0;
        for ( int i = 0; i < winnersIndexes.length; i++ ) {
            winners[currentLength] = players.get( winnersIndexes[i] );
            currentLength++;
        }

        // Trim the array by creating a copy of it using the current length
        return Arrays.copyOf( winners, currentLength );
    }

    /**
     * Displays the score card.
     * 
     * @return String representation of the score card
     */
    public String showScoreCard() {
        return scoreCard.toString();
    }

    /**
     * Updates the scores of the players by comparing the face values of the last 
     * cards that the players put on the people. The card with the highest value
     * wins. There may be multiple winners, each winner's point is increased by 1
     */
    private void updateScores() {
        // Find max of cards just placed on table
        // Increment socres of player(s) with max card(s)
        int[] maxCards;
        int maxValue;

        maxCards = new int[ 4 ];
        maxCards[ 0 ] = cardsOnTable[ 0 ].getTopCard().getFaceValue();
        maxCards[ 1 ] = cardsOnTable[ 1 ].getTopCard().getFaceValue();
        maxCards[ 2 ] = cardsOnTable[ 2 ].getTopCard().getFaceValue();
        maxCards[ 3 ] = cardsOnTable[ 3 ].getTopCard().getFaceValue();

        maxValue = maxCards[0];
        for ( int value: maxCards ) {
            if ( value > maxValue ) {
                maxValue = value;
            }
        }

        for ( int i = 0; i < NUMBER_OF_PLAYERS; i++ ) {
            if ( maxCards[i] == maxValue ) {
                scoreCard.update(i, 1);
            }
        }
    }
}