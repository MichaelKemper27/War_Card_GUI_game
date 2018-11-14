
package lab9;
import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card> {
    int index = 1;
    final int LAST_CARD = 45;
    public Deck()
    {
        this("file:img\\");
    }
    public Deck(String imgFolderPath)
    {
        this.loadCards(imgFolderPath);
    }
    public void shuffle()
    {
        Collections.shuffle(this);
    }
    private void loadCards(String imgFolderPath)
    {
        for (int i = 101; i < 153; i++)
        {
            PlayingCard c = new PlayingCard(imgFolderPath + (i) + ".gif");
            this.add(c);
        }
        Collections.shuffle(this);
    }
    public Card deal() 
    {
        if (index >= LAST_CARD)
        {
            this.shuffle();
            index = 1;
        }
        else
        {
            index++;
        }
        return this.get(index);
    }
}
