package web;

import datos.CompraDaoJDBC;
import datos.ProductoDaoJDBC;
import dominio.Compra;
import dominio.Producto;
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
        
        request.getRequestDispatcher("compras.jsp").forward(request, response);
        response.sendRedirect("compras.jsp");
    }
    
    private void accionInsertado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Compra> compras = new CompraDaoJDBC().listar();
        System.out.println("compras = " + compras);
        request.getRequestDispatcher("menuInicio.jsp").forward(request, response);
        response.sendRedirect("menuInicio.jsp");
    }
    
     private void insertarCompra(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String producto = request.getParameter("producto");
        int idproducto = 0;
        
        List<Producto> productos = new ProductoDaoJDBC().listar();
        for(Producto pr: productos) {
            if (pr.getNombreProducto().equals(producto))
                idproducto = pr.getIdProducto();
        }
        
        int Cantidad = 0;
        String cantidad = request.getParameter("cantidad");
         if (cantidad != null && !"".equals(cantidad)) {
            Cantidad = Integer.parseInt(cantidad);
        }
        
        double costo = 0;
        String costoString = request.getParameter("costo");
        if (costoString != null && !"".equals(costoString)) {
            costo = Integer.parseInt(costoString);
        }
        
        double costo_total = Cantidad * costo;
        
        Producto pr = new Producto(idproducto, producto, Cantidad, costo, costo);
        if (idproducto == 0){
            
            int registrosProducto = new ProductoDaoJDBC().insertar(pr);
            System.out.println("Producto = " + registrosProducto);
        }
        
        //Creamos el objeto de compra (modelo)
        Compra compra = new Compra(idproducto, Cantidad, costo_total);
        
        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new CompraDaoJDBC().insertar(compra);
        System.out.println("registrosModificados = " + registrosModificados);
        
        //Redirigimos hacia accion RetornarPaginaCompra
        this.accionInsertado(request, response);
        
    }

}
