<%@ page import="hgkj.com.model.entity.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>团购</title>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/jquery.js"></script>
<script src="js/tgou.js"></script>
    <style>
        #jj{
            height: 17px;
            width: 200px;
            overflow: hidden;
            white-space:normal;
            display: block;
        }
        #dian{
            position: absolute;
            margin-left: 195px;
            top: 600px;

        }
    </style>
    <script>


    </script>
</head>

<body>
<!--头部-->
<div id="top-cont">
<div id="top-min">
<div id="min-left"></div>
<div id="min-right"></div>
</div>
</div>
<!--导航-->
<div id="menu">
<div id="menu-m">
<ul>
<li><a href="index.jsp">首页</a></li>
<li style="width:8px;"><img src="images/t1.jpg" width="8" height="42" /></li>
<li><a href="/ShowLineServlet?action=Inall">境内游</a></li>
<li style="width:8px;"><img src="images/t1.jpg" width="8" height="42" /></li>
<li><a href="/ShowLineServlet?action=Outall">境外游</a></li>
<li style="width:8px;"><img src="images/t1.jpg" width="8" height="42" /></li>
<li><a href="group.jsp">团购</a></li>
<li><a href="cart.jsp"><img src="images/che.jpg" width="176" height="42" /></a></li>
    <li><a href="#"><%
        Customer customer=(Customer) session.getAttribute("customer");
        if (customer==null){
    %><a  href="login.html">请登录</a><%}else {%>欢迎：<%=customer.getName()%>
        <%}%>
    </a></li>
    <li style="width:8px;"><img src="images/t1.jpg" width="8" height="42" /></li>
</ul>
</div>
</div>
<!--广告位图片-->
<div id="banner"><img src="images/tgg1.jpg" width="1003" height="190" />
<img src="images/del.png" class="close" />
</div>
<!--主体内容第一部分开始-->
<div class="tuangouy">
<ul >
<c:forEach var="line" items="${sessionScope.lineList}">
    <li>
    <div><a a href='/LineShowInfoServlet?lineID=${line.lineID}'><img src="images/${line.picture.picintroduction}" width="305" height="200" /></a></div>
    <div class='tuangouy-m'><a href='/LineShowInfoServlet?lineID=${line.lineID}'>[全国联保]${line.lineName}${line.days}日游</a><br />
        <div id="jj">简介：${line.introduction}...</div>
    <span id="name">团价￥${line.teamBuyPrice}</span>&nbsp;&nbsp;原价：￥${line.price}
    </div>
    <div class='fengsu'>已有666人参与</div>
    </li>
    &nbsp;
</c:forEach>

</ul>
</div>
<div class="tgfy">
    <a href="/ShowLineServlet?action=teamBuyall&pageIndex=1">首页</a>
    <a href="/ShowLineServlet?action=teamBuyall&pageIndex=${pageIndex-1}">上一页</a>
    ${pageIndex}/${totalPage}
    <a href="/ShowLineServlet?action=teamBuyall&pageIndex=${pageIndex+1}">下一页</a>
    <a href="/ShowLineServlet?action=teamBuyall&pageIndex=${totalPage}">尾页</a>
</div>
<!--主体内容第一部分结束-->
<!--底部-->
<div id="foot">
<div id="foot-t"><p>许可证编号：WE125482154 鄂ICP备125478966</p>
<p><a href="#">隐私保护</a> | <a href="#">诚聘英才</a> | <a href="#">关于我们</a> | <a href="#">网站地图</a> | <a href="#">友情链接</a> | <a href="#">商务合作</a></p>
</div>
</div>
</body>
</html>
