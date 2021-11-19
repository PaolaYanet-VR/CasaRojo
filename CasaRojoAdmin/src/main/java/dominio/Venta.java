package dominio;


public class Venta {
    private int idVenta;
    private int idProducto;
    private int Cantidad;
    private double Costo_total;

    public Venta() {
    }
    
    //eliminar
    public Venta(int idVenta) {
        this.idVenta = idVenta;
    }

    //Agregar
    public Venta(int idProducto, int Cantidad, double Costo_total) {
        this.idProducto = idProducto;
        this.Cantidad = Cantidad;
        this.Costo_total = Costo_total;
    }
    
    //Modificar
    public Venta(int idVenta, int idProducto, int Cantidad, double Costo_total) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.Cantidad = Cantidad;
        this.Costo_total = Costo_total;
    }
    
    
    // Getters and Setters
    public int getIdVenta() {
        return idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public double getCosto_total() {
        return Costo_total;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setCosto_total(double Costo_total) {
        this.Costo_total = Costo_total;
    }
    
    
     @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", idProducto=" + idProducto + ", Cantidad=" + Cantidad + ", Costo_total=" + Costo_total +  '}';
    }
}


