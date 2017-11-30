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
    private ETipoFuncionario eTipoFuncionario;

    public EFuncionario() {
        eTipoFuncionario = new ETipoFuncionario();
    }

    public EFuncionario(ETipoFuncionario eTipoFuncionario) {
        this.eTipoFuncionario = eTipoFuncionario;
    }

    public EFuncionario(int codigo, String nome) {
        eTipoFuncionario = new ETipoFuncionario();
        this.codigo = codigo;
        this.nome = nome;
    }

    public EFuncionario(int codigo, String nome, String cpf, String telefone,
            String endereco, String rg, ETipoFuncionario eTipoFuncionario) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.rg = rg;
        this.eTipoFuncionario = eTipoFuncionario;

    }

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

    public ETipoFuncionario geteTipoFuncionario() {
        return eTipoFuncionario;
    }

    public void seteTipoFuncionario(ETipoFuncionario eTipoFuncionario) {
        this.eTipoFuncionario = eTipoFuncionario;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
