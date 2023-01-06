package proyecto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author DanielaGF
 */
public class SeleccionPorTorneo {

    public Individuo[] seleccionPorTorneoK(int k, Individuo[] poblacion, int noIndividuos) {
        Individuo[] individuos = new Individuo[noIndividuos];
        int x = 0;
        while (x < noIndividuos) {
            List<Individuo> muestra = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                muestra.add(poblacion[LeerArchivos.numeroAleatorio(poblacion.length)]);
            }
            Comparator<Individuo> comparator = Comparator.comparing(Individuo::getValorFAInsatisfaccion);
            muestra = muestra.stream().sorted(comparator).collect(Collectors.toList());

            if (iteracionesIncidencias(muestra.get(0), individuos) < poblacion.length / k) {
                individuos[x] = muestra.get(0);
                x++;
            }
        }
        return individuos;
    }

    private int iteracionesIncidencias(Individuo incidencia, Individuo[] array) {
        int iteraciones = 0;
        for (Individuo elem : array) {
            if (elem != null && elem.equalsWithoutId(incidencia)) {
                iteraciones++;
            }
        }
        return iteraciones;
    }

    public double mejorPeorIndividuo(Individuo[] individuos, boolean mejor) {
        double elite = 0;
        if (mejor) {
            elite = 100000000.0;
        }
        for (Individuo individuo : individuos) {
            double FA = ((individuo.getValorFAdistancia() + (individuo.getValorFAInsatisfaccion() * 1000) ) / 10);
            if (mejor) {
                if (elite > FA) {
                    elite = FA;
                }
            } else {
                if (elite < FA) {
                    elite = FA;
                }
            }
        }
        return elite;
    }

    public double promedioIndividuo(Individuo[] individuos) {
        double total = 0;
        for (Individuo individuo : individuos) {
            total += ((individuo.getValorFAdistancia() + (individuo.getValorFAInsatisfaccion() * 1000) ) / 10);
        }
        return total / individuos.length;
    }
}
