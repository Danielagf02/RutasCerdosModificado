package proyecto;

import java.util.Arrays;

/**
 *
 * @author DanielaGF
 */
public class Individuo {

    private int id;
    private int[] genes;
    private double valorFAdistancia;
    private double valorFAInsatisfaccion;

    public Individuo() {
    }

    public Individuo(int id, int[] genes) {
        this.id = id;
        this.genes = genes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getGenes() {
        return genes;
    }

    public void setGenes(int[] genes) {
        this.genes = genes;
    }

    public double getValorFAdistancia() {
        return valorFAdistancia;
    }

    public void setValorFAdistancia(double valorFAdistancia) {
        this.valorFAdistancia = valorFAdistancia;
    }

    public double getValorFAInsatisfaccion() {
        return valorFAInsatisfaccion;
    }

    public void setValorFAInsatisfaccion(double valorFAInsatisfaccion) {
        this.valorFAInsatisfaccion = valorFAInsatisfaccion;
    }

    @Override
    public String toString() {
        return "Individuo{" + "id=" + id + ", genes=" + Arrays.toString(genes) + ", valorFAdistancia=" + valorFAdistancia + ", valorFAInsatisfaccion=" + valorFAInsatisfaccion + '}';
    }

    public String toStringGraficaIND_FAD_FAI(String extra) {
        return id + "\t" + valorFAdistancia + "\t" + valorFAInsatisfaccion + "\t" + ((valorFAdistancia + (valorFAInsatisfaccion * 1000)) / 10) + "\t" + extra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Individuo individuo = (Individuo) o;
        return id == individuo.id && Double.compare(individuo.valorFAdistancia, valorFAdistancia) == 0 && Double.compare(individuo.valorFAInsatisfaccion, valorFAInsatisfaccion) == 0 && Arrays.equals(genes, individuo.genes);
    }

    public boolean equalsWithoutId(Individuo individuo) {
        if (this == individuo) {
            return true;
        }
        if (individuo == null || getClass() != individuo.getClass()) {
            return false;
        }
        return Double.compare(individuo.valorFAdistancia, valorFAdistancia) == 0
                && Double.compare(individuo.valorFAInsatisfaccion, valorFAInsatisfaccion) == 0
                && Arrays.equals(genes, individuo.genes);
    }

    void setGenes(int genSeleccionado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
