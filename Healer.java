import java.util.ArrayList;

public class Healer extends Adventurer {
  private int elixir, elixirMax;
  
  public Healer(String name, int hp, ArrayList<Adventurer> allies){
    super(name, hp, allies);
    elixirMax = 16;
    elixir = elixirMax / 2;
  }

  public Healer(String name, ArrayList<Adventurer> allies){
    this(name, (int) Math.random() * 3 + 24, allies);
  }

  public Healer(String name){
    this(name, (int) Math.random() * 3 + 24, new ArrayList<>());
  }
  public Healer(){
    this("Bob");
  } 

  public String getSpecialname(){
    return "elixir";
  }

  public int getSpecial(){
    return elixir;
  }

  public int getSpecialmax(){
    return elixirMax;
  }

  public void setSpecial(int n){
    elixir = n;
  }


  public String attack(Adventurer other){
    int damage = (int)Math.random() * 3 + 1 ;
    other.applyDamage(damage);
    other.setHP(other.getHP() + (2 * damage));
    return this + "uses Divine Strike on" + other + " and dealt " + damage + " points of damage, healing their allies"
  }
}
