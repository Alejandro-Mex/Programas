package finanmex.Licenciado.controller;

import finanmex.Licenciado.model.CoordinadoraDAO;
import finanmex.Licenciado.model.acreedor;
import finanmex.Licenciado.model.coordinadora;
import finanmex.Licenciado.view.AltasCoordinadora;
import finanmex.Licenciado.view.ConsultaCoordinadora;
import finanmex.Licenciado.view.ModificarCoordinadora;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CoordinadoraController {
    private CoordinadoraDAO CD;
    private ModificarCoordinadora MC;
    private AltasCoordinadora AC;
    private ConsultaCoordinadora CC;
    
    public CoordinadoraController(AltasCoordinadora AC, CoordinadoraDAO CD){
        this.AC = AC;
        this.CD = CD;
        this.AC.addAgregarCoordinadora(new AgregarCoordinadora());
    }
    
    class AgregarCoordinadora implements ActionListener{
        public void actionPerformed(ActionEvent e){
            CD.AgregarCoordinadora(new coordinadora(AC.getCampoNombre(),AC.getCampoApellido(),AC.getCampoFecha(),AC.getCampoDireccion(),AC.getCampoTelefono(),AC.getCampoImagen()));
            AC.campoNombre.setText("");
            AC.campoApellido.setText("");
            AC.campoDireccion.setText("");
            AC.campoTelefono.setText("");
            AC.txtRutaImagen.setText("");
            AC.labelImagen.setIcon(null);
        }
    }
    
    public CoordinadoraController(ModificarCoordinadora MC, CoordinadoraDAO CD){
        this.MC = MC;
        this.CD = CD;
        this.MC.addActualizarCoordinadora(new ActualizarCoordinadora());
    }
    
    class ActualizarCoordinadora implements ActionListener{
        public void actionPerformed(ActionEvent e){
            CD.ActualizarCoordinadora(new coordinadora(MC.getCampoNombre(),MC.getCampoApellido(),MC.getCampoFecha(),MC.getCampoDireccion(),MC.getCampoTelefono(),MC.getCampoImagen(),MC.getID()));
        }
    }
    
    public CoordinadoraController(ConsultaCoordinadora CC, CoordinadoraDAO CD){
        this.CC = CC;
        this.CD = CD;
        this.CC.addEliminarCoordinadora(new EliminarCoordinadora());
    }
    
    class EliminarCoordinadora implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id = CC.tabla.getSelectedRow();
            int ids = Integer.parseInt(CC.tabla.getValueAt(id, 0).toString());
            if(ids >= 0){
                CD.BorrarCoordinadora(ids);
                JOptionPane.showMessageDialog(null, "Acreedor eliminado","Informacion",JOptionPane.OK_OPTION); 
            } else {
                
            }
        }
    }
}
