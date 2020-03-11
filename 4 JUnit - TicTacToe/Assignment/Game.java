import javax.swing.JFrame;

/**
 * <h1>TicTacToe</h1>
 * This is a simple TicTacToe game. 
 * @author  Adeel Malik
 * @version 1.0
 * @since   01-30-2017 
 * YouTube Reference https://www.youtube.com/watch?v=ftJ66kZhdLk
 * @see Class GameInterface
 */

 /**
 * TicTacToe Game Main Class.
 */
public class Game{//class Game

	/**
	 * This is the main method
	 */
    public static void main(String[] args){		
        JFrame ticTacToe = new GameInterface(); //Calling the GameInterface class.
        ticTacToe.setTitle("TicTacToe Game..."); 					
        ticTacToe.setSize(300, 300);								
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
        ticTacToe.setLocationRelativeTo(null);						
        ticTacToe.setVisible(true); 								
    }//end main
} //end class Game
