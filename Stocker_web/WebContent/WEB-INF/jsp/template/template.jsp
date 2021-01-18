<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stocker - ${page}</title>
<link rel="stylesheet" href="/css/common.css">
<c:forEach var="file_nm" items="${styles}">
	<link rel="stylesheet" href="/css/${file_nm}.css">
</c:forEach>

</head>
<body>
    <div id="wrap">
        <jsp:include page="./header.jsp"/>
        <main>
            <jsp:include page="../${page}.jsp"/>
        </main>
    </div>
</body>
</html>