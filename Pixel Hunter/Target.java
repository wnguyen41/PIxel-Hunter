  
 import java.awt.Rectangle;
 import java.awt.Color;
 import java.awt.Graphics;
 public class Target extends GameObject{
	 
     private double gravity;
     private double velX, velY;
     
     private boolean moving = false;
     
     Handler handler;
     
     int targetWidth = 10;
     int targetHeight = 10;
     
     public Target(int x, int y, Handler handler){
         super(x, y);
         this.handler = handler;
     }
     
     public void calcVel(double velocity, double angle){//Calculate the velocity of the object
         velY = (-1)*velocity*Math.abs(Math.sin(Math.toRadians(angle)));
         velX = velocity*Math.abs(Math.cos(Math.toRadians(angle)));
     }

     public boolean ifMoving(){
        return moving;
     }
     
     public void setMoving(boolean moving){
         this.moving = moving;
     }
     
     public Rectangle getBounds(){
         return new Rectangle((int)x,(int)y,targetWidth,targetHeight);
     }
     
     public double randomizeAngle(){
         return Math.random()*40+30;
     }
     
     public void render(Graphics g){
         g.setColor(Color.orange);
         g.fillOval((int)x, (int)y,targetWidth,targetHeight);
     }
     
     public double getGravity() {
         return gravity;
     }
     
     public void setGravity(double gravity) {
         this.gravity = gravity;
     }
     
     public void tick(){//adds onto the x and y values to move the object.
         gravity = .025;
         velY += gravity;
         x+=velX;
         y+=velY;
         if(y>Game.HEIGHT|| y<0){//if target moves out of bounds, move and stop the object.
             this.setX(-50);
             this.setY(-50);
             this.setGravity(0);
             this.setMoving(false);
             velX = 0;
             velY = 0;
         }
     }

 }
