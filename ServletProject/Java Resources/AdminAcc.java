import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminAcc directing the data an
 * html file to open Admin Home page
 * 
 */
@WebServlet("/AdminAcc")
public class AdminAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
        PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		
        pw.println("<h2><center><font color='red'><u>Admin Home Page</u></font></center></h2>");
		pw.println("<h3><center><font color='green'>Admin Login Success..!!!</font></center></h3>");
		pw.println("<h5><font color='red'>"+session.getAttribute("userid")+"</font></h5>");
	}

}