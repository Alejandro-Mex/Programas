
package finanmex.Licenciado.controller;

import finanmex.Licenciado.model.DevolucionDAO;
import finanmex.Licenciado.model.devolucion;
import finanmex.Licenciado.view.ConsultaDevoluciones;
import finanmex.Licenciado.view.RegistroDevolucion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class DevolucionController {
    private DevolucionDAO DD;
    private RegistroDevolucion RD;
    private ConsultaDevoluciones CD;
    
    public DevolucionController(RegistroDevolucion RD, DevolucionDAO DD){
        this.RD = RD;
        this.DD = DD;
        this.RD.addAgregarDevolucion(new AgregarDevolucion());
    }
    
    class AgregarDevolucion implements ActionListener{
        public void actionPerformed(ActionEvent e){
           DD.AgregarDevolucion(new devolucion(RD.getCampoAbono(),RD.getCampoMora(),RD.getCampoSemana(),RD.getCampoFecha(),RD.getCampoSaldoRes(),RD.getCampoSemanaRes(),RD.getIdAcreedor())); 
            System.out.println(RD.getCampoFecha()); 
           System.out.println("Funciono");
        }
    }
    
   public DevolucionController(ConsultaDevoluciones CD, DevolucionDAO DD){
       this.DD = DD;
       this.CD = CD;
       this.CD.addEliminarDevolucion(new EliminarDevolucion());
   }
   
    class EliminarDevolucion implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int id = CD.tabla.getSelectedRow();
            int ids = Integer.parseInt(CD.tabla.getValueAt(id, 0).toString());
            if (ids >=0){
                DD.borrarDevolucion(ids);
                JOptionPane.showMessageDialog(null, "Devolucion Borrado");
            }
        }
    }
}
