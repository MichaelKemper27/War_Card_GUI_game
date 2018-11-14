
package lab9;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TarotCard extends Card {
    private int value;
    private String name;
    public TarotCard()
    {
        this("file:img\\maj_00.jpg");
    }
    public TarotCard(String path)
    {
        super.setImage(path);
    }
    public int getValue() 
    {
        return this.value;
    }
    public String getName() 
    {
        return this.name;
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
        endIndex = str.indexOf(".");
        toBeReplaced = str.substring(startIndex, endIndex + 4);
        str = str.replace(toBeReplaced, replacement);
        this.name = str;
        endIndex = str.indexOf("_");
        toBeReplaced = str.substring(0, endIndex + 1);
        str = str.replace(toBeReplaced, replacement);
        int cardID = Integer.valueOf(str);
        this.value = cardID;
        
    }
}
