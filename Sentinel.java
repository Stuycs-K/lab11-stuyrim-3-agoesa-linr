import java.util.*;
public class Sentinel extends Adventurer{
  private int fortitude;
  private int fortitudeMax = 10; // change the number
  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public static int randomHP(){
    return (int) (Math.random() * 3) + 28;
  }

public Sentinel (String name, ArrayList<Adventurer> allies){
  super(name, allies); // fix the constructors because I got no int hp
  this.fortitude = this.fortitudeMax;
}
  public Sentinel(String name){
    super(name,randomHP());
    this.fortitude = this.fortitudeMax;
  }

  public Sentinel(){
    this("Sentinel");
    this.fortitude = this.fortitudeMax;
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
    int damage = (int)(Math.random()*2) + 3; // 0 to 1 -> 0 to 2 -> 3 inclusive to 5 exclusive
    other.applyDamage(damage);
    restoreSpecial(2);
    return this + " attacked "+ other.getName() + " using Rock Slam and dealt "+ damage +
    " points of damage.";
  }

  /* Stuns enemy up to 3 turns */
  public String specialAttack(Adventurer other){
    int turns = Math.random();
    if (turns > 0.75){
      turns = 3;
      other.setStun(turns);
    }
    else if (turns > 0.25){
      turns = 2;
      other.setStun(turns);
    }
    else {
      turns = 1;
      other.setStun(turns);
    }
    return this + " used Iron Earthquake on " + other.getName() + " and stunned them for " + turns + " turns";
  }
  /*Absorbs damage done to teamates for 2 turns*/
  public String support(Adventurer other){
    return this + " used Guardian's Shield!";
    + other.restoreSpecial(5)+" "+other.getSpecialName();
  }
  /*Absorbs damage done to teamates for 2 turns*/
  public String support(){
    return this + " used Guardian's Shield!";
    + other.restoreSpecial(5)+" "+other.getSpecialName();
  }
}
