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
    private Date data;
    private double valorTotal;
    
    private EFuncionario eFuncionario;
    private List<EItemPedido> eItemPedido;
    
    public EPedido(){
        eFuncionario = new EFuncionario();
        eItemPedido = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public EFuncionario geteFuncionario() {
        return eFuncionario;
    }

    public void seteFuncionario(EFuncionario eFuncionario) {
        this.eFuncionario = eFuncionario;
    }

    public List<EItemPedido> geteItemPedido() {
        return eItemPedido;
    }

    public void seteItemPedido(List<EItemPedido> eItemPedido) {
        this.eItemPedido = eItemPedido;
    }
    
}
