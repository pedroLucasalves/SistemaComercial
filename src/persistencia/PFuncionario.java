/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EFuncionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class PFuncionario {

    public void incluir(EFuncionario eFuncionario) throws ClassNotFoundException, Exception {
        Connection cnn = util.UConexao.getConexao();

        String sq1 = "INSERT INTO FUNCIONARIO"
                + "(NOME,CPF,TELEFONE,ENDERECO,RG"
                + "(?,?,?,?,?);";
        PreparedStatement psd = cnn.prepareStatement(sq1);

        psd.setString(1, eFuncionario.getNome());
        psd.setString(2, eFuncionario.getCpf());
        psd.setInt(3, eFuncionario.getTelefone());
        psd.setString(4, eFuncionario.getEndereco());
        psd.setString(5, eFuncionario.getRg());
        
        String sq2 = "SELECT currval('FUNCIONARIO_COD_SEQ') as codigo";
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sq2);
        if(rs.next()){
            int codigo = rs.getInt("CODIGO");
        }
    }

    public void alterar(EFuncionario eFuncionario) {
        

    }

    public void excluir(int codigo) {

    }

    public EFuncionario consultar(int codigo) {
        return null;
    }

    public ArrayList<EFuncionario> listar() {
        return null;
    }

}
