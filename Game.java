import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {


    run();

  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    for(int a = 1; a <= HEIGHT; a++){

      for(int i = 1; i <= WIDTH; i++){
        if(a == 1 || a == 7|| a == 13||  a == HEIGHT){
          drawText(Text.colorize(" ",BORDER_BACKGROUND), a, i);
        }
        if(i == 1 || (i == 47 && a > 13) || i == WIDTH){
          drawText(Text.colorize(" ",BORDER_BACKGROUND), a, i);
        }
      }
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    Text.go(startRow, startCol);
    System.out.println(s);

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    int currentHeight = 0;
    String tempString = text;

    while (currentHeight < height) {
        if (tempString.length() > width) {
            drawText(tempString.substring(0, width), row + currentHeight, col);
            tempString = tempString.substring(width);
        } else {

            String finalString = tempString;
            while (finalString.length() < width) {
                finalString += " ";
            }

            drawText(finalString, row + currentHeight, col);
            tempString = "";

        }

        currentHeight++;

    }


    while (currentHeight < height) {
        String spaces = ""; // Start with an empty string
        for (int i = 0; i < width; i++) {
            spaces += " $"; // Add spaces to the blank line
        }
        drawText(spaces, row + currentHeight, col);
        currentHeight++;
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      ArrayList<Adventurer> party = new ArrayList<Adventurer>();
      Adventurer Healer = new Healer("Healer");
      Adventurer CodeWarrior = new CodeWarrior ("CodeWarrior");
      Adventurer Mage = new Mage("Mage");

      party.add(Healer);
      party.add(CodeWarrior);
      party.add(Mage);
      int rando = (int) (Math.random() * 3);
      return party.get(rando);


    }

    public static ArrayList<Adventurer> createRandomParty(int size){
      ArrayList<Adventurer> rando = new ArrayList<Adventurer>();
      for(int i = 0; i < size; i++){
        rando.add(createRandomAdventurer());
      }
      return rando;
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){

      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      //YOUR CODE HERE
      for(int i = 0; i < party.size(); i ++){
        drawText((party.get(i)).getName(), startRow, 10 + (i * (WIDTH/party.size())));
        drawText("HP: " + colorByPercent((party.get(i)).getHP(), (party.get(i)).getmaxHP()), startRow + 1, 10 + (i * (WIDTH/party.size())));
        drawText((party.get(i)).getSpecialName() + " : " + (party.get(i)).getSpecial(), startRow + 2, 10 + (i * (WIDTH/party.size())));
      }

      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    if((double) hp / maxHP < 0.25){
      output = Text.colorize(output, Text.RED);
    }
    else if((double) hp / maxHP < 0.75){
      output = Text.colorize(output, Text.YELLOW);
    }
    else{
      output = Text.colorize(output, Text.WHITE);
    }
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    return output;
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> party, ArrayList<Adventurer> enemy){
      drawBackground();

    //draw player party
    Text.go(2,2);
    System.out.print("PARTY: ");
    drawParty(party, 3);


    //draw enemy party
    Text.go(8,2);
    System.out.print("ENEMY PARTY: ");

    drawParty(enemy, 9);

    Text.go(15,3);




  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      Text.go(17,3);

      //show cursor
      Text.showCursor();

      String input = in.nextLine();

      //clear the text that was written

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer> enemies = new ArrayList<Adventurer>();
    ArrayList<String> enemyNames = new ArrayList<String>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    enemies = createRandomParty(3);
    for(int i = 0; i < enemies.size(); i++){
      enemyNames.add((enemies.get(i)).getName());

    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    ArrayList<String> partyNames = new ArrayList<String>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    party = createRandomParty(3);
    for(int i = 0; i < party.size(); i++){
      partyNames.add((party.get(i)).getName());

    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(party, enemies);//initial state.

    //Main loop

    //display this prompt at the start of the game.

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
      TextBox(14, 3, 43, 7, preprompt);

      //Read user input
      input = userInput(in);

      //example debug statment
      // TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.equals("attack") || input.equals("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          TextBox(14, 3, 43, 7, "Which opponent would you like to attack? (Name)");
          input = userInput(in);

          int enemy = enemyNames.indexOf(input);
          while(enemy < 0){
            TextBox(14,3,43,7, "Check your spelling, make sure capitalization is correct.");
            input = userInput(in);
            enemy = enemyNames.indexOf(input);

          }

          party.get(whichPlayer).attack(enemies.get(enemy));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.equals("special") || input.equals("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          TextBox(14, 3, 43, 7, "Which opponent would you like to special attack? (Name) ");
          input = userInput(in);

          int enemy = enemyNames.indexOf(input);

          party.get(whichPlayer).specialAttack(enemies.get(enemy));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
          //THIS IS HOW YOU WANT TO DO THE OTHERS
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          int ally = Integer.parseInt(input.substring(input.length()-1));
          party.get(whichPlayer).support(party.get(ally));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //You should decide when you want to re-ask for user input
        //If no errors:



        if(whichPlayer < party.size() - 1){
          //This is a player turn.
          //Decide where to draw the following prompt:

          String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
          whichPlayer++;



        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see mo                         nster's turn";
          TextBox(14,3,43,7, prompt);

          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member

      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //YOUR CODE HERE
          input = userInput(in);
        int randomAlly = (int)(Math.random() * (party.size() + 1));
        int randomAction = (int)(Math.random() * 2);
        if(randomAction == 0){
          System.out.print(enemies.get(whichOpponent).attack(party.get(randomAlly)));
        }
        if(randomAction == 1){
          System.out.print(enemies.get(whichOpponent).specialAttack(party.get(randomAlly)));
        }

        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";
        TextBox(14,3,43,7, prompt);

        System.out.println(input);

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
      }

      //display the updated screen after input has been processed.
      drawScreen(party, enemies);


    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
