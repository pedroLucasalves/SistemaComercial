package entidade;

public class EProduto {

    private int codigo;
    private String nome;
    private String descricao;
    private double valorUnitario;
    private double quantidade;
    private EPromocao ePromocao;

    public EPromocao getePromocao() {
        return ePromocao;
    }

    public void setePromocao(EPromocao ePromocao) {
        this.ePromocao = ePromocao;
    }

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

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString(){
        return "Produto{" +
                "nome =" + nome
                + "descricao =" + descricao
                +"valorUnitario =" + valorUnitario
                +"quantidade =" + quantidade
                +"promocao =" + ePromocao
                + '}';
    }
    
    
}
