package Natural;
import java.io.*;
import com.csvreader.*;

public class NaturalBooleanos {
   
    private final String[] columnas = new String[4];
    
    public void proceso(String nombreArchivo) throws Exception {
    	
        File origen = new File(nombreArchivo);
        File aux1 = new File("Natural/Booleanos/aux_1.csv");
        File aux2 = new File("Natural/Booleanos/aux_2.cvs");
        System.out.println("Ordenando. Por Favor Espere.....");
        ordenar(origen, aux1, aux2);
        System.out.println("Ordenamiento Finalizado!!!!\n");
        
    }
    
    private int contarRegistros(File F) throws FileNotFoundException, IOException {
        
    	int contador = 0;
        CsvReader archivo = new CsvReader(new FileReader(F));
        //archivo.readHeaders();
        while (archivo.readRecord()) {
            contador++;
        }
        archivo.close();
        System.out.println(contador);
        return contador;
    }

    private void ordenar(File F, File F1, File F2) throws Exception {
        while (division(F, F1, F2)) {
            fusion(F, F1, F2);
        }
    }

    //Metodo para dividir en particiones de secuencias
    private boolean division(File F, File F1, File F2) throws IOException {
        String actual = null;
        String anterior = null;
        int indiceSalida = 0;
        boolean hayCambioDeSecuencia = false;
        CsvWriter auxiliares[] = new CsvWriter[2];
        CsvReader archivo = null;
        auxiliares[0] = new CsvWriter(new FileWriter(F1), ',');
        auxiliares[1] = new CsvWriter(new FileWriter(F2), ',');
        archivo = new CsvReader(new FileReader(F));
        //archivo.readHeaders();
        
        //auxiliares[0].writeRecord(archivo.getHeaders());
        //auxiliares[1].writeRecord(archivo.getHeaders());
        
        while (archivo.readRecord()) {
        	System.out.println(anterior);
        	System.out.println(actual);
        	anterior = actual;
        	
        	//Obtengo la tercera columna
            actual = archivo.get(2);
            
            if (anterior == null) {
                anterior = actual;
            }
            //Condicion de evaluacion de booleanos 
            if (anterior.compareTo(actual) > 0) {
            	//resultado = (condicion)?valor1:valor2;
                indiceSalida = indiceSalida == 0 ? 1 : 0;
                hayCambioDeSecuencia = true;
            }
            guardar(auxiliares[indiceSalida], archivo);
        }
        archivo.close();
        auxiliares[0].flush();
        auxiliares[1].flush();
        auxiliares[0].close();
        auxiliares[1].close();
        
        return hayCambioDeSecuencia;
    }

    //Metodo de fusion de los datos obtenidos en el metodo de particion
    private void fusion(File F, File F1, File F2) throws IOException {
        String[] actual = new String[2];
        String[] anterior = new String[2];
        boolean[] finArchivo = new boolean[2];
        int indexArchivo = 0;
        CsvReader Auxiliares[] = new CsvReader[2];

        int contAux1 = contarRegistros(F1);
        int contAux2 = contarRegistros(F2);
        Auxiliares[0] = new CsvReader(new FileReader(F1));
        Auxiliares[1] = new CsvReader(new FileReader(F2));
        CsvWriter Archivo = new CsvWriter(new FileWriter(F, false), ',');
        //Auxiliares[0].readHeaders();
        //Auxiliares[1].readHeaders();
        //Archivo.writeRecord(Auxiliares[0].getHeaders());
        
        while (contAux1 > 0 && contAux2 > 0) {
            if (anterior[0] == null && anterior[1] == null) {
                Auxiliares[0].readRecord();
                anterior[0] = actual[0] = Auxiliares[0].get(2);
                contAux1--;
                Auxiliares[1].readRecord();
                anterior[1] = actual[1] = Auxiliares[1].get(2);
                contAux2--;
            }
            anterior[0] = actual[0];
            anterior[1] = actual[1];

            //while (anterior[0].compareTo(actual[0]) <= 0 && anterior[1].compareTo(actual[1]) <= 0) {
            while (anterior[0].compareTo(actual[0]) <= 0 && anterior[1].compareTo(actual[1]) <= 0) {
                //indexArchivo = (actual[0].compareTo(actual[1]) <= 0) ? 0 : 1;
                indexArchivo = (actual[0].compareTo(actual[1]) <= 0) ? 0 : 1;
                guardar(Archivo, Auxiliares[indexArchivo]);

                anterior[indexArchivo] = actual[indexArchivo];
                if(indexArchivo==0){
                    if (contAux1>0) {
                        Auxiliares[0].readRecord();
                        actual[0] = Auxiliares[0].get(2);
                        contAux1--;
                    } else {
                        finArchivo[0] = true;
                        break;
                    }
                }
                if(indexArchivo==1){
                    if (contAux2>0) {
                        Auxiliares[1].readRecord();
                        actual[1] = Auxiliares[1].get(2);
                        contAux2--;
                    } else {
                        finArchivo[1] = true;
                        break;
                    }
                }
            }
            
            if(indexArchivo == 0 ){
                //while (anterior[1].compareTo(actual[1]) <= 0) {
                while (anterior[1].compareTo(actual[1]) <= 0) {
                	guardar(Archivo, Auxiliares[1]);
                    anterior[1] = actual[1];
                    if (contAux2>0) {
                        Auxiliares[1].readRecord();
                        actual[1] = Auxiliares[1].get(2);
                        contAux2--;
                    } else {
                        finArchivo[1] = true;
                        break;
                    }
                }
            }
            if(indexArchivo == 1){
                //while (anterior[0].compareTo(actual[0]) <= 0) {
                while (anterior[0].compareTo(actual[0]) <= 0) {
                	guardar(Archivo, Auxiliares[0]);
                    anterior[0] = actual[0];
                    if (contAux1>0) {
                        Auxiliares[0].readRecord();
                        actual[0] = Auxiliares[0].get(2);
                        contAux1--;
                    } else {
                        finArchivo[0] = true;
                        break;
                    }
                }
            }


        }
        if (!finArchivo[0]) {
        	guardar(Archivo, Auxiliares[0]);
            while (contAux1>0) {
                Auxiliares[0].readRecord();
                guardar(Archivo, Auxiliares[0]);
                contAux1--;
            }
        }

        if (!finArchivo[1]) {
        	guardar(Archivo, Auxiliares[1]);
            while (contAux2>0) {
                Auxiliares[1].readRecord();
                guardar(Archivo, Auxiliares[1]);
                contAux2--;
            }
        }
        Auxiliares[0].close();
        Auxiliares[1].close();
        Archivo.flush();
        Archivo.close();
    }
    
   
    private void guardar (CsvWriter escribe, CsvReader lee) throws IOException {
        columnas[0] = lee.get(0);
        columnas[1] = lee.get(1);
        columnas[2] = lee.get(2);
        columnas[3] = lee.get(3);
        escribe.writeRecord(columnas);
    }
}