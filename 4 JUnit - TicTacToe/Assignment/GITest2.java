import static org.junit.Assert.*;

import org.junit.Test;

public class GITest2 {

	@Test
	public void testGameStatus() {
		boolean expectedInput = false;
		
		GameInterface gi = new GameInterface();
		boolean actualInput = gi.GameStatus('X');
		
		assertEquals(expectedInput, actualInput);

		actualInput = gi.GameStatus('O');
		assertEquals(expectedInput, actualInput);
	}

}
