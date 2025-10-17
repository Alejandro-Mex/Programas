
package finanmex.Licenciado.controller;

import finanmex.Licenciado.model.RenovacionDAO;
import finanmex.Licenciado.model.renovacion;
import finanmex.Licenciado.view.ConsultaRenovacion;
import finanmex.Licenciado.view.RegistroRenovacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class RenovacionController {
    private RenovacionDAO RD;
    private RegistroRenovacion RR;
    private ConsultaRenovacion CR;
    
    public RenovacionController(RegistroRenovacion RR, RenovacionDAO RD){
        this.RR = RR;
        this.RD = RD;
        this.RR.addAgregarRenovacion(new AgregarRenovacion());
    }
    
    class AgregarRenovacion implements ActionListener{
        public void actionPerformed(ActionEvent e){
            RD.AgregarRenovacion(new renovacion(RR.getAcreedor(), RR.getEstatus(), RR.getSaldoRestante(), RR.getMontoSolicitado(), RR.getSemanasApagar(), RR.getFecha()));
        }
    }
    
    public RenovacionController(ConsultaRenovacion CR, RenovacionDAO RD){
        this.RD = RD;
        this.CR = CR;
        this.CR.addEliminarRenovacion(new EliminarRenovacion());
    }
    
    class EliminarRenovacion implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id = CR.tabla.getSelectedRow();
            int ids = Integer.parseInt(CR.tabla.getValueAt(id, 0).toString());
            if (ids >= 0){
                RD.borrarRenovacion(ids);
                JOptionPane.showMessageDialog(null,"Renovacion borrado");
            }
        }
    }
}
