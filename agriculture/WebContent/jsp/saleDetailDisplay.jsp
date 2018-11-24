<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body background="./img/Agriculture.jpg">
	<h1 align="center"><font color="blue">Sales Details Are:</font></h1>
	<br>
	<table border="2" align="center" bgcolor="white">
		<tr>
			<td align="center"><h3>
					<b><font color="blue">Bill No</font></b>
				</h3></td>
			<td align="center"><h3>
					<b><font color="blue">Buyer Id</font></b>
				</h3></td>
			<td align="center"><h3>
					<b><font color="blue">Buyer Name</font></b>
				</h3></td>
			<td align="center"><h3>
					<b><font color="blue">Mobile No</font></b>
				</h3></td>
			<td align="center"><h3>
					<b><font color="blue">Comodity</font></b>
				</h3></td>
			<td align="center"><h3>
					<b><font color="blue">Quantity</font></b>
				</h3></td>
		</tr>
		<tr>

			<c:forEach var="SDTo" items="${requestScope.ARR_SALDISP}">
				<tr>
					<td><font>${SDTo.billno}</font></td>
					<td><font>${SDTo.buyid}</font></td>
					<td><font>${SDTo.buyerName}</font></td>
					<td><font>${SDTo.mobno}</font></td>
					<td><font>${SDTo.comodity}</font></td>
					<td><font>${SDTo.qty}</font></td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>