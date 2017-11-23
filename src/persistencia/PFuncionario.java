/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EFuncionario;
import entidade.ETipoFuncionario;
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
public class PFuncionario {

    public void incluir(EFuncionario eFuncionario) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(Query.SELECT_SEQ_FUNCIONARIO);

            if (rs.next()) {
                eFuncionario.setCodigo(rs.getInt("CODIGO"));
            }
            rs.close();
            PreparedStatement psd = cnn.prepareStatement(Query.INSERT_FUNCIONARIO);

            psd.setInt(1, eFuncionario.getCodigo());
            psd.setString(2, eFuncionario.getNome());
            psd.setString(3, eFuncionario.getCpf());
            psd.setString(4, eFuncionario.getTelefone());
            psd.setString(5, eFuncionario.getEndereco());
            psd.setString(6, eFuncionario.getRg());
            psd.setInt(7, eFuncionario.geteTipoFuncionario().getCodigo());
            System.out.println(eFuncionario.geteTipoFuncionario().getCodigo());

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

    public void alterar(EFuncionario eFuncionario) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);

        try {
            PreparedStatement psd = cnn.prepareStatement(Query.UPADTE_FUNCIONARIO);
            psd.setString(1, eFuncionario.getNome());
            psd.setString(2, eFuncionario.getCpf());
            psd.setString(3, eFuncionario.getTelefone());
            psd.setString(4, eFuncionario.getEndereco());
            psd.setString(5, eFuncionario.getRg());
            psd.setInt(6, eFuncionario.geteTipoFuncionario().getCodigo());

            psd.execute();

            cnn.commit();

        } catch (Exception e) {
            cnn.rollback();
        } finally {
            cnn.setAutoCommit(true);
        }

    }

    public void excluir(int codigo) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement psd = cnn.prepareStatement(Query.DELETE_FUNCIONARIO);

            psd.setInt(1, codigo);

            psd.execute();
            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
        } finally {
            cnn.setAutoCommit(true);
        }

    }

    public EFuncionario consultar(int codigo) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();

        PreparedStatement psd = cnn.prepareStatement(Query.SELECT_FUNCIONARIO);

        psd.setInt(1, codigo);

        ResultSet rs = psd.executeQuery();
        EFuncionario eFuncionario = null;

        if (rs.next()) {
            eFuncionario = new EFuncionario();
            eFuncionario.setCodigo(rs.getInt("CODIGO"));
            eFuncionario.setNome(rs.getString("NOME"));
            eFuncionario.setCpf(rs.getString("CPF"));
            eFuncionario.setTelefone(rs.getString("TELEFONE"));
            eFuncionario.setEndereco(rs.getString("ENDERECO"));
            eFuncionario.setRg(rs.getString("RG"));
            eFuncionario.seteTipoFuncionario(new PTipoFuncionario().consultar(rs.getInt("COD_FUNCIONARIO")));
        }
        psd.close();
        rs.close();
        cnn.close();
        return eFuncionario;
    }

    public ArrayList<EFuncionario> listar() throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(Query.SELECT_ALL_FUNCIONARIO);
        
        ArrayList<EFuncionario> lista = null;
        PTipoFuncionario pTipoFuncionario = null;
        while (rs.next()) {
            if (pTipoFuncionario == null) {
                pTipoFuncionario = new PTipoFuncionario();
            }
            
            EFuncionario eFuncionario = new EFuncionario();
            eFuncionario.setCodigo(rs.getInt("CODIGO"));
            eFuncionario.setNome(rs.getString("NOME"));
            eFuncionario.setCpf(rs.getString("CPF"));
            eFuncionario.setTelefone(rs.getString("TELEFONE"));
            eFuncionario.setEndereco(rs.getString("ENDERECO"));
            eFuncionario.setRg(rs.getString("RG"));
            eFuncionario.seteTipoFuncionario(pTipoFuncionario.consultar(rs.getInt("COD_FUNCIONARIO")));
            lista.add(eFuncionario);
        }
        return lista;
    }
}
