<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<body background="./img/Agriculture.jpg">
	<%
		System.out.println(session.getAttribute("ARRAY_INV"));
	%>
	<h1 align="center"><font color="blue">Inventory deatils are :</font></h1>
	<table align="center" border="2" bgcolor="white">
		<tr>
			<td><h3 align="center">
					<b><font color="blue">Comodity_Name/Product_Name</font></b>
				</h3></td>
			<td><h3 align="center">
					<b><font color="blue">Quantity In Bags</font></b>
				</h3></td>
		</tr>
		<c:forEach var="invTo" items="${sessionScope.ARRAY_INV}">
			<tr>
				<td align="center"><font>${invTo.comodity}</font></td>
				<td align="center"><font">${invTo.qty}</font></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>