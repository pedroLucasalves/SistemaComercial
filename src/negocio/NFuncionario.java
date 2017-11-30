/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EFuncionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.PFuncionario;

/**
 *
 * @author Pedro
 */
public class NFuncionario {

    PFuncionario pFuncionario;

    public NFuncionario() {
        pFuncionario = new PFuncionario();
    }

    public void salvar(EFuncionario eFuncionario) throws SQLException, Exception {
        if (eFuncionario.getCodigo() == 0) {
            pFuncionario.incluir(eFuncionario);
        } else {
            pFuncionario.alterar(eFuncionario);
        }
    }

    public void excluir(int codigo) throws SQLException, Exception {
        pFuncionario.excluir(codigo);
    }

    public EFuncionario consultar(int codigo) throws SQLException, Exception {
        return pFuncionario.consultar(codigo);
    }

    public List<EFuncionario> listar() throws SQLException, Exception {
        return pFuncionario.listar();
    }

    public Iterable<EFuncionario> listar(EFuncionario eFuncionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
