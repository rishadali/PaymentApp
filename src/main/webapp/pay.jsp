<html>
	<head>
		<title>Pay Some Person</title>
		<meta name="layout" content="main" />
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<div>
			<h2>Pay</h2>
			<br/>
			<a href="/"><h3>Accounts</h3></a>
			<a href="/payment"><h3>Make Payment</h3></a>
			<br/>
			
			<form action="makePayment">
			From:	
			<select name="payfrom">
				<option value=""></option>
				<c:forEach var="account" items="${accountList}">
				<option value="${account.name}">${account.name}</option>
				</c:forEach>
			</select>
			<br>
			To:
			<select name="payto">
				<option value=""></option>
				<c:forEach var="account" items="${accountList}">
				<option value="${account.name}">${account.name}</option>
				</c:forEach>
			</select>
			<br>
			Amount: <input type="text" name="amount"/>
			
			<br>
			<input type="submit" value="Make Payment"/>
			</form>
		</div>
	</body>
</html>