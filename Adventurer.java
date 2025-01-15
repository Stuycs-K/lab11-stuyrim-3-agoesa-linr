import java.util.ArrayList;

public abstract class Adventurer{
  private String name;
  private int HP,maxHP;
  private ArrayList<Adventurer> allies;
  private ArrayList<Adventurer> enemies;
  private int stun = 0;


  //Abstract methods are meant to be implemented in child classes.
  /*
  all adventurers must have a custom special
  consumable resource (mana/rage/money/witts etc)
  */

  //give it a short name (fewer than 13 characters)
  public abstract String getSpecialName();
  //accessor methods
  public abstract int getSpecial();
  public abstract int getSpecialMax();
  public abstract void setSpecial(int n);

  //concrete method written using abstract methods.
  //refill special resource by amount, but only up to at most getSpecialMax()
  public int restoreSpecial(int n){
    if( n > getSpecialMax() - getSpecial()){
      n = getSpecialMax() - getSpecial();
    }
    setSpecial(getSpecial()+n);
    return n;
  }

  /*
  all adventurers must have a way to attack enemies and
  support their allys
  */
  //hurt or hinder the target adventurer
  public abstract String attack(Adventurer other);

  /*This is an example of an improvement that you can make to allow
   * for more flexible targetting.
   */
  //heal or buff the party
  //public abstract String support(ArrayList<Adventurer> others);

  //heal or buff the target adventurer
  public abstract String support(Adventurer other);

  //heal or buff self
  public abstract String support();

  //hurt or hinder the target adventurer, consume some special resource
  public abstract String specialAttack(Adventurer other);


  /*
  standard methods
  */

  public void applyDamage(int amount){
    this.HP -= amount;
  }

  //You did it wrong if this happens.
  public Adventurer(){
    this("Lester-the-noArg-constructor-string");
  }

  public Adventurer(String name){
    this(name, 10);
  }

  public Adventurer(String name, int hp){
    this.name = name;
    this.HP = hp;
    this.maxHP = hp;
  }

  public Adventurer(String name, int hp, ArrayList<Adventurer> allies){
    this.name = name;
    this.HP = hp;
    this.maxHP = hp;
    this.allies = allies;
  }

  public Adventurer(String name, int hp, ArrayList<Adventurer> allies, ArrayList<Adventurer> enemies){
    this.name = name;
    this.HP = hp;
    this.maxHP = hp;
    this.allies = allies;
    this.enemies = enemies;
  }

  //toString method
  public String toString(){
    return this.getName();
  }

  //Get Methods
  public String getName(){
    return name;
  }

  public int getHP(){
    return HP;
  }

  public int getmaxHP(){
    return maxHP;
  }
  public void setmaxHP(int newMax){
    maxHP = newMax;
  }

  public ArrayList<Adventurer> getAllies(){
    return allies;
  }

  public ArrayList<Adventurer> getEnemies(){
    return enemies;
  }

  public void addFriends(Adventurer friend){
    getAllies().add(friend);
    System.out.println("ally gained!");
  }

  public void addFoe(Adventurer foe){
    getEnemies().add(foe);
    System.out.println("foe gained!");
  }

  //Set Methods
  public void setHP(int health){
    this.HP = health;
  }

  public void setName(String s){
    this.name = s;
  }
  public int getStun(){
    return this.stun;
  }
  public void setStun(int n){
    this.stun = n;
  }
  public void debuff(){
    // actually do the stuff of the debuffs. The prior commands are to tell you the info about it.This is where we actually do it.
  }
}
