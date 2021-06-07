<html>
	<head>
	<title>See transactions</title>
	<meta name="layout" content="main" /> </head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<body>
		<div>
			<h2>Transactions</h2>
			<br/>
			<a href="/"><h3>Accounts</h3></a>
			<a href="/payment"><h3>Make Payment</h3></a>
			<br/>

			<c:if test="${not empty transactionList}">
			<table style="border: 1px solid black;">
				<tr style="border: 1px solid black;">
					<td>ID</td>
					<td>Timestamp</td>
					<td>Amount</td>
					<td>From</td>
					<td>To</td>
				</tr>
				<c:forEach var="transaction" items="${transactionList}">
					<tr style="border: 1px solid black;">
					<td>${transaction.id}</td>
					<td>${transaction.datetime}</td>
					<td>${transaction.amount}</td>
					<td>${transaction.payto}</td>
					<td>${transaction.payfrom}</td>
					
					</tr>
				</c:forEach>
			</table>
			</c:if>
		</div>
	</body>
</html>