

	<%@ include file="header.jsp" %>
       <h3>Tax rate: <%= request.getAttribute("taxRate")%> </h3>
       <h3>Total taxes: <%= request.getAttribute("totalTaxes")%> </h3>
       <h3>Total sales: <%= request.getAttribute("totalSales")%> </h3>
	<%@ include file="footer.jsp" %>



    <jsp:include page="header.jsp"/>
        <h3>Tax rate: <%= request.getAttribute("taxRate")%> </h3>
       <h3>Total taxes: <%= request.getAttribute("totalTaxes")%> </h3>
       <h3>Total sales: <%= request.getAttribute("totalSales")%> </h3>
	<jsp:include page="footer.jsp"/>