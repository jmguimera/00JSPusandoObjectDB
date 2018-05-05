package cliente;
 
import javax.persistence.*;
import javax.servlet.*;
 
public class ClienteListener implements ServletContextListener {

    // Prepare the EntityManagerFactory & Enhance:
    @Override
    public void contextInitialized(ServletContextEvent e) {
        com.objectdb.Enhancer.enhance("cliente.*");
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/clientes.odb");
        e.getServletContext().setAttribute("emf", emf);
    }
 
    // Release the EntityManagerFactory:
    @Override
    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf =
            (EntityManagerFactory)e.getServletContext().getAttribute("emf");
        emf.close();
    }
}