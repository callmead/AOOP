import static org.junit.Assert.*;

import org.junit.Test;

public class GITest3 {
	
	@Test
	public void testBoardIsFull() {
		
		GameInterface gi = new GameInterface();
		
		assertFalse(gi.gameCells[0][1].getToken() == 'X');
		assertFalse(gi.gameCells[1][2].getToken() == 'O');
		assertFalse(gi.gameCells[2][0].getToken() == 'X');
		
	}
}
