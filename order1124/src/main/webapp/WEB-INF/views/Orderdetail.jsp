<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


  
<title>Orderdetail</title>

</head>
<body>
<div class="container row justify-content-center"> 
	<table class="table table-hover"><h2>Orderdetial (*ﾟ∀ﾟ*)</h2></table>
	<form:form>	
	<table class="table table-dark table-striped">
			<tr>
			
			<input type="button" class="btn btn-warning" id="Read" value="查詢訂單" /><p>
			
				<td><form:label path="ORDER_DETAIL_ID">訂單排序：</form:label></td>
				<td><form:input path="ORDER_DETAIL_ID" /></td>
			</tr>
			<tr>
				<td><form:label path="ORDER_ID">訂單編號：</form:label></td>
				<td><form:input path="ORDER_ID" /></td>
			</tr>
			<tr>
				<td><form:label path="product_ID">產品編號：</form:label></td>
				<td><form:input path="product_ID" /></td>
			</tr>
			<tr>
				<td><form:label path="Quantity">數量：</form:label></td>
				<td><form:input path="Quantity" /></td>
			</tr>
			<tr>
				<td><form:label path="price_Each">每個的價格：</form:label></td>
				<td><form:input path="price_Each" /></td>
			</tr>
				<td colspan="2"></td>
			</tr>
		</table>
		
		<input type="button" class="btn btn-info" id="Update" value="修改訂單" />
		<input type="button" class="btn btn-info" id="Delete" value="刪除訂單" />
			</form:form>
			</div>
		<div id="div1"></div>


	<script>
		function rs(data) {
			$("#div1").html(data);
		}

		function Read() {
			$.get("orderdetail/read", rs);
		}
		
		function Update(evt) {
			evt.preventDefault();
			var oid = parseInt($("#ORDER_DETAIL_ID").val());
			var id = $("#ORDER_ID").val();
			var pid = parseInt($("#product_ID").val());
			var qit = parseInt($("#Quantity").val());
			var peh =parseInt($("#price_Each").val());
			$.post("orderdetail/update", {
				"ORDER_DETAIL_ID": oid,
				"ORDER_ID" : id,
				"product_ID" : pid,
				"Quantity" : qit,
				"price_Each" : peh,
			}, ud);
			
			return false;
		}
		function ud(data) {		
			alert('修改成功');	
					
			$.get("orderdetail/read", rs);
			$("#ORDER_DETAIL_ID").val("");
			$("#ORDER_ID").val("");
			$("#product_ID").val("");
			$("#Quantity").val("");
			$("#price_Each").val("");
		}
		
		function Delete(evt) {
			evt.preventDefault();
			var oid = parseInt($("#ORDER_DETAIL_ID").val());
			var id = $("#ORDER_ID").val();
			var pid = parseInt($("#product_ID").val());
			var qit = parseInt($("#Quantity").val());
			var peh = parseInt($("#price_Each").val());
			$.post("orderdetail/delete", {
				"ORDER_DETAIL_ID": oid,
				"ORDER_ID" : id,
				"product_ID" : pid,
				"Quantity" : qit,
				"price_Each" : peh,
			}, de);
			return false;
		}
		function de(data) {
			alert('刪除成功');
			$.get("orderdetail/read", rs);
			$("#ORDER_DETAIL_ID").val("");
			$("#ORDER_ID").val("");
			$("#product_ID").val("");
			$("#Quantity").val("");
			$("#price_Each").val("");
		}
		function start() {
			$("#Read").click(Read);
			$("#Update").click(Update);
			$("#Delete").click(Delete);
		}
		$(document).ready(start);
	</script>

</body>
</html>