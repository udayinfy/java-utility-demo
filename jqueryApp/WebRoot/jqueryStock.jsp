<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>jqueryStock.html</title>
    
    <%response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 %>
 	<%response.setDateHeader ("Expires", 0); //prevents caching at the proxy server %>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=GBK">
    <script type="text/javascript" src="js/jquery-1.3.2.js"></script>
    <script type="text/javascript" src="js/jquery_stock.js"></script>
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
    <div id="300001"><a href="#">上证指数：</a><span></span></div>
    <div id="000001"><a href="#">浦发银行：</a><span></span></div>
    <div id="stock">
    	<div id="yes">昨收：<span></span></div>
    	<div id="tod">今开：<span></span></div>
    	<div id="now">当前：<span></span></div>
    </div>
  </body>
</html>
