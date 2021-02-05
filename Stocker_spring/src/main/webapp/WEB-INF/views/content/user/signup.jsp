<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section id="signup" class="content">
	<h2 class="content_title">Sign up</h2>

	<form id="form">
		<p class="err_message">${err_message}</p>

		<input type="email" name="email" id="email"
			placeholder="Enter your email address" autocomplete="off" required>

		<input type="text" name="nm" id="nm"
			placeholder="Enter your full name" autocomplete="off" required>

		<input type="password" name="pw" id="pw"
			placeholder="Create your password" required>
			
		<input type="password" id="pw_repeat"             
			placeholder="Repeat your password" required> 
			
		<input type="button" value="Sign up" id="signup_btn">
	</form>
	
	<ul class="link">
		<li><a href="/user/login">Login</a></li>
	</ul>
	
</section>