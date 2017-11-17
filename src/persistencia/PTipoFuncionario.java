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
import javax.swing.plaf.basic.BasicBorders;

/**
 *
 * @author Pedro
 */
public class PTipoFuncionario {

    public void incluir(ETipoFuncionario eTipoFuncionario) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {

            String sq1 = "INSERT INTO TIPOFUNCIONARIO"
                    + "(descricao) VALUES"
                    + "(?);";
            PreparedStatement ps = cnn.prepareStatement(sq1);

            ps.setString(1, eTipoFuncionario.getDescricao());
            ps.execute();

            String sql2 = "SELECT currval('TIPOFUNCIONARIO_CODIGO_SEQ') as codigo;";
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sql2);

            if (rs.next()) {
                int codigo = rs.getInt("CODIGO");
            }
            cnn.commit();
            rs.close();
        } catch (Exception e) {
            cnn.rollback();
        }

        cnn.close();
    }

    public void alterar(ETipoFuncionario eTipoFuncionario) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        try {
            String sq1 = "UPDATE TIPOFUNCIONARIO SET DESCRICAO = ?, WHERE CODIGO = ?;";

            PreparedStatement psd = cnn.prepareStatement(sq1);

            psd.setString(1, eTipoFuncionario.getDescricao());
            psd.setInt(2, eTipoFuncionario.getCodigo());

            psd.execute();
            psd.close();
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
            String sq1 = "DELETE * FROM TIPOFUNCIONARIO WHERE CODIGO = ?;";

            PreparedStatement psd = cnn.prepareStatement(sq1);

            psd.setInt(1, codigo);

            psd.execute();
            psd.close();

        } catch (Exception e) {
            cnn.rollback();
        }
        cnn.close();
    }

    public ETipoFuncionario consultar(int codigo) throws ClassNotFoundException, Exception {
        String sq1 = "SELECT * FROM TIPOFUNCIONARIO WHERE CODIGO = ?;";

        Connection cnn = util.UConexao.getConexao();
        PreparedStatement psd = cnn.prepareStatement(sq1);

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
        cnn.close();
        return objeto;
    }

    public ArrayList<ETipoFuncionario> listar() throws ClassNotFoundException, Exception {
        String sq1 = "SELECT * FROM TIPOFUNCIONARIO ORDEY BY CODIGO;";

        Connection cnn = util.UConexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sq1);
        ArrayList<ETipoFuncionario> lista = new ArrayList<ETipoFuncionario>();
        while (rs.next()) {
            ETipoFuncionario objeto = new ETipoFuncionario();
            objeto.setCodigo(rs.getInt("CODIGO"));
            objeto.setDescricao(rs.getString("DESCRICAO"));
        }
        stm.close();
        rs.close();
        cnn.close();
        return lista;
    }

}
