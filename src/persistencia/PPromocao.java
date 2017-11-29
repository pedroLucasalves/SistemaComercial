/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EPromocao;
import java.sql.Connection;
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
            ResultSet rs = stm.executeQuery(Query.SELECT_SEQ_TIPOFUNCIONARIO);

            if (rs.next()) {
                ePromocao.setCodigo(rs.getInt("CODIGO"));
            }
            rs.close();

        } catch (Exception e) {
            cnn.rollback();
            throw e;
        }

    }

    public PPromocao() {
    }

    public void alterar(EPromocao ePromocao) {

    }

    public void excluir(int codigo) {

    }

    public EPromocao consultar(int codigo) {
        return null;
    }

    public ArrayList<EPromocao> listar() {
        return null;
    }

}
