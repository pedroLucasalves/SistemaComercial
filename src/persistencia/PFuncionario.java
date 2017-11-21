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

/**
 *
 * @author Pedro
 */
public class PFuncionario {

    public void incluir(EFuncionario eFuncionario) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            String sq2 = "SELECT FUNCIONARIO_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sq2);

            if (rs.next()) {
                eFuncionario.setCodigo(rs.getInt("CODIGO"));
            }
            rs.close();
            String sq1 = "INSERT INTO FUNCIONARIO"
                    + "(CODIG,NOME,CPF,TELEFONE,ENDERECO,RG, COD_TIPOFUNCIONARIO"
                    + "(?,?,?,?,?,?,?)";
            PreparedStatement psd = cnn.prepareStatement(sq1);
            psd.setInt(1, eFuncionario.getCodigo());
            psd.setString(2, eFuncionario.getNome());
            psd.setString(3, eFuncionario.getCpf());
            psd.setString(4, eFuncionario.getTelefone());
            psd.setString(5, eFuncionario.getEndereco());
            psd.setString(6, eFuncionario.getRg());
            psd.setInt(7, eFuncionario.geteTipoFuncionario().getCodigo());

            psd.close();
            cnn.commit();

        } catch (Exception e) {
            cnn.rollback();
        }
    }

    public void alterar(EFuncionario eFuncionario) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);

        try {
            String sq1 = "UPDATE FUNCIONARIO"
                    + " SET NOME = ?"
                    + " CPF = ?"
                    + " TELEFONE = ?"
                    + " ENDERECO = ?"
                    + " RG = ?"
                    + " COD_TIPOFUNCIONARIO"
                    + " WHERE = CODIGO = ?";

            PreparedStatement psd = cnn.prepareStatement(sq1);
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
        }
        cnn.close();
    }

    public void excluir(int codigo) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            String sq1 = "DELETE FROM FUNCIONARIO WHERE CODIGO = ?";

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

    public EFuncionario consultar(int codigo) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();

        String sq1 = "SELECT CODIGO, NOME, CPF, TELEFONE, ENDERECO, RG,"
                + " COD_FUNCIONARIO"
                + " FROM FUNCIONARIO WHERE CODIGO = ?";

        PreparedStatement psd = cnn.prepareStatement(sq1);

        psd.setInt(1, codigo);

        ResultSet rs = psd.executeQuery();
        EFuncionario eFuncionario = new EFuncionario();

        if (rs.next()) {
            eFuncionario.setCodigo(rs.getInt("CODIGO"));
            eFuncionario.setNome(rs.getString("NOME"));
            eFuncionario.setCpf(rs.getString("CPF"));
            eFuncionario.setTelefone(rs.getString("TELEFONE"));
            eFuncionario.setEndereco(rs.getString("ENDERECO"));
            eFuncionario.setRg(rs.getString("RG"));
            eFuncionario.seteTipoFuncionario(new PTipoFuncionario().consultar(rs.getInt("COD_FUNCIONARIO")));
        }
        psd.close();
        cnn.close();
        return eFuncionario;
    }

    public List<EFuncionario> listar() throws ClassNotFoundException, Exception {
        List<EFuncionario> lista = new ArrayList<>();

        Connection cnn = util.UConexao.getConexao();

        String sq1 = "SELECT * FROM FUNCIONARIO ORDER BY NOME";

        PreparedStatement psd = cnn.prepareStatement(sq1);

        ResultSet rs = psd.executeQuery();
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
