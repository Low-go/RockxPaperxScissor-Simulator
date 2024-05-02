import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;


public class Rock {
    Image image;
    Rectangle hitbox;
    int x, y;
    int dx, dy;
    Random rand;
    
    public Rock(int x, int y){ // allow the coordinates it spawns in to be passed into it
        ImageIcon icon = new ImageIcon("C:\\Users\\lorran\\Documents\\RPS_eletric_boogalo\\assets\\rock.png");
        image = icon.getImage();
        hitbox = new Rectangle(x, y, 32, 32);
        rand = new Random();
        this.x = x;
        this.y = y;

    }

    public void move(){
        x += dx;
        y += dy;

        //not really sure yet?
    }
}
