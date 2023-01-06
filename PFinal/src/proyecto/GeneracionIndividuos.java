package proyecto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DanielaGF
 */
public class GeneracionIndividuos {

    public Individuo[] poblacionInicial(int cantidad) {
        Individuo[] inds = new Individuo[cantidad];
        for (int i = 0; i < cantidad; i++) {
            Individuo ind = crearIndividuo();
            ind.setId(i + 1);
            inds[i] = ind;
        }
        return inds;
    }

    private Individuo crearIndividuo() {
        Individuo ind = new Individuo();
        int noGenes = 30;
        int[] genes = new int[noGenes];
        List<Integer> valorGenes = valorGenes();
        for (int i = 0; i < noGenes; i++) {
            int aleatorio = LeerArchivos.numeroAleatorio(valorGenes.size());
            genes[i] = valorGenes.get(aleatorio);
            valorGenes.remove(aleatorio);
        }
        ind.setGenes(genes);
        return ind;
    }

    private List<Integer> valorGenes() {
        List<Integer> lista = new ArrayList<>();
        for (int i = 1; i <=30; i++) {
            lista.add(i);
        }
        return lista;
    }
}
