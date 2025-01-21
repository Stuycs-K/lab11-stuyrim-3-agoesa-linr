import java.util.ArrayList;
public class Sentinel extends Adventurer{
  private int fortitude;
  private int fortitudeMax;
  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public static int randomHP(){
    return (int) (Math.random() * 3) + 28;
  }

  public Sentinel(String name, int hp, ArrayList<Adventurer> allies, ArrayList<Adventurer> enemies){
    super(name, hp, allies, enemies);
    fortitudeMax = 16;
    fortitude = fortitudeMax/2;
  }

  public Sentinel(String name, ArrayList<Adventurer> allies, ArrayList<Adventurer> enemies){
    this(name, randomHP(), allies, new ArrayList<Adventurer>());
  }
  public Sentinel(String name, ArrayList<Adventurer> allies){
    this(name, allies, new ArrayList<Adventurer>());
  }

  public Sentinel(String name){
    this(name, new ArrayList<Adventurer>());
  }

  public Sentinel(){
    this("Sentinel");
  }


  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "fortitude";
  }

  public int getSpecial(){
    return fortitude;
  }

  public void setSpecial(int n){
    fortitude = n;
  }

  public int getSpecialMax(){
    return fortitudeMax;
  }

  /*Deals 3 - 4 damage to a target*/
  public String attack(Adventurer other){
    if (ifStunned()){
      return "" + this.getName() + " is stunned! Their turn is skipped.";
    }
    int weakFactor;
    if (this.ifPoisoned()){
      this.applyDamage(1);
      weakFactor = 4;
    }
    else {
      weakFactor = 1;
    }
    int damage = ((int)(Math.random()*2) + 3) / weakFactor; // 0 to 1 -> 0 to 2 -> 3 inclusive to 5 exclusive
  
    if (getDamageBoost() > 0){
      damage *= 1.5;
      setDamageBoost(getDamageBoost() - 1);
    }
    other.applyDamage(damage);
    this.restoreSpecial(3);
    return  fireDamage() + "  " + this.getName() + " attacked "+ other.getName() + " using Rock Slam and dealt "+ damage +
    " points of damage.";
  }

  /* Stuns enemy up to 3 turns */
  public String specialAttack(Adventurer other){
    if (ifStunned()){
      return "" + this.getName() + " is stunned! Their turn is skipped.";
    }
    
    if (getSpecial() > 10){
      setSpecial(Math.min(0, getSpecial() - 10));
       int turns = (int) Math.random() * 100;
    if (turns > 75){
      turns = 3;
      other.setStun(other.getStun() + turns);
    }
    else if (turns > 25){
      turns = 2;
      other.setStun(other.getStun() + turns);
    }
    else {
      turns = 1;
      other.setStun(other.getStun() + turns);
    }
    return  fireDamage() + "  " + this.getName() + " used Iron Earthquake on " + other.getName() + " and stunned them for " + turns + " turns";
  }
    else {
      return  fireDamage() + "  " + this.getName() + " tried to use Iron Earthquake but they don't have the 10 fortitude required to use it: " + this.getSpecial() + " / 10";

    }
}
  /*Absorbs damage done to teamates for 2 turns*/
  public String support(Adventurer other){
    if (ifStunned()){
      return "" + this.getName() + " is stunned! Their turn is skipped.";
    }
    
    other.setProtect(other.getProtect() + 2);
    this.restoreSpecial(2);
    return  fireDamage() + "  " +  this.getName() + " used Guardian's Shield on " + other.getName() + "!";

  }
  /*Absorbs damage done to teamates for 2 turns*/
  public String support(){
    if (ifStunned()){
      return "" + this.getName() + " is stunned! Their turn is skipped.";
    }
    
    this.setProtect(this.getProtect() + 2);
    this.restoreSpecial(2);
    return  fireDamage() + "  " + this.getName() + " used Guardian's Shield on" + this.getName() + "!";

  }
}
