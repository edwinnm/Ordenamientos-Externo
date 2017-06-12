package Balanceada;


import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class MezclaBalanceada {
    public static void particionInicial(String rutaOriginal,String rutaF1,String rutaF2, int campo) throws FileNotFoundException, IOException, ParseException{
        ///Apertura de archivos con extension cvs
    	CsvReader file = new CsvReader(rutaOriginal,',');
        CsvWriter file1 = new CsvWriter(new FileWriter(rutaF1),',');
        CsvWriter file2 = new CsvWriter(new FileWriter(rutaF2),',');
        String r,aux;
        boolean band=true;
        
        if (file.readRecord())
            band = false;
        r = file.get(0);
        file1.write(r);
        r = file.get(1);
        file1.write(r);
        r = file.get(2);
        file1.write(r);
        r = file.get(3);
        file1.write(r);
        r = file.get(campo);
        file1.endRecord();
        aux=r;
        band=true;
        
        while(file.readRecord()){
            r=file.get(campo);
            if(orderIt(aux, r, campo)){ //Integer.parseInt(R)>=Integer.parseInt(Aux)
                aux=r;
                
                if(band==true){
                    
                    r = file.get(0);
                    file1.write(r);
                    r = file.get(1);
                    file1.write(r);
                    r = file.get(2);
                    file1.write(r);
                    r = file.get(3);
                    file1.write(r);
                    file1.endRecord();
                }
                else{
                    r = file.get(0);
                    file2.write(r);
                    r = file.get(1);
                    file2.write(r);
                    r = file.get(2);
                    file2.write(r);
                    r = file.get(3);
                    file2.write(r);
                    file2.endRecord(); 
                }
            }
            else{
                aux=r;
                if(band==true){
                    r = file.get(0);
                    file2.write(r);
                    r = file.get(1);
                    file2.write(r);
                    r = file.get(2);
                    file2.write(r);
                    r = file.get(3);
                    file2.write(r);
                    file2.endRecord(); 
                    band=false;
                }
                else{
                    r = file.get(0);
                    file1.write(r);
                    r = file.get(1);
                    file1.write(r);
                    r = file.get(2);
                    file1.write(r);
                    r = file.get(3);
                    file1.write(r);
                    file1.endRecord();
                    band=true;
                }
            }
        }
        file.close();
        file1.close();
        file2.close();   
    }
  
    public static void copiarTodo(String RutaCopiar,String RutaVaciar) throws IOException{
        CsvReader FB = new CsvReader(RutaVaciar,',');
        CsvWriter FC = new CsvWriter(new FileWriter(RutaCopiar),',');
        String R2="";
        while(FB.readRecord()){
            R2= FB.get(0);
            FC.write(R2);
            R2= FB.get(1);
            FC.write(R2);
            R2= FB.get(2);
            FC.write(R2);
            R2= FB.get(3);
            FC.write(R2);
            FC.endRecord();
        }
        ///Cerrar archivos.
        FC.close();
        FB.close();
    }
    public static void eliminarAux(String rutaF1,String rutaF2,String rutaF3){
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
        existe= new File(rutaF3).exists();
        if (existe)
        {
            File ficheroAux = new File(rutaF3);
            ficheroAux.delete();
        }
    }
    
    
    public static void particionFusion(String rutaF1,String rutaF3,String rutaOriginal,String rutaF2, int campo) throws FileNotFoundException, IOException, ParseException{
        String r1="",r2="",r="";
        String aux= "-300000";
        CsvReader fileA = new CsvReader(rutaF1,',');
        CsvReader fileB = new CsvReader(rutaF3,',');
        CsvWriter fileC = new CsvWriter(new FileWriter(rutaOriginal),',');
        CsvWriter fileD = new CsvWriter(new FileWriter(rutaF2),',');
        boolean band,dele1,dele2;
        band=true;
        fileA.readRecord();
        fileB.readRecord();
        r1=fileA.get(campo);
        r2=fileB.get(campo);
        if(r1.equals("")||r2.equals("")){
            return;
        }
        //return Integer.parseInt(R1)<=Integer.parseInt(R2);
        if(orderIt(r1,r2,campo)){//Integer.parseInt(R1)<=Integer.parseInt(R2)
            aux=r1;
            
        }
        else{
            aux=r2;
        }
        dele1=dele2=false;
        while((0!=OrdenamientoBalanceada.contar(rutaF1)||dele1!=true)&&(0!=OrdenamientoBalanceada.contar(rutaF3)||dele2!=true)){
            if(dele1){
                fileA.readRecord();
                r1=fileA.get(campo);
                dele1=false;
                if(r1.equals("")){
                    dele1=true;
                    break;
                }
            }
            if(dele2){
                fileB.readRecord();
                r2=fileB.get(campo);
                dele2=false;
                if(r2.equals("")){
                    dele2=true;
                    break;
                }
            }
            if(orderIt(r1,r2,campo)){//Integer.parseInt(R1)<Integer.parseInt(R2)
                if(orderIt(aux,r1,campo)){//Integer.parseInt(R1)>=Integer.parseInt(Aux)
                    aux=r1;
                    if(band){
                        r1= fileA.get(0);
                        fileC.write(r1);
                        r1= fileA.get(1);
                        fileC.write(r1);
                        r1= fileA.get(2);
                        fileC.write(r1);
                        r1= fileA.get(3);
                        fileC.write(r1);
                        fileC.endRecord();                       
                    }
                    else{
                        r1= fileA.get(0);
                        fileD.write(r1);
                        r1= fileA.get(1);
                        fileD.write(r1);
                        r1= fileA.get(2);
                        fileD.write(r1);
                        r1= fileA.get(3);
                        fileD.write(r1);
                        fileD.endRecord(); 
                    }
                    dele1=true;
                }
                else if(orderIt(aux,r2,campo)){//Integer.parseInt(R2)>=Integer.parseInt(Aux)
                    aux=r2;
                    if(band){
                        r2= fileB.get(0);
                        fileC.write(r2);
                        r2= fileB.get(1);
                        fileC.write(r2);
                        r2= fileB.get(2);
                        fileC.write(r2);
                        r2= fileB.get(3);
                        fileC.write(r2);
                        fileC.endRecord(); 
                    }
                    else{
                        r2= fileB.get(0);
                        fileD.write(r2);
                        r2= fileB.get(1);
                        fileD.write(r2);
                        r2= fileB.get(2);
                        fileD.write(r2);
                        r2= fileB.get(3);
                        fileD.write(r2);
                        fileD.endRecord(); 
                    } 
                    dele2=true;
                }
                else{
                    aux=r1;
                    if(band){
                        r1= fileA.get(0);
                        fileD.write(r1);
                        r1= fileA.get(1);
                        fileD.write(r1);
                        r1= fileA.get(2);
                        fileD.write(r1);
                        r1= fileA.get(3);
                        fileD.write(r1);
                        fileD.endRecord();
                        band=false;
                    }
                    else{
                        r1= fileA.get(0);
                        fileC.write(r1);
                        r1= fileA.get(1);
                        fileC.write(r1);
                        r1= fileA.get(2);
                        fileC.write(r1);
                        r1= fileA.get(3);
                        fileC.write(r1);
                        fileC.endRecord(); 
                        band=true;
                    }
                    dele1=true;
                }
            }
            else{
                if(orderIt(aux,r2,campo)){//Integer.parseInt(R2)>=Integer.parseInt(Aux)
                    aux=r2;
                    if(band){
                        r2= fileB.get(0);
                        fileC.write(r2);
                        r2= fileB.get(1);
                        fileC.write(r2);
                        r2= fileB.get(2);
                        fileC.write(r2);
                        r2= fileB.get(3);
                        fileC.write(r2);
                        fileC.endRecord();                       
                    }
                    else{
                        r2= fileB.get(0);
                        fileD.write(r2);
                        r2= fileB.get(1);
                        fileD.write(r2);
                        r2= fileB.get(2);
                        fileD.write(r2);
                        r2= fileB.get(3);
                        fileD.write(r2);
                        fileD.endRecord(); 
                    }                  
                    dele2=true;
                }
                else if(orderIt(aux,r1,campo)){//Integer.parseInt(R1)>=Integer.parseInt(Aux)
                    aux=r1;                  
                    if(band){
                        r1= fileA.get(0);
                        fileC.write(r1);
                        r1= fileA.get(1);
                        fileC.write(r1);
                        r1= fileA.get(2);
                        fileC.write(r1);
                        r1= fileA.get(3);
                        fileC.write(r1);
                        fileC.endRecord();                       
                    }
                    else{
                        r1= fileA.get(0);
                        fileD.write(r1);
                        r1= fileA.get(1);
                        fileD.write(r1);
                        r1= fileA.get(2);
                        fileD.write(r1);
                        r1= fileA.get(3);
                        fileD.write(r1);
                        fileD.endRecord(); 
                    }
                    dele1=true;
                }
                else{ 
                    aux=r2;
                    if(band){
                        r2= fileB.get(0);
                        fileD.write(r2);
                        r2= fileB.get(1);
                        fileD.write(r2);
                        r2= fileB.get(2);
                        fileD.write(r2);
                        r2= fileB.get(3);
                        fileD.write(r2);
                        fileD.endRecord();    
                        band=false;
                    }
                    else{
                        r2= fileB.get(0);
                        fileC.write(r2);
                        r2= fileB.get(1);
                        fileC.write(r2);
                        r2= fileB.get(2);
                        fileC.write(r2);
                        r2= fileB.get(3);
                        fileC.write(r2);
                        fileC.endRecord();  
                        band=true;
                    }
                    dele2=true;
                }
            }
        }
        if(dele1){
            if(orderIt(aux,r2,campo)){//Integer.parseInt(R2)>=Integer.parseInt(Aux)
                aux=r2;
                if(band){
                    r2=fileB.get(0);
                    fileC.write(r2);
                    r2=fileB.get(1);
                    fileC.write(r2);
                    r2=fileB.get(2);
                    fileC.write(r2);
                    r2=fileB.get(3);
                    fileC.write(r2);
                    fileC.endRecord();
                }
                else{
                    r2=fileB.get(0);
                    fileD.write(r2);
                    r2=fileB.get(1);
                    fileD.write(r2);
                    r2=fileB.get(2);
                    fileD.write(r2);
                    r2=fileB.get(3);
                    fileD.write(r2);
                    fileC.endRecord();
                }
            }
            else{
                
                aux=r2;
                if(band){
                    r2=fileB.get(0);
                    fileD.write(r2);
                    r2=fileB.get(1);
                    fileD.write(r2);
                    r2=fileB.get(2);
                    fileD.write(r2);
                    r2=fileB.get(3);
                    fileD.write(r2);
                    fileC.endRecord();
                    band=false;
                }
                else{
                    r2=fileB.get(0);
                    fileC.write(r2);
                    r2=fileB.get(1);
                    fileC.write(r2);
                    r2=fileB.get(2);
                    fileC.write(r2);
                    r2=fileB.get(3);
                    fileC.write(r2);
                    fileC.endRecord();
                    band=true;
                }
            }
            while(fileB.readRecord()){
                r2=fileB.get(campo);
                if(orderIt(aux,r2,campo)){//Integer.parseInt(R2)>=Integer.parseInt(Aux)
                //if(orderIt(R2,R2,campo)){//Integer.parseInt(R2)>=Integer.parseInt(R2)
                    aux=r2;
                    if(band){
                        r2=fileB.get(0);
                        fileC.write(r2);
                        r2=fileB.get(1);
                        fileC.write(r2);
                        r2=fileB.get(2);
                        fileC.write(r2);
                        r2=fileB.get(3);
                        fileC.write(r2);
                        fileC.endRecord();
                    }
                    else{
                        r2=fileB.get(0);
                        fileD.write(r2);
                        r2=fileB.get(1);
                        fileD.write(r2);
                        r2=fileB.get(2);
                        fileD.write(r2);
                        r2=fileB.get(3);
                        fileD.write(r2);
                        fileC.endRecord();
                    }
                }
                else{
                    aux=r2;                  
                    if(band){
                        r2=fileB.get(0);
                        fileD.write(r2);
                        r2=fileB.get(1);
                        fileD.write(r2);
                        r2=fileB.get(2);
                        fileD.write(r2);
                        r2=fileB.get(3);
                        fileD.write(r2);
                        fileC.endRecord();
                        band=false;
                    }
                    else{
                        r2=fileB.get(0);
                        fileC.write(r2);
                        r2=fileB.get(1);
                        fileC.write(r2);
                        r2=fileB.get(2);
                        fileC.write(r2);
                        r2=fileB.get(3);
                        fileC.write(r2);
                        fileC.endRecord();
                        band=true;
                    } 
                }
            }


        }
        if(dele2){
            if(orderIt(aux,r1,campo)){//Integer.parseInt(R1)>=Integer.parseInt(Aux)
                aux=r1;
                if(band){
                    r1=fileA.get(0);
                    fileC.write(r1);
                    r1=fileA.get(1);
                    fileC.write(r1);
                    r1=fileA.get(2);
                    fileC.write(r1);
                    r1=fileA.get(3);
                    fileC.write(r1);
                    fileC.endRecord();
                }
                else{
                    r1=fileA.get(0);
                    fileD.write(r1);
                    r1=fileA.get(1);
                    fileD.write(r1);
                    r1=fileA.get(2);
                    fileD.write(r1);
                    r1=fileA.get(3);
                    fileD.write(r1);
                    fileD.endRecord();
                }
            }
        
            else{
                aux=r1;
                if(band){
                    r1=fileA.get(0);
                    fileD.write(r1);
                    r1=fileA.get(1);
                    fileD.write(r1);
                    r1=fileA.get(2);
                    fileD.write(r1);
                    r1=fileA.get(3);
                    fileD.write(r1);
                    fileD.endRecord();
                    band=false;
                }
                else{
                    r1=fileA.get(0);
                    fileC.write(r1);
                    r1=fileA.get(1);
                    fileC.write(r1);
                    r1=fileA.get(2);
                    fileC.write(r1);
                    r1=fileA.get(3);
                    fileC.write(r1);
                    fileC.endRecord();
                    band=true;
                }
            }
            while(fileA.readRecord()){
                r1=fileA.get(campo);
                
                
                if(orderIt(aux,r1,campo)){//Integer.parseInt(R1)>=Integer.parseInt(Aux)
                    aux = r1;
                    if(band){
                        r1=fileA.get(0);  
                        fileC.write(r1); 
                        r1=fileA.get(1);
                        fileC.write(r1);
                        r1=fileA.get(2);
                        fileC.write(r1);
                        r1=fileA.get(3);
                        fileC.write(r1);
                        fileC.endRecord();
                       
                    }else{
                        r1=fileA.get(0);  
                        fileD.write(r1); 
                        r1=fileA.get(1);
                        fileD.write(r1);
                        r1=fileA.get(2);
                        fileD.write(r1);
                        r1=fileA.get(3);
                        fileD.write(r1);
                        fileD.endRecord();
                    }
                }
                else{
                    aux=r1;
                    if(band){
                        r1=fileA.get(0);   
                        fileD.write(r1); 
                        r1=fileA.get(1);
                        fileD.write(r1);
                        r1=fileA.get(2);
                        fileD.write(r1);
                        r1=fileA.get(3);
                        fileD.write(r1);
                        fileD.endRecord();
                        band=false;
                    }
                    else{
                        r1=fileA.get(0);    
                        fileC.write(r1); 
                        r1=fileA.get(1);
                        fileC.write(r1);
                        r1=fileA.get(2);
                        fileC.write(r1);
                        r1=fileA.get(3);
                        fileC.write(r1);
                        fileC.endRecord();
                        band=true;
                    }
                }
            }
        }
        fileA.close();
        fileB.close();
        fileC.close(); 
        fileD.close();
    }
    
     public static boolean orderIt(String R1, String R2, int campo) throws ParseException
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
                   // Error, la cadena de texto no se puede convertir en fecha.
                }

         }
         return false;
     }
}