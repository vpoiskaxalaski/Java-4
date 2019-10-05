import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Ggg extends HttpServlet {

    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doGet from Ggg");
        response.getWriter().println("goGet from Ggg");

        if (request.getParameter("param").contains("forwardTwice")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/page2.html");
            dispatcher.forward(request, response);
        }

        response.getWriter().println("doGet from Ggg + " + request.getParameter("param"));

    }

    protected  void  doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.getWriter().println("doPost from Ggg");

        if(request.getParameter("param") != null ){
            response.getWriter().println("We have passed parameter: " + request.getParameter("param") );
        }
    }
}
