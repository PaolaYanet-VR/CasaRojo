package web;

import datos.CompraDaoJDBC;
import datos.GananciaDaoJDBC;
import datos.ProductoDaoJDBC;
import dominio.Compra;
import dominio.Ganancia;
import dominio.Producto;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        if (idproducto < 1){
            
            int registrosProducto = new ProductoDaoJDBC().insertar(pr);
            System.out.println("Producto = " + registrosProducto);
            
        } else {
            for(Producto pr2: productos) {
            if (pr2.getNombreProducto().equals(producto))
                new ProductoDaoJDBC().actualizar(new Producto(pr2.getIdProducto(),pr2.getNombreProducto(),(pr2.getCantidadProducto() + Cantidad),costo,pr2.getPrecioVenta()));
            }
        }
        
        Compra compra = new Compra(idproducto, Cantidad, costo_total);
        
        //Insertamos la compra
        int registrosModificados = new CompraDaoJDBC().insertar(compra);
        System.out.println("registrosModificados = " + registrosModificados);
        
        // ACTUALIZAR GANANCIA
        List<Ganancia> ganancias = new GananciaDaoJDBC().listarGanancias();
        
        Date date = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("MM");
        
        String y = formatter1.format(date);
        String m = formatter2.format(date);
        
        int year = Integer.parseInt(y);
        int mes = Integer.parseInt(m);
        
        Boolean flag = false;
        for (Ganancia ganancia : ganancias){
            if(year==ganancia.getYear()&&mes==ganancia.getMes()){
                new GananciaDaoJDBC().actualizarGanancia(new Ganancia(ganancia.getIdGanancia(), ganancia.getMes(), ganancia.getYear(), ganancia.getInvertido() + costo_total, ganancia.getGanado()));
                flag = true;
                break;
            }
        }
        
        if (!flag) 
            new GananciaDaoJDBC().insertarGanancia(new Ganancia(mes, year, costo_total, 0));
        
        //Redirigimos hacia accion RetornarPaginaCompra
        this.accionInsertado(request, response);
        
    }

}
