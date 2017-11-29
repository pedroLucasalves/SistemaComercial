/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TMethod;
import entidade.EFuncionario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import persistencia.PFuncionario;
/**
 *
 * @author eugeniojulio
 */
public abstract class ProfessorTM {
    //Atributos
    //Metodos
    //Metodo abstrato que ira compor o algoritmo de ordenacao da listagem
    public abstract boolean ePrimeiro(EFuncionario funcionario1, EFuncionario funcionario2);
    
    public Iterator<EFuncionario> listagemDeProfessor()throws Exception{
        try{
            ArrayList<EFuncionario> array = new ArrayList<EFuncionario>();
            PFuncionario pf = new PFuncionario();
            array = pf.listar();

            //algoritmo de Ordenação
            for (int i = 0; i < array.size(); i++) {
                for (int j = i; j < array.size(); j++) {
                    
                    if (!ePrimeiro(array.get(i),array.get(j))) {    
                        EFuncionario temp = array.get(j);
                        array.set(j, array.get(i));
                        array.set(i, temp);
                    }
                }
            }
            return array.iterator();
        }catch(Exception erro){
            throw erro;
        } 
    }
    
}
