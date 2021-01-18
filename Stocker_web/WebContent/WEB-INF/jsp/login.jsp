<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="content">
    <h2>Login page</h2>
    <p class="err-msg">${err_msg}</p>
    <form action="/login" method="post">
    	<input type="text" name="email" id="email" placeholder="Email" autocomplete="off" required>
    	<input type="password" name="pw" id="pw" placeholder="Password" required>
    	<input type="submit" value="log in">
    </form>
</section>

<script>
	// set test values
	email.value = 'test@email.com';
	pw.value = '123';
</script>