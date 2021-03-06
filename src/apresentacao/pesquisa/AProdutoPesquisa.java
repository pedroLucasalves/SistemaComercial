/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao.pesquisa;

import apresentacao.cadastro.AProdutoCadastro;
import entidade.EProduto;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.NProduto;

/**
 *
 * @author Pedro
 */
public class AProdutoPesquisa extends javax.swing.JInternalFrame {

    JDesktopPane jDesktopPanePrincipal;

    /**
     * Creates new form AProdutoPesquisa
     */
    public AProdutoPesquisa() {
        initComponents();
        preencherTela();
    }

    public AProdutoPesquisa(JDesktopPane parametro) {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePesquisa = new javax.swing.JTable();
        jButtonFechar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        jTablePesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablePesquisaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePesquisa);

        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonFechar)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonFechar)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        try {
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jTablePesquisaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePesquisaMousePressed
        try {
            int linha = jTablePesquisa.getSelectedRow();
            String codigo = jTablePesquisa.getValueAt(linha, 0).toString();

            EProduto eProduto = new NProduto().consultar(Integer.parseInt(codigo));
            AProdutoCadastro tela = new AProdutoCadastro(jDesktopPanePrincipal, eProduto);

            jDesktopPanePrincipal.add(tela);
            tela.setVisible(true);

            this.dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTablePesquisaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePesquisa;
    // End of variables declaration//GEN-END:variables

    private void preencherTela() {
        try {
            Vector<String> cabecalho = new Vector();
            cabecalho.add("CODIGO");
            cabecalho.add("NOME");
            cabecalho.add("VALORUNITARIO");
            cabecalho.add("QUANTIDADE");
            cabecalho.add("DESCRICAO");

            Vector detalhes = new Vector();

            for (EProduto produto : new NProduto().listar()) {
                Vector<String> linha = new Vector();
                linha.add(produto.getCodigo() + "");
                linha.add(produto.getNome());
                linha.add(produto.getValorUnitario() + "");
                linha.add(produto.getQuantidade() + "");
                linha.add(produto.getDescricao());
                detalhes.add(linha);
            }
            jTablePesquisa.setModel(new DefaultTableModel(detalhes, cabecalho));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
