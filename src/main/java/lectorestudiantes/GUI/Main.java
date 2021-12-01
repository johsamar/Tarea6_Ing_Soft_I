/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorestudiantes.GUI;

import exceptions.ArchivoException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lectorestudiantes.control.Control;

/**
 *
 * @author SAMUEL-PC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Control control = new Control();
        String ruta = "C:\\Users\\SAMUEL-PC\\Desktop\\archivo.txt";
        try {
            control.cargarInformacion(ruta);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (ArchivoException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
