/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EItemPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Pedro
 */
public class PItemPedido {

    public void incluir(EItemPedido eItemPedido, Connection cnn) throws SQLException, Exception {
        String sq1 = "INSERT INTO ITEMPEDIDO(QUANTIDADE, VALOR, COD_PEDIDO, COD_PRODUTO"
                    +"VALUES (?,?,?,?);";
        
        PreparedStatement psd = cnn.prepareStatement(sq1);
        
        psd.setDouble(1, eItemPedido.getQuantidade());
        psd.setDouble(2,eItemPedido.getValor());
        psd.setInt(3,eItemPedido.getePedido().getCodigo());
        psd.setInt(4,eItemPedido.geteProduto().getCodigo());
        
        
        psd.execute();
    }
}