import java.util.ArrayList;
public class Chimera extends Adventurer{
  private int rage;
  private int rageMax; 
  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public static int randomHP(){
    return (int) (Math.random() * 3) + 28;
  }

  public Chimera(String name, int hp, ArrayList<Adventurer> allies, ArrayList<Adventurer> enemies){
    super(name, hp, allies, enemies);
    rageMax = 16;
    rage = rageMax/2;
  }

  public Chimera(String name, ArrayList<Adventurer> allies, ArrayList<Adventurer> enemies){
    this(name, randomHP(), allies, new ArrayList<Adventurer>());
  }
  public Chimera(String name, ArrayList<Adventurer> allies){
    this(name, allies, new ArrayList<Adventurer>());
  }

  public Chimera(String name){
    this(name, new ArrayList<Adventurer>());
  }
  
  public Chimera(){
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


  public String attack(Adventurer other){
  
  }


  public String specialAttack(Adventurer other){
   
}

  public String support(Adventurer other){
    

  }
  
  public String support(){
    

  }
}
