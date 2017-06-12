package Directa;

import java.io.IOException;
import java.text.ParseException;

public class OrdenamientoDirecta {
    public OrdenamientoDirecta(int campo, String nombreArchivo) throws IOException, ParseException{
        switch(campo){
            case 0:
                DirectaEnteros dE = new DirectaEnteros();
                dE.proceso(nombreArchivo);
                return;
            case 1:
                DirectaCadenas dC = new DirectaCadenas();
                dC.proceso(nombreArchivo);
                return;
            case 2:
                DirectaBooleanos dB = new DirectaBooleanos();
                dB.proceso(nombreArchivo);
                return;
            case 3:
                DirectaFechas dF = new DirectaFechas();
                dF.proceso(nombreArchivo);
                return;
        }
                
        
        
        
        
    }
	
}
