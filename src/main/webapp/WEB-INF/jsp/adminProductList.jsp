<%@ include file="init.jsp"%>
<script>
$(document).ready(function() {
    $('#productList').DataTable();
} );
</script>

<script type="text/javascript">
  setTimeout(function(){
    location = ''
  },60000)
</script>

<table id="productList" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
            	<th>Sr. No.</th>
                <th>Product Name</th>
                <th>BarCode</th>
                 <th>Product Category</th>
                <th>Description</th>
                <th>Avg. Price</th>
                <th>Lowest Price</th>
                <th>Highest Price</th>
                <th>Ideal Price</th>
                <th>No. Of Price Collected</th>
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
		                <td align="center"><fmt:formatNumber type="number" maxFractionDigits="2" value="${product.avgPrice}" /></td>
		                <td align="center"><fmt:formatNumber type="number" maxFractionDigits="2" value="${product.lowPrice}" /></td>
		                <td align="center"><fmt:formatNumber type="number" maxFractionDigits="2" value="${product.highPrice}" /></td>
		                <td align="center"><fmt:formatNumber type="number" maxFractionDigits="2" value="${product.idealPrice}" /></td>
		                <td align="center"><c:out value="${fn:length(product.productLogs)}" /></td>
		            </tr>
		            </c:forEach>
		        </c:if>
	        </c:when>
	        <c:otherwise>
	        	<tr>
	         	<td colspan="10"><c:out value="${showMessage}" /></td>
	         	</tr>
	        </c:otherwise>
        </c:choose>    
         </tbody>
       </table>  
            