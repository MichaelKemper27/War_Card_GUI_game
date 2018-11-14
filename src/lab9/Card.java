
package lab9;

import javafx.scene.control.*;
import javafx.scene.image.*;

public abstract class Card extends Label {
    protected String imgName;
    protected Image imgCard;
    
    public Card()
    {
        this("file:img\\155.gif");
    }
    
    public Card(String path)
    {
        this.setImage(path);
    }
            
    public void setImage(String name)
    {
        this.imgName = name;
        this.loadCard(this.imgName);
    }
    
    protected abstract boolean loadCard(String imgPath);
}
