/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EItemPedido;
import entidade.EPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import util.Query;

/**
 *
 * @author Pedro
 */
public class PPedido {

    public void incluir(EPedido ePedido) throws ClassNotFoundException, Exception {

        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(Query.SELECT_SEQ_PEDIDO);

            if (rs.next()) {
                ePedido.setCodigo(rs.getInt("CODIGO"));
            }
            rs.close();

            PreparedStatement psd = cnn.prepareStatement(Query.INSERT_PEDIDO);
            psd.setInt(1, ePedido.getCodigo());
            psd.setDate(2, ePedido.getDataHora());
            psd.setDouble(3, ePedido.getValorTotal());
            psd.setInt(4, ePedido.geteFuncionario().getCodigo());

            psd.execute();
            PItemPedido itemPedido = new PItemPedido();
            for (EItemPedido item : ePedido.geteItemPedido()) {
                item.getePedido().setCodigo(ePedido.getCodigo());

                itemPedido.incluir(item, cnn);
            }

            cnn.commit();
            psd.close();
        } catch (Exception e) {
            cnn.rollback();
            throw e;
        }
        cnn.setAutoCommit(true);

    }

    public void alterar(EPedido ePedido) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            PreparedStatement psd = cnn.prepareStatement(Query.UPDATE_PEDIDO);
            psd.setDate(1, ePedido.getDataHora());
            psd.setDouble(1, ePedido.getValorTotal());
            psd.setInt(3, ePedido.geteFuncionario().getCodigo());
            psd.setInt(4, ePedido.getCodigo());

            psd.executeUpdate();
            cnn.commit();

        } catch (Exception e) {
            cnn.rollback();
            throw e;
        }
        cnn.setAutoCommit(true);
    }

    public void excluir(int codigo) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        cnn.setAutoCommit(false);

        try {
            PreparedStatement psd = cnn.prepareStatement(Query.DELETE_PEDIDO);
            psd.setInt(1, codigo);

            psd.execute();
            cnn.commit();
            psd.close();
        } catch (Exception e) {
            cnn.rollback();
            throw e;
        }
    }

    public EPedido consultar(int codigo) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();

        PreparedStatement psd = cnn.prepareStatement(Query.SELECT_PEDIDO);

        psd.setInt(1, codigo);

        ResultSet rs = psd.executeQuery();
        EPedido ePedido = null;

        if (rs.next()) {
            ePedido = new EPedido();
            ePedido.setCodigo(rs.getInt("CODIGO"));
            ePedido.setDataHora(rs.getDate("DATA"));
            ePedido.setValorTotal(rs.getDouble("VALORTOTAL"));
            ePedido.seteFuncionario(new PFuncionario().consultar(rs.getInt("COD_FUNCIONARIO")));
        }
        psd.close();
        rs.close();
        return ePedido;
    }

    public ArrayList<EPedido> listar() throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(Query.SELECT_ALL_PEDIDO);

        EPedido ePedido = null;
        ArrayList<EPedido> lista = null;
        PFuncionario pFuncionario = null;

        while (rs.next()) {
            if (lista == null) {
                lista = new ArrayList<>();
            }
            if (pFuncionario == null) {
                pFuncionario = new PFuncionario();
            }
            ePedido = new EPedido();
            ePedido.setCodigo(rs.getInt("CODIGO"));
            ePedido.setDataHora(rs.getDate("DATAHORA"));
            ePedido.setValorTotal(rs.getDouble("VALORTOTAL"));
            lista.add(ePedido);
        }
        return lista;
    }

}
