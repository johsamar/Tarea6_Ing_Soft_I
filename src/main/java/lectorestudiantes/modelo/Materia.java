package lectorestudiantes.modelo;

/**
 *clase en la que se implente una materia de los estudiantes
 * @author Jose Manuel Marin
 */
public class Materia {
    private String codigoMateria;
    private String nombreMateria;

    public Materia(String codigoMateria, String nombreMateria) {
        this.codigoMateria = codigoMateria;
        this.nombreMateria = nombreMateria;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }
}
