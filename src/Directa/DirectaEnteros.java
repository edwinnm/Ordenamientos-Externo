package Directa;

import java.io.*;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class DirectaEnteros {
	private String [] arreglo = new String[4];
	
	public void proceso(String nombreArchivo) throws IOException{
		
		File file = new File(nombreArchivo);
		File aux1 = new File("Directa/Enteros/aux_1.csv");
		File aux2 = new File("Directa/Enteros/aux_2.csv");
		
		int n = contarRegistros(file);
		
		System.out.println("Ordenando.....");
		mezclaDirecta(file,aux1,aux2,n);
		System.out.println("Ordenamiento completado");
	}
	
	private void mezclaDirecta(File file, File aux1, File aux2, int n) throws IOException {
		int part = 1;
		while(part <= ((int)((n+1)/2))){
			divide(file, aux1, aux2, part);
			fusiona(file, aux1, aux2, part);
			part *= 2;
			
		}
		divide (file, aux1, aux2, part);
		fusiona(file, aux1, aux2, part);
		
	}

	private void divide(File file, File aux1, File aux2, int part) throws IOException {
		CsvReader f = new CsvReader(new FileReader(file), ',');
		CsvWriter f1 = new CsvWriter(new FileWriter(aux1), ',');
		CsvWriter f2 = new CsvWriter(new FileWriter(aux2), ',');
		int k=0, l=0;
		//f.readHeaders();
		//f1.writeRecord(f.getHeaders());
		//f2.writeRecord(f.getHeaders());
		
		boolean esFin = f.readRecord();
		while(esFin){
			k=0;
			while((k<part) && esFin){
				guardar(f1,f);
				k++;
				esFin = f.readRecord();
			}
			l=0;
			while((l<part) && esFin){
				guardar(f2,f);
				l++;
				esFin = f.readRecord();
			}
		}
		f1.flush();
		f2.flush();
		f1.close();
		f2.close();
		f.close();
	}

	private void guardar(CsvWriter escribe, CsvReader lee) throws IOException {
		arreglo [0] = lee.get(0);
		arreglo [1] = lee.get(1);
		arreglo [2] = lee.get(2);
		arreglo [3] = lee.get(3);
		escribe.writeRecord(arreglo);
		
		
	}

	private void fusiona(File file, File aux1, File aux2, int part) throws IOException {
		CsvWriter f = new CsvWriter(new FileWriter(file), ',');
        CsvReader f1 = new CsvReader(new FileReader(aux1), ',');
        CsvReader f2 = new CsvReader(new FileReader(aux2), ',');
        int k = 0, l = 0;
        boolean B1 = true, B2 = true;
        boolean esFinf1, esFinf2;
        //f1.readHeaders();
        //f2.readHeaders();
        //f.writeRecord(f2.getHeaders());
        
        esFinf1 = f1.readRecord();
        if (esFinf1){
            B1 = false;
        }
        esFinf2 = f2.readRecord();
        if (esFinf2){
            B2 = false;
        }
        
        while((esFinf1 || (B1 == false)) && (esFinf2 || (B2 == false))){
        	k = l = 0;
        	while(((k < part) && (B1 == false)) && ((l < part) && (B2 == false))){
                if (Integer.parseInt(f1.get(0)) <= Integer.parseInt(f2.get(0))) {
                    guardar(f, f1);
                    B1 = true;
                    k++;
                    esFinf1 = f1.readRecord();
                    if (esFinf1){
                        B1 = false;
                    }
                } else {
                    guardar(f, f2);
                    B2 = true;
                    l++;
                    esFinf2 = f2.readRecord();
                    if (esFinf2){
                        B2 = false;
                    }
                }
            }
            while((k < part) && (B1 == false)) {
                guardar(f, f1);
                B1 = true;
                k++;
                esFinf1 = f1.readRecord();
                if (esFinf1){
                    B1 = false;
                }
            }
            while((l < part) && (B2 == false)) {
                guardar(f, f2);
                B2 = true;
                l++;
                esFinf2 = f2.readRecord();
                if (esFinf2){
                    B2 = false;
                }
            }
        }
        if (B1 == false){
            guardar(f, f1);
        }
        if (B2 == false) {
            guardar(f, f2);
        }
        esFinf1 = f1.readRecord();
        while(esFinf1) {
            guardar(f, f1);
            esFinf1 = f1.readRecord();
        }
        esFinf2 = f2.readRecord();
        while(esFinf2) {
            guardar(f, f2);
            esFinf2 = f2.readRecord();
        }
        f.flush();
        f1.close();
        f2.close();
        f.close();
}
        
	

	private int contarRegistros(File F) throws IOException{
		CsvReader Br = new CsvReader(new FileReader(F),',');
		int contador = 0;
		//Br.readHeaders();
		while(Br.readRecord()){
			contador ++;
		}
		
		return contador;
		
	}
}

