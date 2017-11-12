/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pedro
 */
public class UConexao {

    private static Connection conexao = null;

    public static synchronized Connection getConexao() throws IOException, ClassNotFoundException, Exception {
        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = conectar();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return conexao;
    }

    private static Connection conectar() throws IOException, ClassNotFoundException, Exception {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@"
                    + UPropriedades.getProp("db.host")
                    + ":1521:xe",
                    UPropriedades.getProp("db.user"),
                    UPropriedades.getProp("db.password"));
        } catch (Exception e) {
            throw e;
        }
    }
}
