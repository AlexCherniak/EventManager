package gaming;

import java.io.IOException;
import java.io.PrintWriter;
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
public class deleteEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteEvent() {
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
			
		Object OldNameO = request.getParameter("eventNameOld");//the old event name
		 
         
		if (OldNameO.toString()!="" )
		{
			DataBaseManager.getInstance().deleteMyEvent(OldNameO.toString());
			response.sendRedirect("http://1.manager-event.appspot.com/Main#services");
		}//if
		else
		{
			response.sendRedirect("eventNameExists.html");//redirect to the ERROR page
		}
	}

		}