import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String url="jdbc:mysql://localhost/myuser:8080";
    public static final String username="root";
    public static final String password="yesitsme";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");            //for reading obj from server and displaying client understandable format.
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=(Connection) DriverManager.getConnection(url, username, password);
            //either cast or import java.sql.connection;
            out.println("<h1>successful</h1>");          //if connection is successfully established.
            String name=request.getParameter("name1");
            String pass=request.getParameter("pass12");
            
            
            Statement st=conn.createStatement();
            int i=st.executeUpdate("insert into stud values('"+name+"','"+pass+"');");
            if(i<0)
            {
                out.println("Failure");
            }
            else
            {
                out.println("Values Successfully inserted");
            }
            
        }
        catch(Exception e)
        {
            out.println("<h2>Exception: +e+</h2>");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
