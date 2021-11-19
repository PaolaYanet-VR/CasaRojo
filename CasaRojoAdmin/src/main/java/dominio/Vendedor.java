package dominio;

public class Vendedor {
    private int idVendedor;
    private String usuario;
    private String password;

    public Vendedor() {
    }

    public Vendedor(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Vendedor(int idVendedor, String usuario, String password) {
        this.idVendedor = idVendedor;
        this.usuario = usuario;
        this.password = password;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "idVendedor=" + idVendedor + ", usuario=" + usuario + ", password=" + password + '}';
    }

}