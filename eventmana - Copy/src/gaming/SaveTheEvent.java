package gaming;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mortbay.log.Log;

import com.google.gwt.dev.ModuleTabPanel.Session;

import dbManager.DataBaseManager;
import gaming.newEvent;

/**
 * Servlet implementation class SaveTheEvent
 */
public class SaveTheEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveTheEvent() {
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
		
		Object nameO = request.getParameter("theEventName");//event name
		Object hosterID = request.getParameter("theEventHoster");//event creator
		
		
		if (nameO != null && hosterID != null)//check if there is input
		{
			newEvent g = new newEvent();//call the constructor
			g.name = nameO.toString();
			g.hosterID = (hosterID.toString());
			
			/*
			 * //create a new session that called userName and contains the hosterID
			 * */
			HttpSession session = request.getSession();
			session.setAttribute("userName", g.hosterID);
			if(!DataBaseManager.getInstance().insertNewScore(g))//if false was returned(event name exists)
				response.sendRedirect("eventNameExists.html");//redirect to the ERROR page
				
		}
		response.sendRedirect("Main");//redirect to the main page
	}

}
