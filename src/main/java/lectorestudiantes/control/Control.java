/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorestudiantes.control;

import java.util.ArrayList;
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
    
    private ArrayList<String> leerArchivo(String ruta){
        return null;
    }
    
    private int buscarEstudiante(String codigoEstudiante){
        return 1;
    }
    
    private int crearEstudiante(ArrayList datos){
        return 0;
    }
}
