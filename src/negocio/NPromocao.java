/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import entidade.EPromocao;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PPromocao;



/**
 *
 * @author vip
 */
public class NPromocao {
    
    PPromocao pPromocao;
    
    public NPromocao(){
        pPromocao = new PPromocao();
    }
    
    public void salvar(EPromocao ePromocao)throws SQLException, Exception{
        if(ePromocao.getCodigo() == 0){
             PPromocao.incluir(ePromocao);
        }else{
            pPromocao.alterar(ePromocao);
        }
    }
    public void excluir(int codigo)throws SQLException, Exception{
        pPromocao.excluir(codigo);
    }
    public EPromocao consultar(int codigo)throws SQLException, Exception{
        return pPromocao.consultar(codigo);
    }
    public ArrayList<EPromocao> listar()throws SQLException, Exception{
        return pPromocao.listar();
    }
    
}
