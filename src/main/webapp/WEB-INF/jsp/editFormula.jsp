<%@ include file="init.jsp"%>
<div id="sidebar">
    <h1>Pricing Formula</h1>
  </div>
  <div id="main">
   <form action="${context}/setIdealPriceFormula" method="Post" modelAttribute="idealPriceFormula">
   <input type="hidden" id="id" name="id" value="${idealPriceFormula.id}">
	<table>
	<tr>
		<td>Highest Removing Element:</td>
		<td><input id="rhighest" name="rhighest"  type="text" value="${idealPriceFormula.rhighest}"></td>	
	</tr>
	<tr>
		<td>Lowest Removing Element:</td>
		<td><input id="rlowest" name="rlowest" type="text" value="${idealPriceFormula.rlowest}"></td>	
	</tr>
	<tr>
		<td>Additional % price:</td>
		<td><input id="addition" name="addition" type="text" value="${idealPriceFormula.addition}"></td>	
	</tr>
	<tr>
		<td><input type="reset" value="Reset"></td>
		<td><input type="submit" value="Submit"></td>	
	</tr>

</table>
</form>
  </div>

