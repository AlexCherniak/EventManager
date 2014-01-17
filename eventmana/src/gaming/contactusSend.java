package gaming;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbManager.DataBaseManager;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * Servlet implementation class contactusSend
 */
@WebServlet("/contactusSend")
public class contactusSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactusSend() {
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
		Object hosterID = request.getParameter("profileIDValue");//event creator
		Object message = request.getParameter("text");
		
		if (message != null && hosterID != null)//check if there is input
		{
			sendMail(hosterID.toString(),message.toString());
			//if(!DataBaseManager.getInstance().insertNewScore(g))//if false was returned(event name exists)
				//response.sendRedirect("eventNameExists.html");//redirect to the ERROR page
				
		}
		response.sendRedirect("Main#contactus");//redirect to the main page
	}

	private void sendMail(String id,String userMessage){
		final String username = "eventmanagerproject@gmail.com";
		final String password = "managerproject";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("eventmanagerproject@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("eventmanagerproject@gmail.com"));
			message.setSubject("Event manager Help!");
			message.setText(id
				+ "\n\n"+userMessage);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		
		
	}
	
}
