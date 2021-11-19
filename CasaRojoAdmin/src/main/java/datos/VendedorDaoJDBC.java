package datos;

import dominio.Vendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendedorDaoJDBC {
    private static final String SQL_SELECT = "SELECT idvendedor, usuario, password "
            + " FROM vendedor";

    private static final String SQL_SELECT_BY_USER = "SELECT idvendedor, usuario, password "
            + " FROM vendedor WHERE usuario = ? AND password = ?";
    
    public List<Vendedor> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vendedor vendedor = null;
        List<Vendedor> vendedores = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idVendedor = rs.getInt("idvendedor");
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");

                vendedor = new Vendedor(idVendedor, usuario, password);
                vendedores.add(vendedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return vendedores;
    }
    
    public Vendedor encontrar(Vendedor vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_USER);
            stmt.setString(1, vendedor.getUsuario());
            stmt.setString(2, vendedor.getPassword());
            
            rs = stmt.executeQuery();
            
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            int idVendedor = rs.getInt("idvendedor");
            String usuario = rs.getString("usuario");
            String password = rs.getString("password");
            
            vendedor.setIdVendedor(idVendedor);
            vendedor.setUsuario(usuario);
            vendedor.setPassword(password);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return vendedor;
    }
    
}