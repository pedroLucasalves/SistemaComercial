/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Pedro
 */
public class Query {
    //Funcionario
    
    //TipoFuncionario
    public static final String INSERT_TIPOFUNCIONARIO = "INSERT INTO TIPOFUNCIONARIO"
                                                     +"(CODIGO,DESCRICAO) VALUES"
                                                     + "(?,?)";
    public static final String SELECT_SEQ_TIPOFUNCIONARIO = "SELECT TIPOFUNCIONARIO_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
    public static final String UPDATE_TIPOFUNCIONARIO = "UPDATE TIPOFUNCIONARIO SET "
                                                      + "DESCRICAO = ? WHERE CODIGO = ?";
    
    public static final String DELETE_TIPOFUNCIONARIO = "DELETE FROM TIPOFUNCIONARIO WHERE CODIGO = ?";
    public static final String SELECT_TIPOFUNCIONARIO = "SELECT * FROM TIPOFUNCIONARIO WHERE CODIGO = ?";
    public static final String SELECT_ALL_TIPOFUNCIONARIO = "SELECT * FROM TIPOFUNCIONARIO ORDER BY CODIGO";
                                                      
    //Cliente
    
    //Fornecedor
    
    //Produto
}
