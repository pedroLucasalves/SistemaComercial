/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import apresentacao.cadastro.AFornecedorCadastro;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro
 */
public class AFornecedor extends javax.swing.JInternalFrame {

    JDesktopPane jDesktopPanePrincipal;

    /**
     * Creates new form AFornecedor
     */
    public AFornecedor() {
        initComponents();
    }

    public AFornecedor(JDesktopPane parametro) {
        this();

        this.jDesktopPanePrincipal = parametro;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCadastrarFornecedor = new javax.swing.JButton();
        jButtonConsultarFornecedor = new javax.swing.JButton();

        setClosable(true);

        jButtonCadastrarFornecedor.setText("Cadastrar Fornecedor");
        jButtonCadastrarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarFornecedorActionPerformed(evt);
            }
        });

        jButtonConsultarFornecedor.setText("Consultar Fornecedor");
        jButtonConsultarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarFornecedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCadastrarFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonConsultarFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonCadastrarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonConsultarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarFornecedorActionPerformed
        try {
            AFornecedorCadastro tela01 = new AFornecedorCadastro(jDesktopPanePrincipal);
            jDesktopPanePrincipal.add(tela01);
            tela01.setVisible(true);

            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonCadastrarFornecedorActionPerformed

    private void jButtonConsultarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConsultarFornecedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarFornecedor;
    private javax.swing.JButton jButtonConsultarFornecedor;
    // End of variables declaration//GEN-END:variables
}
