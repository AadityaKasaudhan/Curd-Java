import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RLogin", "root", "Aaditya@#987Kas");
            
            if ("create".equals(action)) {
                createUser(request, response, con);
            } else if ("update".equals(action)) {
                updateUser(request, response, con);
            } else if ("delete".equals(action)) {
                deleteUser(request, response, con);
            } else if ("read".equals(action)) {
                readUser(request, response, con);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void createUser(HttpServletRequest request, HttpServletResponse response, Connection con) throws SQLException, IOException {
        String name = request.getParameter("txtName");
        String password = request.getParameter("txtPwd");
        String email = request.getParameter("txtEmail");
        
        PreparedStatement ps = con.prepareStatement("INSERT INTO Login(uname, password, email) VALUES(?, ?, ?)");
        ps.setString(1, name);
        ps.setString(2, password);
        ps.setString(3, email);
        
        int i = ps.executeUpdate();
        PrintWriter out = response.getWriter();
        if (i > 0) {
            out.println("User created successfully");
        } else {
            out.println("User creation failed");
        }
    }
    
    private void updateUser(HttpServletRequest request, HttpServletResponse response, Connection con) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("txtName");
        String password = request.getParameter("txtPwd");
        String email = request.getParameter("txtEmail");
        
        PreparedStatement ps = con.prepareStatement("UPDATE Login SET uname=?, password=?, email=? WHERE id=?");
        ps.setString(1, name);
        ps.setString(2, password);
        ps.setString(3, email);
        ps.setInt(4, id);
        
        int i = ps.executeUpdate();
        PrintWriter out = response.getWriter();
        if (i > 0) {
            out.println("User updated successfully");
        } else {
            out.println("User update failed");
        }
    }
    
    private void deleteUser(HttpServletRequest request, HttpServletResponse response, Connection con) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        PreparedStatement ps = con.prepareStatement("DELETE FROM Login WHERE id=?");
        ps.setInt(1, id);
        
        int i = ps.executeUpdate();
        PrintWriter out = response.getWriter();
        if (i > 0) {
            out.println("User deleted successfully");
        } else {
            out.println("User deletion failed");
        }
    }
    
    private void readUser(HttpServletRequest request, HttpServletResponse response, Connection con) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Login WHERE id=?");
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        PrintWriter out = response.getWriter();
        if (rs.next()) {
            out.println("ID: " + rs.getInt("id"));
            out.println("Username: " + rs.getString("uname"));
            out.println("Email: " + rs.getString("email"));
        } else {
            out.println("User not found");
        }
    }
}
