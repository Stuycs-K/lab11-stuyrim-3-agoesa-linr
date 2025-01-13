import java.util.*;
public class Sentinel extends Adventurer{
  int fortitude, fortitudeMax;
  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public static int randomHP(){
    return (int) (Math.random() * 3) + 28;
  }


  public Sentinel(String name){
    super(name,randomHP());
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
    int damage = (int)(Math.random()*2) + 3; // 0 to 1 -> 0 to 2 -> 3 inclusive to 5 exclusive
    other.applyDamage(damage);
    restoreSpecial(2);
    return this + " attacked "+ other + " using Rock Slam and dealt "+ damage +
    " points of damage.";
  }

  /* Stuns enemy up to 3 turns */
  public String specialAttack(Adventurer other){
    // stunning really hard prob extra feature ill do this later
    return this + " used Iron Earthquake on " + other + " and stunned them for " + turn + " turns";
  }
  /*Absorbs damage done to teamates for 2 turns*/
  public String support(Adventurer other){
    return this + " used Guardian's Shield!";
    + other.restoreSpecial(5)+" "+other.getSpecialName();
  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){
    int hp = 1;
    setHP(getHP()+hp);
    return this+" drinks a coffee to restores "+restoreSpecial(6)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }
}
