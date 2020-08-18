

<%@ page import="java.util.Enumeration" %>

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
        <%@ include file="/dashboard/header.jsp" %>
        <center>
            <table>

                <tr>
                    <th>Key</th>
                    <th>Value</th>
                    <th>Actions</th>
                </tr>

                <% Enumeration<String> attributes = request.getSession().getAttributeNames();
                        while (attributes.hasMoreElements()) {
                         String key = (String) attributes.nextElement();  %>
                <tr>
                    <td> <%= key%></td>
                    <td><%= (String)request.getSession().getAttribute(key)%> </td>
                    <td>
                        <form action="/Day9SessionCRUDApp/session/update" method="get">
                            <input type="hidden" name="key" value="<%= key %>" />
                            <input type="submit" value="Update" name="update">
                        </form>
                    </td>
                </tr>
                <% } %>

            </table>
            </br><button class="button button2"><a href="http://localhost:7070/Day9SessionCRUDApp/session/delete-all">Delete All</a></button>
        </center>
        </br>
    </body>
</html>

