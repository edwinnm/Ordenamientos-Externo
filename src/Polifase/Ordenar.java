
package Polifase;

import com.csvreader.CsvReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.csvreader.CsvWriter;
import java.io.FileWriter;

public class Ordenar {
	
  public static void divide(String rutaOriginal,String rutaA,String rutaB, int campo) throws FileNotFoundException, IOException, ParseException{
        
	  	
	  	CsvReader archivoOriginal = new CsvReader(rutaOriginal,',');
        CsvWriter auxA = new CsvWriter(new FileWriter(rutaA),',');
        CsvWriter auxB = new CsvWriter(new FileWriter(rutaB),',');
        String R,Aux;
        boolean band=true;
        //Comprueba si se puede ser leido
        if (archivoOriginal.readRecord())
            band = false;
        //Lee 
        R = archivoOriginal.get(0);
        //Escribe
        auxA.write(R);
        
        R = archivoOriginal.get(1);
        auxA.write(R);
        R = archivoOriginal.get(2);
        auxA.write(R);
        R = archivoOriginal.get(3);
        auxA.write(R);
        
        R = archivoOriginal.get(campo);
        //Termina el regsitro y pasa al siguiente
        auxA.endRecord();
        
        Aux=R;
        
        band=true;
        
        while(archivoOriginal.readRecord()){
        	
        	R=archivoOriginal.get(campo);
            
            if(ordenaTipo(Aux, R, campo)){
                Aux=R;
                
                if(band==true){
                    
                    R = archivoOriginal.get(0);
                    auxA.write(R);
                    R = archivoOriginal.get(1);
                    auxA.write(R);
                    R = archivoOriginal.get(2);
                    auxA.write(R);
                    R = archivoOriginal.get(3);
                    auxA.write(R);
                    auxA.endRecord();
                }
                else{
                    R = archivoOriginal.get(0);
                    auxB.write(R);
                    R = archivoOriginal.get(1);
                    auxB.write(R);
                    R = archivoOriginal.get(2);
                    auxB.write(R);
                    R = archivoOriginal.get(3);
                    auxB.write(R);
                    auxB.endRecord(); 
                }
            }
            else{
                Aux=R;
                if(band==true){
                    R = archivoOriginal.get(0);
                    auxB.write(R);
                    R = archivoOriginal.get(1);
                    auxB.write(R);
                    R = archivoOriginal.get(2);
                    auxB.write(R);
                    R = archivoOriginal.get(3);
                    auxB.write(R);
                    auxB.endRecord(); 
                    band=false;
                }
                else{
                    R = archivoOriginal.get(0);
                    auxA.write(R);
                    R = archivoOriginal.get(1);
                    auxA.write(R);
                    R = archivoOriginal.get(2);
                    auxA.write(R);
                    R = archivoOriginal.get(3);
                    auxA.write(R);
                    auxA.endRecord();
                    band=true;
                }
            }
        }
        archivoOriginal.close();
        auxA.close();
        auxB.close();   
    }
           
     public static void une(String rutaOriginal, String rutaF1, String rutaF2, int campo) throws FileNotFoundException, IOException, ParseException{         
        int limit=1;
        CsvWriter Original = new CsvWriter(new FileWriter(rutaOriginal),',');
        CsvReader F1 = new CsvReader(rutaF1,',');
        CsvReader F2 = new CsvReader(rutaF2,',');
        String auxR1="", auxR2="";
        boolean end1=true, end2=true;
        
        if (F1.readRecord())
        {    
            auxR1=F1.get(campo);
            end1=false;
        }
        if (F2.readRecord())
        {    
            auxR2=F2.get(campo);
            end2=false;
        }
        
        
        while((!end1 || !end2))
        {
            
            while(!end1 && !end2 && (ordenaTipo(auxR1, F1.get(campo), campo) && ordenaTipo(auxR2, F2.get(campo), campo)) )
            {
                if ( ordenaTipo(F1.get(campo),F2.get(campo), campo) ) 
                {

                    Original.write(F1.get(0));
                    Original.write(F1.get(1));
                    Original.write(F1.get(2));
                    Original.write(F1.get(3));
                    auxR1 = F1.get(campo);
                    Original.endRecord();
                    end1=true;
                    if (F1.readRecord()){
                        if (ordenaTipo(auxR1, F1.get(campo), campo))
                            auxR1 = F1.get(campo);
                        end1=false;
                    }                        
                }else
                {
                    
                    Original.write(F2.get(0));
                    Original.write(F2.get(1));
                    Original.write(F2.get(2));
                    Original.write(F2.get(3));
                    auxR2 = F2.get(campo);
                    Original.endRecord();
                    end2=true;
                    if (F2.readRecord()){
                        end2=false;
                        if ( ordenaTipo(auxR2, F2.get(campo), campo) ) 
                            auxR2 = F2.get(campo);
                        
                    }
                       
                }                
            }
            
            while (!end1 && ordenaTipo(auxR1, F1.get(campo), campo) ) 
            {
                
                Original.write(F1.get(0));
                Original.write(F1.get(1));
                Original.write(F1.get(2));
                Original.write(F1.get(3));
                auxR1 = F1.get(campo);
                Original.endRecord();
                end1=true;
                if (F1.readRecord()){
                    end1=false;
                }       
            }
            
            while (!end2 && ordenaTipo(auxR2, F2.get(campo),campo) ) 
            {
                
                Original.write(F2.get(0));
                Original.write(F2.get(1));
                Original.write(F2.get(2));
                Original.write(F2.get(3));
                auxR2 = F2.get(campo);
                Original.endRecord();
                end2=true;
                if (F2.readRecord()){
                    end2=false;
                }                   
            }
            if (!end1)            
                auxR1 = F1.get(campo);
            if (!end2)
                auxR2 = F2.get(campo);
            limit++;
        }  
        Original.close();
        F1.close();
        F2.close();         
     }
      public static boolean ordenaTipo(String R1, String R2, int campo) throws ParseException
     {
         switch(campo)
         {
             case 0:
                 return Integer.parseInt(R1)<=Integer.parseInt(R2);
             case 1:
                 return R1.compareTo(R2)<=0;
             case 2:
                 return R1.compareTo(R2)<=0;
             case 3:
                 SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
                try
                {
                   Date fecha1 = sd.parse(R1);
                   Date fecha2 = sd.parse(R2);
                   return fecha1.compareTo(fecha2)<=0;
                }
                catch (ParseException e)
                {
                	;
                }
             }
         return false;
     }
      public static void eliminarAux(String rutaF1,String rutaF2) throws IOException{
        CsvWriter F1 = new CsvWriter(new FileWriter(rutaF1),',');
        CsvWriter F2 = new CsvWriter(new FileWriter(rutaF2),',');
        F1.close();
        F2.close();
        boolean existe = new File(rutaF1).exists();
        if (existe)
        {
            File ficheroAux = new File(rutaF1);
            ficheroAux.delete();
        }
        existe= new File(rutaF2).exists();
        if (existe)
        {
            File ficheroAux = new File(rutaF2);
            ficheroAux.delete();
        }
    }
  
}
