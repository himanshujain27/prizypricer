<%@ include file="init.jsp"%>
<div id="sidebar">
    <h1>Pricing Formula</h1>
  </div>
  <div id="main">
    <p>Ideal Pricing Formula details &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${context}/setIdealPriceFormula">Edit</a>
    <br>
    No. of highest removing price: &nbsp;&nbsp;&nbsp;<c:out value="${idealPriceFormula.rhighest}" /> 
	<br>
    No. of lowest removing price: &nbsp;&nbsp;&nbsp;<c:out value="${idealPriceFormula.rlowest}" /> 
	<br>
    additional % price: &nbsp;&nbsp;&nbsp;<c:out value="${idealPriceFormula.addition}" /> 
	    
    </p>
    <br>
    
  </div>



