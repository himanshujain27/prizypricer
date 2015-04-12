
<%@ include file="init.jsp"%>
<c:set var="context" scope="application"
	value="${pageContext.request.contextPath}" />
<div id="container">
<div id="header">Prizy Pricer</div>
<div id="menu"><a href="${context}/">HOME</a>&nbsp; &nbsp; &nbsp; &nbsp;<a href="${context}/productlist">Worker Panel</a> &nbsp; &nbsp; &nbsp; &nbsp; <a href="${context}/adminproductlist">Admin Panel</a>
&nbsp; &nbsp; &nbsp; &nbsp;<a href="${context}/addproduct">Add Product</a>
&nbsp; &nbsp; &nbsp; &nbsp;<a href="${context}/getIdealPriceFormula">Ideal Price Formula</a>
</div>