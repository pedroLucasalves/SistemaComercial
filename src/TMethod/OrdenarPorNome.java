/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TMethod;

import entidade.EFuncionario;

/**
 *
 * @author Joao
 */
public class OrdenarPorNome extends ProfessorTM{

    @Override
    public boolean ePrimeiro(EFuncionario funcionario1, EFuncionario funcionario2) {
        if(funcionario1.getNome().compareToIgnoreCase(funcionario2.getNome()) <= 0) return true;
        else return false;
    }
    
}
