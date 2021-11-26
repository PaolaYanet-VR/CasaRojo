package web;

import datos.ProductoDaoJDBC;
import dominio.Producto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControladorInventario")
public class ServletControladorInventario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        this.accionDefault(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        this.accionDefault(request, response);
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Producto> productos = new ProductoDaoJDBC().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("productos", productos);
        request.getRequestDispatcher("inventario.jsp").forward(request, response);
        response.sendRedirect("inventario.jsp");
    }

}
