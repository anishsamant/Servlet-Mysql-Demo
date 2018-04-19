

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String psw=request.getParameter("psw");
		String dbEmail=null;
		String dbPsw=null;

		String user="root";
		String password="yesitsme";
		String url="jdbc:mysql://localhost:3306/test";

		Connection conn=null;
		Statement stmt=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
			String sql="select email,password from demo";
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			int flag=0;
			while(rs.next())
			{
				dbEmail=rs.getString("email");
				dbPsw=rs.getString("password");
				if(email.equals(dbEmail) && psw.equals(dbPsw))
				{
					//out.println("Successful");
					flag=1;
					response.sendRedirect("index.jsp");
					break;
				}
				
			}
			if(flag==0)
			{
				response.sendRedirect("login.jsp");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}





















