package proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author DanielaGF
 */
public class LeerArchivos {

    public static int numeroAleatorio(int maximo) {
        Random generadorAleatorios = new Random();
        return generadorAleatorios.nextInt(maximo);
    }

    public static List<String[]> LeeFichero(String ruta) {
        List<String[]> renglones = new ArrayList<>();
        FileReader fr = null;
        try {
            File archivo = new File(ruta);
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                renglones.add(linea.split("\\t"));
            }
        } catch (IOException e) {
            Interfaz.txaResultados.append("Error al acceder al archivo; " + ruta + "; " + e + "\n");
            return null;
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                Interfaz.txaResultados.append("Error al cerrar el archivo; " + e2 + "\n");
            }
        }
        return renglones;
    }
}
