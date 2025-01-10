public class Healer extends Adventurer {
  int elixir, elixerMax;

  public Healer(String name, int hp){
    super(name, hp);
    elixirMax = 15;
    elixir = elixirMax/2;
  }

  public Healer(String name){
    this(name, (int) Math.random() * 3 + 24);
  }

  public Healer(){
    this("Bob");
  }

  public getSpecialname(){
    return "elixir";
  }

  public getSpecial(){
    return elixir;
  }

  public getSpecialmax(){
    return elixirMax;
  }

  public void setSpecial(int n){
    elixir = n;
  }

  public String attack(Adventurer other, Adventurer ally1, Adventurer ally2){
    int damage = (int)Math.random() + 1;
    other.applyDamage(damage);
    int heal
    other.setHP(other.getHP() + (2 * damage));
    return this + "uses Divine Strike on" + other " and dealt " + damage " points of damage, healing their allies"
  }
}
