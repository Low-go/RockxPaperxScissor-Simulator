import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;


public class Base {
    Image image;
    Rectangle hitbox;
    int x, y;
    int dx, dy;
    Random rand;
    
    public Base(int x, int y, String imagePath){ // allow the coordinates it spawns in to be passed into it
        ImageIcon icon = new ImageIcon(imagePath);
        image = icon.getImage();
        hitbox = new Rectangle(x, y, 32, 32);
        rand = new Random();
        this.x = x;
        this.y = y;
        dx = rand.nextInt(10) - 5;
        dy = rand.nextInt(10) - 5;

    }

    public void move(){
        x += dx;
        y += dy;

        hitbox.x = x;
        hitbox.y = y;

        //allow some randomized movment
        if (rand.nextInt(100) < 10){ //10 percent chance of random mov
            dx = rand.nextInt(10) -5;
            dy = rand.nextInt(10) - 5;
        }

        if (hitbox.x + hitbox.width > MyPanel.width){
            hitbox.x = MyPanel.width - hitbox.width;
            dx =- dx;
        }
        if (hitbox.x  < 0){ //hahahahahah it workkssss im going insane
            hitbox.x = 0;
            dx =- dx;
        }
        if(hitbox.y + hitbox.height > MyPanel.height){ //height
            hitbox.y = MyPanel.height - hitbox.height;
            dy =- dy;
        }
        if(hitbox.y < 0){
            hitbox.y = 0;
            dy =- dy;
        }

        //not really sure yet? probably a collide method soon
    }

}
