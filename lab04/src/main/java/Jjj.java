import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(urlPatterns = "/Jjj")
public class Jjj extends HttpServlet {

    private Calendar calendar = Calendar.getInstance();
    private int hour = calendar.get(Calendar.HOUR_OF_DAY);

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Jjj:init");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Jjj:destroy");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Jjj:doGet");
        if (hour > 0 && hour <= 5)
            resp.sendRedirect("night.jsp");
        else if (hour > 5 && hour < 12)
            resp.sendRedirect("morning.jsp");
        else if (hour >= 12 && hour <= 17)
            resp.sendRedirect("afternoon.jsp");
        else
            resp.sendRedirect("evening.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Jjj:doPost");
        if (hour > 0 && hour <= 5)
            resp.sendRedirect("night.jsp");
        else if (hour > 5 && hour < 12)
            resp.sendRedirect("morning.jsp");
        else if (hour >= 12 && hour <= 15)
            resp.sendRedirect("afternoon.jsp");
        else
            resp.sendRedirect("evening.jsp");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod());

        if(req.getMethod().contains("POST")) {
           this.doPost(req, resp);
        }else if(req.getMethod().contains("GET")){
            this.doGet(req, resp);
        }
    }
}
