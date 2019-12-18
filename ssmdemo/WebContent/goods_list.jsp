<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <a href="${pageContext.request.contextPath }/goods_insert.jsp">+</a>
   <form action="${pageContext.request.contextPath }/goods/findByName.action" method="post">
     <input type="text" name="name"/>
     <input type="submit" value="查询"/>
   </form>
   
   <table border="1" cellspacing="0" cellpadding="0">
     <tr>
         <td>编号</td>
         <td>名称</td>
         <td>数量</td>
         <td>价格</td>
         <td>图片</td>
         <td>操作</td>
     </tr>
        <c:forEach items="${info.list }" var="g">
         <tr>
         <td>${g.id }</td>
         <td>${g.name }</td>
         <td>${g.num }</td>
         <td>${g.price }</td>
         <td>${g.img }</td>
         <td>
            <a href="${pageContext.request.contextPath }/goods/yupdate.action?id=${g.id}">修改</a>
            <a href="${pageContext.request.contextPath }/goods/delete.action?id=${g.id}">删除</a>
         </td>
      </tr>
        </c:forEach>
      
   </table>
   <a href="${pageContext.request.contextPath }/goods/findAll.action?page=1">首页</a>
   <a href="${pageContext.request.contextPath }/goods/findAll.action?page=${info.hasPreviousPage?info.prePage:1}">上一页</a>
   <c:forEach items="${info.navigatepageNums }" var="np">
   <a href="${pageContext.request.contextPath }/goods/findAll.action?page=${np}" style="color:${np==info.pageNum?'red':'black'}">${np }</a>
   </c:forEach>
   <a href="${pageContext.request.contextPath }/goods/findAll.action?page=${info.hasNextPage?info.nextPage:info.pages}">下一页</a>
   <a href="${pageContext.request.contextPath }/goods/findAll.action?page=${info.pages}">尾页</a>
 
   </table>
</body>
</html>