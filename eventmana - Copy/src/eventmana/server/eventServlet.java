package eventmana.server;

import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eventmana.server.client;
import eventmana.server.Event;

import java.io.PrintWriter;
/**
 * Servlet implementation class eventServlet
 */
@WebServlet(description = "test servlet", urlPatterns = { "/eventServlet" })
public class eventServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int FB_id;
	private String name;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String newEvent = request.getParameter("info") ;
    	 //  Event c=new Event(newEvent);
    	//   request.setAttribute("newClient",c.get_name() );
    	//   request.getRequestDispatcher("Main").forward(request, response);
       
    	   /**
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:odbc:DRIVER={Microsoft Access Driver (*.accdb)};DBQ=student.accdb","","");
           Connection con = DriverManager.getConnection("jdbc:odbc:https://www.hidrive.strato.com/lnk/am2ROXWD");
            Statement st=con.createStatement();
            String name=info;
            //String address="delhi";
            int i=st.executeUpdate("insert into client(cName) values('"+name+"')");
            PrintWriter out = response.getWriter() ;
            out.println("Row is added") ;
            out.close() ;
           // System.out.println("Row is added");
            }
         catch(Exception e){
        	 PrintWriter out = response.getWriter() ;
             out.println("does not added:") ;
             out.close() ;
            // System.out.println("does not added:"+e);
         }
        */
        /**
        PrintWriter out = response.getWriter() ;
        out.println("<html>") ;
        out.println("<head><title>Hello eventServlet</title></head>") ;
        out.println("<body>") ;
        out.println("<h1>" + info + "</h1>") ;
        out.println("</body>") ;
        out.println("</html>") ;
        out.close() ;
       */

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
           this.doGet(request, response);
    }


}