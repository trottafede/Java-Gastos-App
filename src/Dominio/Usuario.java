package Dominio;
//implements Comparable<Usuario>

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;
    private String password;
    private boolean admin;

    public Usuario(String unNombre, String unaPassword) {
        this.setNombre(unNombre);
        this.setPassword(unaPassword);
        this.setAdmin(false);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String unaPassword) {
        this.password = unaPassword;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

//    @Override
//    public int compareTo(Usuario user) {
//        return this.getNombre().compareTo(user.getNombre());
//    }
}
