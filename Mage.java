import java.util.ArrayList;
import java.util.Random;

public class Mage extends Adventurer {
  private  int aura, auraMax;

  public Mage(String name, int hp, ArrayList<Adventurer> allies, ArrayList<Adventurer> enemies){
    super(name, hp, allies, enemies);
    auraMax = 16;
    aura = auraMax / 2;
  }

  public Mage(String name, ArrayList<Adventurer> allies){
    this(name, (int) ((Math.random() * 3) + 20), allies, new ArrayList<Adventurer>());
  }

  public Mage(String name){
    this(name, new ArrayList<Adventurer>());
  }
  public Mage(){
    this("Mage");
  }

  public String getSpecialName(){
    return "aura";
  }

  public int getSpecial(){
    return aura;
  }

  public int getSpecialMax(){
    return auraMax;
  }

  public void setSpecial(int n){
    aura = n;
  }

  public String attack(Adventurer other){
    restoreSpecial(3);
    int damage = (int) (Math.random() * 5) +  3;
    if (getDamageBoost() > 0){
      damage *= 1.5;
      setDamageBoost(getDamageBoost() - 1);
    }
    other.applyDamage(damage);
    Random rand1 = new Random();
    if (rand1.nextBoolean()){
      other.applyDamage(3);
      return this + " uses Thunderbolt on " + other + " and dealt " + damage + " points of damage. A bolt of lightning strikes! It deals 3 extra damage! Restores 3 aura.";
    }
    else {
      return this + " uses Thunderbolt on " + other + " and dealt " + damage + " points of damage. Restores 3 aura. ";
    }
  }

  public String support(){
    for (int i = 0; i < getAllies().size(); i++){
    getAllies().get(i).setDamageBoost(3);
  }
    return this + " uses Elemental Surge, giving their teammates a damage boost! Restores 2 aura.";
  }

  public String support(Adventurer other){
    return support();
  }

    public String specialAttack(Adventurer other){
      if (getSpecial() > 10){
        setSpecial(Math.min(0, getSpecial() - 10));
        int damage = (int) (Math.random() * 2) + 5;
        if (getDamageBoost() > 0){
          damage *= 1.5;
          setDamageBoost(getDamageBoost() - 1);
        }
        for (int i = 0; i < getEnemies().size(); i++){
          getEnemies().get(i).applyDamage(damage);
          getEnemies().get(i).setFire(3);
        }
        return this + " uses Inferno Blast, dealing " + damage + " damage to each enemy, lighting them on fire!";
      }
      else {
        return this + " does not have enough aura! Instead " + attack(other);
      }
    }
}
