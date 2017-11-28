/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EItemPedido;
import entidade.EPedido;
import entidade.EProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import util.Query;

/**
 *
 * @author Pedro
 */
public class PProduto {

    public void incluir(EProduto eProduto) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);

        try {
            
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(Query.SELECT_SEQ_PRODUTO);

            if (rs.next()) {
                eProduto.setCodigo(rs.getInt("CODIGO"));
            }
            rs.close();
 

            PreparedStatement psd = cnn.prepareStatement(Query.INSERT_PRODUTO);
            psd.setInt(1, eProduto.getCodigo());
            psd.setString(2, eProduto.getNome());
            psd.setString(3, eProduto.getDescricao());
            psd.setDouble(4, eProduto.getValorUnitario());
            psd.setDouble(5, eProduto.getQuantidade());

            psd.execute();
            cnn.commit();
            psd.close();

        } catch (Exception e) {
            cnn.rollback();
            throw e;
        }finally {
            cnn.setAutoCommit(true);
        }
        
    }

    public void alterar(EProduto eProduto) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement psd = cnn.prepareStatement(Query.UPDATE_PRODUTO);
            psd.setInt(1, eProduto.getCodigo());
            psd.setString(2, eProduto.getNome());
            psd.setString(3, eProduto.getDescricao());
            psd.setDouble(4, eProduto.getValorUnitario());
            psd.setDouble(5, eProduto.getQuantidade());
            
            psd.executeUpdate();
            cnn.commit();
          
        } catch (Exception e) {
            cnn.rollback();
            throw e;
        }finally{
            cnn.setAutoCommit(true);
        }

    }

    public void excluir(int codigo) {

    }

    public EProduto consultar(int codigo) {
        return null;
    }

    public ArrayList<EProduto> listar() {
        return null;
    }

}
