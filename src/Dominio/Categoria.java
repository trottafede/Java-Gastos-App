package Dominio;

import Utilidades.ClaseParaSerializar;

public class Categoria extends ClaseParaSerializar implements Comparable<Categoria> {

    private String categoria;

    public Categoria(String unaCategoria) {
        this.categoria = unaCategoria;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String unaCategoria) {
        this.categoria = unaCategoria;
    }

    @Override
    public String toString() {
        return this.getCategoria();
    }

    @Override
    public int compareTo(Categoria o) {
        return this.getCategoria().compareTo(o.getCategoria());
    }

}
