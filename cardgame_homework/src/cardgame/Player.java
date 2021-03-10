package cardgame;

 /**
  * Player - Simple card game player with name and hand of cards
  * @author Selim Can Güler
  * @version 22 February 2021
  */
public class Player
{
    // Properties
    String name;
    Cards hand;
    
    /**
     * Constructor
     * Creates a player with the given name and an empty hand 
     * in which the player has cards
     * 
     * @param name name of the player
     */
    public Player( String name)
    {
        // ToDo
        this.name = name;
        hand = new Cards( false );
    }
    
    // methods

    /**
     * 
     * @return name of the Player
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Adds a card to the hand of the player. The new card is added on top of all cards.
     * 
     * @param c the card to be added on the hand of the player
     */
    public void add( Card c)
    {
        // ToDo
        hand.addTopCard( c );
    }
    
    /**
     * The user plays the card on top of his cards
     * 
     * @return card that the user plays
     */
    public Card playCard()
    {
        // ToDo
        Card result = hand.getTopCard();

        return result;
    }
    
} // end class Player
