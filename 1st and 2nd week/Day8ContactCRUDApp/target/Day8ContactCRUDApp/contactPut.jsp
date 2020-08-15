
<html>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<body>

<%@ page import="day7CRUDApp.entity.Contact" %>
<%@ include file="dashboard/header.jsp" %>
<%@ include file="alert.jsp" %>
<% Contact contact = (Contact)request.getAttribute("contact"); %>

<div>
  <form action = "/webApp/contact/put" method = "POST">
    <label for="name">First Name</label>
    <input type="text" id="name" name="name" value="<%= contact.getName() %>">

    <label for="tel_num">Last Name</label>
    <input type="text" id="tel_num" name="tel_num" value="<%= contact.getTelNum() %>">

    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>