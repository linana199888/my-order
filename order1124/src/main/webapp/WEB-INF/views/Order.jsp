<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<title>Ordersshow</title>

</head>
<body>
	<div class="container row justify-content-center">
		<table class="table table-hover">
			<h2>Orders Interface ٩(◦`꒳´◦)۶</h2>
		</table>
		<form:form>
			<table class="table table-dark table-striped">
				<tr>
					<input type="button" class="btn btn-warning" id="Read" value="查詢訂單" />
					
					<td><form:label path="ORDER_ID">ID：</form:label></td>
					<td><form:input path="ORDER_ID" /></td>
				</tr>
				<tr>
					<td><form:label path="ORDER_DATE">日期：</form:label></td>
					<td><form:input path="ORDER_DATE" /></td>
				</tr>
				<tr>
					<td><form:label path="ORDER_TIME">時間：</form:label></td>
					<td><form:input path="ORDER_TIME" /></td>
				</tr>
				<tr>
					<td><form:label path="TOTAL_PRICE">總價：</form:label></td>
					<td><form:input path="TOTAL_PRICE" /></td>
				</tr>
				
			<tr>
				<td><form:label path="PAID_STATUS">付費狀態：</form:label>
					<select>
				<option>選擇付費狀態：</option>
				<option>true</option>
			    <option>false</option>
			   	 </select>
			    </td>
			</tr>

			</table>
			<input type="button" class="btn btn-info" id="Update" value="修改訂單" />
			<input type="button" class="btn btn-info" id="Delete" value="刪除訂單" />
	</div>
	<div id="div1"></div>
	</form:form>

	<script>
		function rs(data) {
			$("#div1").html(data);
		}

		function Read() {
			$.get("orders/read", rs);
		}

		function Update(evt) {
			evt.preventDefault();
			var id = $("#ORDER_ID").val();
			var date = $("#ORDER_DATE").val();
			var time = $("#ORDER_TIME").val();
			var p = parseInt($("#TOTAL_PRICE").val());
			var i = $("#PAID_STATUS").val();
			$.post("orders/update", {
				"ORDER_ID" : id,
				"ORDER_DATE" : date,
				"ORDER_TIME" : time,
				"TOTAL_PRICE" : p,
				"PAID_STATUS" : i,
			}, ud);

			return false;
		}
		function ud(data) {
			alert('修改成功');
			$.get("orders/read", rs);
			$("#ORDER_ID").val("");
			$("#ORDER_DATE").val("");
			$("#ORDER_TIME").val("");
			$("#TOTAL_PRICE").val("");
			$("#PAID_STATUS").val("");
		}

		function Delete(evt) {
			evt.preventDefault();
			var id = $("#ORDER_ID").val();
			var date = $("#ORDER_DATE").val();
			var time = $("#ORDER_TIME").val();
			var p = parseInt($("#TOTAL_PRICE").val());
			var i = $("#PAID_STATUS").val();
			$.post("orders/delete", {
				"ORDER_ID" : id,
				"ORDER_DATE" : date,
				"ORDER_TIME" : time,
				"TOTAL_PRICE" : p,
				"PAID_STATUS" : i,
			}, de);
			return false;
		}
		function de(data) {
			alert('刪除成功');
			$.get("orders/read", rs);
			$("#ORDER_ID").val("");
			$("#ORDER_DATE").val("");
			$("#ORDER_TIME").val("");
			$("#TOTAL_PRICE").val("");
			$("#PAID_STATUS").val("");
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