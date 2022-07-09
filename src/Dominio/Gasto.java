package Dominio;

import Utilidades.ClaseParaSerializar;
import java.util.Date;

public class Gasto extends ClaseParaSerializar implements Comparable<Gasto> {

    private int precio;
    private Date fecha;
    private Categoria categoria;

    public Gasto(int unPrecio, Date unaFecha, Categoria unaCategoria) {
        this.precio = unPrecio;
        this.fecha = unaFecha;
        this.categoria = unaCategoria;
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int unPrecio) {
        this.precio = unPrecio;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date unaFecha) {
        this.fecha = unaFecha;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria unaCategoria) {
        this.categoria = unaCategoria;
    }

    @Override
    public String toString() {
        return this.getCategoria() + " $" + this.getPrecio() + " " + this.getFecha();
    }

    @Override
    public int compareTo(Gasto o) {
        return this.getPrecio() - o.getPrecio();
    }

}
