package dominio;

public class Ganancia {
      private int idGanancia;
      private int Mes;
      private int Year;
      private double Invertido;
      private double Ganado;

    public Ganancia() {
    }

    // Agregar
    public Ganancia(int Mes, int Year, double Invertido, double Ganado) {
        this.Mes = Mes;
        this.Year = Year;
        this.Invertido = Invertido;
        this.Ganado = Ganado;
    }

    //modificar
    public Ganancia(int idGanancia, int Mes, int Year, double Invertido, double Ganado) {
        this.idGanancia = idGanancia;
        this.Mes = Mes;
        this.Year = Year;
        this.Invertido = Invertido;
        this.Ganado = Ganado;
    }

    public int getIdGanancia() {
        return idGanancia;
    }

    public void setIdGanancia(int idGanancia) {
        this.idGanancia = idGanancia;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public double getInvertido() {
        return Invertido;
    }

    public void setInvertido(double Invertido) {
        this.Invertido = Invertido;
    }

    public double getGanado() {
        return Ganado;
    }

    public void setGanado(double Ganado) {
        this.Ganado = Ganado;
    }

    @Override
    public String toString() {
        return "Ganancia{" + "idGanancia=" + idGanancia + ", Mes=" + Mes + ", Year=" + Year + ", Invertido=" + Invertido + ", Ganado=" + Ganado + '}';
    }
      
   
}
