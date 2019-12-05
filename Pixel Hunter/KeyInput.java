 

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyInput implements KeyListener{
    
    private final int spaceKeyCode = 32;
    
    private int pressedKeyCode;
    
    Handler handler;
    
    private boolean cooldown = false;
    
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    
    public void keyPressed(KeyEvent e){//gets what key is pressed
        pressedKeyCode = e.getKeyCode();
        for(int i = 0; i < handler.targets.size(); i++){
            Target tempTarget = handler.targets.get(i);
            if(pressedKeyCode == spaceKeyCode && !tempTarget.ifMoving() && !cooldown){//if it's space and the object isn't already moving, set the velocities.
                HUD.Launch();
                tempTarget.setX(0);
                tempTarget.setY(Game.HEIGHT-1);
                tempTarget.calcVel(4.5, tempTarget.randomizeAngle());
                tempTarget.setMoving(true);
                cooldown = true;
                new java.util.Timer().schedule(new java.util.TimerTask(){
                    public void run(){ cooldown = false;}
                }, 400);
                return;
                }
        }
    }
    
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}

