package cliente;
 
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class Cliente implements Serializable {



    private static final long serialVersionUID = 1L;
 
    // Persistent Fields:
    @Id 
    String nif;
    private String nombre;
    private String telefono;
 
    // Constructores:
    public Cliente() {
    }

    public Cliente(String nif, String nombre, String telefono) {
        this.nif = nif;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
 
    // String Representation:
    @Override
    public String toString() {
        return nif+" "+getNombre() + " telefono "+getTelefono();
    }
    
    /**
     * @return nif
     */    
    public String getNif() {
        return nif;
    }
    
    /**
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param el valor(nombre) que recibirá la propiedad this.nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     /**
     * @return devuelve el valor de la propiedad telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param el telefono contiene el valor que recibira la propiedad telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}