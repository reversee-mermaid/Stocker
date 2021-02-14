<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<tiles:importAttribute name="tagList"/>
<section id="upload" class="content">
	<h2 class="content_title">Upload</h2>
	<p class="err_message"></p>
	
	<div>
		<form id="form">
			
			<input type="text" name="title" 
				placeholder="Title" autocomplete="off" required>
				
			<textarea name="caption" placeholder="Caption"></textarea>

			<div class="tag_list">
				<c:forEach var="tag" items="${tagList}">
					<input type="checkbox" name="tags" id="${tag.slug}" value="${tag.id}">
					<label for="${tag.slug}">${tag.nm}</label>
				</c:forEach>
			</div>
			
			<input type="file" name="file" accept=".png, .jpg, .jpeg" required>
			
			<input type="button" value="Upload" id="upload_btn">
		</form>
	
		<div id="preview"></div>
	</div>
</section>

<script type="module" src="/res/js/upload.js"></script>