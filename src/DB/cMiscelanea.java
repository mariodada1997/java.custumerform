/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import javax.swing. JPanel;
import javax.swing. JTextField;

/**
 *
 * @author mariodada
 */
public class cMiscelanea {
    public void Deshabilitar(JPanel panel) {
        JTextField cajaTexto;
        for (int x=0; x<panel.getComponentCount(); x++) {
            if (panel.getComponent(x) instanceof JTextField) {
                cajaTexto=(JTextField) panel.getComponent(x);
                cajaTexto.setEditable(false);
            }
        }
    }
    public void Habilitar(JPanel panel) {
        JTextField cajaTexto;
        for (int x=0; x<panel.getComponentCount(); x++) {
            if (panel.getComponent(x) instanceof JTextField) {
                cajaTexto=(JTextField) panel.getComponent(x);
                cajaTexto.setEditable(true);
            }
        }
    }
    public void Limpiar(JPanel panel) {
        JTextField cajaTexto;
        for (int x=0; x<panel.getComponentCount(); x++) {
            if (panel.getComponent(x) instanceof JTextField) {
                cajaTexto=(JTextField) panel.getComponent(x);
                cajaTexto.setText("");
                if (cajaTexto.getName() == "txtNombre") {
                    cajaTexto.requestFocus();
                }
            }
        }
    }
  
    
    public cMiscelanea () { 
    }
}
