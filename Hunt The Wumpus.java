import java.util.Random;



class HuntTheWumpus
{
  public static void main (String[] args)
  {
    
    
    /*
     To Do List:
     1. Output instructions
     2. Create game world using a 2D string array (5 x 5 Box)
     3. Add hazards to game world and make them so they interact with the player (Pit, bats, wumpus) 
     4. Create system that manuevers the player through the game world and keeps track of where the player goes.
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
    
    // 0 1 2 3 4 
    //0  
    //1
    //2
    //3
    //4
       
    String[][] gameWorld = new String[5][5];
    // initializes bored with x in each location
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

    
//creates hazard warning when player approaches hazard (within one place away)
    //wumpus warning
   /* if ();
    {
      
    }
    //pit warning
    if ();
    {
      
    }
    //bat warning
    if ();
    {
      
    }
    */

print2DArray (gameWorld);
  }
 
  // outprints instructions 
  public static void instructions()
  {
    System.out.println("\tInstructions:"); 
    System.out.println("\tHunt the wumpus is a word based, hide and seek formatted game. You must enter a system of caves which create a 5 x 5 square"); 
    System.out.println("\tand hunt a mysterious creature called a wumpus, using 5 armor piercing arrows. All while avoiding hazards which give the"); 
    System.out.println("\tplayer a text warning when you are next to one. These hazards include a pit which you will fell a breeze when near, Bats"); 
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
  public static void print2DArray (String[][] gameWorld)
  {
    int numRow = gameWorld.length;
   int numCol = gameWorld[0].length;
    
    for (int i = 0; i < numRow; i++) {
    for (int j =0; j < numCol; j++) {
     
      System.out.print(gameWorld[i][j] + "\t");
    }
    System.out.println("");
    System.out.println("");
  }
  }
}
