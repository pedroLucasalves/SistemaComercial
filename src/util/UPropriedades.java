/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Pedro
 */
public class UPropriedades {
    public static String getProp(String nome)throws IOException{
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "src\\propriedades\\Propriedades.properties");
        props.load(file);
        return props.getProperty(nome);
    }
}
