
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EProduto;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PProduto;

/**
 *
 * @author Pedro
 */
public class NProduto {

    PProduto pProduto;

    public NProduto() {
        pProduto = new PProduto();
    }

    public NProduto(EProduto parametro) {
        
    }

    public void salvar(EProduto eProduto) throws SQLException, Exception {
        if (eProduto.getCodigo() == 0) {
            pProduto.incluir(eProduto);
        } else {
            pProduto.alterar(eProduto);
        }
    }

    public void excluir(int codigo) throws SQLException, Exception {
        pProduto.excluir(codigo);
    }

    public EProduto consultar(int codigo) throws SQLException, Exception {
        return pProduto.consultar(codigo);
    }

    public ArrayList<EProduto> listar() throws SQLException, Exception {
        return pProduto.listar();
    }

}
