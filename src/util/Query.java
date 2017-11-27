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
    public static final String INSERT_FUNCIONARIO = " INSERT INTO FUNCIONARIO"
            + "(CODIGO,NOME,CPF,TELEFONE,ENDERECO,RG,COD_TIPOFUNCIONARIO)VALUES"
            + "(?,?,?,?,?,?,?)";
    public static final String SELECT_SEQ_FUNCIONARIO = "SELECT FUNCIONARIO_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
    public static final String UPADTE_FUNCIONARIO = "UPDATE FUNCIONARIO SET "
            + "NOME = ?, CPF = ?, TELEFONE = ?, ENDERECO = ?, "
            + "RG = ?, COD_TIPOFUNCIONARIO = ? WHERE CODIGO = ?";
    public static final String DELETE_FUNCIONARIO = "DELETE FROM FUNCIONARIO WHERE CODIGO = ?";
    public static final String SELECT_FUNCIONARIO = "SELECT * FROM FUNCIONARIO WHERE CODIGO = ?";
    public static final String SELECT_ALL_FUNCIONARIO = "SELECT * FROM FUNCIONARIO ORDER BY CODIGO";

    //TipoFuncionario
    public static final String INSERT_TIPOFUNCIONARIO = "INSERT INTO TIPOFUNCIONARIO"
            + "(CODIGO,DESCRICAO) VALUES"
            + "(?,?)";
    public static final String SELECT_SEQ_TIPOFUNCIONARIO = "SELECT TIPOFUNCIONARIO_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
    public static final String UPDATE_TIPOFUNCIONARIO = "UPDATE TIPOFUNCIONARIO SET "
            + "DESCRICAO = ? WHERE CODIGO = ?";
    public static final String DELETE_TIPOFUNCIONARIO = "DELETE FROM TIPOFUNCIONARIO WHERE CODIGO = ?";
    public static final String SELECT_TIPOFUNCIONARIO = "SELECT * FROM TIPOFUNCIONARIO WHERE CODIGO = ?";
    public static final String SELECT_ALL_TIPOFUNCIONARIO = "SELECT * FROM TIPOFUNCIONARIO ORDER BY CODIGO";

    //Cliente
    public static final String INSERT_CLIENTE = "INSERT INTO CLIENTE"
            + "(CODIGO, NOME, CPF, TELEFONE, ENDERECO, FORMADEPAGAMENTO) VALUES"
            + "(?,?,?,?,?,?)";
    public static final String SELECT_SEQ_CLIENTE = " SELECT CLIENTE_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
    public static final String UPDATE_CLIENTE = "UPDATE CLIENTE SET "
            + "NOME = ?, CPF = ?, TELEFONE = ?, ENDERECO = ?, FORMADEPAGAMENTO = ? WHERE CODIGO = ?";
    public static final String DELETE_CLIENTE = "DELETE FROM CLIENTE WHERE CODIGO = ?";
    public static final String SELECT_CLIENTE = "SELECT * FROM CLIENTE WHERE CODIGO = ?";
    public static final String SELECT_ALL_CLIENTE = "SELECT * FROM CLIENTE ORDER BY CODIGO";

    //Fornecedor
    public static final String INSERT_FORNECEDOR = "INSERT INTO FORNECEDOR"
            + "(CODIGO, NOME, CNPJ, TELEFONE, EMAIL, ENDERECO) VALUES"
            + "(?,?,?,?,?,?)";
    public static final String SELECT_SEQ_FORNECEDOR = "SELECT FORNECEDOR_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
    public static final String UPDATE_FORNECEDOR = "UPDATE FORNECEDOR SET "
            + "CODIGO = ?, NOME = ?, CNPJ = ?, TELEFONE = ?, EMAIL = ?, ENDERECO = ?";
    public static final String DELETE_FORNECEDOR = "DELETE * FROM FORNECEDOR WHERE CODIGO = ?";
    public static final String SELECT_FORNECEDOR = "SELECT *FROM FORNECEDOR WHERE CODIGO = ?";
    public static final String SELECT_ALL_FORNECEDOR = "SELECT * FROM FORNECEDOR ORDER BY CODIGO";
    //Produto
}
