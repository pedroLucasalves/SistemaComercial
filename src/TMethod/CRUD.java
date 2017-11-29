/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TMethod;

import entidade.EFuncionario;
import java.util.ArrayList;

/**
 *
 * @author Joao
 */
public interface CRUD {
    public ArrayList<EFuncionario> recuperar()throws Exception;
}
