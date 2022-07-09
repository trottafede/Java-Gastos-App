package Dominio;

import java.io.Serializable;
import java.util.Date;

public class Producto extends Gasto implements Serializable {

    private String nombre;
    private String vendor;

    public Producto(String unNombre, String unVendor, int unPrecio, Date unaFecha, Categoria unaCategoria) {
        super(unPrecio, unaFecha, unaCategoria);
        this.nombre = unNombre;
        this.vendor = unVendor;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String unVendor) {
        this.vendor = unVendor;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.getNombre() + " " + this.getVendor();
    }
}
