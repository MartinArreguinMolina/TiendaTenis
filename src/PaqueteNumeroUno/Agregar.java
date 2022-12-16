package PaqueteNumeroUno;

import java.util.Stack;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agregar {

    public Stack agregar() throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> pila = new Stack();
        String entrada;
        boolean x;

        while ((entrada = bufer.readLine()).isEmpty() == false) {
            x = verificarCadena(entrada);

            if (x == false) {
                System.out.println("CADENA INVALIDA INTENTA DE NUEVO");
            } else {
                pila.add(entrada);
            }
        }

        return pila;
    }

    private boolean verificarCadena(String cadena) {
        String[] subCadenas;
        double precio;
        boolean x1 = false;
        boolean x2 = false;

        subCadenas = cadena.split(" - ");

        Pattern pat = Pattern.compile("[a-zA-Z]{1,20}");
        Matcher mat = pat.matcher(subCadenas[0]);
        if (mat.matches()) {
            x1 = false;
        } else {
            x1 = true;
        }

        try {
            precio = Double.parseDouble(subCadenas[1]);
            x2 = false;
        } catch (NumberFormatException e) {
            x2 = true;
        } catch (ArrayIndexOutOfBoundsException e) {
            x2 = true;
        }

        if (x1 == false && x2 == false) {
            return true;
        } else {
            return false;
        }
    }
}
