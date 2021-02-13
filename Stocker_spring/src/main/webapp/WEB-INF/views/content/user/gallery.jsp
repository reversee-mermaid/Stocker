<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="gallery" class="content">
	<nav class="lnb">
		<a href="/user/profile">&gt;Profile</a>
	</nav>

	<h2 class="content_title">My Gallery</h2>
	<div class="thumb_container">
		<c:forEach var="article" items="${list}">
			<div class="thumb" data-id="${article.id}">

				<img class="thumb_img" alt="Open model - ${article.title}"
					src="/res/image/${article.author_id }/t_${article.file_nm}">

				<p class="thumb_txt">
					<strong>${article.title}</strong>
				</p>
			</div>
		</c:forEach>
	</div>

</section>

<div id="modal" class="hide">
	<c:import url="/WEB-INF/views/template/article.jsp"/>
</div>

<script type="module" src="/res/js/gallery.js"></script>