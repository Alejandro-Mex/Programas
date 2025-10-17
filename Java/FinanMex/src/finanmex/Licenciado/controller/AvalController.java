package finanmex.Licenciado.controller;

import finanmex.Licenciado.model.AvalDAO;
import finanmex.Licenciado.model.aval;
import finanmex.Licenciado.view.AltasAval;
import finanmex.Licenciado.view.ConsultaAval;
import finanmex.Licenciado.view.ModificarAval;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AvalController {
    private AvalDAO AD;
    private ModificarAval MA;
    private AltasAval AA;
    private ConsultaAval CA;
    
    public AvalController(AltasAval AA, AvalDAO AD){
        this.AA = AA;
        this.AD = AD;
        this.AA.addAgregarAval(new AgregarAval());
    }
    
    class AgregarAval implements ActionListener{
        public void actionPerformed(ActionEvent e){
            AD.AgregarAval(new aval(AA.getCampoNombre(),AA.getCampoApellido(),AA.getCampoFecha(),AA.getCampoDireccion(),AA.getCampoTelefono(),AA.getCampoParentesco(),AA.getCampoImagen()));
            AA.campoNombre.setText("");
            AA.campoApellido.setText("");
            AA.campoDireccion.setText("");
            AA.campoTelefono.setText("");
            AA.campoParentesco.setText("");
            AA.txtRutaImagen.setText("");
            AA.labelImagen.setIcon(null);
        }
    }
    
    public AvalController(ModificarAval MA, AvalDAO AD){
        this.MA = MA;
        this.AD = AD;
        this.MA.addActualizarAval(new ActualizarAval());
    }
    
    class ActualizarAval implements ActionListener{
        public void actionPerformed(ActionEvent e){
            AD.ActualizarAval(new aval(MA.getCampoNombre(),MA.getCampoApellido(),MA.getCampoFecha(),MA.getCampoDireccion(),MA.getCampoTelefono(),MA.getCampoParentesco(),MA.getCampoImagen(),MA.getID()));
        }
    }
    
    public AvalController(ConsultaAval CA, AvalDAO AD){
        this.AD = AD;
        this.CA = CA;
        this.CA.addEliminarAval(new EliminarAval());
    }
    
    class EliminarAval implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id = CA.tabla.getSelectedRow();
            int ids = Integer.parseInt(CA.tabla.getValueAt(id, 0).toString());
            if (ids >= 0){
                AD.BorrarAval(ids);
                JOptionPane.showMessageDialog(null, "Aval eliminado"); 
                
            }
        }
    }
}
