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
public class ECliente extends EPessoa {
    private String formaPagamento;

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    @Override
    public String toString(){
        return "CLiente{"
                +"nome=" + nome
                +"cpf=" + cpf
                +"telefone=" + telefone
                +"endereco=" + endereco
                +"formaPagamento" + formaPagamento
                +'}';
    }
            
}
