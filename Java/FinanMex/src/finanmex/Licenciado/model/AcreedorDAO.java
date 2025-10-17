package finanmex.Licenciado.model;
import finanmex.Licenciado.view.AltasAcreedor;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AcreedorDAO {
    public acreedor AA;
    private Connection connection;


    
    public AcreedorDAO(){
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
    

    
    
    
    public void MostrarAcreedores(JTable tablAcreedor){
        acreedor A = new acreedor();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono");
        modelo.addColumn("Direccion");
        modelo.addColumn("Fecha de nacimiento");
        modelo.addColumn("Ruta imagen");
        tablAcreedor.getTableHeader().setReorderingAllowed(false);
        tablAcreedor.setModel(modelo);
        try{
            Statement ins = connection.createStatement();
            ResultSet rs = ins.executeQuery("SELECT id_acreedor, nombres, apellidos, correo, telefono, direccion, fecha_nacimiento, imagen FROM acreedor");
            
            
            while(rs.next()){
                SimpleDateFormat form = new SimpleDateFormat("YYYY-MM-DD");
                java.sql.Date fecha = rs.getDate("fecha_nacimiento");
                
                A.setId_acreedor(rs.getInt("id_acreedor"));
                A.setNombres(rs.getString("nombres"));
                A.setApellidos(rs.getString("apellidos"));
                A.setCorreo(rs.getString("correo"));
                A.setTelefono(rs.getString("telefono"));
                A.setDireccion(rs.getString("direccion"));
                A.setNacimiento(fecha);
                A.setImagen(rs.getString("imagen"));
                
                
                modelo.addRow(new Object[]{A.getId_acreedor(),A.getNombres(),A.getApellidos(),A.getCorreo(),A.getTelefono(),A.getDireccion(),A.getNacimiento(),A.getImagen()});
            }
            
            tablAcreedor.setModel(modelo);
        } catch (Exception e){
            
        }
        
    }
    
    public void AgregarAcreedor(acreedor ac){
        String ruta = "INSERT INTO acreedorcombo (nombre,apellido) VALUES ( ? ,? )";
        if (!ac.getNombres().equals("")||!ac.getApellidos().equals("")||!ac.getFecha_nacimiento().equals("")||!ac.getDireccion().equals("")||ac.getTelefono().equals("")){
            try{
                PreparedStatement ps = connection.prepareStatement("INSERT INTO acreedor (nombres,apellidos,correo,fecha_nacimiento,direccion,telefono,imagen) VALUES ( ? , ? , ? , ? , ? , ? , ?)");
                ps.setString(1, ac.getNombres());
                ps.setString(2, ac.getApellidos());
                ps.setString(3, ac.getCorreo());
                ps.setString(4, ac.getFecha_nacimiento());
                ps.setString(5, ac.getDireccion());
                ps.setString(6, ac.getTelefono());
                ps.setString(7, ac.getImagen());
                ps.executeUpdate();
                ps.close();
                PreparedStatement rs = connection.prepareStatement(ruta);
                rs.setString(1, ac.getNombres());
                rs.setString(2, ac.getApellidos());
                rs.executeUpdate();
                rs.close();
                JOptionPane.showMessageDialog(null,"El acreedor se a agregado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e){
                e.printStackTrace();
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Falta rellinar los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
        
    public void ActualizarAcreedor(acreedor ac){
        if (!ac.getNombres().equals("")&&!ac.getApellidos().equals("")&&!ac.getFecha_nacimiento().equals("")&&!ac.getDireccion().equals("")){
            try{
                PreparedStatement ps = connection.prepareStatement("UPDATE acreedor SET nombres = ?, apellidos = ?, correo = ?, fecha_nacimiento = ?, direccion = ?, telefono = ?, imagen = ? WHERE id_acreedor = ?");
                ps.setString(1, ac.getNombres());
                ps.setString(2, ac.getApellidos());
                ps.setString(3, ac.getCorreo());
                ps.setString(4, ac.getFecha_nacimiento());
                ps.setString(5, ac.getDireccion());
                ps.setString(6, ac.getTelefono());
                ps.setString(7, ac.getImagen());
                ps.setInt(8, ac.getId_acreedor());
                ps.executeUpdate();
                ps.close();
                
                
                JOptionPane.showMessageDialog(null,"El acreedor se a modificado corectamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e){
                e.printStackTrace();
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Falta rellinar uno de los campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void BorrarAcreedor( int id){
        try{
            PreparedStatement ps = connection.prepareStatement("DELETE FROM acreedor WHERE id_acreedor = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
