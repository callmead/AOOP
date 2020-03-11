import javax.swing.JFrame;

/**
 * This is a simple little TicTacToe game.
 */
public class TicTacToe
{
    public static void main(String[] args) 
    {
		//Game game = new Game();
		
        JFrame ticTacToe = new GameInterface();
        ticTacToe.setTitle("Phantom TicTacToe Game!");
        ticTacToe.setSize(600, 600);
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticTacToe.setLocationRelativeTo(null);
        ticTacToe.setVisible(true); 
    }
} // end class TicTacToe