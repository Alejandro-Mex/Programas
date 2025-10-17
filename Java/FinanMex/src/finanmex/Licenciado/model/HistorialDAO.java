package finanmex.Licenciado.model;
import finanmex.Licenciado.model.historial;
import static java.awt.PageAttributes.MediaType.A;
import java.sql.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HistorialDAO {
    public historial H;
    private Connection connection;
    
    public HistorialDAO(){
        conectar();
    }
    
    private void conectar(){
        String url ="jdbc:mysql://localhost:3306/finanmex";
        String password ="";
        String username ="root";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado por fin");
        } catch (ClassNotFoundException ex){
            Logger.getLogger(AcreedorDAO.class.getName()).log(Level.SEVERE, null,ex);
        } catch (SQLException ex){
            Logger.getLogger(AcreedorDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
    }
    
    public void MostrarPrestamo(JTable tablaPrestamo){
        historial H = new historial();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Cantidad prestada");
        modelo.addColumn("Interes");
        tablaPrestamo.getTableHeader().setReorderingAllowed(false);
        tablaPrestamo.setModel(modelo);
        try{
            Statement ins = connection.createStatement();
            ResultSet rs = ins.executeQuery("SELECT id_prestamo, fecha, cantidadPrestada, interes FROM historialprestamo");
            
            while(rs.next()){
                SimpleDateFormat form = new SimpleDateFormat("YYYY-MM-DD");
                java.sql.Date fecha = rs.getDate("fecha");
                
                H.setId_prestamo(rs.getInt("id_prestamo"));
                H.setFecha(fecha);
                H.setCantidadPrestada(rs.getDouble("cantidadPrestada"));
                H.setInteres(rs.getDouble("interes"));
                
                modelo.addRow(new Object[]{H.getId_prestamo(),H.getFecha(),H.getCantidadPrestada(),H.getInteres()});
            }
            
            tablaPrestamo.setModel(modelo);
        }catch (Exception e){
            
        }
    }
    
    public void MostrarDevolucion(JTable tablaDevolucion){
        historial H = new historial();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Cantidad devuelta");
        modelo.addColumn("Mora");
        tablaDevolucion.getTableHeader().setReorderingAllowed(false);
        tablaDevolucion.setModel(modelo);
        try{
            Statement ins = connection.createStatement();
            ResultSet rs = ins.executeQuery("SELECT id_devolucion, fecha, cantidadDevuelta, mora FROM historialdevolucion");
            
            while(rs.next()){
                SimpleDateFormat form = new SimpleDateFormat("YYYY-MM-DD");
                java.sql.Date fecha = rs.getDate("fecha");
                
                H.setId_devolucion(rs.getInt("id_devolucion"));
                H.setFecha(fecha);
                H.setCantidadDevuelta(rs.getDouble("cantidadDevuelta"));
                H.setMora(rs.getDouble("mora"));
                
                modelo.addRow(new Object[]{H.getId_devolucion(),H.getFecha(),H.getCantidadDevuelta(),H.getMora()});
            }
            
            tablaDevolucion.setModel(modelo);
        }catch (Exception e){
            
        }
    }
}
