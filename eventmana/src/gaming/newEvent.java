package gaming;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class newEvent {
	@Persistent
	public String name;//event name
	@Persistent
	public int tries; //how many times event was edited
	@Persistent
	public String hosterID;//ID of event creator
	@Persistent
	public float time;//date time
	@Persistent
	public boolean PrivateOrpublic;//the event is public(true),till the creator change it to private
	@Persistent
	public String invitation;//the invitation card link will be saves here
	@Persistent
	public String location;//the location of the event
	@Persistent
	public String calendar;//the calendar of the event
	
	
	public newEvent()//constructor
	{
		this.name="";
		this.tries=0;
		this.hosterID="";
		this.time=(float) 0.0;
		this.PrivateOrpublic=false;//private
		this.invitation="http://pearlsofprofundity.files.wordpress.com/2013/01/thumbs-up-smiley-face.jpg";
		this.location="location";
		this.calendar="";
		
	}
	
	public newEvent(String name,int tries, String hosterID, String invitation, String location, boolean pvtORpp,String calendars) //constructor
	{
		this.name=name;
		this.tries=tries;
		this.hosterID=hosterID;
		this.time=0;
		this.invitation=invitation;
		this.location=location;
		this.PrivateOrpublic=pvtORpp;//public
		this.calendar=calendars;
	}

}
