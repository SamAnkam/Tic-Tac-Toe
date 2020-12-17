import java.util.Scanner; 

public class TicTacToeRunner { //this uses the methods of ticTacToe to display the game to both the player
	
	public static int checkInput (Scanner scan, String type) {
        while (!scan.hasNextInt()) { //checks to make sure the input is a number
            System.out.println("That's not a number!");
            scan.nextLine();
         }
         int check = scan.nextInt();
         while (check <= 0 || check > 3) { //checks to make sure the input is a valid number
            System.out.println("That's not a valid input. Enter a " + type + " number between 1 and 3");
            check = scan.nextInt();
         }
		return check;
	}

   public static void inputRunner(Scanner scan, Player player, TicTacToe ttt) { //takes in the input of each player and adds their icon (X or O) to the selected spot on the gameBoard
      int row = 0;
      int column = 0;
            
      do { //this is used to make sure there the player selected spot doesn't overlap. 
    	  
         System.out.println(player.getName() + ": Enter the column (1-3) where you want to place " + player.getIcon());
         column = checkInput(scan, "column") - 1; 
      
         System.out.println(player.getName() + ": Enter the row (1-3) where you want to place " + player.getIcon());
         row = checkInput(scan, "row") - 1;
         
      } while (ttt.overlapCheck(row, column)); //goes through the loop if there is an overlap and asks the player to enter a different row and column
      
      if(player.getIcon() == "X") { //this checks whether player1 or player2 is currently playing and adds their icon (X or O) respectively
         ttt.enterX(row, column);  
      }
      if(player.getIcon() == "O") {
         ttt.enterO(row,column); 
      }
               
      ttt.printBoard(); //prints the board after every play
                  
   }

   public static void main(String[] args) {
      Player player1; //creates two new players
      Player player2;
      TicTacToe ttt = new TicTacToe(); //creates a new game of Tic Tac Toe
      Scanner scan = new Scanner(System.in);
      boolean user1 = true;
      boolean user2 = true;
      String anotherRound = "no"; //used to check if the user wants to play a another round
      
      
         System.out.println("Hello! \rWelcome to Tic Tac Toe. \rThis game requires two players"); //start of the tic tac toe game
         System.out.println("Do you want to play? (yes or no)");
         if (scan.nextLine().equalsIgnoreCase("yes")) { //checks if user wants to play the game
            System.out.println("Who wants to be 'X'. Enter your name.");
            player1 = new Player(scan.nextLine(), "X"); //initializes player1 to the values given by the user
            System.out.println("Who wants to be 'O'. Enter your name.");
            player2 = new Player(scan.nextLine(), "O");//initializes player2 to the values given by the user
         
            System.out.println("Instructions: \rThe game will be played in turns. \rWhen prompted to respond, type your location in the form of rows and columns. ");

            do {   //this do-while loop is used if the user wants to play again. check line 116

            System.out.println("This is the game board,");
            ttt.newBoard(); //this creates a new board
            ttt.printBoard(); //this prints the current board
         
            while(!ttt.checkFullBoard()) { //checks if the current gameBoard is full, if not the game continues to run
               if (user2) { //this block of code allows the player1 to play his move
                  inputRunner(scan, player1, ttt);      
                  user1 = true; //used to establish turns in the tic tac toe game
                  user2 = false;
                  if (ttt.winnerCheck()) { //checks if player1 is the winner
                     System.out.println(player1.getName() + " is the winner.");
                     break; //breaks from the game
                  } 
                  if(ttt.checkFullBoard()) { //checks if there is a fullboard, which will result in a tie
                     System.out.println("It's a tie! No one won this game of Tic Tac Toe.");
                     break; //breaks from the game
                  }
                  
                  else {
                     continue; }
               }
               
               else if (user1) {          
                  inputRunner(scan, player2, ttt);
                  user2 = true;
                  user1 = false;
               
                  if (ttt.winnerCheck()) {
                     System.out.println(player2.getName() + " is the winner.");
                     break;
                  } 
                  if(ttt.checkFullBoard()) {
                     System.out.println("It's a tie! No one won this game of Tic Tac Toe.");
                     break;
                  }
                  
                  else {
                     continue; }
               }
            
            } 
            
         scan.nextLine(); //this ensures that the next input line will be returned
         System.out.println("Do you want to play again? (yes or no)"); //allows the user to play again.
         anotherRound = scan.nextLine();  
         } while (anotherRound.equalsIgnoreCase("yes")); //checks whether the player wants to play again.
         System.out.println("Hope you enjoyed your game!");
         
      } else { 
            System.out.println("Goodbye, the game will always be here!");
         }

         
      
   
      
       
      
   
   
   
   
      
   
   }
}