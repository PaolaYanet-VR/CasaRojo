package datos;
import dominio.Venta;
import java.sql.*;
import java.util.*;

public class VentaDaoJDBC {
     private static final String SQL_SELECT = "SELECT idventa, idproducto, cantidad, costo_total "
            + " FROM venta";

    private static final String SQL_SELECT_BY_ID = "SELECT idventa, idproducto, cantidad, costo_total"
            + " FROM venta WHERE idventa = ?";

    private static final String SQL_INSERT = "INSERT INTO venta(idproducto, cantidad, costo_total) "
            + " VALUES(?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE venta "
            + " SET idproducto=?, cantidad=?, costo_total=? WHERE idventa=?";

    private static final String SQL_DELETE = "DELETE FROM venta WHERE idventa = ?";
    
    
    
     public List<Venta> listaventas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Venta venta = null;
        List<Venta> ventas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idVenta = rs.getInt("idventa");
                int idProducto = rs.getInt("idproducto");
                int Cantidad = rs.getInt("cantidad");
                double Costo_total = rs.getDouble("costo_total");

                venta = new Venta(idVenta, idProducto, Cantidad, Costo_total);
                ventas.add(venta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return ventas;
    }
     
     public Venta encontrarVenta(Venta venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, venta.getIdVenta());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

              int idproducto = rs.getInt("idproducto");
              int cantidad = rs.getInt("cantidad");
              double costo_total = rs.getDouble("costo_total");

            venta.setIdProducto(idproducto);
            venta.setCantidad(cantidad);
            venta.setCosto_total(costo_total);
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return venta;
    }
     
      public int insertarVenta(Venta venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, venta.getIdProducto());
            stmt.setInt(2, venta.getCantidad());
            stmt.setDouble(3, venta.getCosto_total());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
      
       public int actualizarVenta(Venta venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, venta.getIdProducto());
            stmt.setInt(2, venta.getCantidad());
            stmt.setDouble(3, venta.getCosto_total());
            stmt.setInt(4, venta.getIdVenta());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
     
       
      public int eliminarVenta(Venta venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, venta.getIdVenta());

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
