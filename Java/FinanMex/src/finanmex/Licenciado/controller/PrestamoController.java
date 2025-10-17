package finanmex.Licenciado.controller;

import finanmex.Licenciado.model.PrestamoDAO;
import finanmex.Licenciado.model.prestamo;
import finanmex.Licenciado.view.ConsultaPrestamos;
import finanmex.Licenciado.view.RegistroPrestamo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class PrestamoController {
    private PrestamoDAO PD;
    private RegistroPrestamo RP;
    private ConsultaPrestamos CP;
    
    public PrestamoController(RegistroPrestamo RP, PrestamoDAO PD){
        this.RP = RP;
        this.PD = PD;
        this.RP.addAgregarPrestamo(new AgregarPrestamo());
    }
    
    class AgregarPrestamo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            PD.AgregarPrestamo(new prestamo(RP.getCampoMonto(),RP.getCampoInteres(),RP.getCampoSemanaAPagar(),RP.getFecha(),RP.getCampoTotal(),RP.getCampoAbono(),RP.getCampoMontoInteres(),RP.getAcreedor(),RP.getAval(),RP.getEstatus()));
        }
    }
    
    public PrestamoController(ConsultaPrestamos CP, PrestamoDAO PD){
        this.PD = PD;
        this.CP = CP;
        this.CP.addEliminarPrestamo(new EliminarPrestamo());
    }
    
    class EliminarPrestamo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int id = CP.tabla.getSelectedRow();
            int ids = Integer.parseInt(CP.tabla.getValueAt(id, 0).toString());
            if (ids >= 0){
               PD.borrarPrestamo(ids);
               JOptionPane.showMessageDialog(null, "Prestamo borrado");
               
            }
        }
    }
}