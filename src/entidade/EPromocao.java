
package entidade;

import java.util.Scanner;
import javax.swing.JOptionPane;


public class EPromocao {

    private int codigo;
    private String descricao;
    private int pague;
    private int leve;
    private double valorFinal;
    private double valorDesconto;
    private double porcentagem;
    private double valorUnitario;
    private int slp;
    private int x;
    

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

    public int getPague() {
        return pague;
    }

    public void setPague(int pague) {
        this.pague = pague;
    }

    public int getLeve() {
        return leve;
    }

    public void setLeve(int leve) {
        this.leve = leve;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getSlp() {
        return slp;
    }

    public void setSlp(int slp) {
        this.slp = slp;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
        public void promocaoQuantidade() {
   
        EProduto eProduto = new EProduto();

        Scanner scan = new Scanner(System.in);
        
        pague = scan.nextInt();
        leve = scan.nextInt();

        valorUnitario = eProduto.getValorUnitario();

        if (leve > pague) {
            slp = leve - pague;

        } else {
            JOptionPane.showMessageDialog(null, "O Valor de LEVE tem que ser maior que o PAGUE");
        }
        valorDesconto = valorUnitario * slp;

        valorFinal = (leve * valorUnitario) - valorDesconto;
        
        JOptionPane.showMessageDialog(null,"Pague" + pague + "Leve" + leve);
        JOptionPane.showMessageDialog(null,"Valor Final: " + valorFinal + "Valor Desconto: " + valorDesconto);
       
        

    }
    
    public void promocaoPorcentagem (){
        
        EProduto eProduto = new EProduto();
        
        valorUnitario = eProduto.getValorUnitario();
        
        Scanner scan = new Scanner(System.in);
        
        x = scan.nextInt();
        
        
        porcentagem = x /100;
        
        valorDesconto =  valorUnitario * porcentagem;
        
        valorFinal = valorUnitario - valorDesconto;
        
        JOptionPane.showMessageDialog(null,"Desconto de " + x + " %.");
        JOptionPane.showMessageDialog(null, "Valor Final: "+valorFinal +"Valor Dosconto: " +valorDesconto);
        
      
  
    }


}


