<html>
<body background="./img/Agriculture.jpg">
<form action="./submitsales.do">
<center>
<table border="1" bgcolor="white">
<h1><font color="blue">Enter following Details</font></h1>
	<tr>
		<td><font color="blue">Buyer Name </font><b>*</b></td>
		<td><input type="text" name="salebuyname"></td>
	</tr>
	<tr>
		<td><font color="blue">Mobile Number</font></td>
		<td><input type="text" name="salemobile"></td>
	</tr>
	<tr>
		<td><font color="blue">Comodity</font></td>
		<td><select name="salecomodity">
			<option value="PADDY">PADDY</option>
			<option value="WHEAT">WHEAT</option>
			<option value="RAGI">RAGI</option>
			<option value="COFFEE">COFFEE</option>
			<option value="PEPPER">PEPPER</option>
			<option value="BARLI">BARLI</option>
			</select>
		</td>
	</tr>
	<tr>
		<td><font color="blue">Quantity</font></td>
		<td><input type="text" name="salequantity"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Submit Sales" ></td>
	<tr>
</table>
</center>
</form>
</body>
</html>