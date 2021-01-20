<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="content">
    <h2>My page</h2>
    <p class="err-msg">${err_msg}</p>
    
    <form action="/mypage" method="post">
    
    	<input type="email" value="${current_user.email}" readonly>
    		
    	<input type="text" name="nm" id="nm" 
    		placeholder="${current_user.nm}" value="${current_user.nm}" autocomplete="off" required>
    		
    	<input type="submit" value="Update">
    </form>
    <a href="/delete">Delete account</a>
</section>