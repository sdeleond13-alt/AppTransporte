
package umg.DAO;
import umg.modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Sussu
 */
public class CiudadDAO {

    private Ciudad objeto;
    //metodo para guardar datos en la tabla ciudad en la base de datos db_paqueteria
    public void insertar (Ciudad ciudad)throws SQLException{
      //crear la instruccion de sql para realizar la operacion de nive de base de datos.
      String sql="Insert into ciudad(Nombre)values(?,?)";
      try(Connection cn=ConexionDB.abrir();
              PreparedStatement ps=cn.prepareStatement(sql)){
              
              ps.setString(1, ciudad.getNombre());
              int filas=ps.executeUpdate();
              if (filas==0){
                  throw new SQLException("No se pudo hacer el registro");
              }
      }   
    }

    public void actualizar (Ciudad ciudad)throws SQLException{
      //crear la instruccion de sql para realizar la operacion de nive de base de datos.
      String sql="update ciudad set Nombre='Suchitepequez' where idCiudad";
      try(Connection cn=ConexionDB.abrir();
              PreparedStatement ps=cn.prepareStatement(sql)){
              //vieo en 1.25
              ps.setString(1, ciudad.getNombre());
              ps.setInt(2, ciudad.getIdCiudad());
              int filas=ps.executeUpdate();
              if (filas==0){
                  throw new SQLException("No se pudo hacer el registro");
              }
      }   
    }
    
    //metood para eliminar
    
     public void eliminar (int id)throws SQLException{
      //crear la instruccion de sql para realizar la operacion de nive de base de datos.
      String sql="select from ciudad where idCiudad=?";
      try(Connection cn=ConexionDB.abrir();
              PreparedStatement ps=cn.prepareStatement(sql)){
              //video en 1.25
             
              ps.setInt(2, id);
              int filas=ps.executeUpdate();
              if (filas==0){
                  throw new SQLException("No se pudo eliminar el registro");
              }
      }   
     }
    
    public List<Ciudad> listar()throws SQLException{
        List<Ciudad> lista=new ArrayList();
        String sql = "select from ciudad";
        
        try (Connection cn=ConexionBD.abrir(); 
                PreparedStatement ps=cn.prepareStatement(sql); 
                ResultSet rs=ps.executeQuery()) {
            while (rs.next()) {
                
                Ciudad ciudad = new Ciudad();
                //Aca voy a asignar los valores obtenidos de MySQL
                ciudad.setIdCiudad(rs.getInt("IdCiudad"));
                ciudad.setNombre(rs.getString("Nombre"));
                //objeto.setNombredelcampo(rs.getString("Nombredelcampo"));              
                lista.add(objeto)
            }
        }
     
    
            
        
    

