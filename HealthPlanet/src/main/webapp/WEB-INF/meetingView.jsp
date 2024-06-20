<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" th:href="@{/css/meetingView.css}">
<title>meetingView</title>
</head>
<body>
    <div class="div">

        <div class="copy">
            <div class="product-name"><span th:text="${post.title}">제목</span></div>
            <div class="subheading">일시 : <span th:text="${post.schedule}">날짜</span></div>
            <div class="subheading">시간대 : <span th:text="${post.time}">시간</span></div>
            <div class="subheading">종목 : <span th:text="${post.sportname}">종목</span></div>
            <div class="subheading">장소 : <span th:text="${post.place}">장소</span></div>
            <div class="subheading">인원수 : <span th:text="${post.headcount}">인원수</span></div>
            <div class="subheading">비용 : <span th:text="${post.cost}">비용</span></div>
            <div class="description">설명 : <span th:text="${post.body}">설명</span></div>
            
            
            <!-- user가 쓴 게시글이면 수정/삭제 버튼 표시, 아니면 찜/신청 버튼 표시 -->
            <div th:if="${user.id}">
                <a href="#" th:href="@{/myPage/updatePost}"
                <c:param name='postId' value='${post.postid}'/>>
                <button type="button" id="btn">수정하기</button>
            </a>
            <a href="#" th:href="@{/myPage/deletePost}"
                <c:param name='postId' value='${post.postid}'/>>
                <button type="button" id="btn2">삭제하기</button>
            </a>
            </div>
            <div th:unless="${user.id}">
                <a href="#" th:href="@{/post/addWish}"
                <c:param name='postId' value='${post.postid}'/>
                <c:param name='userId' value='${user.id}'/>>
                <button type="button" id="btn">찜하기</button>
            </a>
            <a href="#" th:href="@{/post/participate}"
                <c:param name='postId' value='${post.postid}'/>
                <c:param name='userId' value='${user.id}'/>>
                <button type="button" id="btn2">신청하기</button>
            </a>
            </div>
            
        </div>

        <div class="field">
            <div class="label">${post.applicant} / ${post.headcount}</div>
        </div>

    </div>

</body>
</html>