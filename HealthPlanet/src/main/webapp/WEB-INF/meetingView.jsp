<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.dongduk.HealthPlanet.model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/meetingView.css">
<title>meetingView</title>
</head>
<body>
    <div class="div">

        <div class="copy">
            <div class="product-name">${post.title}</div>
            <div class="subheading">일시 : ${post.schedule}</div>
            <div class="subheading">시간대 : ${post.time}</div>
            <div class="subheading">종목 : ${post.sportname}</div>
            <div class="subheading">장소 : ${post.place}</div>
            <div class="subheading">인원수 : ${post.headcount}</div>
            <div class="subheading">비용 : ${post.cost}</div>
            <div class="description">설명 : ${post.body}</div>
            
            
            <!-- user가 쓴 게시글이면 수정/삭제 버튼 표시, 아니면 찜/신청 버튼 표시 -->
            <c:when test="${user.id != null}">
                <a href="<c:url value='/myPage/postUpdateView'>
                <c:param name='postId' value='${post.postid}'/></c:url>">
                <button type="button" id="btn">수정하기</button>
            </a>
            <a href="<c:url value='/myPage/deletePost'>
                <c:param name='postId' value='${post.postid}'/></c:url>">
                <button type="button" id="btn2">삭제하기</button>
            </a>
            </c:when>
            <c:otherwise>
                <a href="<c:url value='/post/wish'>
                <c:param name='postId' value='${post.postid}'/>
                <c:param name='userId' value='${user.id}'/></c:url>">
                <button type="button" id="btn">찜하기</button>
            </a>
            <a href="<c:url value='/post/participate'>
                <c:param name='postId' value='${post.postid}'/>
                <c:param name='userId' value='${user.id}'/></c:url>">
                <button type="button" id="btn2">신청하기</button>
            </a>
            </c:otherwise>
            
            
        </div>

        <div class="field">
            <div class="label">${post.applicant} / ${post.headcount}</div>
        </div>

    </div>

</body>
</html>