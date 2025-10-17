
package finanmex.Licenciado.controller;

import finanmex.Licenciado.model.acreedor;
import finanmex.Licenciado.view.AltasAcreedor;
import finanmex.Licenciado.view.ConsultaAcreedores;
import finanmex.Licenciado.view.ModificarAcreedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import finanmex.Licenciado.model.AcreedorDAO;
import javax.swing.JOptionPane;

public class AcreedorController {
    private AcreedorDAO AD;
    private ModificarAcreedor MA;
    private AltasAcreedor AA;
    private ConsultaAcreedores CA;

    
    public AcreedorController(AltasAcreedor AA, AcreedorDAO AD){
        this.AA = AA;
        this.AD = AD;
        this.AA.addAgregarAcreedor(new AgregarAcreedor());
 
    }
    
    class AgregarAcreedor implements ActionListener{
        public void actionPerformed(ActionEvent e){
          
            AD.AgregarAcreedor(new acreedor(AA.getCampoNombre(),AA.getCampoApellido(),AA.getCampoCorreo(),AA.getCampoFecha(),AA.getCampoDireccion(),AA.getCampoTelefono(),AA.getCampoImagen()));
            System.out.println(AA.getCampoFecha());
            //Calendar calen = Calendar.getInstance();
            AA.campoNombre.setText("");
            AA.campoApellido.setText("");
            AA.campoCorreo.setText("");
            AA.campoTelefono.setText("");
            AA.campoDireccion.setText("");
            //AA.dateChooser.setDate(calen.getTime());
            AA.txtRutaImagen.setText("");
            AA.labelImagen.setIcon(null);
        }
    }
    
    public AcreedorController(ModificarAcreedor MA, AcreedorDAO AD){
        this.MA = MA;
        this.AD = AD;
        this.MA.addActualizarAcreedor(new ActualizarAcreedor());
    }
    class ActualizarAcreedor implements ActionListener{
        public void actionPerformed(ActionEvent e){
            AD.ActualizarAcreedor(new acreedor(MA.getCampoNombre(),MA.getCampoApellido(),MA.getCampoCorreo(),MA.getCampoFecha(),MA.getCampoDireccion(),MA.getCampoTelefono(),MA.getCampoImagen(),MA.getID()));
        }
    }
    
    
    
    
    public AcreedorController(ConsultaAcreedores CA,AcreedorDAO AD){
        this.AD = AD;
        this.CA = CA;
        this.CA.addEliminarAcreedor(new EliminarAcreedor());
    }
    
    class EliminarAcreedor implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id = CA.tabla.getSelectedRow();
            int ids = Integer.parseInt(CA.tabla.getValueAt(id, 0).toString());
            if (ids >= 0){
                AD.BorrarAcreedor(ids);
                JOptionPane.showMessageDialog(null, "Acreedor eliminado");             
            } else {
                
            }
        }
    }
}
