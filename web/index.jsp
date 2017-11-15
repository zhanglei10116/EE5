<%@page import="com.tc23.bean.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机购买!!!</title>
	<style>
		.a{
			background-color: #ffffff;
		}
		.b{
			background-color: #b6b6b6;
		}
	</style>
</head>
<body style="text-align: center">
<h3>11.11</h3>
<jsp:include page="/indexservlet"></jsp:include>
<table border="2" cellpadding="0" cellspacing="0" style="display: inline-table">
	<tr>
	<th>编号</th>
	<th>型号</th>
	<th>价格</th>
	<th>库存</th>
	<th></th>
	</tr>
	<c:forEach var="i" items="${goodList}" varStatus="good">
		<tr class="${good.index%2==1?'a':'b'}">
			<td>
				${i.id}
			</td>
			<td>
				${i.name}
			</td>
			<td>
				${i.price}
			</td>
			<td>
				${i.stock}
			</td>
			<td>
				<a href="buy?id=${good.index+1}>"><input type="button" value="购买"></a>
			</td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="login.jsp"/>
<%--<%--%>
	<%--if (true){--%>
	    <%--<jsp:include page="success.jsp"/>;--%>
	<%--}else {--%>
	    <%----%>
	<%--}--%>
<%--%>--%>
<%--${cookie.get(password).value}():</jsp:include>}--%>

</body>
</html>