
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

<%@ include file="/dashboard/header.jsp" %>
<div>
  <form action = "/Day9SessionCRUDApp/session/create" method = "POST">
    <label for="key">Key</label>
    <input type="text" id="key" name="key" placeholder="Key">

    <label for="value">Value</label>
    <input type="text" id="value" name="value" placeholder="Value">

    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>