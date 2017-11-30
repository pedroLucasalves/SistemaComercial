/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EPromocao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import util.Query;

/**
 *
 * @author vip
 */
public class PPromocao {

    public static void incluir(EPromocao ePromocao) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);

        try {
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(Query.SELECT_SEQ_PROMOCAO);

            if (rs.next()) {
                ePromocao.setCodigo(rs.getInt("CODIGO"));
            }

            rs.close();
            PreparedStatement psd = cnn.prepareStatement(Query.INSERT_PROMOCAO);
            psd.setInt(1, ePromocao.getCodigo());
            psd.setString(2, ePromocao.getDescricao());
            psd.setInt(3, ePromocao.getQuantidade());
            psd.setDouble(4, ePromocao.getValorTotal());
            psd.setDouble(5, ePromocao.getPercentualDesconto());
            psd.setInt(6,ePromocao.getEproduto().getCodigo());
            
            

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

//    public PPromocao() {
//    }
    public void alterar(EPromocao ePromocao) throws ClassNotFoundException, Exception {

        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement psd = cnn.prepareStatement(Query.UPDATE_PROMOCAO);

            psd.setString(1, ePromocao.getDescricao());
            psd.setInt(2, ePromocao.getCodigo());

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
            PreparedStatement psd = cnn.prepareStatement(Query.DELETE_PROMOCAO);

            psd.setInt(1, codigo);

            psd.execute();
            cnn.commit();

        } catch (Exception e) {
            cnn.rollback();
            throw e;
        } finally {
            cnn.setAutoCommit(true);
        }

    }

    public EPromocao consultar(int codigo) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        PreparedStatement psd = cnn.prepareStatement(Query.SELECT_PROMOCAO);

        psd.setInt(1, codigo);

        ResultSet rs = psd.executeQuery();

        EPromocao objeto = null;
        if (rs.next()) {
            objeto = new EPromocao();
            objeto.setCodigo(rs.getInt("CODIGO"));
            objeto.setDescricao(rs.getString("DESCRICAO"));
        }
        psd.close();
        rs.close();
        return objeto;
    }

    public ArrayList<EPromocao> listar() throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(Query.SELECT_ALL_PROMOCAO);

        ArrayList<EPromocao> lista = null;
        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }

            EPromocao objeto = new EPromocao();
            objeto.setCodigo(rs.getInt("CODIGO"));
            objeto.setDescricao(rs.getString("DESCRICAO"));
            lista.add(objeto);
        }
        stm.close();
        rs.close();
        return lista;
    }

}
