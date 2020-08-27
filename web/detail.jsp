<%@ page import="hgkj.com.model.entity.Line" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="hgkj.com.model.entity.Picture" %>
<%@ page import="hgkj.com.model.entity.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>途乐行--旅游景点</title>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/jqzoom.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.3.2.min.js"></script>
<script src="js/jquery.jqzoom1.0.1.js"></script>
<script src="js/jqzoom.pack.1.0.1.js"></script>
<script src="js/detail.js"></script>
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
    <li><a href="/ShowLineServlet?action=teamBuyall">团购</a></li>
    <li><a href="/CarServlet?action=all"><img src="images/che.jpg" width="176" height="42" /></a></li>
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
<div id="banner"><img src="images/banner.jpg" width="1003" height="93" /></div>

<!--主体内容第一部分开始-->
<div class="jindck">
<div class="jindck-meun">[多重优惠+超值赠送]品质全景，张家界、凤凰、天门山、宝峰湖纯玩双飞5日游<img src="images/tjcp.jpg" width="40" height="40" /><img src="images/fk.jpg" width="40" height="40" /></div>
<div class="jin2">
<div class="jin2-left">
<ul>
<li>
<a href="" title="">
    <%Line line=(Line) session.getAttribute("line");

    %>
<img src="images/${pictureList[0].picintroduction}" width="400" height="250" />

</a>
</li>

<li class="pics"><a href="images/jdckb1.jpg" class="zoom" title="<%=line.getLineName()%>" ><img src="images/${pictureList[1].picintroduction}" width="100" height="63" /></a></li>
<li class="pics"><a href="images/jdckb1.jpg" class="zoom" title="<%=line.getLineName()%>" ><img src="images/${pictureList[2].picintroduction}" width="100" height="63" /></a></li>
<li class="pics"><a href="images/jdckb1.jpg" class="zoom" title="<%=line.getLineName()%>" ><img src="images/${pictureList[3].picintroduction}" width="100" height="63" /></a></li>
</ul>
</div>
<div class="jin2-right">
<ul>

<li>途乐行价：<span class="colorc">￥<%=line.getPrice()%></span></li>
<li>团购价：<strong>￥<%=line.getTeamBuyPrice()%></strong> 起</li>
<li>最大优惠：￥<%=line.getPrice()-line.getTeamBuyPrice()%></li>
<li>出游天数：<%=line.getDays()%>天</li>
<li>出游人数：已有<span>0</span>人出游此线路</li>
<li>提前报名：建议提前一天报名</li>
<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/CarServlet?action=insert"><img src="images/jgwc.jpg" width="122" height="42" /></a></li>
</ul>
</div>
</div>
<div class="tuijian">
<div class="tuijian-m">推荐理由</div>
<div class="tuijian-inf">
<ul>
<%=line.getReason()%>
</ul>
</div>
<div class="tuijian-t">特别优惠</div>
<div class="tuijian-inf">
<ul>
    <li><%=line.getArrange()%></li>
</ul>
</div>
</div>
<div class="jianjie">
<div class="jianjie-m">景点简介</div>
<div> <%=line.getIntroduction()%></div>
<div class="tuijian">
  <div class="tuijian-m">温馨提示</div>
  <div class="tuijian-in">
    <ul>
      <li> 按2人入住1间房核算，如出现单男单女，尽量安排该客人与其他同性别团友拼房；如不愿拼房或未能拼房，请补齐单房差以享用单人房间。 </li>
      <li> 当地购物时请慎重考虑，把握好质量与价格，务必索要发票。 </li>
      <li> 出团通知最晚于出团前1天发送，若能提前确定，我们将会第一时间通知您。 </li>
      <li> 出游过程中，如产生退费情况，以退费项目旅行社折扣价为依据，均不以挂牌价为准。 </li>
      <li> 如遇国家政策性调整门票、交通价格等，按调整后的实际价格结算。 </li>
    </ul>
  </div>
</div>
</div>
<!--主体内容第一部分结束-->
<!--底部-->
<div id="foot">
<div id="foot-t"><p>许可证编号：WE125482154 鄂ICP备125478966</p>
<p><a href="#">隐私保护</a> | <a href="#">诚聘英才</a> | <a href="#">关于我们</a> | <a href="#">网站地图</a> | <a href="#">友情链接</a> | <a href="#">商务合作</a></p>
</div>
</div>
</div>
</body>
</html>
