package cliente;
 
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
 
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
    
 
    // Sobre escritura del metodo toString()
    @Override
    public String toString() {
        return nif+" "+getNombre() + " "+getTelefono();
    }
    
    /**
     * Devuelve el valor de NIF
     * @return nif
     */    
    public String getNif() {
        return nif;
    }
    
    /**
     * Devuelve el valor de Nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el valor 
     * @param el valor(nombre) que recibirá la propiedad this.nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     /**
     * Devuelve el valor del campo
     * @return devuelve el valor de la propiedad telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Asigna el valor
     * @param el telefono contiene el valor que recibira la propiedad telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}