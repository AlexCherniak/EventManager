package dbManager;
import java.util.List;

import gaming.newEvent;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.PersistenceManager;

import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.sun.xml.internal.ws.wsdl.writer.document.Fault;
public final class DataBaseManager
 {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    PersistenceManager pm = PMF.get().getPersistenceManager();
    private DataBaseManager() {}
    private static DataBaseManager instance = null;
    public static DataBaseManager getInstance()
    {
        if (instance == null)
            instance = new DataBaseManager();
        return instance;
    }
    
    
    public boolean insertNewScore(newEvent s) //add new event, if event exists don't add
    {
    	if(!DataBaseManager.getInstance().checkIfEventNameAvailable((s.name)))
		{
    		return false;
		}
    	else
    	{
    	pm.makePersistent(s);
    	return true;
    	}
    }
    //public List<newEvent> getScoreForPlayer(String name)
    public List<newEvent> getEvent(String name)
    {
    	System.out.println("getting the event " + name);
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	q.setFilter("hosterID==theName");
    	q.declareParameters("String theName");
    	return (List<newEvent>)q.execute(name);
    }
    
    public boolean checkIfEventNameAvailable(String name)//check if the name exists, if yes it's not available
    {
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	List<newEvent> list =(List<newEvent>)q.execute(name);
    	if(list.isEmpty())
    		return true;
    	return false;
    }
    
    public String getInvitation(String name)//get the invitation link for the "name" event
    {
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	List<newEvent> list = (List<newEvent>)q.execute(name);
    	String temp = "";
    	for (newEvent item : list)
		{
    		temp=item.invitation;
		}
    	return temp;
    }
    
    
    public void setInvitation(String name,String newLink)//set the new invitation link for the "name" event
    {
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	List<newEvent> list = (List<newEvent>)q.execute(name);
    	for (newEvent item : list)
		{
    		item.invitation=newLink;
		}
    	
    }
    
    
    public boolean UpdateMyEvent(newEvent afterUpdate,String OldnameO)//update the newEvent object
    {
    	if(!DataBaseManager.getInstance().checkIfEventNameAvailable((afterUpdate.name)) && afterUpdate.name==OldnameO)//check if the name doesn't exist
		{
    		return false;
		}
    	
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	List<newEvent> list = (List<newEvent>)q.execute(OldnameO);
    	for (newEvent item : list)
		{
    		pm.deletePersistent(item);
		}
    	
    	pm.makePersistent(afterUpdate);
    	return true;
    	
    	
    }
     
    public void deleteMyEvent(String OldnameO)//update the newEvent object
    {	
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	List<newEvent> list = (List<newEvent>)q.execute(OldnameO);
    	for (newEvent item : list)
		{
    		pm.deletePersistent(item);
		}
    }
    
    public float getTime(String name)//get the time for the "name" event
    {
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	List<newEvent> list = (List<newEvent>)q.execute(name);
    	float temp = 0;
    	for (newEvent item : list)
		{
    		temp=item.time;
		}
    	return temp;
    }
    
    public void setTime(String name,float newTime)//set the new time for the "name" event
    {
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	List<newEvent> list = (List<newEvent>)q.execute(name);
    	for (newEvent item : list)
		{
    		item.time=newTime;
		}
    	
    }
    
    public boolean getPrivateOrpublic(String name)//get the PrivateOrpublic for the "name" event
    {
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	List<newEvent> list = (List<newEvent>)q.execute(name);
    	boolean temp = true;
    	for (newEvent item : list)
		{
    		temp=item.PrivateOrpublic;
		}
    	return temp;
    }
    
    public void setPrivateOrpublic(String name,boolean newPrivateOrpublic)//set the new time for the "name" event
    {
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	List<newEvent> list = (List<newEvent>)q.execute(name);
    	for (newEvent item : list)
		{
    		item.PrivateOrpublic=newPrivateOrpublic;
		}
    	
    }
   
    public String getLocation(String name)//get the location for the "name" event
    {
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	List<newEvent> list = (List<newEvent>)q.execute(name);
    	String temp = "";
    	for (newEvent item : list)
		{
    		temp=item.location;
		}
    	return temp;
    }
    
    public String getCalendar(String name)//get the location for the "name" event
    {
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	List<newEvent> list = (List<newEvent>)q.execute(name);
    	String temp = "";
    	for (newEvent item : list)
		{
    		temp=item.calendar;
		}
    	return temp;
    }

    
    public void setLocation(String name,String newlocation)//set the new location for the "name" event
    {
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	List<newEvent> list = (List<newEvent>)q.execute(name);
    	for (newEvent item : list)
		{
    		item.location=newlocation;
		}
    }
       
    
    public String getHosterID(String name)//get the hoster ID for the "name" event
    {
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	List<newEvent> list = (List<newEvent>)q.execute(name);
    	String temp = "";
    	for (newEvent item : list)
		{
    		temp=item.hosterID;
		}
    	return temp;
    }
    
    public List<newEvent> getEventinfo(String name,String Hoster)//get event of a specific event for user
    {
    	javax.jdo.Query q = pm.newQuery(newEvent.class, ":p.contains(Hoster)");
    	q=(javax.jdo.Query)q.execute(name);
    	q.setFilter("name== name");
    	return (List<newEvent>)q.execute(name);
    }
    
    public List<newEvent> getAllEvents()
    {
    	javax.jdo.Query q = pm.newQuery(newEvent.class);
    	return (List<newEvent>)q.execute();
    }

}
