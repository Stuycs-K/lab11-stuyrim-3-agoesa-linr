public class Healer extends Adventurer {
  int elixir, elixerMax;

  public Healer(String name, int hp){
    super(name, hp);
    elixirMax = 15;
    elixir = elixirMax/2;
  }

  public Healer(String name){
    this(name, Math.random() * 3 + 24);
  }

  public Healer(){
    this("Bob");
  }
}
