<%@ include file="init.jsp"%>
<script>
$(document).ready(function() {
    $('#productList').DataTable();
} );
</script>

<table id="productList" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
            	<th>Sr. No.</th>
                <th>Product Name</th>
                <th>BarCode</th>
                <th>Product Category</th>
                <th>Description</th>
                <th>Action</th>
             </tr>
        </thead>
		 <tfoot>
		 </tfoot>
        <tbody>
        <c:choose>
	       <c:when test="${empty showMessage}">
		        <c:if test="${!empty productList}">
		           <c:forEach var="product" items="${productList}"
										varStatus="status">
		            <tr>
		                <td align="center"><c:out value="${status.count}" /></td>
		                <td align="center"><a href="${context}/productdetail/${product.id}"><c:out value="${product.productname}" /></a></td>
		                <td align="center"><c:out value="${product.barcode}" /></td>
		               	<td align="center">
		               		<c:forEach var="productcat" items="${productCategories}" varStatus="status1">
		               		 <c:if test="${productcat.id==product.productCategory.id}">
		               		 		<c:out value="${product.productCategory.category}" />
		               		 	</c:if>	
		               		</c:forEach>
		               </td>
		                <td align="center"><c:out value="${product.description}" /></td>
		                <td align="center"><input type="text" id="price_${product.id}" name="price_${product.id}"><a href="javascript:void(0);" onclick="addPrice('${product.id}')">Add Price</a></td>
		            </tr>
		            </c:forEach>
		        </c:if>
	        </c:when>
	        <c:otherwise>
	        	<tr>
	         	<td colspan="5"><c:out value="${showMessage}" /></td>
	         	</tr>
	        </c:otherwise>
        </c:choose>    
         </tbody>
       </table> 
       <div id="addPriceMsg" style="color: green;"></div> 
<script>
function addPrice(productid) {
	var priceid='price_'+productid;
	var price = $('#'+priceid).val();
	if (price != "") {
		if(!isNaN(price)){
		$.ajax({
			type : "post",
			data : {
				price : price,
				productid:productid
			},
			url : '${context}/addproductprice',
			success : function(response) {
				$('#'+priceid).val('');
				alert("Price Added Successfully");
			}
		});
		}else{
			alert("Please enter number only !");
			$('#'+priceid).val('');
		}	
	}else{
		alert("Please enter prize !");
	}
}

</script>            