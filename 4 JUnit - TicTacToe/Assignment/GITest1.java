import static org.junit.Assert.*;

import org.junit.Test;

public class GITest1 {

	@Test
	public void testBoardisFull() {
		boolean expectedOutPut = false;
		
		GameInterface gi = new GameInterface();

		boolean actualOutput = gi.BoardIsFull();
		assertEquals(expectedOutPut, actualOutput);
		
	}
}

