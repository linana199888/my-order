<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Orders{}</title>
</head>
<body>
<div class="container row justify-content-center"> 
<h2>提交的訂單資訊如下 - </h2>

<table class="table table-dark table-striped" border="1" width="70%">
    <tr>
    <div>
        <th>ORDER_DETAIL_ID：</th><th>ORDER_ID：</th><th>product_ID：</th><th>Quantity：</th><th>price_Each：</th>
	</tr>
	<tr>
	   <c:forEach items="${OrderdetailList}" var="rui">  
        <td>${rui.ORDER_DETAIL_ID}</td><td>${rui.ORDER_ID}</td><td>${rui.product_ID}</td><td>${rui.quantity}</td><td>${rui.price_Each}</td>
    </tr>
       </c:forEach>  </div>
</table>
   <br/> 
   </div> 
</body>
</html>