import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RLogin", "root", "Aaditya@#987Kas");
            
            String name = request.getParameter("txtName");
            String password = request.getParameter("txtPwd");
            String email = request.getParameter("txtEmail");
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO Login(uname, password, email) VALUES(?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, email);
            
            int i = ps.executeUpdate();
            if (i > 0) {
                out.println("<font color=green size=18> Registration Successful! <br>");
                out.println("<a href=login.jsp>Login Now</a>");
            } else {
                out.println("<font color=red size=18> Registration Failed! <br>");
                out.println("<a href=register.jsp>Try Again</a>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
