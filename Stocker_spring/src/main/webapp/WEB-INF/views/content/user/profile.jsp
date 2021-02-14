<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="profile" class="content">
	<nav class="lnb">
    <a href="/user/gallery">&gt;My gallery</a>
	</nav>

	<h2 class="content_title">Profile</h2>
	<p class="err_message">${err_message}</p>

	<form id="form">
		<div class="image_container">
			<div id="preview" class="image_view"></div>
			<label for="file"><span class="material-icons">edit</span></label>
			<input type="file" name="file" id="file" accept="image/*">
		</div>
		
		<input type="email" value="${current_user.email}" readonly>
		
		<input type="text" name="nm" placeholder="${current_user.nm}"
			value="${current_user.nm}" autocomplete="off">
		
		<input type="button" value="Update" id="update_btn">
	</form>
	<ul class="link">
		<li><a href="">Change password</a></li>
		<li><a href="/user/delete">Delete account</a></li>
	</ul>
</section>

<script type="module" src="/res/js/profile.js"></script>
<script type="module" src="/res/js/preview.js"></script>