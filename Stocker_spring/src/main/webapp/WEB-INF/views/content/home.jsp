<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="home" class="content">
	<h2 class="content_title">Home</h2>
</section>
<c:if test="${sessionScope.current_user != null}">
	<a href="/article/upload" id="upload_btn">Upload new image</a>
</c:if>

<article id="modal" class="hide">
	<div id="modal_inner"></div>
</article>

<!-- <script type="text/javascript" src="/js/modal.js"></script> -->