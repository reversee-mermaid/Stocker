<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav>
    <ul>
        <li><a href="/home">Home</a></li>
        <li><a href="/artist">Artist</a></li>
        <li><a href="/explore">Explore</a></li>
        <li><a href="/mypage">${sessionScope.current_user.email}</a></li>
        <li><a href="/logout">Logout</a></li>
    </ul>
</nav>