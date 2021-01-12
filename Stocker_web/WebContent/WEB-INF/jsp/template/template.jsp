<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stocker - ${page}</title>
<link rel="stylesheet" href="/css/common.css">
<link rel="stylesheet" href="/css/${page}.css">
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