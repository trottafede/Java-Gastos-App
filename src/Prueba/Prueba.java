package Prueba;

import Dominio.Sistema;
import Dominio.Usuario;
import Interfaz.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Prueba {

    public static void main(String[] args) {
        //Creo sistema y me agrego a mi usuario
        Sistema s = new Sistema();
        Usuario fede = new Usuario("trottafede", "fede123");
        fede.setAdmin(true);
        s.getListaDeUsuarios().add(fede);

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Sistema.ser"));
            s = (Sistema) (in.readObject());
            in.close();
            System.out.println("Serealizado correctamente");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al recuperar, se usa un sistema vacio");
            System.out.println(e);
        }

        VentanaInicioSesion vis = new VentanaInicioSesion(s);
        vis.setVisible(true);

    }

}
