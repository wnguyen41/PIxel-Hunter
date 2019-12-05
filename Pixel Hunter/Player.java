 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Player extends GameObject {
	
	int x,y;
	
	public Player(int x, int y) {
		super(x, y);
		this.x=(int)x;
		this.y=(int)y;
	}
	
	public void render(Graphics g){//Image of the player
		g.setColor(Color.GREEN);
		g.fillRect((int)x, (int)y, 6, 12);
		g.setColor(Color.white);
		g.fillRect(0,(int)y, (int)x+10,Game.HEIGHT);
	}
	
	public void tick(){}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}

	public Rectangle getBounds() {
		return null;
	}
}
