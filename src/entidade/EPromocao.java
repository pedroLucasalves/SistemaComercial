
package entidade;

import java.util.Scanner;
import javax.swing.JOptionPane;


public class EPromocao {

    private int codigo;
    private String descricao;
    private int quantidade;
    private double valorTotal;
    private double percentualDesconto;
    private EProduto eproduto;
    
    

    public EPromocao(int codigo, String drescricao) {
        this.codigo = codigo;
        this.descricao = drescricao;
    }

    public EPromocao() {
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;

    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    

    public EProduto getEproduto() {
        return eproduto;
    }

    public void setEproduto(EProduto eproduto) {
        this.eproduto = eproduto;
    }

    
    public void descontoPagueLeve(int qtdePague, int qtdeLeve) {
        quantidade = qtdeLeve;
        valorTotal = qtdeLeve * eproduto.getValorUnitario();
        percentualDesconto = ((qtdeLeve * eproduto.getValorUnitario() / qtdePague * eproduto.getValorUnitario())-1)*100;
    }
    
    public void descontoPorcentagem(double porcentagem) {
        quantidade = 1;
        valorTotal = eproduto.getValorUnitario();
        percentualDesconto = porcentagem / 100;
    }


}