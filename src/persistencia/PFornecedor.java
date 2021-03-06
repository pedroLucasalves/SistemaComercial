/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EFornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Query;

/**
 *
 * @author Pedro
 */
public class PFornecedor {

    public void incluir(EFornecedor eFornecedor) throws ClassNotFoundException, Exception {

        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(Query.SELECT_SEQ_FORNECEDOR);
            if (rs.next()) {
                eFornecedor.setCodigo(rs.getInt("CODIGO"));
            }
            rs.close();

            PreparedStatement psd = cnn.prepareStatement(Query.INSERT_FORNECEDOR);
            psd.setInt(1, eFornecedor.getCodigo());
            psd.setString(2, eFornecedor.getNome());
            psd.setString(3, eFornecedor.getCnpj());
            psd.setString(4, eFornecedor.getTelefone());
            psd.setString(5, eFornecedor.getEmail());
            psd.setString(6, eFornecedor.getEndereco());

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

    public void alterar(EFornecedor eFornecedor) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);

        try {
            PreparedStatement psd = cnn.prepareStatement(Query.UPDATE_FORNECEDOR);
            
            
            psd.setString(1, eFornecedor.getNome());
            psd.setString(2, eFornecedor.getCnpj());
            psd.setString(3, eFornecedor.getTelefone());
            psd.setString(4, eFornecedor.getEmail());
            psd.setString(5, eFornecedor.getEndereco());
            psd.setInt(6, eFornecedor.getCodigo());

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
            PreparedStatement psd = cnn.prepareStatement(Query.DELETE_FORNECEDOR);

            psd.setInt(1, codigo);

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

    public EFornecedor consultar(int codigo) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();

        PreparedStatement psd = cnn.prepareStatement(Query.SELECT_FORNECEDOR);

        psd.setInt(1, codigo);

        ResultSet rs = psd.executeQuery();
        EFornecedor eFornecedor = null;

        if (rs.next()) {
            eFornecedor = new EFornecedor();

            eFornecedor.setCodigo(rs.getInt("CODIGO"));
            eFornecedor.setNome(rs.getString("NOME"));
            eFornecedor.setCnpj(rs.getString("CNPJ"));
            eFornecedor.setTelefone(rs.getString("TELEFONE"));
            eFornecedor.setEmail(rs.getString("EMAIL"));
            eFornecedor.setEndereco(rs.getString("ENDERECO"));

        }
        psd.close();
        rs.close();
        return eFornecedor;
    }

    public ArrayList<EFornecedor> listar() throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(Query.SELECT_ALL_FORNECEDOR);

        ArrayList<EFornecedor> lista = null;
        EFornecedor eFornecedor = null;

        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }
            eFornecedor = new EFornecedor();
            eFornecedor.setCodigo(rs.getInt("CODIGO"));
            eFornecedor.setNome(rs.getString("NOME"));
            eFornecedor.setCnpj(rs.getString("CNPJ"));
            eFornecedor.setTelefone(rs.getString("TELEFONE"));
            eFornecedor.setEmail(rs.getString("EMAIL"));
            eFornecedor.setEndereco(rs.getString("ENDERECO"));
            lista.add(eFornecedor);
        }

        return lista;
    }

}
