package cardgame;

/**
 * Card - a single playing card
 * @author Alperen Yılmazyıldız
 * @version 22 February 2021
 */
public class Card
{
    // constants - to do in lectures
    final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs"};
    final String[] FACES = { "A", "2", "3", "4", "5",
                             "6", "7", "8", "9", "10",
                             "J", "Q", "K"};
    
    final int NO_OF_SUITS = 4;
    final int NOOFCARDSINSUIT = 13;
    
    // properties - to do in lectures
    int  cardNo;
    
    // constructors  - to do in lectures

    /**
     * Creates a Card with a certain face value and suit.
     * 
     * @param faceValue Face value of the card (A, 1 , 2, 3, 4, 5,
     *                                          6, 7, 8, 9, 10, J, Q, K)
     * @param suit Suit of the card. (Hearts, Diamonds, Spades, Clubs)
     */
    public Card( int faceValue, int suit)
    {
        cardNo = faceValue + suit * NOOFCARDSINSUIT;
    }
    
    /**
     * Creates a card with the given value
     * 
     * @param cardNumber the value of the card
     */
    public Card( int cardNumber)
    {
        cardNo = cardNumber;
    }
    
    /**
     * 
     * @return Face value of the card. 
     */
    public int getFaceValue()
    {
        return cardNo % NOOFCARDSINSUIT;
    }
    
    /**
     * 
     * @return Suit of the card.
     */
    public int getSuit()
    {
        return cardNo / NOOFCARDSINSUIT;
    }
    
    public String toString()
    {
        return FACES[ getFaceValue() ] + " of " + SUITS[ getSuit() ];
    }
    
    /**
     * 2 cards are the same if and only if their card numbers are the same
     * 
     * @param c Card to compare.
     * @return Whether the card is the same as the one in the parameter
     */
    public boolean equals( Card c)
    {
        // ToDo
        return this.cardNo == c.cardNo;
    }

    /**
     * 
     * @param c
     * @return Positive if 'this' cards number is greater than the one it is compared.
     * 0 if this cards number is the same with the  one it is compared. Negative if 'this'
     * cards number is less than the one it is compared.
     */
    public int compareTo( Card c)
    {
        // ToDo
        return this.cardNo - c.cardNo;
    }
}