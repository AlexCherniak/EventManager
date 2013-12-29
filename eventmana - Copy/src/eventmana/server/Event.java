package eventmana.server;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Event {
	private int eventID;
	private String eventName;
	private Date date;
	private boolean PrivateOrpublic;
	private int HosterID;
	private String invitation;
	private String location;
	
	//public Event(int ID,String Name,Date date,int HosterID)
	public Event(String Name,int HosterID)
	{
		this.eventID=0;
		this.eventName=Name;
		this.date=new Date();
		this.PrivateOrpublic=true;
		this.HosterID=HosterID;
		this.invitation="";
	}
	
	public int getEventID()
	{
		return this.eventID;
	}
	
	public String getLocation()
	{
		return this.location;
	}
	
	public String getInvitation()
	{
		return this.invitation;
	}
	
	public int getHosterID()
	{
		return this.HosterID;
	}
	
	public String geteventName()
	{
		return this.eventName;
	}
	
	public Date getDate()
	{
		return this.date;
	}
	
	public boolean getPrivateOrpublic()
	{
		return this.PrivateOrpublic;
	}
	
	public void setEventID(int eventID)
	{
		this.eventID=eventID;
	}
	
	public void seteventName(String eventName)
	{
		this.eventName=eventName;
	}
	
	public void setLocatione(String location)
	{
		this.location=location;
	}
	
	public void setDate(Date date)
	{
		this.date=date;
	}
	
	public void setDate(String inv)
	{
		this.invitation=inv;
	}
	
	public void setPrivateOrpublic(boolean PrivateOrpublic)
	{
		this.PrivateOrpublic=PrivateOrpublic;
	}
	
	public void setHosterID(int HosterID)
	{
		this.HosterID=HosterID;
	}
	
	private String getDateTime(Date date) 
	{
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    return dateFormat.format(date);
	}
	
	public void printEvent()
	{
		System.out.println("Event name:" + this.eventName);
		System.out.println("Event date:"+getDateTime(this.date)  );
		System.out.println("Event location:" + this.location);
	}
	

}//class
