
package umg.modelo;

/**
 *
 * @author Sussu
 */
public class Ciudad {
    private int idCiudad;
    private String Nombre;
    
    //met cosntructor

    public Ciudad(int idCiudad, String Nombre) {
        this.idCiudad = idCiudad;
        this.Nombre = Nombre;
    }

    public Ciudad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //encapsulados

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "idCiudad=" + idCiudad + ", Nombre=" + Nombre + '}';
    } 
    
    
}
