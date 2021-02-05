<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section id="login" class="content">
	<h2 class="content_title">Login</h2>

	<form id="form">
		<p class="err_message">${err_message}</p>

		<input type="email" name="email" id="email"
			placeholder="Enter your email address" autocomplete="off" required>

		<input type="password" name="pw" id="pw"
			placeholder="Create your password" required>
			
		<input type="button" value="Login" id="login_btn">
	</form>
	
	<ul class="link">
<!-- 	  <li><a href="/user/resetPw">Forgot my password</a></li> -->
	  <li><a href="/user/signup">Sign up</a></li>
	</ul>
	
</section>