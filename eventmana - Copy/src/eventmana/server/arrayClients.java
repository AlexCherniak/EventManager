package eventmana.server;
import java.util.ArrayList;

public class arrayClients {
	public static ArrayList<client> array;
	private int numOfClients;
	
public arrayClients()//constructor
{
	 this.array = new ArrayList<client>(100);
	 this.numOfClients=0;
}
///extend the array
public void addClient(client g)//add Client to array
{
	for (int i=0;i<this.array.size();i++) 
	{
	    //if(this.array.equals(g));
		//if(this.array.get(i).get_FB_id()==g.get_FB_id())
		if(this.array.get(i).get_name()==g.get_name())
		{
			return;
		}
	} 
	this.array.add(g);//add a new Client to the list
	this.numOfClients++;
}

public void removeClient(String Name)//remove Client to array
{
	for (int i=0;i<this.array.size();i++) 
	{
		if(this.array.get(i).get_name()==Name)
		{
			this.array.remove(this.array.get(i));//remvoe a new Client from the list
			this.numOfClients--;
		}
	} 
	
}//removeClient

public void printAllClients()
{
	if(numOfClients==0)
		System.out.println("empty");
	else
		for (client g1 : this.array) 
		{
			g1.printClient();//print name and id
		}
}//printAllClients


}
