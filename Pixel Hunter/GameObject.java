 

import java.awt.Graphics;
import java.awt.Rectangle;
public abstract class GameObject
{
    protected double x;
	protected double y;
    protected double velX, velY;
    
    public GameObject(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setVelX(int velX){
        this.velX = velX;
    }
    public void setVelY(int velY){
        this.velY = velY;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getVelX(){
        return velX;
    }
    public double getVelY(){
        return velY;
    }
}
