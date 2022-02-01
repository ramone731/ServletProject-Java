

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbconnection.DBConnection;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String utype=request.getParameter("utype");
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		
		Connection conn = DBConnection.dbConnect();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from userregist where utype=? and id=? and pwd=?");
			ps.setString(1, utype);
			ps.setString(2, uid);
			ps.setString(3, pwd);
		ResultSet rs = ps.executeQuery();
		int rowcount=0;
		String type=null;
		while(rs.next())
		{
			type=rs.getString(1);
			rowcount++;
			
		}
			
			//int rowcount = ps.executeUpdate();
			if(rowcount>0 & type.equals("admin"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("AdminAcc");
				rd.forward(request, response);
				//pw.println("Register has done...!!");
			}
			else if(rowcount>0 & type.equals("customer"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("CustomerPage");
				rd.forward(request, response);
			}
			else 
			{
				RequestDispatcher rd = request.getRequestDispatcher("UserRegister.html");
				rd.include(request, response);
				pw.println("Something went wrong..");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}