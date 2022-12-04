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
<div class=cantiner">
<div class="container row justify-content-center"> 
<table class="table table-hover"><h2>提交的訂單詳情資訊如下</h2></table>

<br/>
</div>

<table class="table table-dark table-striped" border="1" width="70%">

    <tr>
        <th>ORDER_ID：</th><th>ORDER_DATE：</th><th>ORDER_TIME：</th><th>TOTAL_PRICE：</th><th>PAID_STATUS：</th>
	</tr><tr>
	   <c:forEach items="${OrdersList}" var="rui">  
        <td>${rui.ORDER_ID}</td><td>${rui.ORDER_DATE}</td><td>${rui.ORDER_TIME}</td><td>${rui.TOTAL_PRICE}</td><td>${rui.PAID_STATUS}</td>
    </tr>
       </c:forEach>  
</table>
   <br/> 
   </div> 
</body>
</html>