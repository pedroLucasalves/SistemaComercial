/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Adapter;

import java.util.Arrays;

public class Adaptador implements Conversor{
    public String ParaString (Object objeto) {
     return objeto + "";
    }
   
}