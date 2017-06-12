package Polifase;

import java.io.IOException;
import java.text.ParseException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author Mauri
 */
public class OrdenacionPolifase {
   public int sort(int campo, String rutaOriginal) throws IOException, FileNotFoundException, ParseException {
        
        String rutaA="F1.csv";
        String rutaB = "F2.csv";
        String rutaC="F3.csv";
        int pasada = 1;
        int rRutaB=1,rRutaA=1;
        while(rRutaA!=0 && rRutaB!=0){

           Ordenar.divide(rutaOriginal, rutaA, rutaB, campo);
           Ordenar.une(rutaOriginal, rutaA, rutaB, campo);
           
           rRutaB=(int) contar(rutaB);
           rRutaA=(int) contar(rutaA);
           
           pasada++;
        }
        Ordenar.eliminarAux(rutaA, rutaB);
        return pasada;
    }
    public static long contar(String ruta) throws IOException{
            long contador=0;
            FileReader fr = new FileReader(ruta);
            BufferedReader bf = new BufferedReader(fr);
            boolean sCad;
            while (sCad = bf.readLine()!=null)
            {
                contador++;
            }
            fr.close();
            bf.close();
            System.out.println(contador);
            return contador; 

    }   
}
