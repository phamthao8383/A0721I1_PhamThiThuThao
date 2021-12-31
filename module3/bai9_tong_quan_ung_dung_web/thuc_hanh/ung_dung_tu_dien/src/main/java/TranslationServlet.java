import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslationServlet", urlPatterns = "/translate")
public class TranslationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin Chao");
        dictionary.put("how", "The nao");
        dictionary.put("book", "vo");
        String search = request.getParameter("txtSearch");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        String result = dictionary.get(search);
        if (result != null) {
            writer.println("Word: " + search);
            writer.println("Result: " + result);
        } else {
            writer.println("Not found");
        }

        writer.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
