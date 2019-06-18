import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionuID = 1L;

    public HelloServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>나의 첫 서버</title></head>" );
        out.println( "<body>" );
        out.println( "<h2>오늘은 금요일</h2>" );
        out.println( "<p>행복한 주말 되세요.</p>" );
        out.println( "</body></html>" );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response );
    }
}
