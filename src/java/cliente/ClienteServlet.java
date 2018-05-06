/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import com.objectdb.o.UserException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josem
 */
public class ClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Se obtiene una instancia del Gestor de Persistencia PersistenceManager
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        
        
        try {
            // Procesa un cliente nuevo enviado por la pagina Web
            // recogemos los parametros de los campos input y asignamos su valor
            // a variables locales que seran procesadas
            String nif = request.getParameter("nif");
            String nombre= request.getParameter("nombre");
            String telefono = request.getParameter("telefono");
 
            String resultado=""; 
            
            if (nif !=null) {
                resultado=" ** El Cliente debe tener NIF para agregarlo a la Base de Datos **";                    

                   em.getTransaction().begin();
                   Cliente repetido=em.find(Cliente.class,nif);
                
                   if(repetido==null){
                        em.persist(new Cliente(nif,nombre,telefono));
                        em.getTransaction().commit();
                        resultado=" ** Registro grabado con exito **";
                   } else{
                        resultado=" ** Ya existe un Registro en la Base Datos con el NIF: "+nif;
                   }
            }
 
            // Muestra una lista de los Clientes guardados en la Base de Datos:
            List<Cliente> clienteList =
                em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
            
            request.setAttribute("mensaje",resultado);            
            request.setAttribute("clientes", clienteList);
            request.getRequestDispatcher("/cliente.jsp").forward(request, response);
 
        }
        finally {
            // Cierra el gestor de persistencia PersistenceManager:
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
                em.close();
            }
        }
    }
    
    
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }



}
