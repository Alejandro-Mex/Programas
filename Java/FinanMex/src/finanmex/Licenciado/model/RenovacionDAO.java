
package finanmex.Licenciado.model;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RenovacionDAO {
    public  renovacion R;
    private Connection connection;
    int idAcreedor;
    
    public RenovacionDAO(){
        conectar();
    }
    
    public void setIdAcreedor(int idAcreedor){
        this.idAcreedor = idAcreedor;
    }

    public int getIdAcreedor() {
        return idAcreedor;
    }
    
    private void conectar(){
        String url ="jdbc:mysql://localhost:3306/finanmex";
        String password ="";
        String username ="root";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex){
            Logger.getLogger(RenovacionDAO.class.getName()).log(Level.SEVERE, null,ex);
        } catch (SQLException ex){
            Logger.getLogger(RenovacionDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    
    public void MostrarACreedor(JComboBox comboAcreedor){
        String ruta = "SELECT * FROM acreedor";
        
        try{
            Statement ins = connection.createStatement();
            ResultSet rs = ins.executeQuery(ruta);
            
            while (rs.next()){
                int idAcre = rs.getInt("id_acreedor");
                String nombre = rs.getString("nombres");
                String apellido = rs.getString("apellidos");
                this.setIdAcreedor(rs.getInt("id_Acreedor"));
                comboAcreedor.addItem(idAcre);
                comboAcreedor.putClientProperty(idAcre, idAcreedor);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al mostar acreedor: " +e.toString());
        }

            
    }
    
    public void MostrarRenovacion(JTable tablaRenovacion){
        String ruta= "SELECT * FROM  renovacion";
        renovacion R = new renovacion();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Id_acreedor");
        modelo.addColumn("Estatus");
        modelo.addColumn("Saldo restante");
        modelo.addColumn("Monto solicitado");
        modelo.addColumn("Semanas a pagar");
        modelo.addColumn("Fecha");
        
        try{
            Statement ins = connection.createStatement();
            ResultSet rs = ins.executeQuery(ruta);
            
            while(rs.next()){
                SimpleDateFormat form = new SimpleDateFormat("YYYY-MM-DD");
                java.sql.Date fecha = rs.getDate("fecha");
                
                R.setId_Renovacion(rs.getInt("id_renovacion"));
                R.setId_acreedor(rs.getInt("id_acreedor"));
                R.setStatus(rs.getBoolean("estatus"));
                R.setSaldo_restante(rs.getDouble("saldo_restante"));
                R.setMonto_solicitado(rs.getDouble("monto_solicitado"));
                R.setSemanas_pagar(rs.getInt("semanas_apagar"));
                R.setFechaS(rs.getString("fecha"));
                modelo.addRow(new Object[]{R.getId_Renovacion(),R.getId_acreedor(),R.getStatus(),R.getSaldo_restante(),R.getMonto_solicitado(),R.getSemanas_pagar(),R.getFechaS()});
                
            }
            tablaRenovacion.setModel(modelo);
        } catch(SQLException e){
            
        }
    }
    
    public void AgregarRenovacion (renovacion R){
        String ruta = "INSERT INTO renovacion (id_acreedor, estatus, saldo_restante, monto_solicitado, semanas_apagar, fecha) VALUES (?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(ruta);
            ps.setInt(1, R.getId_acreedor());
            ps.setBoolean(2, R.getStatus());
            ps.setDouble(3, R.getSaldo_restante());
            ps.setDouble(4, R.getMonto_solicitado());
            ps.setInt(5, R.getSemanas_pagar());
            ps.setString(6, R.getFechaS());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,"El renovacion se a registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            
        }  catch (SQLException e)    {
            
        }  
    }
    
    public void borrarRenovacion(int id){
        String ruta = "DELETE FROM renovacion WHERE id_renovacion = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(ruta);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
