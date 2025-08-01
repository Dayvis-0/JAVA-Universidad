public class appArbolBI extends javax.swing.JFrame {
    private cArbolBI arbbi;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(appArbolBI.class.getName());
    
    public appArbolBI() {
        initComponents();
        arbbi = new cArbolBI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        la_nodo = new javax.swing.JLabel();
        tf_nodo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_rta = new javax.swing.JTextArea();
        cb_operaciones = new javax.swing.JComboBox<>();
        bu_eliminar = new javax.swing.JButton();
        bu_ejecutor = new javax.swing.JButton();
        bu_agregar = new javax.swing.JButton();
        bu_limpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        la_nodo.setText("Nodo:");

        ta_rta.setColumns(20);
        ta_rta.setRows(5);
        jScrollPane1.setViewportView(ta_rta);

        cb_operaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Esta vacio?", "Maximo ", "Minimo", "Arbol", "Pre-orden", "In-orden", "Pos-orden", "Existe arbol?", "Es hoja?", "Es padre?", "Su padre?", "Nodos", "Padres", "Hojas", "Altura", "Nivel", "Reccorer hojas", "Reccorer padres", "Reccorer hermano", "Reccorer nivel", "Reccorer primer hijo", "Reccorer hijo unico", "Reccorer ultimo hijo", "Reccorer segundo hijo", "Son hermanos?", "Primeros-ultimos" }));

        bu_eliminar.setText("Eliminar");
        bu_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bu_eliminarMouseClicked(evt);
            }
        });

        bu_ejecutor.setText("Ejecutar");
        bu_ejecutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bu_ejecutorMouseClicked(evt);
            }
        });

        bu_agregar.setText("Agregar");
        bu_agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bu_agregarMouseClicked(evt);
            }
        });

        bu_limpiar.setText("Limpiar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(la_nodo)
                        .addGap(18, 18, 18)
                        .addComponent(tf_nodo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bu_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bu_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cb_operaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bu_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bu_ejecutor, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(la_nodo)
                            .addComponent(tf_nodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bu_eliminar)
                            .addComponent(bu_agregar)
                            .addComponent(bu_limpiar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_operaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bu_ejecutor)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bu_agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bu_agregarMouseClicked
        // TODO add your handling code here:
        if(arbbi.agregar(tf_nodo.getText())){
            ta_rta.setText("Elemento insertado");
        } else {
            ta_rta.setText("Elemento no insertado");
        }
    }//GEN-LAST:event_bu_agregarMouseClicked

    private void bu_ejecutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bu_ejecutorMouseClicked
        // TODO add your handling code here:
        int opc = cb_operaciones.getSelectedIndex();
        
        switch(opc) {
            case 0: ta_rta.setText("Esta vacio: " + arbbi.estaVacio()); break;
            case 1: cNodoAB dir = arbbi.maximo(); ta_rta.setText("Maximo: " + (dir != null ? dir.sElemento(): "----")); break;
            case 2: dir = arbbi.minimo(); ta_rta.setText("Minimo: " + (dir != null ? dir.sElemento(): "----")); break;
            case 3: ta_rta.setText("Arbol: " + arbbi.arbol(tf_nodo.getText())); break;
            case 4: ta_rta.setText("Pre-orden: " + arbbi.preOrden()); break;
            case 5: ta_rta.setText("In-orden: " + arbbi.inOrden()); break;
            case 6: ta_rta.setText("Pos-Orden: " + arbbi.posOrden()); break;
            case 7: ta_rta.setText("Existe arbol: " + arbbi.existe(tf_nodo.getText())); break;
            case 8: ta_rta.setText("Es hoja: " + arbbi.esHoja(tf_nodo.getText())); break;
            case 9: ta_rta.setText("Es padre: " + arbbi.esPadre(tf_nodo.getText())); break;
            case 10: ta_rta.setText("Su padre: " + arbbi.suPadre(tf_nodo.getText())); break;
            case 11: ta_rta.setText("Nodos: " + arbbi.nodos()); break;
            case 12: ta_rta.setText("Padres: " + arbbi.padres()); break;
            case 13: ta_rta.setText("Hojas: " + arbbi.hojas()); break;
            case 14: ta_rta.setText("Altura: " + arbbi.altura()); break;
            case 15: ta_rta.setText("Nivel: " + arbbi.nivel(-1)); break;
            case 16: ta_rta.setText("Recorrer hojas: " + arbbi.recorrerHojas()); break;
            case 17: ta_rta.setText("Recorrer padres: " + arbbi.recorrerPadres()); break;
            case 18: ta_rta.setText("Recorrer hermano: " + arbbi.recorreHermano(tf_nodo.getText())); break;
            case 19: ta_rta.setText("Recorrer nivel: " + arbbi.recorreNivel(-1)); break;
            case 20: ta_rta.setText("Recorrer primer hijo: " + arbbi.recorrePrimerHijo()); break;
            case 21: ta_rta.setText("Recorrer hijo unico: " + arbbi.recorreHijoUnico()); break;
            case 22: ta_rta.setText("Recorrer utlimo hijo: " + arbbi.recorreUltimoHijo()); break;
            case 23: ta_rta.setText("Recorrer segundo hijo: " + arbbi.recorreSegundoHijo()); break;
            case 24: ta_rta.setText("Son hermanos: " + arbbi.sonHermano(tf_nodo.getText())); break;
            case 25: ta_rta.setText("Primeros - ultimos: " + arbbi.primeroUltimo()); break;
            
        }
    }//GEN-LAST:event_bu_ejecutorMouseClicked

    private void bu_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bu_eliminarMouseClicked
        // TODO add your handling code here:
        arbbi.eliminar(tf_nodo);
    }//GEN-LAST:event_bu_eliminarMouseClicked

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                appArbolBI arbi1 = new appArbolBI();
                
                arbi1.setVisible(true);
                arbi1.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bu_agregar;
    private javax.swing.JButton bu_ejecutor;
    private javax.swing.JButton bu_eliminar;
    private javax.swing.JButton bu_limpiar;
    private javax.swing.JComboBox<String> cb_operaciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel la_nodo;
    private javax.swing.JTextArea ta_rta;
    private javax.swing.JTextField tf_nodo;
    // End of variables declaration//GEN-END:variables
}
