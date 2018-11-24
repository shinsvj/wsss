<html>
<body background="./img/Agriculture.jpg">
	<form action="./submitPurchase.do" method="get">
		
			<h1 align="center"><font color="blue">Please enter the purchase details in the text boxes</font></h1>
			<table border="2" align="center">
				<tr>
					<td>Enter Farmer Name :</td>
					<td><input type="text" name="farname">*</td>
				</tr>
				<tr>
					<td>Enter Mobile Number :</td>
					<td><input type="text" name="farmobile">*</td>
				</tr>
				<tr>
					<td>Select Comodity:</td>
					<td><select name="farcomodity">
							<option value="PADDY">PADDY</option>
							<option value="WHEAT">WHEAT</option>
							<option value="RAGI">RAGI</option>
							<option value="COFFEE">COFFEE</option>
							<option value="PEPPER">PEPPER</option>
							<option value="BARLI">BARLI</option>
					</select>*</td>
				</tr>
				<tr>
					<td>Enter Quantity in bags :</td>
					<td><input type="text" name="farqty"><font color="blue">*[should be integer]</font></td>
				</tr>
				
				<tr><br>
					<td colspan="2" align="center"><input type="submit" value="Submit Purchase"></td>
				</tr>
				
			</table>
		
	</form>
</body>
</html>