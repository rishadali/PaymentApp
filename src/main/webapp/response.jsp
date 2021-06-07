<html>
	<head>
	<title>Response</title>
	<meta name="layout" content="main" /> </head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<body>
		<div>
			<h2>Response</h2>
			<br/>
			<a href="/"><h3>Accounts</h3></a>
			<a href="/payment"><h3>Make Payment</h3></a>
			<br/>

			${response}
					
		</div>
	</body>
</html>