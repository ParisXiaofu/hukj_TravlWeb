<%@ page import="hgkj.com.model.entity.Customer" %>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>途乐行--首页</title>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
  <style>

  </style>
  <script>
      // 左侧境内游
    $(function () {
        $.post(
            "/ShowLineServlet",
            {"action":"inCountry"},
            function (data) {
                var result="";
            $(data).each(function () {
                result+="<li><a href='/LineShowInfoServlet?lineID="+this.lineID+"'>"+this.lineName+"</a></li>";
            });
            $("#in").html(result);
        },"json");
    });
    //右侧境内游
      rightIn();
      function rightIn() {
              $.post(
                  "/ShowLineServlet",
                  {"action":"inCountry"},
                  function (data) {
                      var result="";
                      $(data).each(function () {
                          result+=" <div class=\"con-2inf\">\n" +
                              "                      <ul>\n" +
                              "                      <li class=\"w130\"><a href='/LineShowInfoServlet?lineID="+this.lineID+"'><img src='images/"+this.picture.picintroduction+"' width=\"120\" height=\"75\" /></a> 产品编号"+this.lineID+"</li>\n" +
                              "                      <li class=\"w440\">\n" +
                              "                          <div class=\"w440lx\"><a href='/LineShowInfoServlet?lineID="+this.lineID+"'>["+this.days+"日游] &nbsp;&nbsp;"+this.lineName+this.days+"日游 &nbsp;&nbsp;交通工具（"+this.vehicle+"）</a></div>\n" +
                              "                      <div class=\"w440xx\"><a href='/LineShowInfoServlet?lineID="+this.lineID+"' >简介："+this.reason+"</a> <br />" +
                              "                      本线路已有<span>5144</span>人出游 </div>\n" +
                              "                      </li>\n" +
                              "                      <li class=\"w140\"><br />\n" +
                              "                          <span>￥"+this.price+"元/每人</span></li>\n" +
                              "                      </ul>\n" +
                              "                      </div>" ;
                      });
                      $("#left-in").html(result);
                  },"json");
          };

    // 境外游
    $(function () {
        $.post(
            "/ShowLineServlet",
            {"action":"outCountry"},
            function (data) {
                var result="";
                $(data).each(function () {
                    result+="<li><a href='/LineShowInfoServlet?lineID="+this.lineID+"'>"+this.lineName+"</a></li>";
                });
                $("#out").html(result);
            },"json");
    });
      //右侧境外游
      function rightOut() {
          $.post(
              "/ShowLineServlet",
              {"action":"outCountry"},
              function (data) {
                  var result="";
                  $(data).each(function () {
                      result+=" <div class=\"con-2inf\">\n" +
                          "                      <ul>\n" +
                          "                      <li class=\"w130\"><a href='/LineShowInfoServlet?lineID="+this.lineID+"'><img src='images/"+this.picture.picintroduction+"' width=\"120\" height=\"75\" /></a> 产品编号"+this.lineID+"</li>\n" +
                          "                      <li class=\"w440\">\n" +
                          "                          <div class=\"w440lx\"><a href='/LineShowInfoServlet?lineID="+this.lineID+"'>["+this.days+"日游] &nbsp;&nbsp;"+this.lineName+this.days+"日游 &nbsp;&nbsp;交通工具（"+this.vehicle+"）</a></div>\n" +
                          "                      <div class=\"w440xx\"><a href='/LineShowInfoServlet?lineID="+this.lineID+"'  id=\"jj\">简介："+this.reason+"</a> <br />\n" +
                          "                      本线路已有<span>5144</span>人出游 </div>\n" +
                          "                      </li>\n" +
                          "                      <li class=\"w140\"><br />\n" +
                          "                          <span>￥"+this.price+"元/每人</span></li>\n" +
                          "                      </ul>\n" +
                          "                      </div>" ;
                  });
                  $("#left-in").html(result);
              },"json");
      };
    // 海岛游
    $(function () {
        $.post(
            "/ShowLineServlet",
            {"action":"sea"},
            function (data) {
                var result="";
                $(data).each(function () {
                    result+="<li><a href='/LineShowInfoServlet?lineID="+this.lineID+"'>"+this.lineName+"</a></li>";
                });
                $("#sea").html(result);
            },"json");
    });
      //右侧海岛游
      function rightSea() {
          $.post(
              "/ShowLineServlet",
              {"action":"sea"},
              function (data) {
                  var result="";
                  $(data).each(function () {
                      result+=" <div class=\"con-2inf\">\n" +
                          "                      <ul>\n" +
                          "                      <li class=\"w130\"><a href='/LineShowInfoServlet?lineID="+this.lineID+"'><img src='images/"+this.picture.picintroduction+"' width=\"120\" height=\"75\" /></a> 产品编号"+this.lineID+"</li>\n" +
                          "                      <li class=\"w440\">\n" +
                          "                          <div class=\"w440lx\"><a href='/LineShowInfoServlet?lineID="+this.lineID+"'>["+this.days+"日游] &nbsp;&nbsp;"+this.lineName+this.days+"日游 &nbsp;&nbsp;交通工具（"+this.vehicle+"）</a></div>\n" +
                          "                      <div class=\"w440xx\"><a href='/LineShowInfoServlet?lineID="+this.lineID+"'  id=\"jj\">简介："+this.reason+"</a> <br />\n" +
                          "                      本线路已有<span>5144</span>人出游 </div>\n" +
                          "                      </li>\n" +
                          "                      <li class=\"w140\"><br />\n" +
                          "                          <span>￥"+this.price+"元/每人</span></li>\n" +
                          "                      </ul>\n" +
                          "                      </div>" ;
                  });
                  $("#left-in").html(result);
              },"json");
      };
    // 自驾游
    $(function () {
        $.post(
            "/ShowLineServlet",
            {"action":"myself"},
            function (data) {
                var result="";
                $(data).each(function () {
                    result+="<li><a href='/LineShowInfoServlet?lineID="+this.lineID+"'>"+this.lineName+"</a></li>";
                });
                $("#myself").html(result);
            },"json");
    });
      //右侧自驾游
      function rightMyself() {
          $.post(
              "/ShowLineServlet",
              {"action":"myself"},
              function (data) {
                  var result="";
                  $(data).each(function () {
                      result+=" <div class=\"con-2inf\">\n" +
                          "                      <ul>\n" +
                          "                      <li class=\"w130\"><a href='/LineShowInfoServlet?lineID="+this.lineID+"'><img src='images/"+this.picture.picintroduction+"' width=\"120\" height=\"75\" /></a> 产品编号"+this.lineID+"</li>\n" +
                          "                      <li class=\"w440\">\n" +
                          "                          <div class=\"w440lx\"><a href='/LineShowInfoServlet?lineID="+this.lineID+"'>["+this.days+"日游] &nbsp;&nbsp;"+this.lineName+this.days+"日游 &nbsp;&nbsp;交通工具（"+this.vehicle+"）</a></div>\n" +
                          "                      <div class=\"w440xx\"><a href='/LineShowInfoServlet?lineID="+this.lineID+"'  id=\"jj\">简介："+this.reason+"</a> <br />\n" +
                          "                      本线路已有<span>5144</span>人出游 </div>\n" +
                          "                      </li>\n" +
                          "                      <li class=\"w140\"><br />\n" +
                          "                          <span>￥"+this.price+"元/每人</span></li>\n" +
                          "                      </ul>\n" +
                          "                      </div>" ;
                  });
                  $("#left-in").html(result);
              },"json");
      };
    //一日游
      $(function () {
          $.post(
              "/ShowLineServlet",
              {"action":"one"},
              function (data) {
                  var result="";
                  $(data).each(function () {
                      result+="<li><a href='/LineShowInfoServlet?lineID="+this.lineID+"'>"+this.lineName+"</a></li>";
                  });
                  $("#one").html(result);
              },"json");
      });
      //两日游
      $(function () {
          $.post(
              "/ShowLineServlet",
              {"action":"two"},
              function (data) {
                  var result="";
                  $(data).each(function () {
                      result+="<li><a href='/LineShowInfoServlet?lineID="+this.lineID+"'>"+this.lineName+"</a></li>";
                  });
                  $("#two").html(result);
              },"json");
      });
      //多日游
      $(function () {
          $.post(
              "/ShowLineServlet",
              {"action":"more"},
              function (data) {
                  var result="";
                  $(data).each(function () {
                      result+="<li><a href='/LineShowInfoServlet?lineID="+this.lineID+"'>"+this.lineName+"</a></li>";
                  });
                  $("#more").html(result);
              },"json");
      });
      //团购滚动展示
      $(function () {
          $.post(
              "/ShowLineServlet",
              {"action":"teamshow"},
              function (data) {
                  var result="";
                  $(data).each(function () {
                      result+=" <li><img src='images/"+this.picture.picintroduction+"' width='160' height='88' />" +
                          "<a href='/LineShowInfoServlet?lineID="+this.lineID+"'>"+this.lineName+this.days+"日游"+"</a><br /><span>￥"+this.price+"</span>起 原价"+this.teamBuyPrice+"</li>";
                  });
                  $("#team").html(result);
              },"json");
      });
      //展示订单人数
      $(function () {
          $.post(
              "/OrderServlet",
              {"action":"allcount"},
              function (data) {
                  $("#count").html(data);
              },"text");
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
      <li><a href="#">首页</a></li>
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
<div id="banner"> <img src="images/banner.jpg" width="1003" height="93" /></div>

<!--主体内容第一部分开始-->
<div id="content1"> 
  <!--左侧-->
  <div id="con1-left">

    <div class="con1-1" >境内游</div>
    <div class="cs" >
      <ul id="in">

      </ul>
    </div>
    <div class="con1-2">境外游</div>
    <div class="cs">
      <ul id="out">

      </ul>
    </div>
    <div class="con1-3">海岛游</div>
    <div class="cs">
      <ul id="sea">

      </ul>
    </div>
    <div class="con1-4"></div>
    <div class="cs">
      <ul id="myself">

      </ul>
    </div>
  </div>
  <!--右侧-->
  <div id="con1-right">
    <div id="right-top">
      <div class="banner">
        <ul id="imgs">
          <li><img src="images/tg.jpg" width="540" height="240"/></li>
          <li><img src="images/tg2.jpg" width="540" height="240"/></li>
          <li><img src="images/tg3.jpg" width="540" height="240"/></li>
          <li><img src="images/tg4.jpg" width="540" height="240"/></li>
        </ul>
        <ul id="numbers">
          <li>1</li>
          <li>2</li>
          <li>3</li>
          <li>4</li>
        </ul>
      </div>
      <div class="zcdl">
        <ul>
          <!--登录-->
            <%
                if (customer!=null){
            %>

            <li id="es" style="margin-right:3px;"><a href="/ExitsServlet" ><img src="images/exit.jpg" width="80" height="36" /></a></li>
            <%}else {%>
          <li style="margin-right:3px;" ><a href="login.html"><img src="images/dl.jpg" width="85" height="38" /></a></li>
            <%}%>
          <!--注册-->
          <li><a href="regist.jsp" id="ess"><img src="images/zc.jpg" width="85" height="36" /></a></li>
        </ul>
      </div>
      <div class="my">
        <ul>
          <li><span class="myd">96%</span> 满意度</li>
          <li class="xt">已有<span class="rs" id="count">666</span>人预订出游</li>
          <li class="cls"><a href="/OrderServlet?action=all">查看历史订单</a></li>
        </ul>
      </div>
    </div>
    <div id="right-btm">
      <div class="tgj"><span><a href="/ShowLineServlet?action=teamBuyall">更多旅游特价>></a></span></div>
      <div class="tgjlx">
        <ul style="width:1446px" id="team">

        </ul>
      </div>
    </div>
  </div>
</div>
<!--主体内容第一部分结束--> 
<!--主体内容第二部分开始-->
<div id="con-2"> 
  <!--左侧开始-->
  <div id="con-2left">
    <div id="con-2left1">
      <div class="con-21"></div>
      <div class="jingdian">
        <ul id="one">
          <li><a href="#">古琴台</a></li>
          <li><a href="#">黄鹤楼</a></li>
          <li><a href="#">海洋世界</a></li>
          <li><a href="#">武汉东湖</a></li>
          <li><a href="#">木兰天地</a></li>
          <li><a href="#">汉正街</a></li>
          <li><a href="#">坝子岭</a></li>
          <li><a href="#">武汉欢乐谷</a></li>
        </ul>
      </div>
      <div class="con-22"></div>
      <div class="jingdian">
        <ul id="two">
          <li><a href="#">澳门</a></li>
          <li><a href="#">烟台</a></li>
          <li><a href="#">仰光</a></li>
          <li><a href="#">约旦</a></li>
          <li><a href="#">伊朗</a></li>
          <li><a href="#">德国</a></li>
          <li><a href="#">缅甸</a></li>
          <li><a href="#">希腊</a></li>
        </ul>
      </div>
      <div class="con-23"></div>
      <div class="jingdian">
        <ul id="more">
          <li><a href="#">北京</a></li>
          <li><a href="#">上海</a></li>
          <li><a href="#">加拿大</a></li>
          <li><a href="#">香港</a></li>
          <li><a href="#">海南</a></li>
          <li><a href="#">马尔代夫</a></li>
          <li><a href="#">韩国</a></li>
          <li><a href="#">福建</a></li>
        </ul>
      </div>
      <div class="picj"><img src="images/bb1.jpg" width="248" height="94" /></div>
      <div class="picj"><img src="images/bb2.jpg" width="248" height="94" /></div>
      <div class="picj"><img src="images/bb3.jpg" width="248" height="94" /></div>
    </div>
  </div>
  <!--左侧结束--> 
  <!--右侧开始-->
  <div id="con-2right">
    <div id="con-2meun">
      <ul>
        <li><a href="/ShowLineServlet?action=Inall" onmouseover="rightIn()" >境内游</a></li>
        <li><a href="/ShowLineServlet?action=Outall" onmouseover="rightOut()">境外游</a></li>
        <li><a href="#" onmouseover="rightSea()">海岛游</a></li>
        <li><a href="#" onmouseover="rightMyself()">自驾游</a></li>
      </ul>
    </div>
    <div id="left-in">

  </div>
</div>
</div>
<!--主体内容第二部分结束--> 
<!--底部-->
<div id="foot">
  <div id="foot-t">
    <p>许可证编号：WE125482154 鄂ICP备125478966</p>
    <p><a href="#">隐私保护</a> | <a href="#">诚聘英才</a> | <a href="#">关于我们</a> | <a href="#">网站地图</a> | <a href="#">友情链接</a> | <a href="#">商务合作</a></p>
  </div>
</div>
</body>
</html>
