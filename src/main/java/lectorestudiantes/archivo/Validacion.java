/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorestudiantes.archivo;
import exceptions.ArchivoException;
/**
 *
 * @author SAMUEL-PC
 */
public class Validacion {
    
    private static int limite = 4;
    
    public static boolean validarLinea(String linea, int numeroLinea) 
                                    throws ArchivoException{
        
        boolean lineaCorrecta = true;
        
        String[] division = linea.split(",");
        if(division.length < limite){
            throw new ArchivoException("La cantidad de datos "
                    + "es inferior a la requerida "+" numero de línea "+
                        numeroLinea+" contenido: "+linea);
        }
        if(division.length > limite){
                throw new ArchivoException("La cantidad de datos "
                    + "es superior a la requerida "+" numero de línea "+
                        numeroLinea+" contenido: "+linea);
        }
        return lineaCorrecta;
    }
}
