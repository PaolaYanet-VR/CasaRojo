package web;

import datos.CompraDaoJDBC;
import dominio.Compra;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControladorCompra")
public class ServletControladorCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        this.accionDefault(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
      
         this.insertarCompra(request, response);  
        
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Compra> compras = new CompraDaoJDBC().listar();
        System.out.println("compras = " + compras);
        request.getRequestDispatcher("menuInicio.jsp").forward(request, response);
        response.sendRedirect("menuInicio.jsp");
    }
    
     private void insertarCompra(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean bandera = false;
        
        
        double total = 0;
        int idProducto = 0;
        String idproducto = request.getParameter("producto");
        
        
        int Cantidad = 0;
        String cantidad = request.getParameter("cantidad");
        
        
        double costo = 0;
        String costoString = request.getParameter("costo");
        if (costoString != null && !"".equals(costoString) && cantidad!= null && !"".equals(cantidad)&& idproducto!= null && !"".equals(idproducto)) {
            try{
            costo = Double.parseDouble(costoString);
            Cantidad = Integer.parseInt(cantidad);
            idProducto = Integer.parseInt(idproducto);
            total = costo * Cantidad;
            bandera = true;
            }
            catch(Exception e){
             response.sendRedirect("compras.jsp");
            }
        }

        
        if(bandera){
            //Creamos el objeto de compra (modelo)
            Compra compra = new Compra(idProducto, Cantidad, total);

                //Insertamos el nuevo objeto en la base de datos
                new CompraDaoJDBC().insertar(compra);

                //Redirigimos hacia accion RetornarPaginaCompra
                this.accionDefault(request, response);
        }else{
            response.sendRedirect("compras.jsp");
        }
        
        
    }

}
