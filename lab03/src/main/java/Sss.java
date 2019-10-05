import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Sss", urlPatterns = {"/GoSss"})
public  class Sss extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Sss:service: " + req.getMethod());
        res.getWriter().println("Sss:service");

        //to html page
        if(req.getParameter("param").contains("toHtml")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/page2.html");
            dispatcher.forward(req, res);
        }
        else  if (req.getParameter("param").contains("forwardTwice")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GoGgg");
            dispatcher.forward(req, res);
        }

        res.getWriter().println("Sss:service. " + req.getMethod() + " passed value: " + req.getParameter("param"));

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GoGgg");
        dispatcher.forward(req, res);

        String method = req.getMethod();
        if ("GET".equals(method)) {
            this.doGet(req, res);
            this.doPost(req, res);
        } else if ("POST".equals(method)) {
            this.doPost(req, res);
        }

    }

    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doGet from Ssss");
        response.getWriter().println("doGet from Sss");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GoGgg");
        dispatcher.forward(request, response);
    }

    protected  void  doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().println("doPost from Sss");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GoGgg");
        dispatcher.forward(request, response);
    }
}
