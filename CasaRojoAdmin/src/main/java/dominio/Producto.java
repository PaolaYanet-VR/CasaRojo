package dominio;

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private int cantidadProducto;
    private double precioCompra;
    private double precioVenta;

    public Producto() {
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(int idProducto, String nombreProducto, int cantidadProducto, double precioCompra, double precioVenta) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{idProducto=").append(idProducto);
        sb.append(", nombreProducto=").append(nombreProducto);
        sb.append(", cantidadProducto=").append(cantidadProducto);
        sb.append(", precioCompra=").append(precioCompra);
        sb.append(", precioVenta=").append(precioVenta);
        sb.append('}');
        return sb.toString();
    }
    
    
}
