package eventmana.server;
import java.util.ArrayList;

public class eventsArray {
	public static ArrayList<Event> array;
	private int numOfEvents;
	
	public eventsArray()
	{
		 this.array = new ArrayList<Event>(100);
		 this.numOfEvents=0;
	}
	
	public void addEvent(Event g)//add Event to array
	{
		for (int i=0;i<this.array.size();i++) 
		{
		    //if(this.array.equals(g));
			if(this.array.get(i).getEventID()==g.getEventID())
			{
				return;
			}
		} 
		this.array.add(g);//add a new Event to the list
		this.numOfEvents++;
	}

	public void removeEvent(int ID)//remove Event to array
	{
		for (int i=0;i<this.array.size();i++) 
		{
			if(this.array.get(i).getEventID()==ID)
			{
				this.array.remove(this.array.get(i));//remvoe a new Event from the list
				this.numOfEvents--;
			}
		} 
		
	}//removeEvent

	public void printAllEvents()
	{
		for (Event g1 : this.array) 
		{
			g1.printEvent();//print name and id
		}
	}//printAllEvents
	
}//class
