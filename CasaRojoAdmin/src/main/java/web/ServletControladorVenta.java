package web;

import datos.ProductoDaoJDBC;
import datos.VentaDaoJDBC;
import dominio.Producto;
import dominio.Venta;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControladorVenta")
public class ServletControladorVenta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        this.accionDefault(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        this.insertarVenta(request, response);
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Venta> ventas = new VentaDaoJDBC().listaventas();
        System.out.println("ventas = " + ventas);
        
        // para el select producto
        HttpSession sesion = request.getSession();
        List<Producto> productos = new ProductoDaoJDBC().listar();
        sesion.setAttribute("productos", productos);
        
        request.getRequestDispatcher("ventas.jsp").forward(request, response);
        response.sendRedirect("ventas.jsp");
    }
    
    private void accionInsertado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Venta> ventas = new VentaDaoJDBC().listaventas();
        System.out.println("ventas = " + ventas);
        request.getRequestDispatcher("menuInicio.jsp").forward(request, response);
        response.sendRedirect("menuInicio.jsp");
    }
    
    private void insertarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //recuperamos los valores del formulario registroVenta
        
        String producto = request.getParameter("producto");
        int idproducto = 0;
        
        List<Producto> productos = new ProductoDaoJDBC().listar();
        for(Producto pr: productos) {
            if (pr.getNombreProducto().equals(producto))
                idproducto = pr.getIdProducto();
        }
        
        int cantidad = 0;
        String cantidadString = request.getParameter("cantidad");
        if (cantidadString != null && !"".equals(cantidadString)) {
            cantidad = Integer.parseInt(cantidadString);
        }
        
        double costo = 0;
        String costoString = request.getParameter("costo");
        if (costoString != null && !"".equals(costoString)) {
            costo = Double.parseDouble(costoString);
        }
        
        double costo_total = cantidad * costo;

        //Creamos el objeto de venta (modelo)
        Venta venta = new Venta(idproducto, cantidad, costo_total);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new VentaDaoJDBC().insertarVenta(venta);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionInsertado(request, response);
    }

}
