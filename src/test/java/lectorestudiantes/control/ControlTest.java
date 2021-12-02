/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorestudiantes.control;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *clase donde se porbaran algunos metodos de la clase control
 * @author jmanu
 */
public class ControlTest {
    
    public ControlTest() {
    }
    /**
     * prueba en donde se va a evaluar cuando un archivo tiene una ruta buena, 
     * y tiene informacion
     * @throws Exception 
     */
    @Test
    public void testCargarInformacionConArchivoConInfo() throws Exception {
        Control control = new Control();
        String ruta = "C:\\Users\\jmanu\\Desktop\\PonderadoEstudiantes.txt";
        Boolean resultado = control.cargarInformacion(ruta);
        assertTrue(resultado);
        assertEquals(3, control.getEstudiantes().size());
    }
    /**
     * prueba en donde se verifica cuando el archivo tiene una ruta buena, 
     * pero no tiene contenido
     * @throws Exception 
     */
    @Test
    public void testCargarInformacionConArchivoSinInfo() throws Exception {
        Control control = new Control();
        String ruta = "C:\\Users\\jmanu\\Desktop\\Vacio.txt";
        Boolean resultado = control.cargarInformacion(ruta);
        assertTrue(resultado);
        assertEquals(0, control.getEstudiantes().size());
    }
}
