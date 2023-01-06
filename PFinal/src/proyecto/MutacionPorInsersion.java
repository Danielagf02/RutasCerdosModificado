package proyecto;

/**
 *
 * @author DanielaGF
 */
public class MutacionPorInsersion {

    public Individuo mutacion(Individuo seleccionado, int probMut) {

        Individuo selecMutado = seleccionado;
        int num1, num2, dato = (int) Math.random() * 1000;
        boolean mut;

        do {
            num1 = (int) Math.random() * 1000;
        } while (!((num1 + probMut) <= 1000));

        num2 = num1 + probMut;
        mut = (dato >= num1 || dato <= num2) ? true : false;

        if (mut) {
            int genSeleccionado = (int) Math.random() * selecMutado.getGenes().length - 1;
            selecMutado.setGenes(genSeleccionado);
        }
        return selecMutado;
    }
}
