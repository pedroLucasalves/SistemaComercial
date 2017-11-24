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
public class EFornecedor {
    private int codigo;
    private String nome;
    private String cnpj;
    private int telefone;
    private String email;
    private String endereco;
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String toString(){
        return "Fornecedor {"
                + "codigo = " + codigo
                + "nome =" + nome
                + "cnpj =" + cnpj
                +"telefone =" + telefone
                + "email =" + email
                +"endereco =" + endereco
                + '}';
    }
    
}
