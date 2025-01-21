import java.util.ArrayList;
import java.util.Random;

public class Healer extends Adventurer {
  private int elixir, elixirMax;

  public Healer(String name, int hp, ArrayList<Adventurer> allies, ArrayList<Adventurer> enemies){
    super(name, hp, allies, enemies);
    elixirMax = 16;
    elixir = elixirMax / 2;

  }

  public Healer(String name, ArrayList<Adventurer> allies, ArrayList<Adventurer> enemies){
    this(name, (int) (Math.random() * 3) + 24, allies, new ArrayList<Adventurer>());
  }
  public Healer(String name, ArrayList<Adventurer> allies){
    this(name, allies, new ArrayList<Adventurer>());
  }

  public Healer(String name){
    this(name, new ArrayList<Adventurer>());
  }

  public Healer(){
    this("Healer");
  }

  public String getSpecialName(){
    return "elixir";
  }

  public int getSpecial(){
    return elixir;
  }

  public int getSpecialMax(){
    return elixirMax;
  }

  public void setSpecial(int n){
    elixir = n;
  }

  public String attack(Adventurer other){
    if (this.ifStunned()){
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
    Random rand1 = new Random();
    int damage;
    damage = (rand1.nextInt(3) + 1) / weakFactor;
    if (getDamageBoost() > 0){
      damage *= 1.5;
      setDamageBoost(getDamageBoost() - 1);
    }
    restoreSpecial(3);
    other.applyDamage(damage);
    for (int i = 0; i < getAllies().size(); i++){
    getAllies().get(i).setHP(Math.min(getAllies().get(i).getmaxHP(), getAllies().get(i).getHP() + (damage)));
    }
    return this.fireDamage() + " " + this + " uses Divine Strike on " + other + " and dealt " + damage + " points of damage, healing their allies by " + damage +" HP! " + this + " gains 3 elixir!";
  }

  public String support(){
    if (this.ifStunned()){
      return "" + this.getName() + " is stunned! Their turn is skipped.";
    }

    int hpAdd = 7;
    int specialAdd = 3;
    setHP(Math.min(getmaxHP(), getHP() + hpAdd));
    restoreSpecial(3);
    return this.fireDamage() + " " + this + " meditates and restores " + hpAdd + "HP and " + specialAdd + " elixir!";
  }

  public String support(Adventurer other){
    if (this.ifStunned()){
      return "" + this.getName() + " is stunned! Their turn is skipped.";
    }

    int hpAdd = 7;
    int specialAdd = 3;
    other.setHP(Math.min(other.getmaxHP(), other.getHP() + hpAdd));
    other.restoreSpecial(3);
    return this.fireDamage() + " " + this + " meditates and restores " + other + "'s HP by " + hpAdd + " and their " + other.getSpecialName() +  " by " + specialAdd + " elixir!";
  }

    public String specialAttack(Adventurer other){
      if (this.ifStunned()){
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
      if (getSpecial() > 10){
        setSpecial(Math.max(0, getSpecial() - 10));
        for (int i = 0; i < getAllies().size(); i++){
        getAllies().get(i).setHP((int) Math.min( getAllies().get(i).getmaxHP(),  getAllies().get(i).getHP() +  getAllies().get(i).getmaxHP()/4));
      }
        int damage = ((int) (Math.random() * 3) + 2) / weakFactor;
        if (getDamageBoost() > 0){
          damage *= 1.5;
          setDamageBoost(getDamageBoost() - 1);
        }
        other.applyDamage(2);
        return  this.fireDamage() + " " + this + " uses Heaven's Blessing, healing their allies by 25% of their max HP and dealing " + damage + "   points of damage to " + other + "!";
      }
      else {
        return  this + " does not have enough elixir! Instead" + attack(other);
      }
    }
}
