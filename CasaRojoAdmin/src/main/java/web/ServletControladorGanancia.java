package web;

import datos.GananciaDaoJDBC;
import dominio.Ganancia;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControladorGanancia")
public class ServletControladorGanancia extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accionListar = request.getParameter("accionListar");
        if (accionListar != null) {
            switch (accionListar) {
                case "accionListar":
                    this.filtrarCompra(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //this.accionDefault(request, response);
    }
    
    private void filtrarCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ganancia> ganancias = new GananciaDaoJDBC().listarGanancias();
        List<Ganancia> filtradas = new ArrayList<>();
        String year = request.getParameter("year");
        String mes = request.getParameter("mes");
        
        for (Ganancia ganancia : ganancias){
            if(year.equals(String.valueOf(ganancia.getYear()))&&mes.equals(String.valueOf(ganancia.getMes()))){
                filtradas.add(ganancia);
            }
        }
        HttpSession sesion = request.getSession();
        sesion.setAttribute("ganancias", filtradas);
        request.getRequestDispatcher("ganancias.jsp").forward(request, response);
        response.sendRedirect("ganancias.jsp");
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ganancia> ganancias = new GananciaDaoJDBC().listarGanancias();
        List<Ganancia> filtradas = new ArrayList<>();
        String year = "2021";
        String mes = "1";
        
        for (Ganancia ganancia : ganancias){
            if(year.equals(String.valueOf(ganancia.getYear()))&&mes.equals(String.valueOf(ganancia.getMes()))){
                filtradas.add(ganancia);
            }
        }
        HttpSession sesion = request.getSession();
        sesion.setAttribute("ganancias", filtradas);
        request.getRequestDispatcher("ganancias.jsp").forward(request, response);
        response.sendRedirect("ganancias.jsp");
    }

}
