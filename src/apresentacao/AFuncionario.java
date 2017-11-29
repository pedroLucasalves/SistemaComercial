/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import apresentacao.cadastro.AFuncionarioCadastro;
import apresentacao.cadastro.ATipoFuncionarioCadastro;
import apresentacao.pesquisa.AFuncionarioPesquisa;
import java.awt.JobAttributes;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro
 */
public class AFuncionario extends javax.swing.JInternalFrame {

    JDesktopPane jDesktopPanePrincipal;

    /**
     * Creates new form AFuncionarioCadastro
     */
    public AFuncionario() {
        initComponents();
    }

    public AFuncionario(JDesktopPane parametro) {
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

        jButtonCadastrarFuncionario = new javax.swing.JButton();
        jButtonCadastrarTipoFuncionario = new javax.swing.JButton();
        jButtonConsultarFuncionario = new javax.swing.JButton();

        setClosable(true);

        jButtonCadastrarFuncionario.setText("Cadastrar Funcionario");
        jButtonCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarFuncionarioActionPerformed(evt);
            }
        });

        jButtonCadastrarTipoFuncionario.setText("Cadastrar Tipo Funcionario");
        jButtonCadastrarTipoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarTipoFuncionarioActionPerformed(evt);
            }
        });

        jButtonConsultarFuncionario.setText("Consultar Funcionario");
        jButtonConsultarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCadastrarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadastrarTipoFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonConsultarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButtonCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonCadastrarTipoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonConsultarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarFuncionarioActionPerformed
        try {
            AFuncionarioCadastro tela01 = new AFuncionarioCadastro(jDesktopPanePrincipal);
            jDesktopPanePrincipal.add(tela01);
            tela01.setVisible(true);

            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonCadastrarFuncionarioActionPerformed

    private void jButtonCadastrarTipoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarTipoFuncionarioActionPerformed
        try {
            ATipoFuncionarioCadastro tela02 = new ATipoFuncionarioCadastro(jDesktopPanePrincipal);
            jDesktopPanePrincipal.add(tela02);
            tela02.setVisible(true);

            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonCadastrarTipoFuncionarioActionPerformed

    private void jButtonConsultarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarFuncionarioActionPerformed
        try {
            AFuncionarioPesquisa tela03 = new AFuncionarioPesquisa(jDesktopPanePrincipal);
            jDesktopPanePrincipal.add(tela03);
            tela03.setVisible(true);

            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonConsultarFuncionarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarFuncionario;
    private javax.swing.JButton jButtonCadastrarTipoFuncionario;
    private javax.swing.JButton jButtonConsultarFuncionario;
    // End of variables declaration//GEN-END:variables
}
