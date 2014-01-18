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
	public void addNewEvent() //create a new newEvent
	{
		//act
		newEvent newTest=new newEvent();
		
		//assert
		assertEquals(newTest.getTries(),3);
	}
	
	@Test
	public void addNewEventWithVariables() //add a new event With variables
	{
		//act
		newEvent newTest2=new newEvent("rani",22,"000","1.manager-event.appspot.com","jce",true,"19/01/2014");
		
		//assert
		assertEquals(newTest2.getTries(),22);
	}
	
	
	

}
