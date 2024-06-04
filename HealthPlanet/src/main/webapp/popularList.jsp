<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- static resource 경로 지정 문제 있음 
<script type="text/javascript" src="js/popularList.js"></script>
<link type="text/css" rel="stylesheet" href="css/popularList.css" />
-->
</head>

<body>
	<div class="FlipCardcontainer">
        <div class="slider-container">
            <span class="slider-leftBtn sliderBtn"></span>	
            <div class="card-container" id="slider">
            	<c:forEach var="post" items="${postList}">
					<a href='<c:url value="/shop/viewProduct.do">
				          <c:param name="postid" value="${post.postid}"/></c:url>'>
						<div class="card" onClick="" style="cursor:pointer;">
							<h5>${post.title}</h5>
							<p>${post.custid}</p>
							<p>${post.schedule}</p>
							<!-- 참여상태체크 -->
							<c:choose>
								<c:when test="${post.myState}">
									<a>신청취소</a>
								</c:when>
								<c:otherwise>
									<a>신청하기</a>
								</c:otherwise>
							</c:choose>
						</div>
					</a>
				</c:forEach>
            </div>
            <span class="slider-rightBtn sliderBtn"></span>
        </div>
    </div>
</body>
</html>