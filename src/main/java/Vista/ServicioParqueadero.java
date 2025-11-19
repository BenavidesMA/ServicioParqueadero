/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Vista;

import GUI.*;
import Modelo.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Usuario
 */
public class ServicioParqueadero {

    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        EventQueue.invokeLater(() -> {

            VentanaPrincipal principal = new VentanaPrincipal();

            principal.pack();
            principal.setVisible(true);
        });

    }
}
