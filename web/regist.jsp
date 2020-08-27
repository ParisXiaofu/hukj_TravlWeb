<%@ page import="hgkj.com.model.entity.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新用户注册</title>
  <script type="text/javascript" src="js/shop.js"></script>
  <script src="js/jquery.js" type="text/javascript"></script>

  <script type="text/javascript">
      function change() {
          document.getElementById("ig").src="/YzmServlet?id"+Math.random();
      }
  </script>
<style type="text/css">
.txtInit {
	border: 1px #cecece solid;
}
.txtFocus {
	border: 1px solid #009;
}
span{
 color: red
}
.spanInit {
	width: 300px;
	height: 22px;
	display: block;
	float: right;
	background-repeat: no-repeat;
	background-position: left;
}
/*邮箱输入正确，设置打勾的背景图片*/
.spanBlurOk{
	
	background-image:url(images/right.jpg);
}
#ig{
  height:25px;  padding-left:5px;
  position: absolute;
}

    #mmsg{
        font-size: 36px;
        color:red;
        text-align: center;
        font-family: 微软雅黑;
    }
</style>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/regist.js"></script>
</head>

<body>
<!--头部-->
<div id="top-cont">
  <div id="top-min">
    <div id="min-left"></div>
    <div id="min-right"></div>
  </div>
</div>
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


<!--注册版块-->
<div id="reg">

  <div id="reg-top">&nbsp;&nbsp;&nbsp;&nbsp;会员注册</div>
  <div id="reg-mleft">
  <form action="/RegisterServlet" onsubmit="return check() " method="post">
    <ul>
      <li class="m">用户帐号：</li>
      <li class="r" >
        <input name="account" type="text" class="box txtInit" id="txtNo" />
        <span id='prompt_no' class="spanInit" ></span></li>
      <li class="m">设置密码：</li>
      <li class="r">
        <input name="textfield" type="password" class="box txtInit" id="txtPwd" />
        <span id='prompt_pwd'  class="spanInit" ></span></li>
      <li class="m">确认密码：</li>
      <li class="r">
        <input name="password" type="password" class="box txtInit" id="txtConfirmPwd" />
        <span id='prompt_confirmpwd' class="spanInit"  ></span></li>
      <li class="m">用户姓名：</li>
      <li class="r">
        <input name="name" type="text" class="box txtInit" id="txtName" />
        <span id='prompt_name' class="spanInit"  ></span></li>
      <li class="m">身份证号：</li>
      <li class="r">
        <input name="identityID" type="text" class="box txtInit" id="txtId" />
        <span id='prompt_id' class="spanInit"   ></span></li>
      <li class="m">性 别：</li>
      <li class="r">
        <input name="gender" type="radio" id="radio" value="男" checked="checked" class="gender"/>
        男
        <input type="radio" name="gender" id="radio2" value="女" class="gender" />
        女 </li>
      <li class="m">手机号码：</li>
      <li class="r">
        <input name="tel" type="text" class="box txtInit" id="txtPhone" />
        <span id='prompt_phone' class="spanInit" ></span></li>
      <li class="m" >校验码：</li>
      <li class="r">
        <input name="yzm" type="text" class="box txtInit" id="yzm" size="15" />
        <img src="/YzmServlet" id="ig"/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        看不清？<a  onclick="change()">换一张</a><span id="msg"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></span></li>
      <li class="m"> </li>
      <li class="r">
        <input name="button"  type="image" id="btn" value="提交" src="images/but2.jpg"  />
      </li>
      <li class="m"> </li>
      <li class="r">
        <input name="checkbox" type="checkbox" id="checkbox" checked="checked" />
        《途乐行旅游网会员服务条款》 <img src="images/jt.jpg" width="13" height="12" /></li>
    </ul>
      </form>
  </div>

  <div id="reg-right">
    <div><img src="images/kf.jpg" width="230" height="150" /></div>
    <div id="kf2"><a href="login.html">已有账户，请点击登录</a></div>
      <div id="kf" ><span id="mmsg"><%=request.getAttribute("mmsg")==null?"":request.getAttribute("mmsg")%></span></div>
  </div>
</div>
<!--底部-->
<div id="foot">
  <div id="foot-t"> 
    <p>许可证编号：WE125482154 鄂ICP备125478966</p>
    <p><a href="#">隐私保护</a> | <a href="#">诚聘英才</a> | <a href="#">关于我们</a> | <a href="#">网站地图</a> | <a href="#">友情链接</a> | <a href="#">商务合作</a></p>
  </div>
</div>
</body>
</html>
