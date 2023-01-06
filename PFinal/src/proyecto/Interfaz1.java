package proyecto;

import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Alejandro
 */
public class Interfaz1 extends javax.swing.JFrame {

    static List<Individuo[]> historico = new ArrayList<>();
    static int NUMERO_GENERACIONES_EJECUTAR, NUMERO_INDIVIDUOS_POR_GENERACION, TORNEO, PROBABILIDAD_CRUCE, PROBABILIDAD_MUTACION;
    String cadena;

    /**
     * Creates new form PruebaInterfaz
     */
    public Interfaz1() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Mejores Rutas para repartir cerdos");
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaResultados = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnEjecutar = new javax.swing.JButton();
        txtGeneraciones = new javax.swing.JTextField();
        txtIndividuos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCruce = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTorneo1 = new javax.swing.JTextField();
        txtMutacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        txaResultados.setEditable(false);
        txaResultados.setColumns(20);
        txaResultados.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txaResultados.setForeground(new java.awt.Color(0, 0, 204));
        txaResultados.setRows(5);
        txaResultados.setSelectionColor(new java.awt.Color(0, 153, 0));
        jScrollPane1.setViewportView(txaResultados);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Resultados mejores Rutas para distribución de cerdos");

        btnEjecutar.setBackground(new java.awt.Color(255, 255, 255));
        btnEjecutar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnEjecutar.setText("Probar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnEjecutarActionPerformed(evt);
            }
        });

        txtGeneraciones.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtGeneraciones.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGeneraciones.setSelectionColor(new java.awt.Color(0, 153, 0));
        txtGeneraciones.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtGeneracionesActionPerformed(evt);
            }
        });

        txtIndividuos.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtIndividuos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIndividuos.setSelectionColor(new java.awt.Color(0, 153, 0));
        txtIndividuos.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtIndividuosActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Generaciones:");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Individuos:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Probabilidad de Cruce (0-100):");

        txtCruce.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtCruce.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCruce.setSelectionColor(new java.awt.Color(0, 153, 0));
        txtCruce.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtCruceActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Tamaño de torneo (1-5):");

        txtTorneo1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtTorneo1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTorneo1.setSelectionColor(new java.awt.Color(0, 153, 0));
        txtTorneo1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtTorneo1ActionPerformed(evt);
            }
        });

        txtMutacion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtMutacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMutacion.setSelectionColor(new java.awt.Color(0, 153, 0));
        txtMutacion.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtMutacionActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Probabilidad de Mutación (0-1000):");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnEjecutar)
                                .addGap(272, 272, 272))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtTorneo1, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtCruce, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtMutacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtIndividuos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtGeneraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEjecutar)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtGeneraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIndividuos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTorneo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCruce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtMutacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGeneracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGeneracionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneracionesActionPerformed

    private void txtIndividuosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndividuosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndividuosActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed

        historico.clear();
        txaResultados.setText(null);

        try {

            NUMERO_GENERACIONES_EJECUTAR = Integer.parseInt(txtGeneraciones.getText());
            NUMERO_INDIVIDUOS_POR_GENERACION = Integer.parseInt(txtIndividuos.getText());
            TORNEO = Integer.parseInt(txtTorneo1.getText());
            PROBABILIDAD_CRUCE = Integer.parseInt(txtCruce.getText());
            PROBABILIDAD_MUTACION = Integer.parseInt(txtMutacion.getText());

            List<Clientes> clientes = Clientes.obtenerClientes();
            List<String[]> rutas = LeerArchivos.LeeFichero("distancias.txt");
            double[][] distancias = new double[rutas.size()][rutas.get(0).length];
            for (int i = 0; i < rutas.size(); i++) {
                for (int j = 0; j < rutas.get(i).length; j++) {
                    distancias[i][j] = Double.parseDouble(rutas.get(i)[j]);
                }
            }
            //capacidad de carga, velocidad en metros por minutos, tiempo de entrega min, tiempo de reabastecimiento, hora de comienzo
            FuncionDeAptitud evaluacionFA = new FuncionDeAptitud(
                    50,
                    240,
                    5,
                    10,
                    LocalTime.of(13, 0)
            );

            SeleccionPorTorneo seleccion = new SeleccionPorTorneo();
            CruzaPorOrden cruza = new CruzaPorOrden();

            DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
            LineAndShapeRenderer renderer = new LineAndShapeRenderer();
            JFreeChart chart;
            CategoryPlot plot;

            txaResultados.append("Poblacion inicial\n");
            txaResultados.append("\n");
            GeneracionIndividuos generacionIndividuos = new GeneracionIndividuos();
            Individuo[] poblacionInicial = generacionIndividuos.poblacionInicial(NUMERO_INDIVIDUOS_POR_GENERACION);
            poblacionInicial = evaluacionFA.evaluar(poblacionInicial, clientes, distancias);
            txaResultados.append("\tIndividuo\tDistancia\tInsatisfacion\tFuncion de Aptitud\tGenes\n");
            for (Individuo individuo : poblacionInicial) {
                txaResultados.append("\t" + individuo.toStringGraficaIND_FAD_FAI(Arrays.toString(individuo.getGenes())) + "\n");
            }
            txaResultados.append("\n");
            historico.add(poblacionInicial);
            Individuo[] NGeneracion = poblacionInicial;
            for (int i = 0; i < NUMERO_GENERACIONES_EJECUTAR; i++) {

                Individuo[] seleccionIndividuos = seleccion.seleccionPorTorneoK(TORNEO, NGeneracion, NUMERO_INDIVIDUOS_POR_GENERACION);

                if (PROBABILIDAD_CRUCE > 0 && PROBABILIDAD_CRUCE <= 100 || PROBABILIDAD_MUTACION > 0) {
                    Individuo[] nuevaGeneracion = cruza.aplicarCruza(seleccionIndividuos, PROBABILIDAD_CRUCE);
                    NGeneracion = evaluacionFA.evaluar(nuevaGeneracion, clientes, distancias);
                } else {
                    NGeneracion = evaluacionFA.evaluar(seleccionIndividuos, clientes, distancias);
                }

                txaResultados.append("\n");
                txaResultados.append("\tIndividuo\tDistancia\tInsatisfacion\tFuncion de Aptitud\tGenes\n");
                for (Individuo individuo : NGeneracion) {
                    txaResultados.append("\t" + individuo.toStringGraficaIND_FAD_FAI(Arrays.toString(individuo.getGenes())) + "\n");
                }
                historico.add(NGeneracion);
                txaResultados.append("\n");
            }

            txaResultados.append("Historial\n");
            txaResultados.append("\n");
            String formulas = "";
            txaResultados.append("Individuo\tDistancia\tInsatisfacion\tFuncion de Aptitud\tGenes\n");

            for (int i = 0; i < historico.size(); i++) {
                for (Individuo individuo : historico.get(i)) {
                    txaResultados.append("" + individuo.toStringGraficaIND_FAD_FAI(Arrays.toString(individuo.getGenes())) + "\n");
                }
                formulas += (historico.get(i)[0].getId() / 100) + "\t"
                        + seleccion.mejorPeorIndividuo(historico.get(i), true)
                        + "\t" + seleccion.mejorPeorIndividuo(historico.get(i), false)
                        + "\t" + seleccion.promedioIndividuo(historico.get(i)) + "\n";

                line_chart_dataset.addValue(seleccion.mejorPeorIndividuo(historico.get(i), true), "Mejor Individuo", "" + i);
                line_chart_dataset.addValue(seleccion.mejorPeorIndividuo(historico.get(i), false), "Peor Individuo", "" + i);
                line_chart_dataset.addValue(seleccion.promedioIndividuo(historico.get(i)), "Promedio", "" + i);

                renderer.setSeriesPaint(0, new Color(0, 200, 0));
                renderer.setSeriesPaint(1, Color.RED);
                renderer.setSeriesPaint(2, Color.BLUE);

            }

            txaResultados.append("\n");
            txaResultados.append("Tabla General\n");
            txaResultados.append("\n");
            txaResultados.append("Generación\tMejor Individuo\tPeor Individuo\tPromedio\n");
            txaResultados.append(formulas);

           /* chart = ChartFactory.createLineChart(
                    " ",
                    "Generaciones",
                    "FA",
                    line_chart_dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false);

            plot = chart.getCategoryPlot();
            plot.setRenderer(renderer);

            ChartPanel chartPanel = new ChartPanel(chart);
            ;*/

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!");
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void txtCruceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCruceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCruceActionPerformed

    private void txtTorneo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTorneo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTorneo1ActionPerformed

    private void txtMutacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMutacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMutacionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea txaResultados;
    private javax.swing.JTextField txtCruce;
    private javax.swing.JTextField txtGeneraciones;
    private javax.swing.JTextField txtIndividuos;
    private javax.swing.JTextField txtMutacion;
    private javax.swing.JTextField txtTorneo1;
    // End of variables declaration//GEN-END:variables
}
