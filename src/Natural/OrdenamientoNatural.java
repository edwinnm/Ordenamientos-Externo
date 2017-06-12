package Natural;

public class OrdenamientoNatural {
    public OrdenamientoNatural(int campo, String nombreArchivo) throws Exception{
        switch(campo){
            case 0:
            	NaturalEnteros nE = new NaturalEnteros();
                nE.proceso(nombreArchivo);
                return;
            case 1:
		NaturalCadenas nC = new NaturalCadenas();
		nC.proceso(nombreArchivo);
                return;
            case 2:
                NaturalBooleanos nB = new NaturalBooleanos();
		nB.proceso(nombreArchivo);
                return;
            case 3:
		NaturalFechas nF = new NaturalFechas();
		nF.proceso(nombreArchivo);
                return;
        }
            
    }
}
