package web;

import datos.GananciaDaoJDBC;
import dominio.Ganancia;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControladorGanancia")
public class ServletControladorGanancia extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        this.accionDefault(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //this.accionDefault(request, response);
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ganancia> ganancias = new GananciaDaoJDBC().listarGanancias();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("ganancias", ganancias);
        request.getRequestDispatcher("ganancias.jsp").forward(request, response);
        response.sendRedirect("ganancias.jsp");
    }

}
