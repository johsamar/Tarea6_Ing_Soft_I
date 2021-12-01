package lectorestudiantes.modelo;

import java.util.ArrayList;

/**
 * En esta clase se implementa un estudiante con sus metodos
 * @author Jose Manuel Marin
 */
public class Estudiante {

    private String nombreEstudiante;
    private String cedulaEstudiante;
    private ArrayList<Materia> materias;

    public Estudiante(String nombreEstudiante, String cedulaEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
        this.cedulaEstudiante = cedulaEstudiante;
        this.materias = new ArrayList<Materia>();
    }

    public String getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }
    
    
    /**
     * metodo encargado de añadir una materia a la lista del estudiante si 
     * aun no la tiene
     * @param nombreMateria el nombre de la materia a asignar
     * @param codigoMateria el coddigo de la materia a asignar
     * @return 
     */
    public Boolean asignarMateria (String nombreMateria, String codigoMateria){
        if (!this.buscarMateira(codigoMateria)) {
            Materia newMateria = new Materia(codigoMateria, nombreMateria);
            this.materias.add(newMateria);
        }
        return true;
    }

    /**
     * se buscara una materia por su codigo
     * @param codigoMateria codigo de la materia a buscar
     * @return true si se ecuentra una materia con igual codigo al que se 
     * esta evaluando, de lo contrario se retorna false
     */
    public Boolean buscarMateira(String codigoMateria){
        for (Materia materia : materias) {
            if (materia.getCodigoMateria().equals(codigoMateria)) {
                return true;
            }
        }
        return false;
    }
    /**
     * metodo con el que se obtendra la cantida de materias que esta cursando 
     * un estudiante
     * @return el tamaño del arreglo de materias
     */
    public int getCantidadMaterias() {
        return this.materias.size();
    }
}
