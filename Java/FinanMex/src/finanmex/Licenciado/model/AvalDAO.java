package finanmex.Licenciado.model;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AvalDAO {
    public aval A;
    private Connection connection;
    
    public AvalDAO(){
        conectar();
    }
    
    private void conectar(){
        String url ="jdbc:mysql://localhost:3306/finanmex";
        String password ="";
        String username ="root";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex){
            Logger.getLogger(AvalDAO.class.getName()).log(Level.SEVERE, null,ex);
        } catch (SQLException ex){
            Logger.getLogger(AvalDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    
     public void MostrarAval(JTable tablAcreedor){
        aval A = new aval();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Fecha de nacimiento");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Parentesco");
        modelo.addColumn("Ruta imagen");
        tablAcreedor.getTableHeader().setReorderingAllowed(false);
        tablAcreedor.setModel(modelo);
        try{
            String ruta = "SELECT id_aval, nombres, apellidos, fecha_nacimiento, direccion, telefono,parentesco, imagen FROM aval";
            Statement ins = connection.createStatement();
            ResultSet rs = ins.executeQuery(ruta);
            
            
            while(rs.next()){
                SimpleDateFormat form = new SimpleDateFormat("YYYY-MM-DD");
                java.sql.Date fecha = rs.getDate("fecha_nacimiento");
                
                A.setId_acreedor(rs.getInt("id_aval"));
                A.setNombres(rs.getString("nombres"));
                A.setApellidos(rs.getString("apellidos"));
                A.setNacimiento(fecha);
                A.setDireccion(rs.getString("direccion"));
                A.setTelefono(rs.getString("telefono"));
                A.setParentesco(rs.getString("parentesco"));
                A.setImagen(rs.getString("imagen"));
                
                
                modelo.addRow(new Object[]{A.getId_acreedor(),A.getNombres(),A.getApellidos(),A.getNacimiento(),A.getDireccion(),A.getTelefono(),A.getParentesco(),A.getImagen()});
            }
            
            tablAcreedor.setModel(modelo);
        } catch (Exception e){
            
        }
        
    }
    
    public void AgregarAval(aval a){
        String ruta = "INSERT INTO aval (nombres,apellidos,fecha_nacimiento,direccion,telefono,parentesco,imagen) VALUES ( ? , ? , ? , ? , ? , ? , ?)";
        if (!a.getNombres().equals("")&&!a.getApellidos().equals("")&&!a.getFecha_nacimiento().equals("")&&!a.getDireccion().equals("")){
            try{
                PreparedStatement ps = connection.prepareStatement(ruta);
                ps.setString(1, a.getNombres());
                ps.setString(2, a.getApellidos());
                ps.setString(3, a.getFecha_nacimiento());
                ps.setString(4, a.getDireccion());
                ps.setString(5, a.getTelefono());
                ps.setString(6, a.getParentesco());
                ps.setString(7, a.getImagen());
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null,"El aval se a agregado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e){
                e.printStackTrace();
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Falta rellinar los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
        
    public void ActualizarAval(aval a){
        String ruta = "UPDATE aval SET nombres = ?, apellidos = ?, fecha_nacimiento = ?, direccion = ?, telefono = ?,parentesco = ? , imagen = ? WHERE id_aval = ?";
        if (!a.getNombres().equals("")&&!a.getApellidos().equals("")&&!a.getFecha_nacimiento().equals("")&&!a.getDireccion().equals("")){
            try{
                PreparedStatement ps = connection.prepareStatement(ruta);
                ps.setString(1, a.getNombres());
                ps.setString(2, a.getApellidos());
                ps.setString(3, a.getFecha_nacimiento());
                ps.setString(4, a.getDireccion());
                ps.setString(5, a.getTelefono());
                ps.setString(6, a.getParentesco());
                ps.setString(7, a.getImagen());
                ps.setInt(8, a.getId_aval());
                ps.executeUpdate();
                ps.close();
                
                
                JOptionPane.showMessageDialog(null,"El aval se a modificado corectamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e){
                e.printStackTrace();
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Falta rellinar uno de los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void BorrarAval(int id){
        String ruta = "DELETE FROM aval WHERE id_aval = ?";
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
