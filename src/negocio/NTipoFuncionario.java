/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.ETipoFuncionario;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PTipoFuncionario;

/**
 *
 * @author Pedro
 */
public class NTipoFuncionario {

    PTipoFuncionario per;

    public NTipoFuncionario() {
        per = new PTipoFuncionario();
    }
    public void salvar(ETipoFuncionario eTipoFuncionario)throws SQLException, Exception{
        if(eTipoFuncionario.getCodigo() == 0){
            per.incluir(eTipoFuncionario);
        }else{
            per.alterar(eTipoFuncionario);
        }
    }
    public void excluir(int codigo)throws SQLException{
        per.excluir(codigo);
    }
    public ETipoFuncionario consultar(int codigo) throws SQLException{
        return per.consultar(codigo);
    }
    public ArrayList<ETipoFuncionario> listar()throws SQLException{
        return per.listar();
    }
}
