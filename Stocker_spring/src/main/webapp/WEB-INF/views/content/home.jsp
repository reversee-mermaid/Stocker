<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:importAttribute name="tagList"/>

<section id="home" class="content">
	<h2 class="content_title">Home</h2>
	<div class="options">
		<ul class="filter_list">
			<li class="filter" data-slug="all"><a href="/home/all">All</a></li>
			<c:forEach var="tag" items="${tagList}">
				<li class="filter" data-slug="${tag.slug}"><a href="/home/${tag.slug}">${tag.nm}</a></li>
			</c:forEach>
		</ul>
	</div>

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
	<c:import url="/WEB-INF/views/template/article.jsp"/>
</div>

<script type="module" src="/res/js/home.js"></script>