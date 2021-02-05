<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section id="signup" class="content">
	<h2 class="content_title">Sign up</h2>

	<form id="form">
		<p class="err_message">${err_message}</p>

		<input type="email" name="email"
			placeholder="Enter your email address" autocomplete="off" required>

		<input type="text" name="nm"
			placeholder="Enter your full name" autocomplete="off" required>

		<input type="password" name="pw"
			placeholder="Create your password" required>
			
		<input type="password" name="pw_repeat"             
			placeholder="Repeat your password" required> 
			
		<input type="button" value="Sign up" id="signup_btn">
	</form>
	
	<ul class="link">
		<li><a href="/user/login">Login</a></li>
	</ul>
	
</section>

<script type="module" src="/res/js/signup.js"></script>