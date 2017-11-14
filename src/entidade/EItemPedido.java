/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author Pedro
 */
public class EItemPedido {

    private int codigo;
    private double quantidade;
    private double valor;

    private EPedido ePedido;
    private EProduto eProduto;

    public EItemPedido(){
        ePedido = new EPedido();
        eProduto = new EProduto();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public EPedido getePedido() {
        return ePedido;
    }

    public void setePedido(EPedido ePedido) {
        this.ePedido = ePedido;
    }

    public EProduto geteProduto() {
        return eProduto;
    }

    public void seteProduto(EProduto eProduto) {
        this.eProduto = eProduto;
    }
    
    
    
    
}
