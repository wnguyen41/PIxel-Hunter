 
import java.awt.Font;
import java.awt.Graphics;
public class HUD
{
    static int Points = 0;//Score streak multiplies points gained. Farther away from player equals more points.
    static int ammoCount = 0;
    
    static boolean reloading = false;
    static boolean hit = false;
    
    public void tick(){

    }
    
    public void ammoCount(Handler handler){
        int tempCount = 0;
        for(int i = 0; i < handler.bullets.size(); i++){
            if(handler.bullets.get(i).ifShot() == false){
                tempCount++;
            }
        }
        ammoCount = tempCount;
    }
    
    public static void addPoints(int x){
        Points += (100+x);
    }
    
    public static void Miss(){
        Points -= 50;
    }
    
    public static void Launch(){
        Points -= 50;
    }
    
    public static void setReloading(boolean r){
        reloading = r;
    }
    
    public static boolean isReloading(){
        return reloading;
    }
    
    public static void setHit(boolean h){
        hit = h;
    }
    
    public void render(Graphics g){
        g.setFont(new Font("Impact", Font.PLAIN, 20)); 
        g.drawString("Points: " + Points,15,20);
        g.drawString("Instructions :",480,20);
        g.drawString("Left Click to Shoot",480,40);
        g.drawString("Right Click to Reload",480,60);
        g.drawString("Spacebar to launch targets",480,80);
        if(reloading)
            g.drawString("Ammo: Reloading...",15,40);
        else
            g.drawString("Ammo: " +ammoCount,15,40);
            Graphics tempG = g;
            tempG.setFont(new Font("Impact", Font.PLAIN, 40));
        if(hit){
            tempG.drawString("Hit!", 250,40);
        }
        
    }
}