package lectorestudiantes.archivo;

import exceptions.ArchivoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Lee un archivo, para obtener su contenido
 * @author Johan Samuel Marin Bañol
 * @version 1.1
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
         * Lee un archivo
         * @param ruta la ruta del archivo a leer
         * @return el contenido del archivo en una lista de líneas
         * @throws FileNotFoundException Si el archivo no existe
         * @throws ArchivoException Si no cumple con las condiciones de una línea
         */
        public ArrayList<String> leerArchivo(String ruta) 
                throws FileNotFoundException,ArchivoException {

            try {
                archivo = new File(ruta);
                fileReader = new FileReader(archivo);
                bufferedReader = new BufferedReader(fileReader);

                String linea;
                int numeroLinea = 1;
                while ((linea = bufferedReader.readLine()) != null) {
                    boolean  validaciones = Validacion.validarLinea(linea, numeroLinea);
                    if(validaciones){
                        contenido.add(linea);
                    }
                    numeroLinea++;
                }
                return contenido;

            } catch (FileNotFoundException fe) {
                throw new FileNotFoundException("Archivo No encontrado");
            } catch (ArchivoException archivoException) {
                throw archivoException;
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
