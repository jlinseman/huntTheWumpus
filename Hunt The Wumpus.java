
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
    // initializes board with locations in each index
    gameWorld[0][0]=  "you are at 0,0" ; 
    gameWorld[0][1] = "you are at 0,1" ;
    gameWorld[0][2] = "you are at 0,2" ;
    gameWorld[0][3] = "you are at 0,3" ;
    gameWorld[0][4] = "you are at 0,4" ;
    
    gameWorld[1][0] = "you are at 1,0"; 
    gameWorld[1][1] = "you are at 1,1" ;
    gameWorld[1][2] = "you are at 1,2" ;
    gameWorld[1][3] = "you are at 1,3" ;
    gameWorld[1][4] = "you are at 1,4" ;
    
    gameWorld[2][0] = "you are at 2,0" ;
    gameWorld[2][1] = "you are at 2,1" ;
    gameWorld[2][2] = "you are at 2,2" ;
    gameWorld[2][3] = "you are at 2,3" ;
    gameWorld[2][4] = "you are at 2,4" ;
    
    gameWorld[3][0] = "you are at 3,0" ;
    gameWorld[3][1] = "you are at 3,1" ;
    gameWorld[3][2] = "you are at 3,2" ;
    gameWorld[3][3] = "you are at 3,3" ;
    gameWorld[3][4] = "you are at 3,4" ;
    
    gameWorld[4][0] = "you are at 4,0" ;
    gameWorld[4][1] = "you are at 2,1" ;
    gameWorld[4][2] = "you are at 2,2" ;
    gameWorld[4][3] = "you are at 2,3" ;
    gameWorld[4][4] = "you are at 2,4" ;
    
    //creates random spawn location for wumpus
    int wumpRowInd = randInt(0,4);
    int wumpColInd = randInt(0,4); 
    gameWorld[wumpRowInd][wumpColInd] = gameWorld[wumpRowInd][wumpColInd].concat(" you were eaten by a wumpus!"); 
 
    //creates random spawn location for pit hazard
   do
   {
    int pitRowInd = randInt(0,4);
    int pitColInd = randInt(0,4); 
    gameWorld[pitRowInd][pitColInd] =  gameWorld[pitRowInd][pitColInd].concat(" you fell into a pit!"); 
   }while (gameWorld[pitRowInd][pitColInd] ==  gameWorld[wumpRowInd][wumpColInd]);
    


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
  }   
  public static void instructions()
  {
    System.out.println("\tInstructions:"); 
    System.out.println("\tHunt the wumpus is a word based, hide and seek formatted game. You must enter a system of caves which create a 5 x 5 square"); 
    System.out.println("\tand hunt a mysterious creature called a wumpus, using 5 armor piercing arrows. All while avoiding hazards which give the"); 
    System.out.println("\tplayer a text warning when you are next to one. These hazards include a pit which you will fell a breeze when near, Bats"); 
    System.out.println("\twhich will transport you to a new location in the cave and is alerted by the flapping of wings, and finally the wumpus which"); 
    System.out.println("\tomits a horrible smell when you get close."); 
  }  
  public static int randInt(int min, int max)
  {
    Random rand = new Random();
    
    int randomNum = rand.nextInt((max - min) + 1) + min;
    
    return randomNum;
  }
  
  
} 
