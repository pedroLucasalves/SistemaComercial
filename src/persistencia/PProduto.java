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

/**
 *
 * @author Pedro
 */
public class PProduto {

    public void incluir(EProduto eProduto) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);

        try {
            String sq2 = "SELECT PRODUTO_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sq2);

            if (rs.next()) {
                eProduto.setCodigo(rs.getInt("CODIGO"));
            }
            rs.close();
            String sq1 = "INSERT INTO PRODUTO (CODIGO,NOME, VALOR,QUANTIDADE)"
                    + "VALUES (?,?,?,?)";

            PreparedStatement psd = cnn.prepareStatement(sq1);
            psd.setInt(1, eProduto.getCodigo());
            psd.setString(2, eProduto.getNome());
            psd.setDouble(3, eProduto.getValor());
            psd.setDouble(4, eProduto.getQuantidade());

            psd.execute();

            psd.close();
            cnn.commit();

        } catch (Exception e) {
            cnn.rollback();
        }
        cnn.close();
    }

    public void alterar(EProduto eProduto) {

    }

    public void excluir(int codigo) {

    }

    public EProduto consultar(int codigo) {
        return null;
    }

    public ArrayList<EProduto> listar() {
        return null;
    }

}
