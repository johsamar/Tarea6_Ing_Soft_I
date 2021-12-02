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
    private final int PArtition_DATA_DEFAULT = 4;

    public Control() {
        estudiantes = new ArrayList<>();
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    
    public boolean cargarInformacion(String ruta)
            throws FileNotFoundException, ArchivoException {

        ArrayList infoArchivo = leerArchivo(ruta);
        int posicionEstudiante;
        String[] particionLinea = new String[PArtition_DATA_DEFAULT];
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

    /**
     * metodo donde se armara el ponderado con la informacion del del archivo
     * @return retorna el pondera con la informacion solicitada
     */
    public String mostrarPonderadoEstudiante() {
        String ponderado = "<html>";
        for (int i = 0; i < this.estudiantes.size(); i++) {
            ponderado += this.estudiantes.get(i).getNombreEstudiante() + " " +
                    this.estudiantes.get(i).getCantidadMaterias() + " materias <br>";
        }
        ponderado = ponderado + "</html>";
        return ponderado;
    }

    /**
     * metodo que creara un estudiante 
     * @param datos lista que contiene los datos del estudiante a crear
     * @return la ultima posicion del array estudiantes ya que en esa posicion 
     * es donde quedo el nuevo estudiante 
     */
    private int crearEstudiante(String[] datos) {
        Estudiante estudiante = new Estudiante(datos[0], datos[1]);
        this.estudiantes.add(estudiante);
        return this.estudiantes.size() - 1;
    }

    /**
     * Lee el archivo que se encuentra en la ruta 
     * @param ruta la ruta del archivo
     * @return contenido del archivo en un arreglo de string(lineas)
     * @throws FileNotFoundException
     * @throws ArchivoException
     */
    private ArrayList<String> leerArchivo(String ruta)
            throws FileNotFoundException, ArchivoException {

        Lector lector = new Lector();
        return lector.leerArchivo(ruta);

    }

    /**
     * Busca un estudiante por su cedula
     *
     * @param cedulaEstudiante cedula del estudiante a buscar
     * @return retorna la posicion del estudiante en la lista,
     * y si no lo encuentra retorna -1
     */
    private int buscarEstudiante(String cedulaEstudiante) {
        int noEncontrado = -1;
        int contador = 0;
        
        while (contador < estudiantes.size()){
            if (estudiantes.get(contador).getCedulaEstudiante().equals(cedulaEstudiante)) {
                return contador;
            }
            contador++;
        }
        return noEncontrado;
    }

}
