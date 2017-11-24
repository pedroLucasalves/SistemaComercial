/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EFornecedor;
import java.sql.SQLException;
import java.util.List;
import persistencia.PFornecedor;

/**
 *
 * @author Pedro
 */
public class NFornecedor {

    PFornecedor pFornecedor;

    public NFornecedor() {
        pFornecedor = new PFornecedor();
    }

    public void salvar(EFornecedor eFornecedor) throws SQLException, Exception {
        if (eFornecedor.getCodigo() == 0) {
            pFornecedor.incluir(eFornecedor);
        } else {
            pFornecedor.alterar(eFornecedor);
        }
    }
    public void excluir(int codigo) throws SQLException, Exception {
        pFornecedor.excluir(codigo);
    }
    public  EFornecedor consultar(int codigo)throws SQLException, Exception{
        
        return pFornecedor.consultar(codigo);
    }
    public List<EFornecedor> listar()throws SQLException, Exception{
       return pFornecedor.listar(); 
    }

}
