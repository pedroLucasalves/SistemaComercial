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

/**
 *
 * @author Pedro
 */
public class PCliente {

    public void incluir(ECliente eCliente) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);

        try {
            String sq2 = "SELECT  CLIENTE_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sq2);

            if (rs.next()) {
                eCliente.setCodigo(rs.getInt("CODIGO"));
            }
            rs.close();
            String sq1 = "INSERT INTO CLIENTE"
                    + "(CODIGO,NOME,CPF,TELEFONE,ENDERECO,RG, FORMAPAGAMENTO"
                    + "(?,?,?,?,?,?,?)";

            PreparedStatement psd = cnn.prepareStatement(sq1);
            psd.setInt(1, eCliente.getCodigo());
            psd.setString(2, eCliente.getNome());
            psd.setString(3, eCliente.getCpf());
            psd.setString(4, eCliente.getTelefone());
            psd.setString(5, eCliente.getEndereco());
            psd.setString(6, eCliente.getFormaPagamento());

            psd.close();
            cnn.commit();

        } catch (Exception e) {
            cnn.rollback();
        }
    }

    public void alterar(ECliente eCliente) throws ClassNotFoundException, Exception {

        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);

        try {
            String sq1 = "UPDATE CLIENTE"
                    + " SET NOME = ?"
                    + " CPF = ?"
                    + " TELEFONE = ?"
                    + " ENDERECO = ?"
                    + " FORMAPAGAMENTO"
                    + " WHERE = CODIGO = ?";

            PreparedStatement psd = cnn.prepareStatement(sq1);
            psd.setString(1, eCliente.getNome());
            psd.setString(2, eCliente.getCpf());
            psd.setString(3, eCliente.getTelefone());
            psd.setString(4, eCliente.getEndereco());
            psd.setString(5, eCliente.getFormaPagamento());

            psd.execute();

            cnn.commit();

        } catch (Exception e) {
            cnn.rollback();
        }
        cnn.close();
    }

    public void excluir(int codigo) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            String sq1 = "DELETE FROM CLIENTE WHERE CODIGO = ?";

            PreparedStatement psd = cnn.prepareStatement(sq1);

            psd.setInt(1, codigo);

            psd.execute();

            psd.close();
            cnn.commit();
        } catch (Exception e) {
            cnn.rollback();
        }
        cnn.close();
    }

    public ECliente consultar(int codigo) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();

        String sq1 = "SELECT CODIGO, NOME, CPF, TELEFONE, ENDERECO, FORMAPAGAMENTO,"
                + " COD_CLIENTE"
                + " FROM CLIENTE WHERE CODIGO = ?";

        PreparedStatement psd = cnn.prepareStatement(sq1);

        psd.setInt(1, codigo);

        ResultSet rs = psd.executeQuery();
        ECliente eCliente = new ECliente();

        if (rs.next()) {
            eCliente.setCodigo(rs.getInt("CODIGO"));
            eCliente.setNome(rs.getString("NOME"));
            eCliente.setCpf(rs.getString("CPF"));
            eCliente.setTelefone(rs.getString("TELEFONE"));
            eCliente.setEndereco(rs.getString("ENDERECO"));
            eCliente.setFormaPagamento(rs.getString("FORMAPAGAMENTO"));
        }
        psd.close();
        cnn.close();
        return eCliente;
    }

    public List<ECliente> listar() throws ClassNotFoundException, Exception {
        List<ECliente> lista = new ArrayList<>();

        Connection cnn = util.UConexao.getConexao();

        String sq1 = "SELECT * FROM CLIENTE ORDER BY NOME";

        PreparedStatement psd = cnn.prepareStatement(sq1);

        ResultSet rs = psd.executeQuery();

        ECliente eCliente = new ECliente();
        eCliente.setCodigo(rs.getInt("CODIGO"));
        eCliente.setNome(rs.getString("NOME"));
        eCliente.setCpf(rs.getString("CPF"));
        eCliente.setTelefone(rs.getString("TELEFONE"));
        eCliente.setEndereco(rs.getString("ENDERECO"));
        eCliente.setFormaPagamento(rs.getString("FORMAPAGAMENTO"));
        lista.add(eCliente);

        return lista;
    }

}
