<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style type="text/css">
	.post {
		display: inline-block;
		border-radius: 5px;
		padding: 5px;
		margin: 5px;
		box-shadow: 2px 2px 10px 3px;
	}
</style>


</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="post" items="${postList}">
	<a href='<c:url value="/shop/viewProduct.do">
          <c:param name="postid" value="${post.postid}"/></c:url>'>
		<div class="post" onClick="" style="cursor:pointer;">
			<h5>${post.title}</h5>
			<p>${post.custid}</p>
			<p>${post.schedule}</p>
			<!-- ��������üũ -->
			<c:choose>
				<c:when test="${post.myState}">
					<a>��û���</a>
				</c:when>
				<c:otherwise>
					<a>��û�ϱ�</a>
				</c:otherwise>
			</c:choose>
		</div>
	</a>
</c:forEach>














</body>
</html>