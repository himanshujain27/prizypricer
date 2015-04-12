<%@ include file="init.jsp"%>
<div style="float: none;background-color: white;">
<div id="sidebar" style="float: left;">
    <img src="${context}/resources/images/product-range.jpg" />
  </div>
  <div id="main" style="float: right;">
        <div style="color:blue;font-size: 15px;"><a href="javascript:void(0);" onclick="history.go(-1);">Back</a></div>
        <h2><c:out value="${product.productname}"/></h2>&nbsp;&nbsp;&nbsp;<br>
        <p>Barcode: <c:out value="${product.barcode}"/>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Product Category: <c:out value=""/></p><br>
        <p>Description: <c:out value="${product.description}"/></p><br>
        <p>Ideal Price: <c:out value="${product.idealPrice}"/></p><br>
        <p>Average Price: <c:out value="${product.avgPrice}"/></p><br> 
        <p>Lowest Price: <c:out value="${product.lowPrice}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Highest Price: <c:out value="${product.highPrice}"/></p><br>        
  </div>
 </div> 