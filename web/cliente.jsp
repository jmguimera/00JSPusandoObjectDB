<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,cliente.Cliente"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>JPA Guestbook Web Application Tutorial</title>
    </head>

    <body>
        <form method="POST" action="ClienteServlet">
            NIF: <input type="text" name="nif" />
            Nombre: <input type="text" name="nombre" />
            Telefono: <input type="text" name="telefono" />
            <input type="submit" value="Agregar" />            
        </form>

        <hr><ol> 
            <%
            @SuppressWarnings("unchecked")
            List<Cliente> clientes = (List<Cliente>)request.getAttribute("clientes");
            for (Cliente cliente : clientes) { %>
                <li> <%= cliente %> </li> <%
            } %>
        </ol><hr>

        <iframe src="http://www.objectdb.com/pw.html?web-download"
            frameborder="0" scrolling="no" width="100%" height="30"></iframe>
     </body>
 </html>