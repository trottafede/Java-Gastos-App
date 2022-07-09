package Dominio;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

public class Sistema implements Serializable {

    private ArrayList<Usuario> listaDeUsuarios;
    private ArrayList<Categoria> listaDeCategorias;
    private ArrayList<Gasto> listaDeGastos;

    public Sistema() {
        this.listaDeUsuarios = new ArrayList<Usuario>();
        this.listaDeCategorias = new ArrayList<Categoria>();
        this.listaDeGastos = new ArrayList<Gasto>();
    }

    public ArrayList<Usuario> getListaDeUsuarios() {
        return this.listaDeUsuarios;
    }

    //getters
    public ArrayList<Categoria> getListaDeCategorias() {
        Collections.sort(this.listaDeCategorias);
        return this.listaDeCategorias;
    }

    public ArrayList<Gasto> getListaDeGastos() {
        Collections.sort(this.listaDeGastos);
        return this.listaDeGastos;
    }

    //Usuario
    public boolean loguearUsuario(String username, String password) {
        boolean resultado = false;

        Iterator<Usuario> iter = this.getListaDeUsuarios().iterator();

        while (iter.hasNext() && !resultado) {
            Usuario user = iter.next();
            if (user.getNombre().equals(username) && user.getPassword().equals(password)) {
                resultado = true;
            }
        }

        return resultado;

    }

    public boolean agregarUsuario(Usuario unUser) {
        boolean resultado = false;
        boolean yaEstaRegistrado = false;
        //encuentro al usuario
        //si existe no lo creo y mando false
        //sino existe, lo creo y mando true

        Iterator<Usuario> iter = this.getListaDeUsuarios().iterator();

        //recorro lista de usuarios para ver si se encuentra ya registrado
        while (iter.hasNext() && !yaEstaRegistrado) {
            Usuario user = iter.next();

            if (user.getNombre().equals(unUser.getNombre())) {
                yaEstaRegistrado = true;
            }

        }

        // como no esta registrado lo agrego
        if (!yaEstaRegistrado) {
            this.getListaDeUsuarios().add(unUser);
            resultado = true;
        }

        return resultado;
    }

    //Serializer
    public void serializar() {
        try {
            FileOutputStream ff = new FileOutputStream("Sistema.ser");
            BufferedOutputStream bb = new BufferedOutputStream(ff);
            ObjectOutputStream out = new ObjectOutputStream(bb);
            out.writeObject(this);
            out.close();
        } catch (IOException e) {
            System.out.println("IOException lanzada");
        }
    }

    public Sistema deserealizar() throws IOException, ClassNotFoundException, FileNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Sistema.ser"));
        Sistema unSistemaRecuperado = (Sistema) (in.readObject());
        in.close();
        return unSistemaRecuperado;
    }

    //Interfaz Ventana Lista Gastos
    public ArrayList<String> getListaDeMeses() {
        ArrayList<String> meses = new ArrayList<>();
        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        meses.add("Abril");
        meses.add("Mayo");
        meses.add("Junio");
        meses.add("Julio");
        meses.add("Agosto");
        meses.add("Setiembre");
        meses.add("Octubre");
        meses.add("Noviembre");
        meses.add("Diciembre");
        return meses;
    }

    public int getGastoPorCategoria(Categoria c) {
        int resultado = 0;

        //Recorro todos mis gatos y los filtro por categoria
        Iterator<Gasto> iter = this.getListaDeGastos().iterator();

        //recorro lista de usuarios para ver si se encuentra ya registrado
        while (iter.hasNext()) {
            Gasto g = iter.next();
            if (g.getCategoria().getCategoria().equals(c.getCategoria())) {
                resultado += g.getPrecio();
            }

        }

        return resultado;

    }

    public int getGastoPorMes(String mes) {
        int resultado = 0;
        DateFormat formatter = new SimpleDateFormat("MMMM");

        //Recorro todos mis gatos y los filtro por categoria
        Iterator<Gasto> iter = this.getListaDeGastos().iterator();

        //recorro lista de usuarios para ver si se encuentra ya registrado
        while (iter.hasNext()) {
            Gasto g = iter.next();
            Date actualDate = g.getFecha();
            String fecha = formatter.format(actualDate);
            if (fecha.equals(mes)) {
                resultado += g.getPrecio();
            }

        }

        return resultado;
    }

    public int getGastosAnuales(int a) {
        int resultado = 0;
        DateFormat formatter = new SimpleDateFormat("YYYY");

        //Recorro todos mis gatos y los filtro por categoria
        Iterator<Gasto> iter = this.getListaDeGastos().iterator();

        //recorro lista de usuarios para ver si se encuentra ya registrado
        while (iter.hasNext()) {
            Gasto g = iter.next();
            Date actualDate = g.getFecha();
            String fecha = formatter.format(actualDate);
            if (fecha.equals(Integer.toString(a))) {
                resultado += g.getPrecio();
            }
        }
        return resultado;
    }
}
