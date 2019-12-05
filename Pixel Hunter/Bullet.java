  

 import java.awt.Color;
 import java.awt.Graphics;
 import java.awt.Rectangle;
 public class Bullet extends GameObject {
        private double vel,angle;
        
        private boolean Shot = false;
        
        int bulletWidth = 2;
        int bulletHeight = 2;
        
        static boolean collision = false;
        
        Handler handler;
        
        public Bullet( int x, int y,double vel, Handler handler){
            super(x,y);
            this.vel = vel;
            this.handler = handler;
        }
        //gets the mouse cordinates and calculates the speed and direction of the bullet
        public void Shoot(int mX, int mY){
            x=handler.object.getFirst().getX();
            y=handler.object.getFirst().getY();
            angle = Math.atan2(mX-x, mY-y);
            velY = vel*Math.abs(Math.cos(angle));
            velX = vel*Math.abs(Math.sin(angle));
            Shot = true;
        }
        
        public void tick(){
            x+=velX;
            if(Math.toDegrees(angle)+180>270)
                y-=velY;
            else
                y+=velY;
            if(x > Game.WIDTH){//if it reaches the edge of the window, substract points if missed and move bullet off screen
                if(!collision){
                    HUD.Miss();
                }
                else{
                    HUD.setHit(true);
                    new java.util.Timer().schedule(new java.util.TimerTask(){//Waits 1.5 seconds before executing the following code
                        public void run(){
                            HUD.setHit(false);
                         }
                    }, 1000);
                         
                    collision = false;
                }
                x = -100;
                y = -100;
                velX = 0;
                velY = 0;
                
            }
        }

        public void render(Graphics g){
            if(velX>0){
                g.setColor(Color.yellow);
                g.fillRect((int)x, (int)y, bulletWidth, bulletHeight);
            }
        }
        
        public void reload(){
            Shot = false;
        }
        
        public boolean ifShot(){
            return Shot;
        }
        
        public void setCollision(boolean c){
            collision = c;
        }
        public boolean getCollision(){
            return collision;
        }
        
        public Rectangle getBounds(){
            return new Rectangle((int)x,(int)y,bulletWidth,bulletHeight);
        }
        
        public double getVel() {
            return vel;
        }
        
        public void setVel(double vel) {
            this.vel = vel;
        }
 }

