/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorestudiantes.archivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author SAMUEL-PC
 */
public class Lector {
        private File archivo = null;
        private FileReader fileReader = null;
        private BufferedReader bufferedReader = null;
        private ArrayList<String> contenido;

        public Lector() {
            contenido = new ArrayList<>();
        }
        /**
         * 
         * @param ruta
         * @return 
         */
        public ArrayList<String> leerArchivo(String ruta) throws FileNotFoundException {

            try {
                archivo = new File(ruta);
                fileReader = new FileReader(archivo);
                bufferedReader = new BufferedReader(fileReader);

                String linea;
                int numeroLinea = 0;
                while ((linea = bufferedReader.readLine()) != null) {
                    if(Validacion.validarLinea(linea, numeroLinea)){
                        contenido.add(linea);
                    }
                    numeroLinea++;
                }
                return contenido;

            } catch (FileNotFoundException fe) {
                throw new FileNotFoundException("Archivo No encontrado");
            }
            catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != fileReader) {
                        fileReader.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
}
