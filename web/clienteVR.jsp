<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,cliente.Cliente"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>JPA Guestbook Web Application Tutorial</title>
    </head>
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

    <body>
        <center>
        <form method="POST" action="ClienteServlet">
            <fieldset>
                <legend>Formulario Altas Clientes</legend>
            <div>
                NIF: <input type="text" name="nif" />
                Nombre: <input type="text" name="nombre" />            
                Teléfono: <input type="text" name="telefono" />
            <input id="boton" type="submit" value="Agregar" />
            </div>    
            </fieldset>
        </form>
        </center>
        <%/*
            String mensaje=(String)request.getAttribute("resultado");
            if(mensaje!=null){*/%>
<!--            mensaje -->
            <%//}%>
        <hr><ol> <%
            @SuppressWarnings("unchecked")
            List<Cliente> clientes = (List<Cliente>)request.getAttribute("clientes");
            for (Cliente cliente : clientes) { %>
                <li> <%= cliente %> </li> <%
            } %>
        </ol><hr>

     </body>
 </html>