package gaming;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mortbay.log.Log;

import com.google.gwt.dev.ModuleTabPanel.Session;

import dbManager.DataBaseManager;
import gaming.newEvent;

/**
 * Servlet implementation class editEvent
 */
@WebServlet("/editEvent")
public class editEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editEvent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		Object nameO = request.getParameter("eventtName");//new event name
		Object OldNameO = request.getParameter("eventNameOld");//the old event name
		Object hosterID = request.getParameter("eventHoster");//event creator
		//Object time = request.getParameter("EventTime");//event time
		//Object PrivateOrpublic = request.getParameter("EventPublic");//event Private Or public
		Object invitation = request.getParameter("EventInvitation");//event invitation URL
		Object location = request.getParameter("EventLocation");//event location
		int tries=0;
		
		if (nameO != null && OldNameO!=null && nameO.toString() != "" &&hosterID.toString() != "" &&invitation.toString() != ""  &&location.toString() != "" && OldNameO.toString()!="" )//create a new event object and send it to update function
		{
			newEvent newE=new newEvent(nameO.toString(),tries,hosterID.toString(),invitation.toString(),location.toString());
			DataBaseManager.getInstance().UpdateMyEvent(newE, OldNameO.toString());
			response.sendRedirect("eventindex?name=" + nameO.toString());
		}//if
		else
		{
			response.sendRedirect("eventNameExists.html");//redirect to the ERROR page
		}
	}

		}