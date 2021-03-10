import java.util.Scanner;
import cardgame.*;

/**
 * CardGameTest - Test class for the Card Game.
 * 
 * @author Selim Can Güler
 * @author Alperen Yılmazyıldız
 * @version 22 February 2021
 */
public class CardGameTest 
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of CardGameTest\n");
        
        // CONSTANTS
        
        // VARIABLES
        Card       c;
        Cards      cards;
        ScoreCard  scores;
        Player     p;
        CardGame   game;
        Player     p4;
        Player     p3; 
        Player     p2;
        Player     p1;  
        
        // PROGRAM CODE
        
        // test Card class
        c = new Card( 0);
        System.out.println( c);
        System.out.println();
        
        // test Cards class
        cards = new Cards( true);
        cards.addTopCard( c);
        // cards.testOnlyPrint();  // remove method after testing!
        cards.shuffle();
        System.out.println();
        // cards.testOnlyPrint();
        System.out.println();

        // test ScoreCard class
        scores = new ScoreCard( 4);
        scores.update( 3, 2);
        scores.update( 1, 2);
        scores.update( 0, 1);
        int[] winners = scores.getWinners();
        for (int i = 0; i < scores.getWinners().length; i++) {
            System.out.println( "Winner: " + winners[i]);
        }
        System.out.println( "\n" + scores );
        
        // test Player class
        // ToDo
        p = new Player("Arı");
        p.add(c);
        System.out.println(p.playCard());
        System.out.println(p.playCard());
        
        // test CardGame class too?
        // Todo
        p1 = new Player( "p1");
        p2 = new Player( "p2");
        p3 = new Player( "p3");
        p4 = new Player( "p4");
        
        game = new CardGame( p1, p2, p3, p4);
        System.out.println();
        System.out.println(game.getRoundNo());
        game.playTurn( p1, c);
        game.playTurn( p2, c);
        game.playTurn( p3, c);
        game.playTurn( p4, c);
        game.playTurn( p1, c);

        System.out.println("Score of p1:" + game.getScore(0));
        System.out.println("Name of p1: " + game.getName(0));
        System.out.println("Is game over:" + game.isGameOver());
        System.out.println( game.getRoundNo());

        for ( Player play : game.getWinners() ) {
            System.out.println( play.getName() );
        }

        
        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.
        
        System.out.println( "\nEnd of CardGameTest\n" );
    }
    
} // end of class CardGameTest
