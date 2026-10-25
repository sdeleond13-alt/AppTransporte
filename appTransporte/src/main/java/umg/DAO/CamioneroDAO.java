/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import umg.modelo.Camionero;

/**
 *
 * @author Sussu
 */
public class CamioneroDAO {
     public void insertar(Camionero camionero) throws SQLException {
        
       
        
        String sql = "INSERT INTO camionero (Nombre, Telefono, Direccion, Salario, Poblacion) VALUES (?, ?, ?, ?, ?)"; //escribo camionero como aparece en mi tabla de mysql
        
        try (Connection cn = ConexionDB.abrir(); PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, camionero.getNombre());
            ps.setString(2, camionero.getTelefono());
            ps.setString(3, camionero.getDireccion());
            ps.setDouble(4, camionero.getSalario());
            ps.setString(5, camionero.getPoblacion());
           
            
            int filas = ps.executeUpdate();
            
            if (filas == 0) {
                throw new SQLException("No se pudo insertar el registro.");
            }
        }
    } 
   
     public void actualizar(Camionero camionero) throws SQLException {
            
         
        
        String sql = "UPDATE camionero SET Nombre=?, Telefono=?, Direccion=?, Salario=?, Poblacion=?  WHERE idCamionero = ?";
        
        try (Connection cn = ConexionDB.abrir(); PreparedStatement ps = cn.prepareStatement(sql)) {

            // Asignación de parámetros
            ps.setString(1, camionero.getNombre());
            ps.setString(2, camionero.getTelefono());
            ps.setString(3, camionero.getDireccion());
            ps.setDouble(4, camionero.getSalario());
            ps.setString(5, camionero.getPoblacion());

            // Parámetro de la llave primaria
            ps.setInt(8, camionero.getIdCamionero());
            
            int filas = ps.executeUpdate();
            
            if (filas == 0) {
                throw new SQLException("No se encontró el registro para actualizar.");
            }
        }
    }
     
  public void eliminar(int id) throws SQLException {
        
        String sql = "DELETE FROM Camionero WHERE idCamionero = ?";
        
        try (Connection cn = ConexionDB.abrir(); PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            
            if (filas == 0) {
                throw new SQLException("No se encontró el registro para eliminar.");
            }
        }
    }
    public List<Camionero> listar() throws SQLException {
        
        List<Camionero> lista = new ArrayList<>();
        
        String sql = "SELECT idCamionero, Nombre, Telefono, Direccion, Salario, Poblacion FROM Camionero";
        
        try (Connection cn = ConexionDB.abrir(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                
                Camionero Camionero = new Camionero();

                // Asignar los valores obtenidos de MySQL
                Camionero.setIdCamionero(rs.getInt("idCamionero"));
                Camionero.setNombre(rs.getString("Nombre"));
                Camionero.setTelefono(rs.getString("Telefono"));
                Camionero.setDireccion(rs.getString("Direccion"));
                Camionero.setSalario((float) rs.getDouble("Salario"));
                Camionero.setPoblacion(rs.getString("Poblacion"));
               
                
                lista.add(Camionero);
            }
        }
        
        return lista;
    }
}
