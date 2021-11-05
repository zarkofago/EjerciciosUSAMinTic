
package Reto3;

import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class Actualizar extends javax.swing.JFrame {
    
    public BaseDatosProductos baseDatos;
    private JTable tabla;
    private Producto producto;
  
    public Actualizar() {
        initComponents();
    }
     public Actualizar(BaseDatosProductos baseDatos, JTable tabla, Producto producto){
        this.baseDatos = baseDatos;
        this.tabla = tabla;
        this.producto = producto;
         
        initComponents();
    }
    public void controlTablaModelo(){
        tabla.setModel(new controlTabla(this.baseDatos.getBasedeDatos()));
    }
   public boolean validarDatos(String nombre, String precio, String inventario){
        boolean resultado = true;
        if(nombre.isEmpty() || precio.isEmpty() || inventario.isEmpty()){
            resultado = false;
        }
       return resultado;
    }
    
   public void limpiarCajas(){
        Principal.txtNombre.setText("");
        Principal.txtPrecio.setText("");
        Principal.txtInventario.setText("");
    
    }
     
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        txtPrecio2 = new javax.swing.JTextField();
        txtInventario2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnActualizar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingrese los nuevos valores");

        txtInventario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInventario2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel3.setText("Precio");

        jLabel4.setText("Inventario");

        btnActualizar2.setText("Actualizar Producto");
        btnActualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtInventario2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(119, 119, 119))
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(btnActualizar2)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtPrecio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtInventario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addGap(38, 38, 38)
                .addComponent(btnActualizar2)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtInventario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInventario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInventario2ActionPerformed

    private void btnActualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar2ActionPerformed
        if (validarDatos(txtNombre2.getText(),txtPrecio2.getText(),txtInventario2.getText())){
             int codigo = producto.getCodigo();
             String nombre = txtNombre2.getText();
             double precio = Double.parseDouble(txtPrecio2.getText());
             int inventario = Integer.parseInt(txtInventario2.getText());
             
             Producto producto = new Producto(codigo,nombre,precio,inventario);
             baseDatos.actualizar(producto);
             JOptionPane.showMessageDialog(this,"el producto fue actualizado correctamente");
             controlTablaModelo();
             limpiarCajas();
             this.setVisible(false);
         }else{
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios","Advertencia", JOptionPane.WARNING_MESSAGE);
         }
    }//GEN-LAST:event_btnActualizar2ActionPerformed

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
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actualizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JTextField txtInventario2;
    public static javax.swing.JTextField txtNombre2;
    public static javax.swing.JTextField txtPrecio2;
    // End of variables declaration//GEN-END:variables
}
