import Asientos.Asiento;
import GestionBoletos.CompraBoleto;
import GestionCooperativa.Cooperativa;
import GestionCooperativa.IngresoCoperativas;
import GestionRutas.IngresoRutas;
import GestionUsusarios.Usuario;


public class Principal {
     
    public static void main(String[] args) {
        
       
        
        CompraBoleto b = new CompraBoleto();
        Cooperativa co = new Cooperativa();
       

        switch (opcion) {
            case 1:

                break;

            case 2:

                break;

            case 3:

                break;

            case 4:
                
                break;

            case 5:
               
                break;

            case 6:
                
                break;

            case 7:
              
               
                break;

            case 8:

               
                break;

            case 9:

               

                break;

            case 10:

               //b.impresionRutas();
        
              

                break;

            case 11:
            b.impresionRutas();
            b.compraTicket();

            //Instanciar objetos en el main y pasarlos como parametros e los metoods de registro

            break;

            default:
                break;
        }
    }
}