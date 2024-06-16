<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" th:href="@{/css/myPage.css}">
<title>myPage</title>
</head>
<body>
    <div class="div">

        <div class="line-1"></div>
        <div class="line-2"></div>

        <div class="copy">
            <div class="div2">내가 참여한 모임</div>
            <div class="button">
                <a href="#" th:href="@{/myPage/participationList}"
                        <c:param name='userId' value='${user.id}'/>>확인</a>
            </div>
        </div>

        <div class="copy2">
            <div class="div2">나의 찜 목록</div>
            <div class="button">
                <a href="#" th:href="@{/myPage/wishList}"
                        <c:param name='userId' value='${user.id}'/>>확인</a>
            </div>
        </div>

        <div class="copy3">
            <div class="div2">내 게시글</div>
            <div class="button">
                <a href="#" th:href="@{/myPage/myPostList}"
                        <c:param name='userId' value='${user.id}'/>>확인</a>
            </div>
        </div>

    </div>
</body>
</html>