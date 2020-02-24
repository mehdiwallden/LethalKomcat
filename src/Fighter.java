import java.util.ArrayList;

public class Fighter {

   String name;
   String motto;
   public int health = 100;
   public int winPerRound = 0;
   String statistics;
   private boolean alive = true;

   Fighter(String name, String motto, String statistics){
       this.name = name;
       this.motto = motto;
       this.statistics = statistics;
   }

    public void attack (Fighter enemy){

    }

   public void defend(){
        
    }

    public void revive() {
       this.health = 100;
       this.alive = true;
    }

    public void die(){
        this.alive = false;
    }

    public void hurt(int value) {
        this.health -= value;
        if (this.health < 1){
            die();
        }
    }

    public void heal(){
        this.health += 10;
    }

    public void won() {
       this.winPerRound++;
    }

    public boolean isAlive() {
        return alive;
    }
    

}
