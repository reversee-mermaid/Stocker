<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stocker</title>

<!-- google fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Courier+Prime&display=swap">

<!-- stylesheets -->
<link rel="stylesheet" href="/res/css/reset.css">
<link rel="stylesheet" href="/res/css/common.css">
<link rel="stylesheet" href='<tiles:getAsString name="stylesheet"/>'>

</head>
<body>
	<div id="wrap">
		<header id="header">
			<h1>
				<a href="/">Stocker</a>
			</h1>
			<nav class="gnb">
				<ul>
					<li><a href="/home">Home</a></li>
					<li><a href="/explore">Explore</a></li>
					<li><a href="/artists">Artists</a></li>
					<li><a href="/about">About</a></li>
				</ul>
				<ul class="gnb_user">
					<c:choose>
						<c:when test="${sessionScope.current_user == null}">
							<li><a href="/user/login">Login</a></li>
							<li><a href="/user/join">Join</a></li>
						</c:when>
						<c:otherwise>
							<li><b>${sessionScope.current_user.nm}</b></li>
							<li><a href="/user/logout">Logout</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</header>
		<div id="container">
			<tiles:insertAttribute name="content" />
		</div>
	</div>
</body>
</html>