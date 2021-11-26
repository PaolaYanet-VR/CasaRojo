package dominio;


public class Compra {
    private int idCompra;
    private int idProducto;
    private int Cantidad;
    private double Precio_Total;

    //eliminar
    public Compra(int idCompra) {
        this.idCompra = idCompra;
    }

    //Agregar
    public Compra(int idProducto, int cantidad, double precioTotal) {
        this.idProducto = idProducto;
        this.Cantidad = cantidad;
        this.Precio_Total = precioTotal;
    }

    public Compra(int idCompra, int idProducto, int Cantidad, double Precio_Total) {
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.Cantidad = Cantidad;
        this.Precio_Total = Precio_Total;
    }
    
    // Getters and Setters
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio_Total() {
        return Precio_Total;
    }

    public void setPrecio_Total(double Precio_Total) {
        this.Precio_Total = Precio_Total;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", idProducto=" + idProducto + ", Cantidad=" + Cantidad + ", Precio_Total=" + Precio_Total + '}';
    }
    
}
