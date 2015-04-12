<%@ include file="init.jsp"%>
<div style="margin-left: 30%;margin-top: 5%;">
<h1>Add Product</h1>
<form action="${context}/addproduct" method="Post" modelAttribute="product">
<table>
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td>Product Category:</td>
		<td>
			<select id="productCategory.id" name="productCategory.id">
				<option>--Please select product category--</option>
				 <c:forEach var="productcat" items="${productCategories}"
											varStatus="status">
					<option value="${productcat.id}"><c:out value="${productcat.category}" /></option>		
					</c:forEach>
			</select>
		</td>	
	</tr>
	<tr>
		<td>Product Name:</td>
		<td><input id="productname" name="productname"  type="text"></td>	
	</tr>
	<tr>
		<td>Bar Code:</td>
		<td><input id="barcode" name="barcode" type="text" onblur="checkBarcode();"></td>	
	</tr>
	<tr>
		<td>Description:</td>
		<td><textarea id="description" name="description" type="text"></textarea></td>	
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td><input type="reset" value="Reset">&nbsp;<input type="submit" value="Submit"></td>	
	</tr>

</table>
</form>
</div>

<script>
function checkBarcode(){
	var barcode=$('#barcode').val().trim();
	if(barcode!= ""){
		$.ajax({
			type : "get",
			data : {
				barcode:barcode
			},
			url : '${context}/checkbarcode',
			success : function(response) {
				if(response=="failed"){
					alert("product is already exist, please refer list");
					$('#barcode').val('');
				}
			}
		});
  }
}

</script>