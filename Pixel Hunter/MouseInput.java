  

 import java.awt.event.MouseEvent;
 import java.awt.event.MouseListener;
 public class MouseInput implements MouseListener{
     static int mX;
     static int mY;
        
     private int button;
        
     private boolean reloading = false;
        
     private Handler handler;
        
     public MouseInput(Handler handler){
         this.handler = handler;
        }
        
     public void mouseClicked(MouseEvent arg0) {}

     public void mouseEntered(MouseEvent arg0) {}

     public void mouseExited(MouseEvent arg0) {}

     public void mousePressed(MouseEvent e) {//gets which mouse button is pressed
         mX = e.getX();
         mY = e.getY();
         button = e.getButton();
         for(int i = 0; i<handler.bullets.size();i++){
             Bullet tempBullet = handler.bullets.get(i);
             if(tempBullet.ifShot() == false && button == 1 && reloading == false){//If left click shoot if it hasn't been shot already.
                 tempBullet.Shoot(mX, mY);
                 return;
                }
             if(tempBullet.ifShot() == true && button == 3){ //Create text on hud that signifies reloading
                 reloading = true;
                 HUD.setReloading(reloading);
                 new java.util.Timer().schedule(new java.util.TimerTask(){//Waits 1.5 seconds before executing the following code
                     public void run(){
                         tempBullet.reload();
                         reloading = false;
                         HUD.setReloading(reloading);
                        }
                 }, 1500);   
                }
            }  
        }
        
     public static int getMouseX(){
         return mX;
        }
        
     public static int getMouseY(){
         return mY;
        }
        
     public void mouseReleased(MouseEvent arg0) {}
     }

