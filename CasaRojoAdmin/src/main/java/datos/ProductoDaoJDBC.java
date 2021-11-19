package datos;

import dominio.Producto;
import java.sql.*;
import java.util.*;

public class ProductoDaoJDBC {
    private static final String SQL_SELECT = "SELECT idproducto, nombre, cantidad, precio_compra, precio_venta "
            + " FROM producto";
    private static final String SQL_SELECT_BY_ID = "SELECT idproducto, nombre, cantidad, precio_compra, precio_venta "
            + " FROM producto WHERE idproducto = ?";

    private static final String SQL_INSERT = "INSERT INTO producto(nombre, cantidad, precio_compra, precio_venta) "
            + " VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE producto "
            + " SET nombre=?, cantidad=?, precio_compra=?, precio_venta=? WHERE idproducto=?";

    private static final String SQL_DELETE = "DELETE FROM producto WHERE idproducto = ?";
    
    public List<Producto> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt("idproducto");
                String nombreProducto = rs.getString("nombre");
                int cantidadProducto = rs.getInt("cantidad");
                double precioCompra = rs.getDouble("precio_compra");
                double precioVenta = rs.getDouble("precio_venta");

                producto = new Producto(idProducto, nombreProducto, cantidadProducto, precioCompra, precioVenta);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return productos;
    }
    
    public Producto encontrar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, producto.getIdProducto());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            int idProducto = rs.getInt("idproducto");
            String nombreProducto = rs.getString("nombre");
            int cantidadProducto = rs.getInt("cantidad");
            double precioCompra = rs.getDouble("precio_compra");
            double precioVenta = rs.getDouble("precio_venta");
            
            producto.setIdProducto(idProducto);
            producto.setNombreProducto(nombreProducto);
            producto.setCantidadProducto(cantidadProducto);
            producto.setPrecioCompra(precioCompra);
            producto.setPrecioVenta(precioVenta);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return producto;
    }
    
    public int insertar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getNombreProducto());
            stmt.setInt(2, producto.getCantidadProducto());
            stmt.setDouble(3, producto.getPrecioCompra());
            stmt.setDouble(4, producto.getPrecioVenta());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int actualizar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getNombreProducto());
            stmt.setInt(2, producto.getCantidadProducto());
            stmt.setDouble(3, producto.getPrecioCompra());
            stmt.setDouble(4, producto.getPrecioVenta());
            stmt.setInt(5, producto.getIdProducto());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
     public int eliminar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getIdProducto());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
