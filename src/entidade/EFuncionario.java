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
public class EFuncionario extends EPessoa {

    private int codigo;
    private String rg;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Funcionario{"
                + "nome=" + nome
                + "cpf=" + cpf
                + "telefone=" + telefone
                + "endereço=" + endereco
                + "rg=" + rg
                + '}';
    }

}
