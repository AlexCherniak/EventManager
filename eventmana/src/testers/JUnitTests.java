package testers;

import static org.junit.Assert.*;
import dbManager.DataBaseManager;
import gaming.newEvent;

import org.junit.Test;

public class JUnitTests {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void addNewEvent() //input: variables, the event creator
	{
		//act
		newEvent newTest=new newEvent();
		
		//assert
		assertEquals(newTest.getTries(),0);
	}

}
