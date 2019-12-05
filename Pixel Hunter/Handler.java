  

 import java.awt.Graphics;
 import java.util.LinkedList;
 public class Handler{
     
     LinkedList<GameObject> object = new LinkedList<GameObject>();
     
     LinkedList<Target> targets = new LinkedList<Target>();
     
     LinkedList<Bullet> bullets = new LinkedList<Bullet>();
     
     LinkedList<Collision> collisions = new LinkedList<Collision>();
     public void tick(){
         for(int i = 0; i < object.size(); i++){
             GameObject tempObject = object.get(i);
             tempObject.tick();
         }
         for(int i = 0; i < bullets.size(); i++){
            Bullet tempBullet = bullets.get(i);
             tempBullet.tick();
         }
         for(int i = 0; i < targets.size(); i++){
            Target tempTarget = targets.get(i);
             tempTarget.tick();
         }
         for(Collision c: collisions){
             c.tick();
         }
     }
     
     public void addCollision(Collision collision){
        this.collisions.add(collision);
     }
     
     public void removeCollision(Collision collision){
        this.collisions.remove(collision);
     }
     
     public void addTarget(Target target){
        this.targets.add(target);
     }
     
     public void removeTarget(Target target){
        this.targets.remove(target);
     }
     
     public void addBullet(Bullet bullet){
        this.bullets.add(bullet);
     }
     
     public void removeBullet(Bullet bullet){
        this.bullets.remove(bullet);
     }
     
     public void addObject(GameObject object){
         this.object.add(object);
     }
     public void removeObject(GameObject object){
         this.object.remove(object);
     }

     public void render(Graphics g) {
        for(int i = 0; i < object.size(); i++){
             GameObject tempObject = object.get(i);
             tempObject.render(g);
         }
        for(int i = 0; i < bullets.size(); i++){
            Bullet tempBullet = bullets.get(i);
             tempBullet.render(g);
        }
        for(int i = 0; i < targets.size(); i++){
            Target tempTarget = targets.get(i);
             tempTarget.render(g);
        }
     }
 }
