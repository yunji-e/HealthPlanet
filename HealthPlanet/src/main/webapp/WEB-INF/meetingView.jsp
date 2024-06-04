<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.dongduk.HealthPlanet.model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/meetingView.css">
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

            <button type="button" id="btn">
                <div class="div2">수정하기</div>
            </button>
            <button type="button" id="btn2">
                <div class="div2">삭제하기</div>
            </button>
            
        </div>

        <div class="field">
            <div class="label">${post.applicant} / ${post.headcount}</div>
        </div>

    </div>

</body>
</html>