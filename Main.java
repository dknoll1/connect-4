/*
  Title: Connect4.java
  Author:Daniel Knoll
  Design: A grid object with the following variables:
    -2d Array of characters
methods:
  turn_drop (char dropWhat, int colNum)):
    -place a letter
      'o' for player
      'x' for computer
    -finds the last possible cell in the column to sink to
  display_grid:
    -prints the 2d array in a pretty fashion

main:
  variables:
  -scanner user
  -random gen

  -instantiate grid

  -while (true) loop 
  -display board
  -wait for column selection for player turn
  -player.didIWin
  -computer decides randomly (unless time allows for making a smart computer)
  -computer.didIWin
  
*/
import java.util.*;

class Main 
{
  public static void main(String[] args)
  {
    Scanner  user = new Scanner(System.in);
    Random   gen  = new Random();

    System.out.printf("Welcome to Connect-X!\nHow many columns would you like? (Connect4 uses 7) ");
    int columns = user.nextInt();
    System.out.printf("How many rows would you like? (Connect 4 uses 6) ");
    int rows = user.nextInt();
    System.out.println("You need 4 checkers to win."); // found variable checkers quantity not possible without some things i haven't learned yet
    int checkers = 4;
    
    GameGrid board = new GameGrid(columns, rows, checkers);
    int      colChoice; 
    board.display_grid();
    
    while(true)
    {

      //player's turn
      colChoice = 0;
      do
      {
        System.out.printf("Your turn. Enter a column: 1-%d: ", board.columns);
        colChoice = user.nextInt();
      } while (colChoice < 1 || colChoice > board.columns);
      board.turn_drop('O', colChoice - 1);
      board.display_grid();
      if(board.checkWin('O'))
      {
        System.out.println("You win!");
        break;
      }
      
      //computer's turn
      System.out.println("Computer's turn now ...");
      colChoice = gen.nextInt(board.checkers);
      board.turn_drop('X', colChoice);
      board.display_grid();
      if(board.checkWin('X'))
      {
        System.out.println("Computer wins!");
        break;
      }
    }
  }
}