<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/goods/update.action" method="post" enctype="multipart/form-data">
   <input type="hidden" name="id" value="${updategoods.id }"/>
   <input type="hidden" name="img" value="${updategoods.img }"/>
     商品名称：<input type="text" name="name"  value="${updategoods.name }"/><br><br>
     商品数量：<input type="text" name="num" value="${updategoods.num }"/><br><br>
     商品价格：<input type="text" name="price" value="${updategoods.price }"/><br><br>
    商品图片:<input type="file" name="upfile"/><br><br>
    商品描述：<textarea rows="5" cols="30" name="miaoshu">${updategoods.miaoshu }</textarea><br><br>
    <input type="submit" value="修改"/>
  </form>
</body>
</html>