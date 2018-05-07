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
     
        </style>
    </head>

    <body>
        
        <center><form method="POST" action="ClienteServlet">
            <fieldset style="width: 500px">
                <legend> ** Formulario para Agregar Cliente ** </legend>
            NIF: <input type="text" name="nif" />
            Nombre: <input type="text" name="nombre" />
            Telefono: <input type="text" name="telefono" />
            <input type="submit" value="Grabar" />            
            </fieldset>
        </form></center>
        <%
            String mensa=(String)request.getAttribute("mensaje");
            if(mensa!=null){%>
            <%= mensa %>
            <%}%>
        <hr/>
        <center>
         <% @SuppressWarnings("unchecked")
            List<Cliente> clientes = (List<Cliente>)request.getAttribute("clientes");
            out.println("<table>");
            out.println("<table border=\"1\">");
            out.println("<th>"+"NIF"+"</th>"
                       +"<th>"+"Nombre"+"</th>"
                       +"<th>"+"Telefono"+"</th>");
            
            for (Cliente cliente : clientes) {
              out.println("<tr>");                            
              out.print("<td>"+cliente.getNif()+"</td>"
                       +"<td>"+cliente.getNombre()+"</td>"
                       +"<td>"+cliente.getTelefono()+"</td");
              out.println("</tr>");
            }
              out.println("</table>");%>
        </center>
        <hr/>

     </body>
 </html>