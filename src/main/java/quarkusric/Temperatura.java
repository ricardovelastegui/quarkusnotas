package quarkusric;

import java.util.Objects;

public class Temperatura {

    private String ciudad; 
    private int minima;
    private int maxima;

    //genera un constructor vacio
    public Temperatura() {
    }
    //genera un constructor con todos los atributos
    public Temperatura(String ciudad, int minima, int maxima) {
        this.ciudad = ciudad;
        this.minima = minima;
        this.maxima = maxima;
    }
    //genera los getters y setters
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public int getMinima() {
        return minima;
    }
    public void setMinima(int minima) {
        this.minima = minima;
    }
    //getter y setter de maxima
    public int getMaxima() {
        return maxima;
    }
    public void setMaxima(int maxima) {
        this.maxima = maxima;
    }

    //genera el hashcode y el equals
    @Override
    public int hashCode() {

        return Objects.hash(ciudad, maxima, minima);
    }
    
    //genera el equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ) return false;
        if (getClass() != o.getClass()) return false;
        Temperatura other = (Temperatura) o;
        return Objects.equals(ciudad, other.ciudad) && maxima == other.maxima && minima == other.minima;
    }

    @Override
    public String toString() {
        return "Temperatura" +
                "[ciudad=" + ciudad +
                ", minima=" + minima +
                ", maxima=" + maxima +
                "]";
    }   

    
}
