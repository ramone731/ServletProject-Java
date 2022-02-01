
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCustomer
 */
@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		Cookie cname = new Cookie("cname",request.getParameter("cname"));
		Cookie caddress = new Cookie("caddress",request.getParameter("caddress"));
		
		//set time to store client data in browser
		cname.setMaxAge(3600);
		caddress.setMaxAge(3600);
		
		//add cookies in client browser
		response.addCookie(cname);
		response.addCookie(caddress);
		
		pw.println("Click Button to get the Client Information");
		pw.println("<form action='CustomerData' method='post'>");
		pw.println("<input type='submit' value='Click Hee'>");
		
	}

}