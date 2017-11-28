/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.ECliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Query;

/**
 *
 * @author Pedro
 */
public class PCliente {

    public void incluir(ECliente eCliente) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {

            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(Query.SELECT_SEQ_CLIENTE);

            if (rs.next()) {
                eCliente.setCodigo(rs.getInt("CODIGO"));
            }
            rs.close();
            PreparedStatement psd = cnn.prepareStatement(Query.INSERT_CLIENTE);

            psd.setInt(1, eCliente.getCodigo());
            psd.setString(2, eCliente.getNome());
            psd.setString(3, eCliente.getCpf());
            psd.setString(4, eCliente.getTelefone());
            psd.setString(5, eCliente.getEndereco());
            psd.setString(6, eCliente.getFormaPagamento());

            psd.execute();
            psd.close();
            cnn.commit();

        } catch (Exception e) {
            cnn.rollback();
            throw e;
        } finally {
            cnn.setAutoCommit(true);
        }
    }

    public void alterar(ECliente eCliente) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);

        try {

            PreparedStatement psd = cnn.prepareStatement(Query.UPDATE_CLIENTE);

            psd.setString(1, eCliente.getNome());
            psd.setString(2, eCliente.getCpf());
            psd.setString(3, eCliente.getTelefone());
            psd.setString(4, eCliente.getEndereco());
            psd.setString(5, eCliente.getFormaPagamento());
            psd.setInt(6, eCliente.getCodigo());

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
            PreparedStatement psd = cnn.prepareStatement(Query.DELETE_CLIENTE);

            psd.setInt(1, codigo);

            psd.execute();

            psd.close();
            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
            throw e;
        } finally {
            cnn.setAutoCommit(true);
        }

    }

    public ECliente consultar(int codigo) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();

        PreparedStatement psd = cnn.prepareStatement(Query.SELECT_CLIENTE);

        psd.setInt(1, codigo);

        ResultSet rs = psd.executeQuery();

        ECliente eCliente = null;

        if (rs.next()) {
            eCliente = new ECliente();
            eCliente.setCodigo(rs.getInt("CODIGO"));
            eCliente.setNome(rs.getString("NOME"));
            eCliente.setCpf(rs.getString("CPF"));
            eCliente.setTelefone(rs.getString("TELEFONE"));
            eCliente.setEndereco(rs.getString("ENDERECO"));
            eCliente.setFormaPagamento(rs.getString("FORMADEPAGAMENTO"));
        }
        psd.close();
        rs.close();
        return eCliente;
    }

    public ArrayList<ECliente> listar() throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(Query.SELECT_ALL_CLIENTE);

        ECliente eCliente = null;
        ArrayList<ECliente> lista = null;
        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();

            }
            eCliente = new ECliente();
            eCliente.setCodigo(rs.getInt("CODIGO"));
            eCliente.setNome(rs.getString("NOME"));
            eCliente.setCpf(rs.getString("CPF"));
            eCliente.setTelefone(rs.getString("TELEFONE"));
            eCliente.setEndereco(rs.getString("ENDERECO"));
            eCliente.setFormaPagamento(rs.getString("FORMADEPAGAMENTO"));
            lista.add(eCliente);

        }

        return lista;
    }

}
