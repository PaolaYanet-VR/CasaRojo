package dominio;


public class Compra {
    private int idCompra;
    private int idProducto;
    private int cantidad;
    private double precioTotal;

    public Compra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Compra(int idCompra, int idProducto, int cantidad, double precioTotal) {
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }
    

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
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Compra{idCompra=").append(idCompra);
        sb.append(", idProducto=").append(idProducto);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", precioTotal=").append(precioTotal);
        sb.append('}');
        return sb.toString();
    }
    
    
}
