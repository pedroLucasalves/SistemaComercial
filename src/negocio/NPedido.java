/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EPedido;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PPedido;

/**
 *
 * @author Pedro
 */
public class NPedido {
    PPedido pPedido;
    
    public NPedido(){
        pPedido = new PPedido();
    }
    public void salvar(EPedido ePedido)throws SQLException, Exception{
       if(ePedido.getCodigo() == 0){
           pPedido.incluir(ePedido);
       }else{
           pPedido.alterar(ePedido);
       }
    }
    public void excluir(int codigo)throws SQLException, Exception{
        pPedido.excluir(codigo);
    }
    public EPedido consultar(int codigo)throws SQLException, Exception{
        return pPedido.consultar(codigo);
    }
    public ArrayList<EPedido> listar()throws SQLException, Exception{
        return EPedido.listar();
    }
}
