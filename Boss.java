import java.util.ArrayList;
public class Boss extends Adventurer{
  private int rage;
  private int rageMax;
  /*the other constructors ultimately call the constructor
  *with all parameters.*/


  public Boss(String name, int hp, ArrayList<Adventurer> allies, ArrayList<Adventurer> enemies){
    super(name, hp, allies, enemies);
    rageMax = 16;
    rage = rageMax/2;
  }

  public Boss(String name, ArrayList<Adventurer> allies, ArrayList<Adventurer> enemies){
    this(name, 99, allies, new ArrayList<Adventurer>());
  }
  public Boss(String name, ArrayList<Adventurer> allies){
    this(name, allies, new ArrayList<Adventurer>());
  }

  public Boss(String name){
    this(name, new ArrayList<Adventurer>());
  }

  public Boss(){
    this("Chimera");
  }


  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "rage";
  }

  public int getSpecial(){
    return rage;
  }

  public void setSpecial(int n){
    rage = n;
  }

  public int getSpecialMax(){
    return rageMax;
  }

//"Rampage" Deals 6-10 dmg to one enemy, poisoning them for 2 turns, which reduces enemy attack damage by 75% and deals 1 damage per turn. Chimera gains 1 Rage.
  public String attack(Adventurer other){
    if (ifStunned()){
      return "" + this.getName() + " is stunned! Their turn is skipped.";
    }
    int damage = (int)(Math.random()* 5) + 6; // 0 to 1 -> 0 to 5 -> 6 to 11 exclusive.
    other.applyDamage(damage);
    this.restoreSpecial(1);
    other.setPoison(other.getPoison() + 2);
    return fireDamage() + " " + this.getName() + " attacked "+ other.getName() + " using Rampage and dealt "+ damage +
    " points of damage and inflicted poison on them." ;
  }
//"Chimera's wrath" Chimera does an AOE stomp, dealing 8 dmg to all enemies, while breathing fire, lighting all of its enemies on fire for 5 turns. 15 rage required.
  public String specialAttack(Adventurer other){
    if (ifStunned()){
      return "" + this.getName() + " is stunned! Their turn is skipped.";
    }
    if (getSpecial() >= 15){
      for (int i = 0; i < getEnemies().size(); i++){
        getEnemies().get(i).applyDamage(8);
        getEnemies().get(i).setFire(getEnemies().get(i).getFire() + 5);
    }
    this.setSpecial(this.getSpecial() - 15);
    return fireDamage() + " " + this.getName() + " used Chimera's wrath and dealth 8 damage to its opponents and lit them on fire for 5 turns!";
  }
    else {
      return this.getName() + " tried to use Chimera's wrath but they don't have the 15 rage required to use it: " + this.getSpecial() + " / 15. Instead " + attack(other);
    }
    }



  public String support(Adventurer other){
    if (ifStunned()){
      return "" + this.getName() + " is stunned! Their turn is skipped.";
    }
    return support();

  }
  //"Limitless adaptation"Chimera heals itself for 25% of its current HP and nullifies all of its bad status effects. Gains 1 rage.
  public String support(){
    if (ifStunned()){
      return "" + this.getName() + " is stunned! Their turn is skipped.";
    }
    int health = this.getHP() / 4;
    this.setHP(health);
    this.restoreSpecial(1);
    this.setFire(0);
    this.setPoison(0);
    this.setStun(0);
    return fireDamage() + " " + this.getName() + "healed " + health + "hp and nullified all its bad status effects!";

  }
}
