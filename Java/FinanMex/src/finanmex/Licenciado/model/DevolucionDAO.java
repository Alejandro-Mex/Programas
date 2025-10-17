
package finanmex.Licenciado.model;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class DevolucionDAO {
    public devolucion D;
    private Connection connection;
    int idAcreedor, idPrestamo;
    
    public void setIdPrestamo(int idPrestamo){
        this.idPrestamo = idPrestamo;
    }
    
    public void setIdAcreedor(int idAcreedor){
        this.idAcreedor = idAcreedor;
    }
    
    public int getIdAcreedor(){
        return idAcreedor;
    }
    
    public DevolucionDAO(){
        conectar();
    }
    private void conectar(){
        String url ="jdbc:mysql://localhost:3306/finanmex";
        String password ="";
        String username ="root";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado");
        } catch (ClassNotFoundException ex){
            Logger.getLogger(DevolucionDAO.class.getName()).log(Level.SEVERE, null,ex);
        } catch (SQLException ex){
            Logger.getLogger(DevolucionDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    
    public void MostrarAcreedor(JComboBox comboDevolucion){
        String ruta = "SELECT * FROM Acreedor";
        
        try{
            Statement ins = connection.createStatement();
            ResultSet rs = ins.executeQuery(ruta);
            //combo acreedor.remove
            
            while (rs.next()){
                int idAcre = rs.getInt("id_Acreedor");
                String nombre = rs.getString("nombres");
                String apellido = rs.getNString("apellidos");
                this.setIdAcreedor(rs.getInt("id_Acreedor"));
                comboDevolucion.addItem(idAcre);
                comboDevolucion.putClientProperty(idAcre, idAcreedor);
                
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error al mostrar acreedor: "+e.toString());
            
        }
    }
    
    public void AgregarDevolucion(devolucion D){
        String ruta = "INSERT INTO devolucion (abono, mora, semanaPagada, fecha, SaldoRestante, SemanasRestantes, id_acreedor) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(ruta);
            ps.setDouble(1, D.getAbono());
            ps.setDouble(2, D.getMora());
            ps.setInt(3, D.getSemanaPagada());
            ps.setString(4, D.getFechas());
            ps.setDouble(5, D.getSaldoRestante());
            ps.setDouble(6, D.getSemanasRestantes());
            ps.setInt(7, D.getId_acreedor());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,"La devolucion se a registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException e){
            System.out.println("No activa");
        }
    }
    
    public void MostrarDevolucion(JTable tablaDevolucion){
        String ruta = "SELECT * FROM devolucion";
        devolucion D = new devolucion();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Abono");
        modelo.addColumn("Mora");
        modelo.addColumn("Semana Pagada");
        modelo.addColumn("Fecha");
        modelo.addColumn("Saldo restante");
        modelo.addColumn("Semanas Restantes");
        modelo.addColumn("Prestamo");
        modelo.addColumn("Acreedor");
        
        try{
            Statement ins = connection.createStatement();
            ResultSet rs = ins.executeQuery(ruta);
            
            while(rs.next()){
                SimpleDateFormat form = new SimpleDateFormat("YYYY-MM-DD");
                java.sql.Date fecha = rs.getDate("Fecha");
                
                D.setId_devolucion(rs.getInt("id_devolucion"));
                D.setAbono(rs.getDouble("abono"));
                D.setMora(rs.getDouble("mora"));
                D.setSemanaPagada(rs.getInt("semanaPagada"));
                D.setFechas(rs.getString("fecha"));
                D.setSaldoRestante(rs.getDouble("SaldoRestante"));
                D.setSemanasRestantes(rs.getInt("SemanasRestantes"));
                D.setId_prestamo(rs.getInt("id_prestamo"));
                D.setId_acreedor(rs.getInt("id_acreedor"));
                
                modelo.addRow(new Object[]{D.getId_devolucion(), D.getAbono(), D.getMora(), D.getSemanaPagada(), D.getFechas(), D.getSaldoRestante(), D.getSemanasRestantes(), D.getId_prestamo(), D.getId_acreedor()});
            }
            
            tablaDevolucion.setModel(modelo);    
        } catch (SQLException e){
        }
        
    }
    
    public void borrarDevolucion(int id){
        String ruta = "DELETE FROM devolucion WHERE id_devolucion = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(ruta);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}