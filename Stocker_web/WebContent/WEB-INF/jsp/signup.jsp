<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="content">
    <h2>Signup page</h2>
    <p class="err-msg">${err_msg}</p>
    
    <form action="/signup" method="post">
    
    	<input type="email" name="email" id="email" 
    		placeholder="Enter your email address" autocomplete="off" required>
    		
    	<input type="text" name="nm" id="nm" 
    		placeholder="Enter your full name" autocomplete="off" required>
    		
    	<input type="password" name="pw" id="pw" 
    		placeholder="Create your password" required>
    		
    	<input type="password" id="pw_repeat" 
    		placeholder="Repeat your password" required>
    		
    	<input type="submit" value="Sign up">
    </form>
</section>

<script>
	// set test values
	email.value = 'test@email.com';
	nm.value = 'user';
	pw.value = '123';
	pw_repeat.value = '123';
</script>