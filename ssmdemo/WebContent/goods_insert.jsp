<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="${pageContext.request.contextPath }/goods/insert.action" method="post" enctype="multipart/form-data">
     商品名称：<input type="text" name="name"/>
     商品数量：<input type="text" name="num"/>
     商品价格：<input type="text" name="price"/>
     商品图片：<input type="file" name="upfile"/>
     商品描述：<textarea rows="5" cols="30" name=""miaoshu></textarea><br><br>
     <input type="submit" value="增加"/>
  </form>
</body>
</html>