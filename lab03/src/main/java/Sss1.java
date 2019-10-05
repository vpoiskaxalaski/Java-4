import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public  class Sss1 extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //System.out.println("Sss1:service: " + req.getMethod());

        //to html page
        if(req.getParameter("param").contains("toHtml")){
            res.sendRedirect(req.getContextPath() + "/page2.html");
        }
        else  if (req.getParameter("param").contains("redirectTwice")){
            req.getSession().setAttribute("param", "parameter");
            res.sendRedirect(req.getContextPath() + "/GoGgg1?param=redirectTwice");
        }
        else if (req.getParameter("param").contains("param")){
            req.getSession().setAttribute("param", "parameter");
            res.sendRedirect(req.getContextPath() + "/GoGgg1?param=parameter");
        }
        else {
            String method = req.getMethod();
            if ("GET".equals(method)) {
                this.doGet(req, res);
                this.doPost(req, res);
            } else if ("POST".equals(method)) {
                this.doPost(req, res);
            }
        }

    }

    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doGet from Sss1");

        response.sendRedirect(request.getContextPath() +"/GoGgg1?param=" + request.getParameter("param") );
    }

    protected  void  doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        System.out.println("doPost from Ss1");

        response.sendRedirect(request.getContextPath() + "/GoGgg1?param=" + request.getParameter("param"));
        response.getWriter().println("We can not redirect to post method of Ggg :(");
    }
}
