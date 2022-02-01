import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateSession
 */
@WebServlet("/CreateSession")
public class CreateSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession();
		String sessionid = session.getId();
		if(session.isNew())
		{
			pw.println("Created a New Session");
			pw.println("Session id is: "+sessionid);
			pw.println(session.getCreationTime());
		}
		else
		{
			pw.println("Session is already exist");
			pw.println("Server Identified");
		}
	}

}