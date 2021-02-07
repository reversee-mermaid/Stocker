<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section id="detail" class="content">
	<article class="article">
		<ul class="tag_list">
			<c:forEach var="tag" items="${article.tagList}">
				<li class="tag">${tag.nm}</li>			
			</c:forEach>
		</ul>
		
		<h2 class="article_title">Title: ${article.title}</h2>
		<p class="article_caption">Caption: ${article.caption}</p>
		<small class="article_author">@${article.author_nm}</small>
		<small class="article_regdate">${article.regdate}</small>
		
		<img class="article_img" alt="${article.title}" src="/res/image/${article.author_id}/${article.file_nm}">
		
		<ul class="btn_container">
			<button class="download_btn" type="button">
				<a href="/res/image/${article.author_id}/${article.file_nm}" download>Download(❁´◡`❁)</a>
			</button>
		</ul>
		
	</article>
</section>