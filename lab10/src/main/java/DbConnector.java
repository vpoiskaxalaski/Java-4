import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DbConnector", urlPatterns = "/database")
public class DbConnector extends HttpServlet {

    private  Connection connection;
    private  String url = "jdbc:mysql://localhost:3306/lab_10";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String userName = "root";
    private static String password = "кщще";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName(driverName).newInstance();
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Statement stmt=null;
        try{
            try{
                Integer id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                stmt = connection.createStatement();
                String query = String.format("call insertToT1(%d, '%s')", id, name);
                ResultSet rs=stmt.executeQuery(query);
                response.getWriter().println("done");
            } catch(SQLException s){
                s.printStackTrace();
                response.getWriter()
                        .println(s.getMessage());
            }

            stmt.close();
        }catch (Exception e){
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            response.getWriter()
                    .println(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id;
        String name;
        String query;

        query = "SELECT * FROM t1";

        if(request.getParameter("id")!=null){
            id=Integer.parseInt(request.getParameter("id"));
            query = String.format("SELECT * FROM t1 WHERE id=%d", id);
        }

        if(request.getParameter("name")!=null){
            name = request.getParameter("name");
            query = String.format("SELECT * FROM t1 WHERE name='%s'", name);
        }

        Statement stmt=null;
        try{
            try{
                stmt = connection.createStatement();
                ResultSet rs=stmt.executeQuery(query);

                StringBuilder resultMessage = new StringBuilder();
                while(rs.next()){
                    resultMessage
                            .append("<div>")
                            .append(rs.getInt("id")).append("   ").append(rs.getString("name"))
                            .append("</div>");
                }
                // close ResultSet rs
                rs.close();
                System.out.println(resultMessage);
                response.getWriter().println(resultMessage);
            } catch(SQLException s){
                s.printStackTrace();
                response.getWriter()
                        .println(s.getMessage());
            }

            stmt.close();
        }catch (Exception e){
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            response.getWriter()
                    .println(e.getMessage());
        }
    }

    @Override
    public void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}