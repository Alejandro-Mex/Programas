package finanmex.Licenciado.model;

import finanmex.Licenciado.view.AltasCoordinadora;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CoordinadoraDAO {
    public coordinadora CC;
    private Connection connection;
    private AltasCoordinadora AC;
    
    public CoordinadoraDAO(){
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
            Logger.getLogger(CoordinadoraDAO.class.getName()).log(Level.SEVERE, null,ex);
        } catch (SQLException ex){
            Logger.getLogger(CoordinadoraDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
        
    public void MostrarCoordinadoras(JTable tabla){
        coordinadora c = new coordinadora();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Fecha de nacimiento");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Ruta imagen");
        tabla.setModel(modelo);
            
        try{
            Statement conn = connection.createStatement();
            ResultSet rs = conn.executeQuery("SELECT id_cordi,nombres,apellidos,fecha_nacimiento,direccion,telefono,imagen FROM coordinadora");
               
            while(rs.next()){
                SimpleDateFormat form = new SimpleDateFormat("YYYY-MM-DD");
                Date fecha = rs.getDate("fecha_nacimiento");
                   
                c.setId_cordi(rs.getInt("id_cordi"));
                c.setNombres(rs.getString("nombres"));
                c.setApellidos(rs.getString("apellidos"));
                c.setNacimiento(fecha);
                c.setDireccion(rs.getString("direccion"));
                c.setTelefono(rs.getString("telefono"));
                c.setImagen(rs.getString("imagen"));
                modelo.addRow(new Object[]{c.getId_cordi(),c.getNombres(),c.getApellidos(),c.getNacimiento(),c.getDireccion(),c.getTelefono(),c.getImagen()});
            }
            tabla.setModel(modelo);
        } catch(Exception e){
                 
        }
        
    }
    
    public void AgregarCoordinadora(coordinadora cordi){
        if (!cordi.getNombres().equals("")&&!cordi.getApellidos().equals("")&&!cordi.getFecha_nacimiento().equals("")&&!cordi.getDireccion().equals("")&&!cordi.getTelefono().equals("")){
            try{
                PreparedStatement ps = connection.prepareStatement("INSERT INTO coordinadora (nombres,apellidos,fecha_nacimiento,direccion,telefono,imagen) VALUES ( ? , ? , ? , ? , ? , ? )");
                ps.setString(1, cordi.getNombres());
                ps.setString(2, cordi.getApellidos());
                ps.setString(3, cordi.getFecha_nacimiento());
                ps.setString(4, cordi.getDireccion());
                ps.setString(5, cordi.getTelefono());
                ps.setString(6, cordi.getImagen());
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null,"El cordinador se a agregado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta rellinar los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void ActualizarCoordinadora(coordinadora cordi){
        String ruta = "UPDATE coordinadora SET nombres = ?, apellidos = ?, fecha_nacimiento = ?, direccion = ?, telefono = ?, imagen = ? WHERE id_cordi = ?";
        if (!cordi.getNombres().equals("")&&!cordi.getApellidos().equals("")&&!cordi.getFecha_nacimiento().equals("")&&!cordi.getDireccion().equals("")&&!cordi.getTelefono().equals("")){
            try{
                PreparedStatement ps = connection.prepareStatement(ruta);
                ps.setString(1, cordi.getNombres());
                ps.setString(2, cordi.getApellidos());
                ps.setString(3, cordi.getFecha_nacimiento());
                ps.setString(4, cordi.getDireccion());
                ps.setString(5, cordi.getTelefono());
                ps.setString(6, cordi.getImagen());
                ps.setInt(7, cordi.getId_cordi());
                ps.executeUpdate();
                ps.close();
                
                JOptionPane.showMessageDialog(null,"El coordinador se a modificado corectamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e){
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta rellinar uno de los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void BorrarCoordinadora(int id){
        String ruta = "DELETE FROM coordinadora WHERE id_cordi = ?";
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
