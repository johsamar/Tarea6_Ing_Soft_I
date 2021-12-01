/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorestudiantes.control;

import exceptions.ArchivoException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public boolean cargarInformacion(String ruta)
            throws FileNotFoundException, ArchivoException {

        ArrayList infoArchivo = leerArchivo(ruta);
        int posicionEstudiante;
        String[] particionLinea = new String[4];
        for (int i = 0; i < infoArchivo.size(); i++) {
            particionLinea = infoArchivo.get(i).toString().split(",");
            posicionEstudiante = this.buscarEstudiante(particionLinea[0]);
            if (posicionEstudiante == - 1) {
                posicionEstudiante = this.crearEstudiante(particionLinea);
            }
            this.estudiantes.get(posicionEstudiante).asignarMateria(particionLinea[2], particionLinea[3]);
        }
        return true;
    }

    public String mostrarPonderadoEstudiante() {
        return "";
    }

    private ArrayList<String> leerArchivo(String ruta)
            throws FileNotFoundException, ArchivoException {
        Lector lector = new Lector();
        return lector.leerArchivo(ruta);
    }

    private int buscarEstudiante(String codigoEstudiante) {
        return 1;
    }

    private int crearEstudiante(String[] datos) {
        Estudiante estudiante = new Estudiante(datos[0], datos[1]);
        this.estudiantes.add(estudiante);
        return this.estudiantes.size()-1;
    }
}
