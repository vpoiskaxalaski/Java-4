import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Ggg1 extends HttpServlet {

    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    System.out.println("doGet from Ggg1");

    if (request.getParameter("param").contains("redirectTwice")){
        response.sendRedirect(request.getContextPath() + "/page2.html");
    }

    response.getWriter().println("doGet from Ggg1 + " + request.getParameter("param"));

}

    protected  void  doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.getWriter().println("doPost from Ggg1");

        if(request.getParameter("param") != null ){
            response.getWriter().println("We have passed parameter: " + request.getParameter("param") );
        }
    }
}
