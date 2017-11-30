/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class EPedido {

    private int codigo;
    private Date dataHora;
    private double valorTotal;
    
    private EFuncionario eFuncionario;
    private List<EItemPedido> ListaPedido;
    
    public EPedido(){
        eFuncionario = new EFuncionario();
        ListaPedido = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date data) {
        this.dataHora = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public void setValorTotalAcumulando(double valor) {
        this.valorTotal += valor;
    }

    public EFuncionario geteFuncionario() {
        return eFuncionario;
    }

    public void seteFuncionario(EFuncionario eFuncionario) {
        this.eFuncionario = eFuncionario;
    }

    public List<EItemPedido> geteItemPedido() {
        return ListaPedido;
    }

    public void seteItemPedido(List<EItemPedido> eItemPedido) {
        this.ListaPedido = eItemPedido;
    }
    
}
