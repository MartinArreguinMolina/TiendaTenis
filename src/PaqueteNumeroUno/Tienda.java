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

    private ArrayList<Tenis> listaTenis() throws IOException {
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
        ArrayList<Tenis> listaAux = new ArrayList();

        listaAux = lista;
        String entrada;
        int n;
        boolean x = false;

        do {
            do {

                System.out.println("::::::::::ELIGE UNA OPCION::::::::::"
                        + "\n1.Ordenar por orden alfabetico"
                        + "\n2.Ordenar por precio del menor al mayor"
                        + "\n3.Ordenar por precio del mayor al menor"
                        + "\n4.Mostrar"
                        + "\n5.Agregar"
                        + "\nSalir");
                System.err.print("R= ");
                try {

                } catch (NumberFormatException e) {
                    System.out.println("DEBES DE DIGITAR UN NUMERO INTENTA DE NUEVO");
                }
                n = Integer.parseInt(entrada = bufer.readLine());
            } while (n < 1 || n > 7);

            switch (n) {
                case 1:
                    lista = ordenarPorOrdenAlfabetico(lista);
                    break;
                case 2:
                    lista = ordenarPorPrecioMenor(lista);
                    break;
                case 3:
                    lista = ordenarPorPrecioMayorAux(ordenarPorPrecioMenor(lista));
                    break;
                case 4:
                    imprimirLista(lista);
                    break;
                case 5:
                    lista = agregarTenis(listaAux);
                    break;
                case 6:
                    listaRecortada(lista);
                    break;
                case 7:
                    x = true;
                    break;
            }

        } while (x == false);

    }

    private ArrayList<Tenis> ordenarPorOrdenAlfabetico(ArrayList<Tenis> lista) {
        Collections.sort(lista, (Tenis uno, Tenis dos) -> (uno.getTenis()).compareTo(dos.getTenis()));
        return lista;
    }

    private ArrayList<Tenis> ordenarPorPrecioMenor(ArrayList<Tenis> lista) {
        Collections.sort(lista, (Tenis uno, Tenis dos) -> new Double(uno.getPrecio()).compareTo(dos.getPrecio()));
        return lista;
    }

    private ArrayList<Tenis> ordenarPorPrecioMayorAux(ArrayList<Tenis> lista) {
        ArrayList<Tenis> listaAux = new ArrayList();

        for (int i = lista.size() - 1; i >= 0; i--) {
            listaAux.add(lista.get(i));
        }
        return listaAux;
    }

    private void imprimirLista(ArrayList<Tenis> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }

    private ArrayList<Tenis> agregarTenis(ArrayList<Tenis> listaOriginal) throws IOException {
        Tienda ob2 = new Tienda();
        ArrayList<Tenis> lista = new ArrayList();

        lista = ob2.listaTenis();

        for (int i = 0; i < lista.size(); i++) {
            listaOriginal.add(lista.get(i));
        }

        return listaOriginal;
    }

    private ArrayList<Tenis> listaRecortada(ArrayList<Tenis> lista) {
        Tenis[] a = new Tenis[lista.size()];
        int[] b = new int[lista.size()];
        int contador = 0;

        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.size(); j++) {
                if(lista.get(i).getPrecio() == lista.get(j).getPrecio() && lista.get(i).getTenis().equals(lista.get(j).getTenis())){
                    contador++;
                }
            }
            b[i] = contador;
            contador = 0;
        }

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getPrecio() + " " + b[i]);
        }
        return lista;
    }
}
