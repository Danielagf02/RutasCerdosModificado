package proyecto;

import java.time.LocalTime;
import java.util.List;

/**
 *
 *@author DanielaGF
 */
public class FuncionDeAptitud {

    double GcapacidadCargaKG;
    double GvelocidadMetrosMin;
    int GtiempoEntregaMin;
    int GtiempoReabastecimiento;

    LocalTime GinicioRuta;
    int GvalorSatisf = 1;

    public FuncionDeAptitud(double GcapacidadCargaKG, double GvelocidadMetrosMin, int GtiempoEntregaMin, int GtiempoReabastecimiento, LocalTime GinicioRuta) {
        this.GcapacidadCargaKG = GcapacidadCargaKG;
        this.GvelocidadMetrosMin = GvelocidadMetrosMin;
        this.GtiempoEntregaMin = GtiempoEntregaMin;
        this.GtiempoReabastecimiento = GtiempoReabastecimiento;
        this.GinicioRuta = GinicioRuta;
    }

    public Individuo[] evaluar(Individuo[] individuos, List<Clientes> clientes, double[][] distancias) {
        for (Individuo individuo : individuos) {
            double almacen = GcapacidadCargaKG;
            LocalTime horaActual = GinicioRuta;
            double FAdistancia = 0;
            double FAInsatisfacion = 0;
            for (int i = 0; i < individuo.getGenes().length; i++) {
                int index = individuo.getGenes()[i] - 1;
                Clientes gen = clientes.get(index);

                
                if (almacen - gen.getKgEntrega() < 0) {
                   

                    double distanciaReabastecimiento = (distancias[0][individuo.getGenes()[i - 1]]) * 2;
                    FAdistancia += distanciaReabastecimiento;
                    horaActual = horaActual.plusSeconds((int) ((distanciaReabastecimiento / GvelocidadMetrosMin) * 60));
                    horaActual = horaActual.plusMinutes(GtiempoReabastecimiento);
                    almacen = GcapacidadCargaKG;
                }

                double distanciaEntrega;
                if (i == 0) {
                    distanciaEntrega = distancias[0][gen.getIndex()];
                } else {
                    distanciaEntrega = distancias[individuo.getGenes()[i - 1]][gen.getIndex()];
                }

                almacen -= gen.getKgEntrega();
                FAdistancia += distanciaEntrega;
                
                
                horaActual = horaActual.plusSeconds((int) ((distanciaEntrega / GvelocidadMetrosMin) * 60));
                if ((gen.getHoraMin().isBefore(horaActual) || gen.getHoraMin().equals(horaActual))
                        && (gen.getHoraMax().isAfter(horaActual) || gen.getHoraMax().equals(horaActual))) {
                    
                    
                    
                    FAInsatisfacion -= GvalorSatisf;
                } else {
                    FAInsatisfacion += GvalorSatisf;
                }
                horaActual = horaActual.plusMinutes(GtiempoEntregaMin);

                
            }
            individuo.setValorFAdistancia(FAdistancia / 1);
            individuo.setValorFAInsatisfaccion(FAInsatisfacion);


        }
        return individuos;
    }

}
