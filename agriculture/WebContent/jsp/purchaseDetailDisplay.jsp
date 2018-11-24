<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body background="./img/Agriculture.jpg">
	<b>
		<h1 align="center"><font color="blue">Purchase Details Are:</font></h1>
		<table align="center" border="2" bgcolor="white">
			<tr>
				<td align="center"><b><font color="blue">Bill No</font></b></td>
				<td align="center"><b><font color="blue">Farmer Id</font></b></td>
				<td align="center"><b><font color="blue">Farmer Name</font></b></td>
				<td align="center"><b><font color="blue">Mobile No</font></b></td>
				<td align="center"><b><font color="blue">Comodity</font></b></td>
				<td align="center"><b><font color="blue">Quantity In Bags</font></b></td>
				<!-- 	<td>Purchase Date</td> -->
			</tr>
			<c:forEach var="PDTO" items="${requestScope.ARL_PUR}">
				<tr>

					<td align="center"><font>${PDTO.billNo}</font></td>
					<td align="center"><font>${PDTO.farmerId}</font></td>
					<td align="center"><font>${PDTO.farName}</font></td>
					<td align="center"><font>${PDTO.mobNo}</font></td>
					<td align="center"><font>${PDTO.comodity}</font></td>
					<td align="center"><font>${PDTO.qty}</font></td>
					<%-- 	<td>${PDTO.purDate}</td> --%>

				</tr>
			</c:forEach>
		</table>

	</b>
</body>
</html>