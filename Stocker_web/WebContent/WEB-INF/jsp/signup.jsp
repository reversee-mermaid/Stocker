<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="content">
    <h2>Signup page</h2>
    <p>${err_msg}</p>
    <form action="/signup" method="post">
    	<input type="text" name="email" id="email" placeholder="Enter your email address" autocomplete="off">
    	<input type="text" name="nm" id="nm" placeholder="Enter your full name" autocomplete="off">
    	<input type="password" name="pw" id="pw" placeholder="Create your password">
    	<input type="password" id="pw_repeat" placeholder="Reapeat your password">
    	<input type="submit" value="Sign up">
    </form>
</section>