package finanmex.Licenciado.model;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class PrestamoDAO {
    public prestamo P;
    private Connection connection;
    int idAcreedor, idAval;
    
    public void setIdAval(int idAval){
        this.idAval = idAval;
    }
    
    public void setIdAcreedor(int idAcreedor){
        this.idAcreedor = idAcreedor;
    }
    
    public int getIdAcreedor(){
        return idAcreedor;
    }
    public PrestamoDAO(){
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
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null,ex);
        } catch (SQLException ex){
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
    }
    
    public void foto(){
        String ruta = "SELECT imagen FROM acreedor";
        try{
            Statement ins = connection.createStatement();
            ResultSet rs = ins.executeQuery(ruta);
            String Imagen = rs.getString("imagen");
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error al mostrar aceedor: "+e.toString());
        }
        
        
    }
    
    public void MostrarAcreedores(JComboBox comboAcreedor){
        String ruta = "SELECT * FROM acreedor";
        
        try{
            Statement ins = connection.createStatement();
            ResultSet rs = ins.executeQuery(ruta);
            //comboAcreedor.removeAllItems();
            
            while (rs.next()){
                int idAcre = rs.getInt("id_Acreedor");
                String nombre = rs.getString("nombres");
                String apellido = rs.getString("apellidos");
                this.setIdAcreedor(rs.getInt("id_Acreedor"));
                comboAcreedor.addItem(idAcre);
                comboAcreedor.putClientProperty(idAcre, idAcreedor);
                
                //comboAcreedor.setSelectedIndex(idAcre);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error al mostrar aceedor: "+e.toString());
        }
    }
    
    public void MostrarAvales(JComboBox comboAval){
        String ruta = "SELECT * FROM aval";
        
        try{
            Statement ins = connection.createStatement();
            ResultSet rs = ins.executeQuery(ruta);
            comboAval.removeAllItems();
            
            while (rs.next()){
                int idAva = rs.getInt("id_Aval");
                String nombre = rs.getString("nombres");
                String apellido = rs.getString("apellidos");
                this.setIdAcreedor(rs.getInt("id_Aval"));
                comboAval.addItem(idAva);
                comboAval.putClientProperty(idAva, idAval);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error al mostrar aceedor: "+e.toString());
        }
    }
    
    public void AgregarPrestamo(prestamo p){
        String ruta = "INSERT INTO prestamo (monto,interes,semanaApagar,fecha,monto_total,abono_semanal,monto_interes,id_acreedor,id_aval,estatus) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
        String consulta = "";
        try{
            PreparedStatement ps = connection.prepareStatement(ruta);
            ps.setDouble(1, p.getMonto());
            ps.setDouble(2, p.getInteres());
            ps.setInt(3, p.getSemanaApagra());
            ps.setString(4, p.getFechaS());
            ps.setDouble(5, p.getMonto_total());
            ps.setDouble(6, p.getAbono_semanal());
            ps.setDouble(7, p.getMonto_interes());
            ps.setInt(8, p.getId_acreedor());
            ps.setInt(9, p.getId_aval());
            ps.setBoolean(10, p.getEstatus());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,"El prestamo se a registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e){
            
        }
    }
    
    public void MostrarPrestamo(JTable tablaPrestamo){
        String ruta = "SELECT * FROM prestamo";
        prestamo p = new prestamo();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Monto");
        modelo.addColumn("Interes (%)");
        modelo.addColumn("Estatus");
        modelo.addColumn("Semanas a pagar");
        modelo.addColumn("Fecha");
        modelo.addColumn("Monto total");
        modelo.addColumn("Abono semanal");
        modelo.addColumn("Monto Interes ($)");
        modelo.addColumn("Coordinadora");
        modelo.addColumn("Acreedor");
        modelo.addColumn("Aval");
        
        try{
            Statement ins = connection.createStatement();
            ResultSet rs = ins.executeQuery(ruta);
            
            while(rs.next()){
                SimpleDateFormat form = new SimpleDateFormat("YYYY-MM-DD");
                java.sql.Date fecha = rs.getDate("fecha");
                
                p.setId_prestamo(rs.getInt("id_prestamo"));
                p.setMonto(rs.getDouble("monto"));
                p.setInteres(rs.getDouble("interes"));
                p.setEstatus(rs.getBoolean("estatus"));
                p.setSemanaApagar(rs.getInt("semanaApagar"));
                p.setFechaS(rs.getString("fecha"));
                p.setMonto_total(rs.getDouble("monto_total"));
                p.setAbono_semanal(rs.getDouble("abono_semanal"));
                p.setMonto_interes(rs.getDouble("monto_interes"));
                p.setId_cordi(rs.getInt("id_cordi"));
                p.setId_acreedor(rs.getInt("id_acreedor"));
                p.setId_aval(rs.getInt("id_aval"));
                
                modelo.addRow(new Object[]{p.getId_prestamo(),p.getMonto(),p.getInteres(),p.getEstatus(),p.getSemanaApagra(),p.getFechaS(),p.getMonto_total(),p.getAbono_semanal(),p.getMonto_interes(),p.getId_cordi(),p.getId_acreedor(),p.getId_aval()});
            }
            
            tablaPrestamo.setModel(modelo);
        } catch (SQLException e){
            
        }
    }
    
    public void borrarPrestamo(int id){
        String ruta = "DELETE FROM prestamo WHERE id_prestamo = ?";
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
