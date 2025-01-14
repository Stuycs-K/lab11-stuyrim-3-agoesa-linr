import java.util.ArrayList;
import java.util.Random;

public class Healer extends Adventurer {
  private int elixir, elixirMax;

  public Healer(String name, int hp, ArrayList<Adventurer> allies, ArrayList<Adventurer> enemies){
    super(name, hp, allies, enemies);
    elixirMax = 16;
    elixir = elixirMax / 2;
  }

  public Healer(String name, ArrayList<Adventurer> allies){
    this(name, (int) (Math.random() * 3) + 24, allies, new ArrayList<Adventurer>());
  }

  public Healer(String name){
    this(name, new ArrayList<Adventurer>());
  }
  public Healer(){
    this("Bob");
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
    Random rand1 = new Random();
    int damage;
    damage = rand1.nextInt(3) + 1;
    other.applyDamage(damage);
    for (int i = 0; i < getAllies().size(); i++){
    getAllies().get(i).setHP(Math.min(getAllies().get(i).getmaxHP(), getAllies().get(i).getHP() + (2 * damage)));
  }
    return this + " uses Divine Strike on " + other + " and dealt " + damage + " points of damage, healing their allies by " + 2 * damage +" HP!";
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
        for (int i = 0; i < getAllies().size(); i++){
        getAllies().get(i).setHP((int) Math.min( getAllies().get(i).getmaxHP(),  getAllies().get(i).getHP() +  getAllies().get(i).getmaxHP()/2));
      }
        int damage = (int) (Math.random() * 3) + 2;
        other.applyDamage(2);

        return this + " uses Dark Blessing, sacrificing 25% of their health, healing their allies by 50% of their max HP and dealing " + damage + "points of damage to " + other + "!";
      }
      else {
        return "Not enough elixir!";
      }
    }
}
