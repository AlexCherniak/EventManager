package gaming;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class GameScore {
	@Persistent
	public String name;//event name
	@Persistent
	public int tries;
	@Persistent
	public String hosterID;
	@Persistent
	public float time;
	@Persistent
	private boolean PrivateOrpublic;
	@Persistent
	private String invitation;
	@Persistent
	private String location;
	
	
	public GameScore()
	{
		this.name="";
		this.tries=0;
		this.hosterID="";
		this.time=(float) 0.0;
		this.PrivateOrpublic=true;//public
		this.invitation="";
		this.location="";
		
	}

}
