/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.ETipoFuncionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.basic.BasicBorders;
import util.Query;

/**
 *
 * @author Pedro
 */
public class PTipoFuncionario {

    public void incluir(ETipoFuncionario eTipoFuncionario) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(Query.SELECT_SEQ_TIPOFUNCIONARIO);
            if (rs.next()) {
                eTipoFuncionario.setCodigo(rs.getInt("CODIGO"));
            }
            rs.close();
            PreparedStatement ps = cnn.prepareStatement(Query.INSERT_TIPOFUNCIONARIO);

            ps.setInt(1, eTipoFuncionario.getCodigo());
            ps.setString(2, eTipoFuncionario.getDescricao());

            ps.execute();

            cnn.commit();
            ps.close();
        } catch (Exception e) {
            cnn.rollback();
            throw e;
        } finally {
            cnn.setAutoCommit(true);
        }

    }

    public void alterar(ETipoFuncionario eTipoFuncionario) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement psd = cnn.prepareStatement(Query.UPDATE_TIPOFUNCIONARIO);

            psd.setString(1, eTipoFuncionario.getDescricao());
            psd.setInt(2, eTipoFuncionario.getCodigo());

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
            PreparedStatement psd = cnn.prepareStatement(Query.DELETE_TIPOFUNCIONARIO);

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

    public ETipoFuncionario consultar(int codigo) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        PreparedStatement psd = cnn.prepareStatement(Query.SELECT_TIPOFUNCIONARIO);

        psd.setInt(1, codigo);

        ResultSet rs = psd.executeQuery();

        ETipoFuncionario objeto = null;
        if (rs.next()) {
            objeto = new ETipoFuncionario();
            objeto.setCodigo(rs.getInt("CODIGO"));
            objeto.setDescricao(rs.getString("DESCRICAO"));
        }
        psd.close();
        rs.close();
        return objeto;
    }

    public ArrayList<ETipoFuncionario> listar() throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(Query.SELECT_ALL_TIPOFUNCIONARIO);

        ArrayList<ETipoFuncionario> lista = null;
        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }

            ETipoFuncionario objeto = new ETipoFuncionario();
            objeto.setCodigo(rs.getInt("CODIGO"));
            objeto.setDescricao(rs.getString("DESCRICAO"));
            lista.add(objeto);
        }
        stm.close();
        rs.close();
        return lista;
    }

}
