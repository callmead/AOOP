import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * <h1>TicTacToe</h1>
 * This is a simple TicTacToe game. 
 * @author  Adeel Malik
 * @version 1.0
 * @since   01-30-2017 
 * YouTube Reference https://www.youtube.com/watch?v=ftJ66kZhdLk
 * @see Class Game
 */


/**
 * JFrame to hold Game Interface.
 */
public class GameInterface extends JFrame{//class GameInterface
	
	/* Indicate the current player */
	private char player = 'X';
	/* Indicate the game status */
	private boolean gameOver = false;

	/* Create game grid */
	public gameGrid[][] gameCells = new gameGrid[3][3];

	/* Create a status label */
	JLabel lblStatus = new JLabel("Player X to play");

   /**
    * Constructor
    */
	public GameInterface(){//Constructor
	   
		/* Panel to hold cells */
		JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				panel.add(gameCells[i][j] = new gameGrid());
			}//end for loop j
		}// end for loop i
		
		add(panel, BorderLayout.CENTER);
		add(lblStatus, BorderLayout.SOUTH);
	}//end Constructor

   /**
    * Determine if game board is full.
    * @return True, if game board is full. Otherwise, false.
    */
	public boolean BoardIsFull(){//BoardIsFull
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if (gameCells[i][j].getToken() == ' '){
					return false;
				}//end if
			}//end for loop j
		}//end for loop i
		return true;
	}//end BoardIsFull

   /**
    * Determines Game Status if a player has won.
    * @param token Token to check winner.
    * @return True, if the token has won. Otherwise, false.
    */
	public boolean GameStatus(char token){
		/* Checking rows for winner*/
		for (int i = 0; i < 3; i++){
			if ((gameCells[i][0].getToken() == token) && (gameCells[i][1].getToken() == token) && (gameCells[i][2].getToken() == token)){
				return true;
			}//end if
		}//end for loop i

		/* Checking columns for winner*/
		for (int j = 0; j < 3; j++){
			if ((gameCells[0][j].getToken() == token) && (gameCells[1][j].getToken() == token) && (gameCells[2][j].getToken() == token)){
				return true;
			}//end if
		}//end for loop j
		
		/* Checking diagonally for winner */
		if ((gameCells[0][0].getToken() == token) && (gameCells[1][1].getToken() == token) && (gameCells[2][2].getToken() == token)){
            return true;
		}//end if
		
		if ((gameCells[0][2].getToken() == token) && (gameCells[1][1].getToken() == token) && (gameCells[2][0].getToken() == token)){
            return true;
		}//end if

		return false;
	}

   /**
    * public class gameGrid. Defining cell on the game board.
    */
    public class gameGrid extends JPanel{//class gameGrid
		// token of current cell
		private char token = ' ';

       /**
        * Constructor
        */
		public gameGrid(){//Constructor
			setBorder(new LineBorder(Color.black, 1));
			addMouseListener(new gameMouseListener());
		}//end Constructor

       /**
        * Gets the token of the cell.
        * @return The token value of the cell.
        */
		public char getToken(){//getToken
			return token;
		}//end getToken

       /**
        * Sets the token of the cell.
        * @param c Character to use as token value.
        */
		public void setToken(char c){//setToken
			token = c;
			repaint();
		}//end setToken

       /**
        * paintComponent to Paint the cells with X or O.
        * 
        */		
		@Override
		protected void paintComponent(Graphics g){//paintComponent
			super.paintComponent(g);

			/* if token is X then draw X*/	
			if (token == 'X'){
				g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
				g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
			}
			/* if token is O then draw O*/	
			else if (token == 'O'){
				g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
			}
		}//end paintComponent

	   /**
		* Private class gameMouseListener. To entertain user mouse clicks.
		*/
		private class gameMouseListener extends MouseAdapter{
		   
			@Override
			public void mouseClicked(MouseEvent e){
				//if game is over then return.
				if (gameOver)
					return;
               
				// if the cell is empty and the game is not over
				if (token == ' ' && player != ' '){
					setToken(player);
				}
				// Check game status
				if (GameStatus(player)){
					lblStatus.setText("Player " + player + " Won!   Game over!");
					player = ' ';
					gameOver = true;
				}
				//if board is full without a winner then return and tie game
				else if (BoardIsFull()){
					lblStatus.setText("Game tied!!!");
					player = ' ';
					gameOver = true;
				}
				//one of the players has won
				else{
					player = (player == 'X') ? 'O' : 'X';
					lblStatus.setText("Player " + player + " to play.");
				}
			}
		} // end class gameMouseListener
	} // end class gameGrid
} // end class GameInterface