class GameGrid
{
  int columns;
  int rows;
  int checkers;
  char[][] gameBoard;
  // i would like to choose the gamegrid based on user input, and also choose how many connected checkers are needed to win!
  public GameGrid(int colNum, int rowNum, int winAmt) 
  {
    columns  = colNum;
    rows     = rowNum;
    checkers = winAmt;

    gameBoard = new char[rows][columns];
    for (int i = 0; i < rows; i++)
      {
        for (int j = 0; j < columns; j++)
          {
            gameBoard[i][j] = ' ';
          }
      }
  }
  
  public void turn_drop(char dropWhat, int col)
  // should be simple enough, something like if the next row of this column is null, move to it until placing the letter there
  {
    for (int i = rows - 1; i > -1; i--)
    {
      if(gameBoard[i][col] == ' ')
      {
        gameBoard[i][col] = dropWhat;
        break;
      }
    }
  }
  
  public boolean checkWin(char who)
  // this will be recursive, and very fun to write once i have the courage
  {
  	int i = 0;
    int j = 0;
  
    for (i = 0; i < rows; i++)
    { // check horizontals
      for (j = 0; j < columns - checkers + 1; j++)
      {
        if(gameBoard[i][j] == who && gameBoard[i][j + 1] == who && gameBoard[i][j + 2] == who && gameBoard[i][j + 3] == who)
        {
          return true;
        }
      }
    }
    
    for (i = 0; i < rows - checkers + 1; i++)
    { //check verticals
      for (j = 0; j < columns; j++)
      {
        if(gameBoard[i][j] == who && gameBoard[i + 1][j] == who && gameBoard[i + 2][j] == who && gameBoard[i + 3][j] == who)
        {
          return true;
        }
      }
    }
    
    for (i = 0; i < rows - checkers + 1; i++)
    { // check diagonals
      for (j = 0; j < columns; j++)
      {
        if(gameBoard[i][j] == who && gameBoard[i + 1][j + 1] == who && gameBoard[i + 2][j + 2] == who && gameBoard[i + 3][j + 3] == who)
        {
          return true;
        }
      }
    }

    for (i = rows - checkers + 1; i < rows; i++)
    { // check reverse diagonals
      for (j = 0; j < columns - checkers + 1; j++)
      {
        if(gameBoard[i][j] == who && gameBoard[i - 1][j + 1] == who && gameBoard[i - 2][j + 2] == who && gameBoard[i - 3][j + 3] == who)
        {
          return true;
        }
      }
    }
    return false;
  }

  public void display_grid()
  // write a beautiful printing of the game board, and maybe some instructions at the bottom of it. 
  {
    for (int i = 0; i < rows; i++)
    {
      for (int j = 0; j < columns; j++)
      {
          System.out.printf("[%c]", gameBoard[i][j]);
      }
      System.out.printf("\n");
    }
  }
}