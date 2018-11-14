
package lab9;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayingCard extends Card {
    private int value;
    private Suit suit;
    public PlayingCard()
    {
        this("file:img\\155.gif");
    }
    
    public PlayingCard(String path)
    {
        super.setImage(path);
    }
    
    public int getValue() 
    {
        return this.value;
    }
    public Suit getSuit() 
    {
        return this.suit;
    }
    protected boolean loadCard(String path)
    {
        this.imgCard = new Image(path);
        this.setGraphic(new ImageView(this.imgCard));
        getCardValue(path);
        return true;
    }
    private void getCardValue(String imgName)
    {
        String str = imgName;
        int endIndex = str.indexOf("\\");
        String replacement = "";
        String toBeReplaced = str.substring(0, endIndex + 1);
        str = str.replace(toBeReplaced, replacement);
        int startIndex = str.indexOf(".");
        endIndex = str.indexOf("f");
        toBeReplaced = str.substring(startIndex, endIndex + 1);
        str = str.replace(toBeReplaced, replacement);
        int cardID = Integer.valueOf(str);
        int val;
        val = (((cardID % 100)) % 13) ;
        switch(val) {
            case 1:
                val = 11;
                break;
            case 0:
            case 11:
            case 12:
                val = 10;
                break;
        }
        this.value = val;
        int suitTest = ((((cardID) % 100)- 1)/13);
        switch(suitTest) {
            case 0:
                this.suit = Suit.Diamonds;
                break;
            case 1:
                this.suit = Suit.Clubs;
                break;
            case 2:
                this.suit = Suit.Hearts;
                break;
            case 3:
                this.suit = Suit.Spades;
                break;
        }
    }
}
