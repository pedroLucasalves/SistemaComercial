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
            + "NOME = ?, CPF = ?, TELEFONE = ?, ENDERECO = ?, FORMADEPAGAMENTO = ?  WHERE CODIGO = ?";
    public static final String DELETE_CLIENTE = "DELETE FROM CLIENTE WHERE CODIGO = ?";
    public static final String SELECT_CLIENTE = "SELECT * FROM CLIENTE WHERE CODIGO = ?";
    public static final String SELECT_ALL_CLIENTE = "SELECT * FROM CLIENTE ORDER BY CODIGO";

    //Fornecedor
    public static final String INSERT_FORNECEDOR = "INSERT INTO FORNECEDOR"
            + "(CODIGO, NOME, CNPJ, TELEFONE, EMAIL, ENDERECO) VALUES"
            + "(?,?,?,?,?,?)";
    public static final String SELECT_SEQ_FORNECEDOR = "SELECT FORNECEDOR_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
    public static final String UPDATE_FORNECEDOR = "UPDATE FORNECEDOR SET "
            + "NOME = ?, CNPJ = ?, TELEFONE = ?, EMAIL = ?, ENDERECO = ? WHERE CODIGO = ?";
    public static final String DELETE_FORNECEDOR = "DELETE FROM FORNECEDOR WHERE CODIGO = ?";
    public static final String SELECT_FORNECEDOR = "SELECT * FROM FORNECEDOR WHERE CODIGO = ?";
    public static final String SELECT_ALL_FORNECEDOR = "SELECT * FROM FORNECEDOR ORDER BY CODIGO";

    //Produto
    public static final String INSERT_PRODUTO = "INSERT INTO PRODUTO"
            + "(CODIGO, NOME, VALORUNITARIO, QUANTIDADE, DESCRICAO) VALUES"
            + "(?,?,?,?,?)";
    public static final String SELECT_SEQ_PRODUTO = "SELECT PRODUTO_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
    public static final String UPDATE_PRODUTO = "UPDATE PRODUTO SET "
            + "NOME = ?, VALORUNITARIO = ?, QUANTIDADE = ?, DESCRICAO = ? WHERE CODIGO = ?";
    public static final String DELETE_PRODUTO = "DELETE FROM PRODUTO WHERE CODIGO = ?";
    public static final String SELECT_PRODUTO = "SELECT * FROM PRODUTO WHERE CODIGO = ?";
    public static final String SELECT_ALL_PRODUTO = "SELECT * FROM PRODUTO ORDER BY CODIGO";

    //Pedido
    public static final String INSERT_PEDIDO = "INSERT INTO PEDIDO"
            + "(CODIGO, NOW(DATAHORA), VALORTOTAL, COD_FUNCIONARIO) VALUES "
            + "(?,?,?,?)";
    public static final String SELECT_SEQ_PEDIDO = "SELECT PEDIDO_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
    public static final String UPDATE_PEDIDO = "UPDATE PEDIDO SET "
            + "DATAHORA = ?, VALORTOTAL = ?, COD_FUNCONARIO = ? WHERE CODIGO = ?";
    public static final String DELETE_PEDIDO = "DELETE FROM PEDIDO WHERE CODIGO = ?";
    public static final String SELECT_PEDIDO = "SELECT * FROM PEDIDO WHERE CODIGO = ?";
    public static final String SELECT_ALL_PEDIDO = "SELECT * FROM PEDIDO ORDER BY CODIGO";

    //Item pedido
    public static final String INSERT_ITEMPEDIDO = "INSERT INTO ITEMPEDIDO"
            + "(CODIGO, QUANTIDADE, COD_PEDIDO, COD_PRODUTO) VALUES"
            + "(?,?,?,?)";
    public static final String SELECT_SEQ_ITEMPEDIDO = "SELECT ITEMPEDIDO_CODIGO_SEQ>NEXTVAL AS CODIGO FROM DUAL";
    public static final String UPDATE_ITEMPEDIDO = "UPDATE ITEMPEDIDO SET "
            + "QUANTIDADE, COD_PEDIDO, COD_PRODUTO WHERE CODIGO = ?";
    public static final String DELETE_ITEMPEDIDO = "DELETE ITEMPEDIDO WHERE CODIGO = ?";
    public static final String SELECT_ITEMPEDIDO = "SELECT * FROM ITEMPEDIDO WHERE CODIGO = ?";
    public static final String SELECT_ALL_ITEMPEDIDO = "SELECT * FROM ITEMPEDIDO ORDER BY CODIGO";
    //public 
    //promocao
    public static final String INSERT_PROMOCAO = "INSERT INTO PROMOCAO"
            + " (CODIGO, DESCRICAO) VALUES"
            + "(?,?)";
    public static final String SELECT_SEQ_PROMOCAO = "SELECT PROMOCAO_CODIGO_SEQ.NEXTVAL AS CODIGO FROM DUAL";
    public static final String UPDATE_PROMOCAO = "UPDATE PROMOCAO SET "
            + "DESCRICAO = ?,VALORDESCONTO =?, VALORFINAL =? WHERE CODIGO = ?";
    public static final String DELETE_PROMOCAO = "DELETE FROM PROMOCAO WHERE CODIGO = ?";
    public static final String SELECT_PROMOCAO = "SELECT * FROM PROMOCAO WHERE CODIGO = ?";
    public static final String SELECT_ALL_PROMOCAO = "SELECT * FROM PROMOCAO ORDER BY CODIGO";

}
