/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author vip
 */
public class EPromocao {
    
    private int codigo;
    private String drescricao;

    public EPromocao(int codigo, String drescricao) {
        this.codigo = codigo;
        this.drescricao = drescricao;
    }
    
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDrescricao() {
        return drescricao;
    }

    public void setDrescricao(String drescricao) {
        this.drescricao = drescricao;
    }
    
    public static String promocaoPorcentagem(){
        
        int n;
        double porcentagem;
        double valorDesconto;
        double valorFinal;
        Scanner leia = new Scanner(System.in);
        
        n = leia.nextInt();
        
        porcentagem = n/100.00;
        double valorUnitario = 0;
        
        valorDesconto = valorUnitario*porcentagem;
        
        valorFinal = valorUnitario - valorDesconto;

        //return valorFinal;
        return null;
    
}
    public static String promocaoQuantidade(){
        
        int pague = 3;
        int leve = 5;
        int valorFinal;
        int slp = 0;
        int valorUnitario = 0 ;
        int valorDesconto;
        
        
        if(leve > pague){
            slp = leve - pague;
            
        } else {
            JOptionPane.showMessageDialog(null, "o valor de leva tem  que ser maior que o pague");
        }
        valorDesconto = valorUnitario*slp;
        valorFinal = (leve*valorUnitario) - valorDesconto;
                
        return null;
        
    }
    
    
}
