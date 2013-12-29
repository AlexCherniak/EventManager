package gaming;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbManager.DataBaseManager;

/**
 * Servlet implementation class eventinfo
 */
@WebServlet("/eventinfo")
public class eventinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventinfo() {
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
		//Object nameO = request.getParameter("theEventName");//event name
				//Object hosterID = request.getParameter("theEventHoster");//event creator
				
				Object nameO = request.getParameter("EventName");//event name
				if (nameO != null)
				{
				//response.sendRedirect("/WEB-INF/eventindex.jsp?name=" + URLEncoder.encode(nameO.toString(), "UTF-8"));
					response.sendRedirect("eventindex?name=" + nameO.toString());
				}
	}

		}