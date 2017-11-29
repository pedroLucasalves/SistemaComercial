/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TMethod;

import entidade.EFuncionario;
import TMethod.CRUD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import persistencia.PFuncionario;
import util.UConexao;

/**
 *
 * @author Joao
 */
public class FuncionarioDAO implements CRUD {

    public FuncionarioDAO() {
    }

    public ArrayList<EFuncionario> recuperar() throws Exception {
        PFuncionario pf = new PFuncionario();
        ArrayList<EFuncionario> lista = new ArrayList<>();
        lista = pf.listar();
        
return lista;
    }
}
