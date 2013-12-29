package eventmana.server;

import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

/**
 * Servlet implementation class client
 */
@WebServlet("/client")
public class client extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private int FB_id;
	private String name;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public client(String name)//cons
	{
		//this.FB_id=FB_id;
		this.name=name;
	}
	
	//public int get_FB_id()
	//{
	//	return this.FB_id;
	//}

	public String get_name()
	{
		return this.name;
	}

	//public void set_FB_id(int id)
	//{
	//	this.FB_id=id;
	//}

	public void set_name(String name)
	{
		this.name=name;
	}

	public void printClient()
	{
		System.out.println("Name = " + this.name);
		//System.out.println("Facebook ID = " + this.FB_id);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String M = request.getParameter("message") ;
	       // String message=null;
		 client c=new client(M);
	        request.setAttribute("newClient",c.get_name() );
	        request.getRequestDispatcher("Main").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
