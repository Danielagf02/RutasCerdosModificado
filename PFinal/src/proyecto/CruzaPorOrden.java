package proyecto;

/**
 *
 * @author DanielaGF
 */
public class CruzaPorOrden {

    private int generacion = 0;

    public CruzaPorOrden() {
    }

    public Individuo[] aplicarCruza(Individuo[] poblacionInicial, int cruza) {
        this.generacion++;

        Interfaz.txaResultados.append("#"+generacion + "Generación\n");

        Individuo[] nuevaGeneracion = new Individuo[poblacionInicial.length];
        for (int i = 0; i < poblacionInicial.length; i += 2) {
            Individuo[] hijos = cruzaPorOrden(poblacionInicial[i], poblacionInicial[i + 1], i + 1, cruza);
            nuevaGeneracion[i] = hijos[0];
            nuevaGeneracion[i + 1] = hijos[1];
        }
        return nuevaGeneracion;
    }

    private Individuo[] cruzaPorOrden(Individuo padre1, Individuo padre2, int noInd, int cruza) {
        int[] hijo1Genes = new int[padre1.getGenes().length];
        int[] hijo2Genes = new int[padre1.getGenes().length];
        int corte1 = 2;
        int corte2 = 5;
        while (corte1 == corte2) {
            corte2 = LeerArchivos.numeroAleatorio(36);
        }
        if (corte2 < corte1) {
            int aux = corte1;
            corte1 = corte2;
            corte2 = aux;
        }
        for (int i = (corte1 + 1); i <= corte2; i++) {
            hijo1Genes[i] = padre1.getGenes()[i];
            hijo2Genes[i] = padre2.getGenes()[i];
        }

        int recorredorpadre2 = corte2 + 1 + (cruza * 0);
        int recorredorhijo1 = corte2 + 1 + (cruza * 0);
        
        
        int recorredorpadre1 = recorredorpadre2;
        int recorredorhijo2 = recorredorhijo1;
        while (recorredorhijo1 != corte1 + 1) {
            if (recorredorpadre2 == padre2.getGenes().length) {
                recorredorpadre2 = 0;
            }
            
            
            if (recorredorhijo1 == hijo1Genes.length) {
                recorredorhijo1 = 0;
            }
            
            
            if (findIndex(hijo1Genes, padre2.getGenes()[recorredorpadre2]) == -1) {
                hijo1Genes[recorredorhijo1] = padre2.getGenes()[recorredorpadre2];
                recorredorpadre2++;
                recorredorhijo1++;
            } else {
                recorredorpadre2++;
            }
        }
        while (recorredorhijo2 != corte1 + 1) {
            if (recorredorpadre1 == padre1.getGenes().length) {
                
                
                
                recorredorpadre1 = 0;
            }
            
            
            if (recorredorhijo2 == hijo2Genes.length) {
                recorredorhijo2 = 0;
            }
            if (findIndex(hijo2Genes, padre1.getGenes()[recorredorpadre1]) == -1) {
                hijo2Genes[recorredorhijo2] = padre1.getGenes()[recorredorpadre1];
                recorredorpadre1++;
                recorredorhijo2++;
            } else {
                recorredorpadre1++;
            }
        }

        Individuo[] hijos = new Individuo[2];
        hijos[0] = new Individuo(((getGeneracion() * 100) + noInd + 1), hijo1Genes);
        hijos[1] = new Individuo(((getGeneracion() * 100) + noInd + 2), hijo2Genes);

        if (findIndex(hijo1Genes, 0) != -1 || findIndex(hijo2Genes, 0) != -1) {
            Interfaz.txaResultados.append("\n\n\n ERROR\n");
            Interfaz.txaResultados.append("padre1 = " + padre1 + "\n");
            Interfaz.txaResultados.append("padre2 = " + padre2 + "\n");
            Interfaz.txaResultados.append("hijo 1 = " + hijos[0] + "\n");
            Interfaz.txaResultados.append("hijo 2 = " + hijos[1] + "\n");
            Interfaz.txaResultados.append("cortes en " + corte1 + " y " + corte2 + "\n\n\n");
        }
        return hijos;
    }

    private int findIndex(int arr[], int t) {
        if (arr == null) {
            return -1;
        }
        int len = arr.length;
        int i = 0;
        while (i < len) {
            if (arr[i] == t) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }
}
