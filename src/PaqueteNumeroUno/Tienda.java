package PaqueteNumeroUno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Tienda {

    public static void main(String... args) throws IOException {
        Tienda ob1 = new Tienda();
        ArrayList<Tenis> listaTenis = new ArrayList();
        
        listaTenis = ob1.listaTenis();
        
        
    }

    public ArrayList<Tenis> listaTenis() throws IOException {
        Agregar ob1 = new Agregar();
        
        Stack<String> pila = new Stack();
        ArrayList<Tenis> listaTenis = new ArrayList();
        
        String[] subCadenas;
        String cadena;
        String tenis;
        double precio;
        
        pila = ob1.agregar();
        
        while(!pila.isEmpty()){
            cadena = pila.pop();
            
            subCadenas = cadena.split(" ");
            
            tenis = subCadenas[0];
            precio = Double.parseDouble(subCadenas[1]);
            
            
            listaTenis.add(new Tenis(tenis , precio));
        }
        
        return listaTenis;
    }
}
