import java.util.Random;



class HuntTheWumpus
{
  public static void main (String[] args)
  {
    
    
    /*
     To Do List:
     1. Output instructions 
     2. Create game world using a 2D string array (5 x 5 Box) Complete
     3. Add hazards to game world and make them so they interact with the player (Pit, bats, wumpus) Complete
     4. Create system that manuevers the player through the game world. Complete
     5. Create a way for the player to shoot arrows in the direction of the wumpus and if the player misses the wumpus changes location (5 arrows)
     6. Make it so when a arrow is sent to the location of the wumpus the player wins and outputs a ending statement
     */
    
    //making the main menu
    String menuSelection; 
    System.out.println("\tHunt The Wumpus");  
    System.out.println("\tPress I for instructions");
    System.out.println("\tPress P to begin");                     
    int repeat = 1;
    do
    {
      menuSelection = In.getString();
      menuSelection = menuSelection.toUpperCase(); 
      
      
      
      if(menuSelection.equals ("I"))
      {
        instructions();  
      }
      else if(menuSelection.equals ("P"))
      {
        repeat++;
      }
      else
      {
        System.out.println("\tThat is a invalid input. Please enter either I or P"); 
      }
    }
    while (repeat == 1);
    
    
    
//Making the game world and filling it 
  
       
    String[][] gameWorld = new String[5][5];
    // initializes board with x in each location
      for (int i = 0; i <= 4; i++) {
          for (int j = 0; j <= 4; j++) {
             gameWorld[i][j] = "X";
          }
      }

      
    //creates random spawn location for wumpus
    int wumpRowInd = randInt(0,4);
    int wumpColInd = randInt(0,4); 
    gameWorld[wumpRowInd][wumpColInd] = gameWorld[wumpRowInd][wumpColInd] = "W"; 
 
    //creates random spawn location for pit hazard
int done = 0;
int pitRowInd = 0;
int pitColInd = 0;

do
{
    pitRowInd = randInt(0,4);
    pitColInd = randInt(0,4); 
    if ((pitRowInd != wumpRowInd) || (pitColInd != wumpColInd))
    {
      done = 1;
    }
} while (done == 0);
    gameWorld[pitRowInd][pitColInd] =  gameWorld[pitRowInd][pitColInd] = "P";

//creates random spawn location for bat hazard
done = 0;
   int batRowInd = 0;
   int batColInd = 0;
do 
{
   batRowInd = randInt(0,4);
   batColInd = randInt(0,4); 
       if ((batRowInd == wumpRowInd) && (batColInd == wumpColInd))
    {
      done = 0;
    }
    else if ((batRowInd == pitRowInd) && (batColInd == pitColInd))
    {
     done = 0; 
    }
    else 
    {
      done = 1;
    }
} while (done == 0);
    gameWorld[batRowInd][batColInd] =  gameWorld[batRowInd][batColInd] = "B";
    
//Selects random spawn location for player        
    done = 0;
   int playerRowInd = 0;
   int playerColInd = 0;
    do
    {
   playerRowInd = randInt(0,4);
   playerColInd = randInt(0,4); 
       if ((playerRowInd == wumpRowInd) && (playerColInd == wumpColInd))
    {
      done = 0;
    }
    else if ((playerRowInd == pitRowInd) && (playerColInd == pitColInd))
    {
     done = 0; 
    }
    else if((playerRowInd == batRowInd) && (playerColInd == batColInd))
    {
      done = 0;
    }
    else
    {
      done = 1;
    }
} while (done == 0);
gameWorld[playerRowInd][playerColInd] = gameWorld[playerRowInd][playerColInd] = "O";

// *************** //
// begin game play //
// *************** //

String keypress;
boolean gameover = false;
boolean visible = false;

do {
  
   // if you're on the wompus, game over //
    
    if((playerRowInd == wumpRowInd) && (playerColInd == wumpColInd)) {
      System.out.println("You've been eaten by the Wompus");
      gameover = true; 
    }
    
    // if you're in the pit, game over //
    
    if((playerRowInd == pitRowInd) && (playerColInd == pitColInd)) {
      System.out.println("You fell in a pit");
      gameover = true; 
    }
    
    //if you're on a bat, game over //
    
     if((playerRowInd == batRowInd) && (playerColInd == batColInd)) {
      System.out.println("You've been eaten by a bat");
      gameover = true; 
    }
  
    // if not gameover, upedate player position on board //
     if (!gameover) { 
        gameWorld[playerRowInd][playerColInd] = "O"; 
      }
     
       print2DArray (gameWorld, visible);
    
    
    
    
   
    if (!gameover) {

      
    // output warning if you're near a wompus //
    // output warning if your near a pit //
    // output a warning if you're near a bat // 
      
      if ((Math.abs(playerRowInd - wumpRowInd) <= 1) && (Math.abs(playerColInd - wumpColInd) <= 1)) {
     System.out.println("you smell something horrible!");
    }
     
      if ((Math.abs(playerRowInd - pitRowInd) <= 1) && (Math.abs(playerColInd - pitColInd) <= 1)) {
        System.out.println("you feel a breeze!");
    }
     
      if ((Math.abs(playerRowInd - batRowInd) <= 1) && (Math.abs(playerColInd - batColInd) <= 1)) {
     System.out.println("you hear flapping!");
     }
    
    }
 
    // if not game over, get a new keypress, otherwise you're dead //
    
    if (!gameover) {
       keypress = In.getString();
       keypress = keypress.toUpperCase(); 
    }
   
    // "O" stands for 'over', because you are dead //
    else {
       keypress = "O";
    } 
    
       
    if(keypress.equals("Q")) { //creates user input to quit the game
       gameover = true;  
      }
    else if (keypress.equals("O")) { //makes it so once the games over it doesnt prompt the user for more inputs
      gameover = true; 
      }
      
    else if (keypress.equals("V")) { //makes a way for the user to turn the bored visible revealing hazad locations
      if (visible == true) {
          visible = false;
      }
      else {
          visible = true;
      }
     }
//system to move player if possible and replace his previous position with a x
    else if (keypress.equals("W")) { 
    // move player up if you can //  
      
      if (playerRowInd != 0) {
       // mark the spot you've come from with an X //
       gameWorld[playerRowInd][playerColInd] = "X"; 
       playerRowInd = playerRowInd - 1; 
      }      
    }
    else if (keypress.equals("A")) {
    // move player left if you can //  
          if (playerColInd != 0) {
       // mark the spot you've come from with an X //
       gameWorld[playerRowInd][playerColInd] = "X"; 
       playerColInd = playerColInd - 1; 
      }      
  
    }
    else if (keypress.equals("S")) {
    // move player down if you can //  
      if (playerRowInd != 4) {
       // mark the spot you've come from with an X //
       gameWorld[playerRowInd][playerColInd] = "X"; 
       playerRowInd = playerRowInd + 1; 
      }      
    }
     
    else if (keypress.equals("D")) {
    // move player right if you can //  
      if (playerColInd != 4) {
       // mark the spot you've come from with an X //
       gameWorld[playerRowInd][playerColInd] = "X"; 
       playerColInd = playerColInd + 1; 
      }      
    }
    //creates method to shoot arrows
    else if ( keypress.equals("I")) {
    // fire an arrow into the cell above //
      
    }  
    else if ( keypress.equals("J")) {
    // fire an arrow into the cell to the left //
      
    }  
    else if ( keypress.equals("K")) {
    // fire an arrow into the cell below //
      
    }  
    else if ( keypress.equals("L")) {
    // fire an arrow into the cell to the right //
      
    }  
             
             
      else {
          System.out.println("incorrect key pressed");            
      }
} while (!gameover);

  System.out.println("Game over");
   
  }
 
  // outprints instructions 
  public static void instructions()
  {
    System.out.println("\tInstructions:"); 
    System.out.println("\tHunt the wumpus is a word based, hide and seek formatted game. You must enter a system of caves which create a 5 x 5 square"); 
    System.out.println("\tand hunt a mysterious creature called a wumpus, using 5 armor piercing arrows. All while avoiding hazards which give the"); 
    System.out.println("\tplayer a text warning when you are next to one. These hazards include a pit which you will feel a breeze when near, Bats"); 
    System.out.println("\twhich will transport you to a new location in the cave and is alerted by the flapping of wings, and finally the wumpus which"); 
    System.out.println("\tomits a horrible smell when you get close."); 
  }  

  // random number generator
  public static int randInt(int min, int max)
  {
    Random rand = new Random();
    
    int randomNum = rand.nextInt((max - min) + 1) + min;
    
    return randomNum;
  }

  
  // Method to print 2D array
  public static void print2DArray (String[][] gameWorld, Boolean visible)
  {
   int numRow = gameWorld.length;
   int numCol = gameWorld[0].length;
    
    for (int i = 0; i < numRow; i++) {
    for (int j =0; j < numCol; j++) {
     
      // if visible, print everything //
      // if invisible, print only player position //
      
      if (gameWorld[i][j] == "W" && !visible) {
         System.out.print("X\t");
      }
      else if (gameWorld[i][j] == "P" && !visible) {
         System.out.print("X\t");
      }
      else if (gameWorld[i][j] == "B" && !visible) {
         System.out.print("X\t");        
      }
      else 
          System.out.print(gameWorld[i][j] + "\t" );
    }
    System.out.println("");
    System.out.println("");
  }
  }
}
