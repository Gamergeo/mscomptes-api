<html>

	<head>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		
		<script type="text/javascript" src="<c:url value='/webjars/jquery/3.4.1/jquery.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/webjars/jquery-ui/1.12.1/jquery-ui.min.js' />"></script>
		
		<script type="text/javascript">
		
			function generateCsv() {
				$.get({
					url: '/mscomptes/main/generate.do',
					success : function(resp) {
						alert(resp);
					}
				})
			}
			
		
		</script>
	</head>
	
	<body>	
		<div id="assetList">
		
			<span>Listes des assets : <br/></span>
			<span>
				<c:forEach items="${assetList}" var="asset">
					${asset.name}
				</c:forEach>
			</span>
		</div>
		
		<button onclick="generateCsv()">Generer csv</button>

	</body>
</html>