 

import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Canvas;
public class Window extends Canvas{

	private static final long serialVersionUID = -8181743627297587821L;

	public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(game);
        game.start();
    }
}