import java.awt.Graphics;
import java.util.LinkedList;

public class Collision{
    Bullet bullet = null;
    LinkedList<Target> target = new LinkedList<Target>();
    public Collision(Bullet b, LinkedList<Target> t){
        bullet = b;
        target = t;
    }
    
    public void checkCollision(){
        for(Target t: target){
            if(bullet.getBounds().intersects(t.getBounds())){
                    bullet.setCollision(true);
                    HUD.addPoints((int)bullet.getX());
                    t.setY(-50);
                    HUD.setHit(true);
                }
        }
    }
    
    public void tick(){
        checkCollision();
    }
    
    public void render(Graphics g){
        
    }
}