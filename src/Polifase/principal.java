package Polifase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Mauri
 */

public class principal {
    
    public static void main(String args[]) throws IOException, FileNotFoundException, ParseException {
        OrdenacionPolifase polifase = new OrdenacionPolifase();
        Scanner imput= new Scanner(System.in);
        System.out.println("Ordenar por campo: \n1.-Int \n2.-Texto \n3.-Boolean \n4.-Fecha \nOpcion: ");
        int entrada =imput.nextInt();
        polifase.sort((entrada-1), "archivo");
    }
    
}
