package backend.example.project.server;
import java.util.ArrayList;
import java.util.List;



public class Fib {
	private List<Integer> knownNumbers;
	private Fib()
	{
		knownNumbers = new ArrayList<Integer>();
	}
	private static Fib instance = null;
	public static Fib getInstance()
	{
		if (instance == null)
			instance = new Fib();
		return instance;
	}
	
	
	public int getFibNumber(int index)
	{
		fillTable(index);
		return knownNumbers.get(index);
	}
	
	private void fillTable(int index)
	{
		while (knownNumbers.size() <= index)
		{
			if (knownNumbers.size() >= 2)
			{
				knownNumbers.add(knownNumbers.get(knownNumbers.size() - 1) + knownNumbers.get(knownNumbers.size() - 2));
			}
			else
			{
				knownNumbers.add(1);
			}
		}
	}

}
