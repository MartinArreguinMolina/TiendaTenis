package PaqueteNumeroUno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.Collections;

public class Tienda {

    public static void main(String... args) throws IOException {
        Tienda ob1 = new Tienda();
        ArrayList<Tenis> listaTenis = new ArrayList();
        
        listaTenis = ob1.listaTenis();
        
        ob1.menu(listaTenis);

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

        while (!pila.isEmpty()) {
            cadena = pila.pop();

            subCadenas = cadena.split(" - ");

            tenis = subCadenas[0];
            precio = Double.parseDouble(subCadenas[1]);

            listaTenis.add(new Tenis(tenis, precio));
        }

        return listaTenis;
    }

    private void menu(ArrayList<Tenis> lista) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        int n;
        boolean x = false;

        do {
            do {
                System.out.println("1.Ordenar por orden alfabetico"
                        + "\n2.Ordenar por precio del mayor al menor"
                        + "\n3.Ordenar por precio del menor al mayor"
                        + "4.Mostrar");
                System.err.print("R=");
                try{
                    
                }catch(NumberFormatException e){
                    System.out.println("DEBES DE DIGITAR UN NUMERO INTENTA DE NUEVO");
                }
                n = Integer.parseInt(entrada = bufer.readLine());
            } while (n < 1 || n > 5);
            
            switch(n){
                case 1:
                    lista = ordenarPorOrdenAlfabetico(lista);
                    break;
                case 2:
                   lista = ordenarPorPrecioMayor(lista);
                    break;
                case 3:
                    lista = ordenarPorPrecioMenorAux(lista);
                    break;
                case 4:
                    imprimirLista(lista);
                    break;
            }

        } while (x == false);

    }
    
    private ArrayList<Tenis> ordenarPorOrdenAlfabetico(ArrayList<Tenis> lista){
        Collections.sort(lista , (Tenis uno , Tenis dos) -> (uno.getTenis()).compareTo(dos.getTenis()));
        return lista;
    }
    
    private ArrayList<Tenis> ordenarPorPrecioMayor(ArrayList<Tenis> lista){
        Collections.sort(lista , (Tenis uno , Tenis dos) -> new Double (uno.getPrecio()).compareTo(dos.getPrecio()));
        return lista;
    }
    
    private ArrayList<Tenis> ordenarPorPrecioMenor(ArrayList<Tenis> lista){
        Collections.sort(lista, (Tenis uno , Tenis dos) -> new Double (uno.getPrecio()).compareTo(dos.getPrecio()));
        return lista;
    }
    
    private ArrayList<Tenis> ordenarPorPrecioMenorAux(ArrayList<Tenis> lista){
        ArrayList<Tenis> listaAux = new ArrayList();
        
        for(int i = lista.size() - 1; i >= 0; i--){
           listaAux.add(lista.get(i));
        }
        return listaAux;
    }
    
    private void imprimirLista(ArrayList<Tenis>  lista){
        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i).toString());
        }
    }
}
