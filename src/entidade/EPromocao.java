/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.Scanner;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.codegen.CompilerConstants;

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
}

//    public static double promocaoQuantidade(EProduto eProduto) {
//
//        int pague;
//        int leve;
//        double valorFinal = 0;
//        int slp = 0;
//        double valorUnitario;
//        double valorDesconto;
//
//        valorUnitario = eProduto.getValorUnitario();
//
//        if (leve > pague) {
//            slp = leve - pague;
//
//        } else {
//            JOptionPane.showMessageDialog(null, "O Valor de LEVE tem que ser maior que o PAGUE");
//        }
//        valorDesconto = valorUnitario * slp;
//
//        valorFinal = (leve * valorUnitario) - valorDesconto;
//        double promo = valorFinal;
//        return valorFinal;
//
//    }
//
//}
