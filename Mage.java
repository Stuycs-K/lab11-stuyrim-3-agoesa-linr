import java.util.ArrayList;
import java.util.Random;

public class Mage extends Adventurer {
  private  int aura, auraMax;

  public Mage(String name, int hp, ArrayList<Adventurer> allies, ArrayList<Adventurer> enemies){
    super(name, hp, allies);
    auraMax = 16;
    aura = auraMax / 2;
  }

  public Mage(String name, ArrayList<Adventurer> allies){
    this(name, (int) Math.random() * 3 + 20, allies, new ArrayList<Adventurer>());
  }

  public Mage(String name){
    this(name, new ArrayList<Adventurer>());
  }
  public Mage(){
    this("mark");
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
    int damage = (int) (Math.random() * 5) +  3 ;
    other.applyDamage(damage);
    Random rand1 = new Random();
    if (rand1.nextBoolean()){
      other.applyDamage(3);
      return this + " uses Lightning Bolt on " + other + " and dealt " + damage + " points of damage. A bolt of lightning strikes! It deals 3 extra damage!";
    }
    else {
      return this + " uses Lightning Bolt on " + other + " and dealt " + damage + " points of damage. ";
    }
  }

  public String support(){
    int hpAdd = 7;
    int specialAdd = 3;
    setHP(Math.min(getmaxHP(), getHP() + hpAdd));
    setSpecial(Math.min(getSpecialMax(), getSpecial() + specialAdd));
    return this + " meditates and restores " + hpAdd + "HP and " + specialAdd + " elixir!";
  }

  public String support(Adventurer other){
    int hpAdd = 7;
    int specialAdd = 3;
    other.setHP(Math.min(other.getmaxHP(), other.getHP() + hpAdd));
    other.setSpecial(Math.min(other.getSpecialMax(), other.getSpecial() + specialAdd));
    return this + " meditates and restores " + other + "'s HP by " + hpAdd + " and their" + other.getSpecialName() +  " by " + specialAdd + " elixir!";
  }

    public String specialAttack(Adventurer other){
      if (getSpecial() > 10){
        setSpecial(Math.min(0, getSpecial() - 1));
        int hpSacrifice = getHP() / 4;
        setHP(getHP() - hpSacrifice);
        getAllies().get(0).setHP( (int) Math.min( getAllies().get(1).getmaxHP(),  getAllies().get(1).getHP() +  getAllies().get(1).getmaxHP() /2));
        getAllies().get(1).setHP( (int) Math.min( getAllies().get(0).getmaxHP(),  getAllies().get(0).getHP() +  getAllies().get(0).getmaxHP() /2));

        int damage = (int) (Math.random() * 3) + 2;
        other.applyDamage(2);

        return this + " uses Dark Blessing, sacrificing 25% of their health, healing their allies by 50% of their max HP and dealing " + damage + "points of damage to " + other + "!";
      }
      else {
        return "Not enough elixir!";
      }
    }
}
