/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.ECliente;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PCliente;

/**
 *
 * @author Pedro
 */
public class NCliente {
    
    PCliente pCliente;
    public NCliente() {
        pCliente = new PCliente();
    }
    public void salvar(ECliente eCliente)throws SQLException, Exception{
       if(eCliente.getCodigo() == 0){
           pCliente.incluir(eCliente);
       }else{
           pCliente.alterar(eCliente);
       }
    }
    public void excluir(int codigo)throws SQLException, Exception{
        pCliente.excluir(codigo);
    }
    public ECliente consultar(int codigo)throws SQLException, Exception{
        return pCliente.consultar(codigo);
    }
    public ArrayList<ECliente> listar()throws SQLException, Exception{
        return pCliente.listar();
    }
    
}
