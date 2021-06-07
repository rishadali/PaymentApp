<html>
	<head>
		<title>Accounts</title>
		<meta name="layout" content="main" />
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<div>
			<h2>Accounts</h2>
			<br/>
			<a href="/"><h3>Accounts</h3></a>
			<a href="/payment"><h3>Make Payment</h3></a>
			<br/>
			
			<c:if test="${not empty accountList}">	
			<ul>
				<c:forEach var="account" items="${accountList}">
					<li>
					<form action="accountTransactions">
					Account Name : ${account.name}, 
					Balance : ${account.balance}
					<input type="hidden" name="name" value="${account.name}">
					<input type="submit" value="Select">
					</form>
					</li>
				</c:forEach>
			</ul>
			</c:if>
			
		</div>
	</body>
</html>