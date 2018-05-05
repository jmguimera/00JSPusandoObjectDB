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
 
        // Obtain a PersistenceManager instance:
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        
//        String repetido=null;
        
        try {
            // Handle a new guest (if any):
            String nif = request.getParameter("nif");
//            repetido=nif;
            String nombre= request.getParameter("nombre");
            String telefono = request.getParameter("telefono");
 //           request.setAttribute("resultado",null);
            if (nif != null) {
                em.getTransaction().begin();
                em.persist(new Cliente(nif,nombre,telefono));
                em.getTransaction().commit();
            }
 
            // Muestra una lista de los Clientes guardados en la Base de Datos:
            List<Cliente> clienteList =
                em.createQuery("SELECT g FROM Cliente g", Cliente.class).getResultList();
            request.setAttribute("clientes", clienteList);
            request.getRequestDispatcher("/cliente.jsp").forward(request, response);
 
        }
//        catch(UserException ue){
//            request.setAttribute("resultado","El cliente con NIF: "+repetido+" ya Existe!!");
//        }
        finally {
            // Close the PersistenceManager:
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
    }
    
    
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }



}
