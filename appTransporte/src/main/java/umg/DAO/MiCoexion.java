/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiCoexion {
    
    private static final String URL
            = "jdbc:mysql://localhost:3306/basedatos"//aca la base de datos
            + "?useSSL=false"
            + "&allowPublicKeyRetrieval=true"
            + "&serverTimezone=America/Guatemala";
    
    private static final String USER = "usuario";
    private static final String PASS = "password";
    
    public static Connection abrir() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
/**
 *
 * @author Sussu
 */

