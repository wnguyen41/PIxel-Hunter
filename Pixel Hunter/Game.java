 import java.awt.Canvas;
 import java.awt.Color;
 import java.awt.Graphics;
 import java.awt.image.BufferStrategy;
public class Game extends Canvas implements Runnable{
     
     private static final long serialVersionUID = -1222106848935153580L;
     
     static final int WIDTH = 720;
     static final int HEIGHT = WIDTH / 12 * 9;
     
     private boolean isRunning = false;
     
     private Thread thread;
     private Handler handler;
     private HUD hud;
     
     public Game(){ //Initializes window.
         handler = new Handler();
         hud = new HUD();
         
         new Window(WIDTH, HEIGHT, "Pixel Hunter", this);
         
         this.addMouseListener(new MouseInput(handler));
         
         this.addKeyListener(new KeyInput(handler));
         
         handler.addObject(new Player(10,HEIGHT/3*2));
         
         for(int i = 0 ;  i < 10; i++){//Adds 10 bullet objects
             handler.addBullet(new Bullet(-100,-100,10, handler));
         }
         
         for(int i = 0; i < 10; i++){//Adds 10 target objects
            handler.addTarget(new Target(-50,-50, handler));
         }
         
         for(int i = 0; i < handler.bullets.size(); i++){//Creates collision objects that check for collisions between bullets and targets
                handler.addCollision(new Collision(handler.bullets.get(i),handler.targets));
         }
     }
    
     public synchronized void start(){ //Starts the threads and makes sure only one thread executes at a time.
         thread = new Thread(this);
         thread.start();
         isRunning = true;
     }
     
     public synchronized void stop(){
         try{
             thread.join();//Waits for 
             isRunning = false;
         }catch(Exception e){
             e.printStackTrace();//Prints error.
         }
     }
     
     public void run(){ //Game loop
         this.requestFocus();
         long lastTime = System.nanoTime();
         double amountOfTicks = 120.0; // How many ticks you want per second
         double ns = 1000000000 / amountOfTicks; // how many nanoseconds per tick
         double delta = 0; //Variable to save change in time
         long timer = System.currentTimeMillis(); // get current time
         int tickRate = 0; //Variable to save number of frames per second
         while(isRunning){ 
             long now = System.nanoTime(); 
             delta += (now - lastTime) / ns; //Saves how many ticks have passed
             lastTime = now;  
             while(delta >= 1){ //when one tick has passed execute tick()
                 tick();  
                 delta--;  
                 tickRate++;
             }
             if(isRunning){
                 render(); //Renders next frame
             }
             if(System.currentTimeMillis() - timer > 1000 ){ 
                 timer+= 1000; 
                 //System.out.println("Tick Rate: " + tickRate); //When one second has passed print out number of loops done
                 tickRate = 0; 
             }
         }//End of loop
         stop(); // no longer running stop the thread
     }
     //Executes the tick() in each object making them do something
     private void tick(){
         handler.tick();
         hud.tick();
         hud.ammoCount(handler);
     }
     //renders the graphics of all objects in the handler class and the hud.
     private void render(){
         BufferStrategy buffStrat = this.getBufferStrategy();
         if (buffStrat == null){
             this.createBufferStrategy(3);
             return;
         }
         
         Graphics g = buffStrat.getDrawGraphics();
         
         g.setColor(Color.black);
         g.fillRect(0, 0, WIDTH, HEIGHT);
         
         handler.render(g);
         hud.render(g);
         
         g.dispose();
         buffStrat.show();
     }
     //Returns the handler.
     public Handler getHandler(){
         return handler;
        }
     
     public static void main(String []args){
         new Game();
     }
 }//End class Game.java

