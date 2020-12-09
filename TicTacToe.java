public class TicTacToe { //holds the methods for ticTacToe Runner
   final private int size = 3;
   private String[][] gameBoard = new String[size][size]; //creates a 2D array for the gameBoard
   final private int counter = 9;
   
   public void newBoard() { //creates a new gameBoard by entering '*' into the slots
      for(int i = 0; i < size; i++) {
         for(int j = 0; j < size; j++) {
            gameBoard[i][j] = "*";
         }
      }
   }
   
   public void printBoard() { //prints the gameBoard
      for(int i = 0; i < size; i++) { //goes through the 2D Array and prints each specific row and column
         for(int j = 0; j < size; j++) {
            System.out.print(gameBoard[i][j]);
         }
         System.out.println();
      }
   }
   
   public void enterX(int row, int col) { //enters X into the gameBoard
      if (!overlapCheck(row, col)) {
         gameBoard[row][col] = "X";
      }
	   }
   
   public void enterO(int row, int col) { //enters O into the gameBoard
      if (!overlapCheck(row, col)) {
         gameBoard[row][col] = "O";
         }
   }
   
   public boolean overlapCheck(int row, int col) { //checks for overlaps at a specific row and column
      if (gameBoard[row][col].equals("X") || gameBoard[row][col].equals("O")) { 
         return true;
         }
      else
         return false;
         
   }
   
   public boolean checkFullBoard() {
      int counterDup = counter; //uses a temporary counter using the value of counter 
      for(int i = 0; i < size; i++) { // goes through the 2D array and checks for '*' by calling the overlapCheck method
         for(int j = 0; j < size; j++) {
            if (overlapCheck(i,j)) {
               counterDup--; } 
         }
      }
      if (counterDup == 0) {
         return true; }
      else
         return false;
   }
   public boolean winnerCheck() { //checks for all the conditions and makes sure that '*' is not a criteria for matches
      if (!gameBoard[0][0].equals("*") && gameBoard[0][0].equals(gameBoard[0][1]) && gameBoard[0][1].equals(gameBoard[0][2])) {
         return true; }
      else if (!gameBoard[1][0].equals("*") && gameBoard[1][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[1][2])) {
         return true; }
      else if (!gameBoard[2][0].equals("*") && gameBoard[2][0].equals(gameBoard[2][1]) && gameBoard[2][1].equals(gameBoard[2][2])) {
         return true; }
      else if (!gameBoard[0][0].equals("*") && gameBoard[0][0].equals(gameBoard[1][0]) && gameBoard[1][0].equals(gameBoard[2][0])) {
         return true; }
      else if (!gameBoard[0][1].equals("*") && gameBoard[0][1].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][1])) {
         return true; }
      else if (!gameBoard[0][2].equals("*") && gameBoard[0][2].equals(gameBoard[1][2]) && gameBoard[1][2].equals(gameBoard[2][2])) {
         return true; }
      else if (!gameBoard[0][0].equals("*") && gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2])) {
         return true; }
      else if (!gameBoard[0][2].equals("*") && gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0])) {
         return true; }
      else 
         return false;
   }
   

 

   

   

   
   
}