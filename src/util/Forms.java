/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author Pedro
 */
public class Forms {

    public static void centralizar(JInternalFrame objeto) {
        Dimension d = objeto.getDesktopPane().getSize();
        objeto.setLocation((d.width - objeto.getSize().width) / 2, (d.height - objeto.getSize().height) / 2);
    }
}
