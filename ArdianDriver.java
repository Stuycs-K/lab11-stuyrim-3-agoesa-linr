public class ArdianDriver {

  public static void main(String[] args){
    Healer healer1 = new Healer("bob");
    Healer healer2 = new Healer("billy");
    Healer healer3 = new Healer("barry");
    Healer healer4 = new Healer("brenda");

    System.out.println(healer1.getHP());
    System.out.println(healer2.getHP());
    System.out.println(healer3.getHP());
    System.out.println(healer4.getHP());

/*
    System.out.println(healer1.attack(healer2));
    System.out.println(healer2.getHP());
    System.out.println(healer1.attack(healer2));
    System.out.println(healer1.attack(healer2));
    System.out.println(healer1.attack(healer2));

    System.out.println(healer1.attack(healer2));
    System.out.println(healer2.getHP());
*/

/*
    healer1.addFriends(healer3);
    healer1.addFriends(healer4);
    System.out.println(healer1.getAllies());

    System.out.println(healer2.attack(healer3));
    System.out.println(healer2.attack(healer4));
    System.out.println(healer2.attack(healer3));
    System.out.println(healer2.attack(healer4));
    System.out.println(healer2.attack(healer3));
    System.out.println(healer2.attack(healer4));
    System.out.println(healer3.getHP());
    System.out.println(healer4.getHP());

    System.out.println(healer1.specialAttack(healer2));
    System.out.println(healer3.getHP());
    System.out.println(healer4.getHP());
    System.out.println(healer1.getHP());
    System.out.println(healer1.getSpecial());
*/

    Mage mage1 = new Mage();
    System.out.println(healer1.getHP());
    System.out.println(mage1.attack(healer1));
    System.out.println(healer1.getHP());
    System.out.println(mage1.getAllies());
    mage1.addFriends(healer3);
    mage1.addFriends(healer4);
    System.out.println(healer3.getDamageBoost());
    System.out.println(healer4.getDamageBoost());
    System.out.println(healer3.attack(healer2));
    System.out.println(healer4.attack(healer2));
    System.out.println(mage1.support());
    System.out.println(healer3.getDamageBoost());
    System.out.println(healer4.getDamageBoost());
    System.out.println(healer3.attack(healer2));
    System.out.println(healer4.attack(healer2));
    System.out.println(healer3.getDamageBoost());
    System.out.println(healer4.getDamageBoost());
    System.out.println(healer3.attack(healer2));
    System.out.println(healer4.attack(healer2));
    System.out.println(healer3.getDamageBoost());
    System.out.println(healer4.getDamageBoost());
    System.out.println(healer3.attack(healer2));
    System.out.println(healer4.attack(healer2));
    System.out.println(healer3.getDamageBoost());
    System.out.println(healer4.getDamageBoost());
    System.out.println(healer3.attack(healer2));
    System.out.println(healer4.attack(healer2));
    System.out.println(healer3.getDamageBoost());
    System.out.println(healer4.getDamageBoost());

  }
}
