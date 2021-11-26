package web;

import datos.VendedorDaoJDBC;
import dominio.Vendedor;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControladorInicio")
public class ServletControladorInicio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        boolean flag = this.verificar(request, response);
        if(flag)
            this.accionDefault(request, response);
        else
           response.sendRedirect("index.jsp"); 
    }
    
    private boolean verificar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        boolean flag = false;
        List<Vendedor> vendedores = new VendedorDaoJDBC().listar();
        for(Vendedor vendedor: vendedores){
            if(vendedor.getUsuario().equals(usuario)&&vendedor.getPassword().equals(password)){
                flag = true;
                break;
            }
        }
        
        return flag;
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.getRequestDispatcher("menuInicio.jsp").forward(request, response);
        response.sendRedirect("menuInicio.jsp");
    }

}
