/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;
public class ToString implements Conversor{
     public String ParaString (Object objeto){
        return objeto.toString();
    }
}
