package Dominio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ArchivoGrabacion {

    private Formatter out;

    public ArchivoGrabacion(String nombreArchivo) {

        try {
            out = new Formatter(nombreArchivo);
        } catch (java.io.FileNotFoundException e) {
            System.out.println("No se pudo crear el archivo");
            System.exit(1);
        } catch (SecurityException e) {
            System.out.println("No tiene permisos suficientes para crear archivo");
            System.exit(1);
        }

    }

    public ArchivoGrabacion(String unNombre, boolean ext) {
        // si el parametro *viene en true, indica que se extiende
        // si es false, se sobreescribe
        try {
            FileWriter f = new FileWriter(unNombre, ext);
            out = new Formatter(f);
        } catch (IOException e) {
            System.out.println("no se puede crear/extender");
            System.exit(1);
        }
    }

    public void grabarLinea(String linea) {
        out.format("%s%n", linea);
    }

    public void cerrar() {
        out.close();
    }
}
