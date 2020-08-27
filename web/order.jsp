<%@ page import="hgkj.com.model.entity.Line" %>
<%@ page import="hgkj.com.model.entity.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>途乐行--订单</title>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.4.custom.min.css"  rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script  type="text/javascript" src="js/jquery-ui-1.10.4.custom.min.js"></script>
    <script type="text/javascript" src="js/dingdans.js"></script>
    <script>
       $(function () {
           $("#button").click(function () {
               if ($(this).val()=="提交"){
                   document.getElementById("p1").innerHTML="<img src=\"images/n11.jpg\" width=\"205\" height=\"62\" />";
                   document.getElementById("p2").innerHTML="<img src=\"images/n2.jpg\" width=\"205\" height=\"62\" />"
                   document.getElementById("c1").innerHTML="<img src=\"images/jt21.jpg\" width=\"44\" height=\"60\" />";
                   document.getElementById("c2").innerHTML="<img src=\"images/jt2.jpg\" width=\"44\" height=\"60\" />";
                   document.getElementById('textfield1').setAttribute('disabled', 'disabled')
                   //  为指定的element添加指定的属性，使用原生JS方法
                   jQuery('#textfield1').attr('disabled', 'disabled')
                   document.getElementById('textfield2').setAttribute('disabled', 'disabled')
                   //  为指定的element添加指定的属性，使用原生JS方法
                   jQuery('#textfield2').attr('disabled', 'disabled')
                   document.getElementById('textfield3').setAttribute('disabled', 'disabled')
                   //  为指定的element添加指定的属性，使用原生JS方法
                   jQuery('#textfield3').attr('disabled', 'disabled')
                   document.getElementById('txtLeaveDates').setAttribute('disabled', 'disabled')
                   //  为指定的element添加指定的属性，使用原生JS方法
                   jQuery('#txtLeaveDates').attr('disabled', 'disabled')
                   $(this).val("确认订单");
               if ($(this).val()=="确认订单"){
                   $("#button").click(function () {
                   document.getElementById("p1").innerHTML="<img src=\"images/n11.jpg\" width=\"205\" height=\"62\" />";
                   document.getElementById("p2").innerHTML="<img src=\"images/n22.jpg\" width=\"205\" height=\"62\" />"
                   document.getElementById("p3").innerHTML="<img src=\"images/n3.jpg\" width=\"205\" height=\"62\" />";
                   document.getElementById("rf").innerHTML="<input name=\"button\" type=\"image\" id=\"button\" value='pay' src=\"images/js.jpg\" />"
                       $(this).val("pay");
                       if ($(this).val()=="pay"){
                           $("#button").click(function () {
                               var name=$("#textfield1").val();
                               var tel=$("#textfield2").val();
                               var iden=$("#textfield3").val();
                               var time=$("#txtLeaveDates").val();
                             location.href="/OrderServlet?action=insert&carID=<%=request.getSession().getAttribute("carIDS")%>&name="+name+"&tel="+tel+"&iden="+iden+"&time="+time+"";
                           });
                       }
                   });

               }

               }
           });

       });
    </script>
    <style>
        .people{
            margin-right: 15px;
        }
        strong{
            color: white;
            font-size: 15px;
        }
        #to{
color: red;
            font-size: 26px;
        }
    </style>
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

<!--主体内容第一部分开始-->
<div class="dingdan">
<div class="dingdan-m">
<ul>

<li id="p1"><img src="images/n1.jpg" width="205" height="62" /></li>
<li id="c1"><img src="images/jt2.jpg" width="44" height="60" /></li>
<li id="p2"><img src="images/n22.jpg" width="205" height="62" /></li>
<li id="c2"><img src="images/jt21.jpg" width="44" height="60" /></li>
<li id="p3"><img src="images/n33.jpg" width="205" height="62" /></li>

</ul>
</div>
<div class="dingdan-inf">
<div class="dingdan-infm">线路信息</div>
<div class="dingdan-mm">
<div class="dingdan-x">线路信息</div>
<div class="dingdan-lx">
<ul>
<li class="ds">线路编号</li>
<li class="ds">线路名称</li>
<li class="ds">单价</li>
<li class="ds">出行工具</li>
    <%
        Line line=(Line) session.getAttribute("lines");

    %>
    <li id="de"><%=line.getLineID()%></li>
    <li ><%=line.getLineName()%><%=line.getDays()%>日游</li>
    <li>￥<%=line.getPrice()%></li>
    <li><%=line.getVehicle()%></li>
</ul>
</div>
</div>
<div class="dingdan-infm">填写游客信息&nbsp;&nbsp;<span>请准确填写游客信息，以免发生不必要的纠纷&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
   <span style="color:red">*</span>选择出游日期：<input type="text" value="" id="txtLeaveDates" name="time" /><span></span>
</div>
<div class="vistor_info"> <!--游客的信息,以下是增加，删除的内容-->
<div class="dingdan-mm">
  <div class="dingdan-x">游客信息</div>
  <div class="youke">
  <ul>
      <li><span>*</span> 真实姓名 :
      <input name="name" type="text" id="textfield1" size="20" class="t1"/>

        <li><span>*</span> 手机 :
      <input name="tel" type="text" id="textfield2" size="20" class="t2"/>

        <li><span>*</span> 身 份 证 :
          <input name="iden" type="text" id="textfield3" size="20"class="t3" />

      <li class="opli"></li>
    </ul>
  </div>
</div>
</div>  <!--游客结束-->

<div class="people" align="right" id="jine">
    <strong >应付总额：</strong><span id="to"><%=line.getPrice()%></span><strong>元</strong>
</div>
<div class="xyb" id="rf">
  <input name="button" type="image" id="button" value="提交" src="images/xyb.jpg" />
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
</body>
</html>
