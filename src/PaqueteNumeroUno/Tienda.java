package PaqueteNumeroUno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Tienda {

    public static void main(String... args) {

    }

    public ArrayList<Tenis> listaTenis() throws IOException {
        Agregar ob1 = new Agregar();
        
        Stack<String> pila = new Stack();
        ArrayList<Tenis> listaTenis = new ArrayList();
        
        pila = ob1.agregar();
        
        return listaTenis;
    }
}
