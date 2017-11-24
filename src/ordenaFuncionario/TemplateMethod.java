/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenaFuncionario;

import entidade.EFuncionario;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import persistencia.PFuncionario;

/**
 *
 * @author Pedro
 */
public abstract class TemplateMethod {

    public abstract boolean ePrimeiro(EFuncionario eFunionario1, EFuncionario eFuncionario2);

    public Iterator<EFuncionario> listagemDeFuncionario() throws Exception {
        try {
            ArrayList<EFuncionario> listaDeFuncionario = new ArrayList<EFuncionario>();

        //    PFuncionario pFuncionario = new PFuncionario().consultar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
