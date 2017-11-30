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
            psd.setDouble(3, eProduto.getValorUnitario());
            psd.setDouble(4, eProduto.getQuantidade());
            psd.setString(5, eProduto.getDescricao());

            psd.execute();
            cnn.commit();
            psd.close();

        } catch (Exception e) {
            cnn.rollback();
            throw e;
        } finally {
            cnn.setAutoCommit(true);
        }

    }

    public void alterar(EProduto eProduto) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement psd = cnn.prepareStatement(Query.UPDATE_PRODUTO);
            psd.setString(1, eProduto.getNome());
            psd.setDouble(2, eProduto.getValorUnitario());
            psd.setDouble(3, eProduto.getQuantidade());
            psd.setString(4, eProduto.getDescricao());
            psd.setInt(5, eProduto.getCodigo());

            psd.executeUpdate();
            cnn.commit();

        } catch (Exception e) {
            cnn.rollback();
            throw e;
        } finally {
            cnn.setAutoCommit(true);
        }

    }

    public void excluir(int codigo) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);

        try {
            PreparedStatement psd = cnn.prepareStatement(Query.DELETE_PRODUTO);
            psd.setInt(1, codigo);

            psd.execute();
            cnn.commit();

        } catch (Exception e) {
            cnn.rollback();
        } finally {
            cnn.setAutoCommit(true);
        }

    }

    public EProduto consultar(int codigo) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        PreparedStatement psd = cnn.prepareStatement(Query.SELECT_PRODUTO);

        psd.setInt(1, codigo);

        ResultSet rs = psd.executeQuery();
        EProduto eProduto = null;

        if (rs.next()) {
            eProduto = new EProduto();
            eProduto.setCodigo(rs.getInt("CODIGO"));
            eProduto.setNome(rs.getString("NOME"));
            eProduto.setValorUnitario(rs.getDouble("VALORUNITARIO"));
            eProduto.setQuantidade(rs.getDouble("QUANTIDADE"));
            eProduto.setDescricao(rs.getString("DESCRICAO"));

        }
        psd.close();
        rs.close();

        return eProduto;
    }

    public ArrayList<EProduto> listar() throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(Query.SELECT_ALL_PRODUTO);
        
        ArrayList<EProduto> lista = null;

        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }
            EProduto eProduto;
            eProduto = new EProduto();
            eProduto.setCodigo(rs.getInt("CODIGO"));
            eProduto.setNome(rs.getString("NOME"));
            eProduto.setValorUnitario(rs.getDouble("VALORUNITARIO"));
            eProduto.setQuantidade(rs.getDouble("QUANTIDADE"));
            eProduto.setDescricao(rs.getString("DESCRICAO"));
            lista.add(eProduto);
        }

        return lista;
    }

}
