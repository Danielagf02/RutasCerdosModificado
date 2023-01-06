package proyecto;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author DanielaGF
 */
public class Clientes {

    private int index;
    private String nombre;
    private double kgEntrega;
    private String colorTort;
    private LocalTime horaMin;
    private LocalTime horaMax;

    public Clientes() {
    }

    public Clientes(int index, String nombre, double kgEntrega, String colorTort, LocalTime horaMin, LocalTime horaMax) {
        this.index = index;
        this.nombre = nombre;
        this.kgEntrega = kgEntrega;
        this.colorTort = colorTort;
        this.horaMin = horaMin;
        this.horaMax = horaMax;
    }

    public static List<Clientes> obtenerClientes() {
        List<Clientes> lista = new ArrayList<>();
        Interfaz.txaResultados.append("Clientes\n");
        Interfaz.txaResultados.append("\n");
        for (String[] corte : LeerArchivos.LeeFichero("clientes.txt")) {
            Interfaz.txaResultados.append("\t" + Arrays.toString(corte) + "\n");
            lista.add(new Clientes(
                    Integer.parseInt(corte[0]),
                    corte[1],
                    Double.parseDouble(corte[2]),
                    corte[3],
                    LocalTime.parse(corte[4], DateTimeFormatter.ofPattern("HH:mm")),
                    LocalTime.parse(corte[5], DateTimeFormatter.ofPattern("HH:mm"))
            ));
        }
        Interfaz.txaResultados.append("\n");
        return lista;
    }

    public Clientes obtenerClientePórIndex(int index) {
        return obtenerClientes().get(index);
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the kgEntrega
     */
    public double getKgEntrega() {
        return kgEntrega;
    }

    /**
     * @param kgEntrega the kgEntrega to set
     */
    public void setKgEntrega(double kgEntrega) {
        this.kgEntrega = kgEntrega;
    }

    /**
     * @return the colorTort
     */
    public String getColorTort() {
        return colorTort;
    }

    /**
     * @param colorTort the colorTort to set
     */
    public void setColorTort(String colorTort) {
        this.colorTort = colorTort;
    }

    /**
     * @return the horaMin
     */
    public LocalTime getHoraMin() {
        return horaMin;
    }

    /**
     * @param horaMin the horaMin to set
     */
    public void setHoraMin(LocalTime horaMin) {
        this.horaMin = horaMin;
    }

    /**
     * @return the horaMax
     */
    public LocalTime getHoraMax() {
        return horaMax;
    }

    /**
     * @param horaMax the horaMax to set
     */
    public void setHoraMax(LocalTime horaMax) {
        this.horaMax = horaMax;
    }

    @Override
    public String toString() {
        return "ClienteGen{"
                + "index=" + index
                + ", nombre='" + nombre + '\''
                + ", kgEntrega=" + kgEntrega
                + ", TipoCliente='" + colorTort + '\''
                + ", horaMin=" + horaMin
                + ", horaMax=" + horaMax
                + '}';
    }
}
