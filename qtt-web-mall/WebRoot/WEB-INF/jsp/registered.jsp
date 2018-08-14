<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html lang="en">
<script src="../static/js/hm.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<title>全天链区块链应用商店</title>

<!-- Bootstrap core CSS -->
<link href="../static/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../static/static/css/album.css" rel="stylesheet">
<link href="../static/css/theme.css" rel="stylesheet">
<link href="../static/css/responsive.css" rel="stylesheet">
<link href="../static/css/iconfont.css" rel="stylesheet">




</head>

<body>
	<!-- This is the page header -->
	<header class="header">

		<div class="navbar navbar-dark bg-dark box-shadow">
			<div class="container d-flex justify-content-between"
				style="width: 100%">
				<a href="App_home.jsp"
					class="navbar-brand d-flex align-items-center"> <img
					class="logo" src="../static/images/logo.png" title="dapp store" alt="logo">
					<h1 style="display: none">全天链 - 区块链应用商店</h1> <strong>全天链 -
						区块链应用商店</strong>
				</a>

				<ul class="nav navbar-nav navbar-right toggler-md-navbar ">
					<li>
						<form class="query" action="/qtt-web-mall/home/ListHome.do" method="get"
							id="queryForm" accept-charset="UTF-8">
							<input type="text" name="username" class="form-control"
								id="username">
						    <input class="btn btn-primary"
								type="button" id="button" value="查询">
						</form>
					</li>
					<li><a href="/qtt-web-mall/home/ListHome.do">
							<button class="" type="button" name="button">Dapps</button>
					</a></li>
					<li><a href="/qtt-web-mall/home/GoAdd.do">
							<button class="submit-myApp" type="button" name="button">提交我的应用</button>
					</a></li>
				</ul>
			</div>
		</div>
	</header>




	<div class="container">
		<div class="row submit-title ">
			<h1>全天链注册</h1>
		</div>
	</div>

	<div class="container submit-from" id="submit-dapp">
		<div class="row" style="margin-bottom:40px;">
			<form method="post" novalidate=""
				class="col-md-12 col-sm-12 from-body">
				<div class="col-md-12 col-sm-12 from-body">
					<div class="col-6" style="margin: 0 auto;">
						<div class="form-group ">
							<label class="control-label "><span class="required">*</span>用户名</label>
							<input type="text" name="uname" maxlength="200"
								class="textinput textInput form-control" required=""
								id="uname" onblur="messuser()"><span id="user" style="color: red"></span>
						</div>
						
						<div class="form-group ">
							<label class="control-label "><span class="required">*</span>密码</label>
							<input type="password" name="password" maxlength="100"
								class="textinput textInput form-control" required=""
								id="password">
						</div>
						
						<div class="form-group ">
							<label class="control-label "><span class="required">*</span>确认密码</label>
							<input type="password" name="passwordto" maxlength="150"
								class="textinput textInput form-control" required=""
								id="passwordto"  onblur="messyz()"><span id="a" style="color: red"></span>
						</div>
						
						<div class="form-group ">
							<label class="control-label "><span class="required">*</span>邮箱</label>
							<input type="url" name="email" maxlength="100"
								class="urlinput form-control" required="" id="email">
						</div>
						
						<div class="form-group ">
							<label class="control-label "><span class="required">*</span>ETH地址</label>
							<input type="url" name="ethurl" maxlength="100"
								class="urlinput form-control" required="" id="ethurl">
						</div>
					</div>
				</div>
				
				<div class="col-md-12">
					<input id="btnSave" type="submit"
						style="margin:0 auto; display: block"
						class="btn btn-primary col-md-4" value=提交>
				</div>
			</form>
		</div>
	</div>



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="../static/js/jquery_3.3.1_jquery.js"></script>
	<script src="../static/js/echarts_4.0.4_echarts.js"></script>
	<script src="../static/js/renderUtil.js"></script>
	<script src="../static/js/popper.min.js"></script>
	<script src="../static/js/bootstrap.min.js"></script>
	<script src="../static/js/holder.min.js"></script>
	<script src="../static/js/zhuce.js"></script>
	<script type="text/javascript" src="../static/js/main.js"></script>


	<script src="../static/js/dapp_form.js"></script>

	<!-- This is the baidu tongji -->
	<div style="display: none">
		<!-- 数据统计 -->
		<script>
			var _hmt = _hmt || [];
			(function() {
				var hm = document.createElement("script");
				hm.src = "https://hm.baidu.com/hm.js?bccb109f3920338432e264ac7fe0a6ef";
				var s = document.getElementsByTagName("script")[0];
				s.parentNode.insertBefore(hm, s);
			})();
		</script>
	</div>
	
	

</body>
</html>