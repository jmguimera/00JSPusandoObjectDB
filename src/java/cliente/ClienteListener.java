package cliente;
 
import javax.persistence.*;
import javax.servlet.*;
/**
 *
 * @author josem
 */ 
public class ClienteListener implements ServletContextListener {

    // Se prepara el gestor de base de datos para su uso en el programa
    // Se crea una instancia que abre la base de Datos para ser usado 
    // en el contexto Cleinte Servidor utilizado en la web cuando sea
    // necesaria
    @Override
    public void contextInitialized(ServletContextEvent e) {
        com.objectdb.Enhancer.enhance("cliente.*");
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/clientes.odb");
        e.getServletContext().setAttribute("emf", emf);
    }
 
    // Cierre del Gestor de de la base de datos mediante la instancia creada
    @Override
    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf =
            (EntityManagerFactory)e.getServletContext().getAttribute("emf");
        emf.close();
    }
}