package datos;
import dominio.Ganancia;
import java.sql.*;
import java.util.*;

public class GananciaDaoJDBC {
     private static final String SQL_SELECT = "SELECT idganancia, mes, year, invertido, ganado "
            + " FROM ganancia";
    
     private static final String SQL_INSERT = "INSERT INTO ganancia(mes, year, invertido, ganado) "
            + " VALUES(?, ?, ?, ?)";

     private static final String SQL_UPDATE = "UPDATE ganancia "
            + " SET mes=?, year=?, invertido=?, ganado=? WHERE idganancia=?";
     
     public List<Ganancia> listarGanancias() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ganancia ganancia = null;
        List<Ganancia> ganancias = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idGanancia = rs.getInt("idganancia");
                int Mes = rs.getInt("mes");
                int Year = rs.getInt("year");
                double Invertido = rs.getDouble("invertido");
                double Ganancias = rs.getDouble("ganado");

                ganancia = new Ganancia(idGanancia, Mes, Year, Invertido, Ganancias);
                ganancias.add(ganancia);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return ganancias;
    }
     
     public int insertarGanancia(Ganancia ganancia) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, ganancia.getMes());
            stmt.setInt(2, ganancia.getYear());
            stmt.setDouble(3, ganancia.getInvertido());
            stmt.setDouble(4, ganancia.getGanado());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
     public int actualizarGanancia(Ganancia ganancia) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, ganancia.getMes());
            stmt.setInt(2, ganancia.getYear());
            stmt.setDouble(3, ganancia.getInvertido());
            stmt.setDouble(4, ganancia.getGanado());
            stmt.setInt(5, ganancia.getIdGanancia());

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
