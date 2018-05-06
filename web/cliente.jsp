<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,cliente.Cliente"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>JPA Guestbook Web Application Tutorial</title>
        <style>
        
            form {
                width: 500px;
            }
        
            form input{
                margin: .4em 0;            
                display: block;
                }
            
            div {
                margin-top: 35px;
            }
        
        form input boton
        
        </style>
    </head>

    <body>
        
        <center><form method="POST" action="ClienteServlet">
            <fieldset style="width: 500px">
                <legend> ** Formulario para Agregar Cliente ** </legend>
            NIF: <input type="text" name="nif" />
            Nombre: <input type="text" name="nombre" />
            Telefono: <input type="text" name="telefono" />
            <input type="submit" value="Agregar" />            
            </fieldset>
        </form></center>
        <%
            String mensa=(String)request.getAttribute("mensaje");
            if(mensa!=null){%>
            <%= mensa %>
            <%}%>
        <hr><ol> 
            <%
            @SuppressWarnings("unchecked")
            List<Cliente> clientes = (List<Cliente>)request.getAttribute("clientes");
            for (Cliente cliente : clientes) { %>
                <li> <%= cliente.toString() %> </li> <%
            } %>
        </ol><hr>

        <iframe src="http://www.objectdb.com/pw.html?web-download"
            frameborder="0" scrolling="no" width="100%" height="30"></iframe>
     </body>
 </html>