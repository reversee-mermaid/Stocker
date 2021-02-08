<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="home" class="content">
	<h2 class="content_title">Home</h2>

	<div class="thumb_container">
		<c:forEach var="article" items="${list}">
			<div class="thumb" data-id="${article.id}">

				<img class="thumb_img" alt="Open model - ${article.title}"
					src="/res/image/${article.author_id }/t_${article.file_nm}">

				<p class="thumb_txt">
					<strong>${article.title}</strong> <small>${article.author_nm}</small>
				</p>
			</div>
		</c:forEach>
	</div>

</section>
<c:if test="${sessionScope.current_user != null}">
	<a href="/article/upload" id="upload_btn">Upload new image</a>
</c:if>

<div id="modal" class="hide">
	<article id="modal_inner" class="article">
		<ul class="tag_list"></ul>

		<h2 class="article_title"></h2>
		<p class="article_caption"></p>
		<small class="article_author"></small>
		<small class="article_regdate"></small>

		<img class="article_img" alt="" src="">

		<ul class="btn_container">
			<button class="download_btn" type="button">
				<a download>Download(❁´◡`❁)</a>
			</button>
		</ul>
	</article>
</div>

<script type="text/javascript" src="/res/js/modal.js"></script>