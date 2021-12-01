/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorestudiantes.control;

import exceptions.ArchivoException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import lectorestudiantes.archivo.Lector;
import lectorestudiantes.modelo.Estudiante;

/**
 *
 * @author SAMUEL-PC
 */
public class Control {
    private ArrayList<Estudiante> estudiantes;

    public Control() {
    
    }
    
    public boolean cargarInformacion(){
        return true;
    }
    
    public String mostrarPonderadoEstudiante(){
        return "";
    }
    /**
     * Lee el archivo
     * @param ruta la ruta del archivo
     * @return contenido del archivo en un arreglo de string(lineas)
     * @throws FileNotFoundException
     * @throws ArchivoException 
     */
    private ArrayList<String> leerArchivo(String ruta) 
            throws FileNotFoundException, ArchivoException{
        
        Lector lector = new Lector();
        return lector.leerArchivo(ruta);
        
    }
    /**
     * Busca un estudiante
     * @param cedulaEstudiante
     * @return retorna la posicion del estudiante en la lista
     */
    private int buscarEstudiante(String cedulaEstudiante){
        int noEncontrado = -1;
        int contador = 0;
        while (contador < estudiantes.size()) {
            if(estudiantes.get(contador).getCedulaEstudiante().equals(cedulaEstudiante)){
                return contador;
            }
            contador++;
        }
        return noEncontrado;
    }
    
    private int crearEstudiante(String[] datos){
        return 0;
    }
}
