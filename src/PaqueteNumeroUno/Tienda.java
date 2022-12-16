package PaqueteNumeroUno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Tienda {

    public static void main(String... args) throws IOException {
        Tienda ob1 = new Tienda();
        ArrayList<Tenis> listaTenis = new ArrayList();
        
        listaTenis = ob1.listaTenis();
        
        
    }

    private ArrayList<Tenis> listaTenis() throws IOException {
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
    
    private void menu(ArrayList<Tenis> lista) throws IOException{
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        int n;
        
        do{
            System.out.println("1.Ordenar por orden alfabetico"
                    + "\n2.Ordenar por precio del mayor al menor"
                    + "\n3.Ordenar por precio del menor al mayor"
                    + "4.Salir");
            System.err.print("R=");
            n = Integer.parseInt(entrada = bufer.readLine());
        }while(n < 1 || n > 5);
    }
}
