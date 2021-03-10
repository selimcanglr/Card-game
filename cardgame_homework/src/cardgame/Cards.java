package cardgame;

import java.util.Random;

/**
 * Cards - Maintains a collection of zero or more playing cards Provides 
 * facilities to create a full pack of 52 cards and to shuffle the cards.
 * 
 * @author Selim Can Güler
 * @version 22 February 2021
 */
public class Cards
{
    final int NO_OF_CARDS_IN_FULL_PACK = 52;

    // properties
    Card[] cards;
    int    valid;  // number of cards currently in collection

    /**
     * constructors
     * Creates a card list
     * 
     * @param fullPack whether or not the Cards will be a full pack of cards
     */
    public Cards( boolean fullPack)
    {
        cards = new Card[ NO_OF_CARDS_IN_FULL_PACK ];
        valid = 0;
        
        if ( fullPack)
            createFullPackOfCards();
    }
    
    // methods

    /**
     * 
     * @return The top card on the cards list.
     */
    public Card getTopCard()
    {
        Card tmp;

        if ( valid <= 0)
            return null;
        else
        {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }
    
    /**
     * Adds a card to the cards list if there is enough space
     * 
     * @param c card that will be added on the list
     * @return true if the card is added successfully, else false
     */
    public boolean addTopCard( Card c)
    {
        if ( valid < cards.length)
        {
            cards[valid] = c;   // should this be cloned?
            valid++;
            return true;
        }

        return false;
    
    }
    
    /**
     * Creates a pack of cards
     */
    private void createFullPackOfCards()
    {
        // Todo
        for ( int i = 0; i < NO_OF_CARDS_IN_FULL_PACK; i++ ) {
            Card card = new Card(i);
            addTopCard(card);
        }
    }
    
    /**
     * Shuffles the cards in the cards list by swapping each card with
     * a random another card
     */
    public void shuffle()
    {
        // Todo
        Random random = new Random();

        // Randomly swapping the places of the cards starting from the first card 
        // in the cards array and continuing the swapping until the last card. 
        for ( int i = 0; i < cards.length; i++ ) {
            int index;
            // Get a random index
            index = random.nextInt(cards.length);

            // Store one of the cards in a temporary variable
            Card temp = cards[i];

            // Swap the cards 
            cards[i] = cards[index];
            cards[index] = temp;
        }
    }
} // end class Cards
