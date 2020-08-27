<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hgkj.com.model.entity.Customer" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>境内游</title>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script src="js/type.js"></script>
<script>
    // 活动
    $(function () {
        $.post(
            "/ShowLineServlet",
            {"action":"outCountry"},
            function (data) {
                var result="";
                $(data).each(function () {
                    result+="<li><a href='/LineShowInfoServlet?lineID="+this.lineID+"'><img src='images/"+this.picture.picintroduction+"' width='180' height='120' /></a>时间："+this.beginTime+"~"+this.endTime+"<p>"+this.lineName+this.days+"日游</p></li>";
                });
                $("#huodong").html(result);
            },"json");
    });

    //团购
    $(function () {
        $.post(
            "/ShowLineServlet",
            {"action":"Outteam"},
            function (data) {
                var result="";
                $(data).each(function () {
                    result+="<li> " +
                        "<div class='w16'><img src='images/"+this.picture.picintroduction+"' width='160' height='120' /></div> " +
                    "<div class='w16-r'>【团购】"+this.lineName+this.days+"日游豪华套餐</div> " +
                    "<div class='w16-rx'>团购价<span>￥"+this.teamBuyPrice+"</span> 节省"+(this.price-this.teamBuyPrice)+"<a href='/LineShowInfoServlet?lineID="+this.lineID+"'><img src='images/qg.jpg' width='92' height='32' /></a></div></li>";
                });
                $("#teamin").html(result);
            },"json");
    });
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
<li><a href="outtype.jsp">境外游</a></li>
<li style="width:8px;"><img src="images/t1.jpg" width="8" height="42" /></li>
<li><a href="/ShowLineServlet?action=teamBuyall">团购</a></li>
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
<div id="banner"> <img src="images/banner.jpg" width="1003" height="93" /></div>

<!--主体内容第一部分开始-->
<div class="jindinf">
<div class="jindinf-left">
<ul>
<li>当月景点推荐</li>
    <li><a href="/LineShowInfoServlet?lineID=${lineList2[6].lineID}">${lineList2[6].lineName}</a>  <a href="/LineShowInfoServlet?lineID=${lineList2[4].lineID}">| ${lineList2[4].lineName}</a></li>
    <li>景点推荐</li>
    <li><a href="#">${lineList2[0].lineName}</a>  <a href="#">| ${lineList2[1].lineName}</a></li>
    <li><a href="#">${lineList2[2].lineName}</a>  <a href="#">| ${lineList2[3].lineName}</a></li>
    <li><a href="#">${lineList2[4].lineName}</a>  <a href="#">| ${lineList2[5].lineName}</a></li>
    <li><a href="#">${lineList2[6].lineName}</a>  <a href="#">| ${lineList2[7].lineName}</a></li>
    <li><a href="#">${lineList2[8].lineName}</a>  <a href="#">| ${lineList2[9].lineName}</a></li>
</ul>
</div>
<div class="jindinf-right">
    <ul class="jnImgs">
        <c:forEach var="line" items="${sessionScope.lineList2}">
            <li><a href="/LineShowInfoServlet?lineID=${line.lineID}"><img src="images/${line.picture.picintroduction}" width="780" height="260"/></a></li>
        </c:forEach>
    </ul>
    <ul class="jnText">
        <c:forEach var="line" items="${sessionScope.lineList2}">
            <li>${line.lineName}</li>
            </c:forEach>
    </ul>
</div>
</div>
<!--主体内容第一部分结束-->
<!--主体内容第二部分开始-->
<div class="huodong">
<div class="huodong-meun1">最新活动</div>
<div class="huodong-inf">
<ul id="huodong">
<li><img src="images/typeact1.jpg" width="180" height="120" />时间：2014.3.8-4.5<p>深度镇西南7日游</p></li>
<li><img src="images/typeact2.jpg" width="180" height="120" />时间：2014.3.6-5.5<p>三亚游火爆进行中</p></li>
<li><img src="images/typeact3.jpg" width="180" height="120" />时间：2014.5.8-6.5<p>厦门半自助美食之旅</p></li>
<li><img src="images/typeact4.jpg" width="180" height="120" />时间：2014.4.8-4.20<p>凤凰古城6日游</p></li>
<li><img src="images/typeact5.jpg" width="180" height="120" />时间：2014.5.12-6.5<p>北京6日游</p></li>
<li><img src="images/typeact6.jpg" width="180" height="120" />时间：2014.2.8-5.5<p>灵山大佛</p></li>
<li><img src="images/typeact7.jpg" width="180" height="120" />时间：2014.3.6-4.5<p>上海欢乐谷</p></li>
<li><img src="images/typeact8.jpg" width="180" height="120" />时间：2014.2.8-3.15<p>东方明珠</p></li>
<li><img src="images/typeact9.jpg" width="180" height="120" />时间：2014.4.8-4.20<p>中华恐龙园</p></li>
<li><img src="images/typeact10.jpg" width="180" height="120" />时间：2014.3.12-4.5<p>横店影视城</p></li>

</ul>
</div>
<div></div>
</div>
<!--主体内容第二部分结束-->
<!--主体内容第三部分开始-->
<div class="jinrtg">
<div class="jinrtg-meun">今日景点团购</div>
<div class="jinrtg-inf">
<ul id="teamin">
<li>
  <div class="w16"><img src="images/jrtg.jpg" width="160" height="120" /></div>
  <div class="w16-r">(团购)上海国际赛车场风洞亲子体验中心套餐</div>
  <div class="w16-rx">团购价<span>￥556</span> 节省230<img src="images/qg.jpg" width="92" height="32" /></div></li>
  <li>
  <div class="w16"><img src="images/jrtg1.png" width="160" height="120" /></div>
  <div class="w16-r">(团购)【买一送一】昆明、大理、丽江木府双飞6日游 </div>
  <div class="w16-rx">团购价<span>￥1199</span> 节省1301<img src="images/qg.jpg" width="92" height="32" /></div></li>

<li>
  <div class="w16"><img src="images/jrtg2.png" width="160" height="120" /></div>
  <div class="w16-r">(团购)昆明、大理、丽江双飞6日游</div>
  <div class="w16-rx">团购价<span>￥1760</span> 节省920<img src="images/qg.jpg" width="92" height="32" /></div></li>

</ul>
</div>
</div>
<!--主体内容第三部分结束-->
<!--主体内容第四部分开始-->
<div class="jdtj">
<div class="jdtj-meun">推荐景点</div>
<div class="jdtj-inf">
<ul id="tuijian">
<c:forEach var="line" items="${sessionScope.OutlineList}">
    <li><a href="/LineShowInfoServlet?lineID=${line.lineID}"><img src='images/${line.picture.picintroduction}' width='240'height='160' /></a><span>推荐理由：${line.reason}</span></li>
</c:forEach>
</ul>
</div>
<div class="jdfy">
    <a href="/ShowLineServlet?action=Outall&OutpageIndex=1">首页</a>
    <a href="/ShowLineServlet?action=Outall&OutpageIndex=${OutpageIndex-1}">上一页</a>
    ${OutpageIndex}/${OuttotalPage}
    <a href="/ShowLineServlet?action=Outall&OutpageIndex=${OutpageIndex+1}">下一页</a>
    <a href="/ShowLineServlet?action=Outall&OutpageIndex=${OuttotalPage}">尾页</a>
</div>
</div>
<!--主体内容第四部分结束-->
<!--底部-->
<div id="foot">
<div id="foot-t"><p>许可证编号：WE125482154 鄂ICP备125478966</p>
<p><a href="#">隐私保护</a> | <a href="#">诚聘英才</a> | <a href="#">关于我们</a> | <a href="#">网站地图</a> | <a href="#">友情链接</a> | <a href="#">商务合作</a></p>
</div>
</div>
</body>
</html>
