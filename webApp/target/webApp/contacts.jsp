<%@ page import="java.util.List" %>
<%@ page import="day7PostGetPut.Contact" %>

<html>
    <head>
        <style>
             table {
               border-collapse: collapse;
               width: 100%;
             }
             th, td {
               text-align: left;
               padding: 8px;
             }
             tr:nth-child(even) {background-color: #f2f2f2;}

        </style>
    </head>
    <body>

        <%@ include file="dashboard/header.jsp" %>

        <center>
            <table>

                <tr>
                    <th>Name</th>
                    <th>Tel. Number</th>
                </tr>

                <% for ( Contact contact: (List<Contact>)request.getAttribute("contacts")) { %>
                <tr>
                    <td> <%= contact.getName()%></td>
                    <td><%= contact.getTelNum()%> </td>
                </tr>
                <% } %>

            </table>
        </center>
        </br>
        <%@ include file="contactButtonGroup.jsp" %>
    </body>
</html>

