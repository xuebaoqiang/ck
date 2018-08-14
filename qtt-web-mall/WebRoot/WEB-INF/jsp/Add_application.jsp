<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

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
<link href="../static/css/album.css" rel="stylesheet">
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
				<a href="ListHome.do" class="navbar-brand d-flex align-items-center">
					<img class="logo" src="../static/images/logo.png"
					title="dapp store" alt="logo"/>
					<h1 style="display: none">全天链 - 区块链应用商店</h1> <strong>全天链 -
						区块链应用商店</strong>
				</a>

				<ul class="nav navbar-nav navbar-right toggler-md-navbar ">
					<li>
						<form class="query" action="ListHome.do"
							method="get" id="queryForm" accept-charset="UTF-8">
							<input type="text" name="username" class="form-control"> <input
								class="btn btn-primary" type="submit" value="查询">
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


	<ul class="rightMenu">
		<li><i class="dappfont icon-logo-wechat"></i> <span> <img
				src="../static/images/wechart.jpg" title="微信公众号" alt="weichart">
		</span></li>
	</ul>

	<div class="container">
		<div class="row submit-title ">
			<h1>提交你的 Dapp</h1>
		</div>
	</div>


	<div class="container submit-from" id="submit-dapp">
		<div class="row">
			<form method="post" novalidate=""
				class="col-md-12 col-sm-12 from-body">
				<div class="col-md-12 col-sm-12 from-body">

					<div class="col-md-6 form-left">
						<div class="form-group ">
							<label class="control-label "><span class="required">*</span>名称</label>
							<input type="text" name="dappname" id="dappname" maxlength="200"
								class="textinput textInput form-control" required="">

						</div>
						<div class="form-group ">
							<label class="control-label "><span class="required">*</span>邮箱地址</label>
							<input type="text" name="dappemail" id="dappemail"
								maxlength="100" class="textinput textInput form-control"
								required="">

						</div>
						<div class="form-group ">
							<label class="control-label "><span class="required">*</span>简单描述</label>
							<input type="text" name="dappresume" id="dappresume"
								maxlength="150" class="textinput textInput form-control"
								required="">

						</div>
						<div class="form-group ">
							<label class="control-label "><span class="required">*</span>官网地址</label>
							<input type="url" name="dappweb" id="dappweb" maxlength="100"
								class="urlinput form-control" required="">

						</div>
						<div class="form-group ">
							<label class="control-label ">LogoUrl</label> <input type="text"
								name="dapplogo" maxlength="255"
								class="textinput textInput form-control" id="dapplogo">

						</div>
						<div class="form-group ">
							<label class="control-label "><span class="required">*</span>作者</label>
							<input type="text" name="dappowner" maxlength="255"
								class="textinput textInput form-control" required=""
								id="dappowner">

						</div>
						<div class="form-group ">
							<span class="required">*</span><label class="control-label ">应用地址</label> <input type="url"
								name="dappaddress" maxlength="100" class="urlinput form-control"
								id="dappaddress">

						</div>
						<div class="form-group ">
							<label class="control-label ">微博</label> <input type="text"
								name="dappweibo" maxlength="100"
								class="textinput textInput form-control" id="dappweibo">

						</div>
						<div class="form-group ">
							<label class="control-label ">微信</label> <input type="text"
								name="ddappwechat" maxlength="100"
								class="textinput textInput form-control" id="ddappwechat">

						</div>
						<div class="form-group ">
							<label class="control-label ">电报</label> <input type="text"
								name="dapptelegram" maxlength="100"
								class="textinput textInput form-control" id="dapptelegram">

						</div>
					</div>
					<div class="col-md-6 form-right">
						<div class="form-group ">
							<label class="control-label "><span class="required">*</span>详细描述</label>
							<textarea name="dappexplain" cols="40" rows="10"
								class="textarea form-control" required="" id="dappexplain"></textarea>

						</div>
						<div class="form-group ">
							<label class="control-label ">基础链</label>
							<div class="form-row">
								<div class="form-group col-md-9">
									<select name="block_chain" class="select form-control"
										id="id_block_chain">
										<option value="0">以太坊</option>

										<option value="1">以太经典</option>

										<option value="2">EOS</option>

										<option value="100">自带主链</option>

										<option value="200">其他</option>

									</select>

								</div>
								<div class="form-group col-md-3">
									<input id="addChain" class="btn btn-primary col-md-12"
										type="button" value="增加地址">
								</div>
							</div>
							<div class="block_chain_info">
								<div class="form-row">
									<div class="form-group col-md-3">
										<select class="form-control" name="dappchaininfo"
											id="dappchaininfo">
											<option value="1">Mainnet</option>
											<option value="2">Ropsten</option>
											<option value="3">Kovan</option>
											<option value="4">Rinkeby</option>
										</select>
									</div>
									<div class="form-group col-md-6">
										<input type="text" name="address" class="form-control">
									</div>
									<div class="form-group col-md-3">
										<input id="addChain" class="btn btn-primary col-md-12"
											type="button" value="删除">
									</div>
								</div>
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label ">GitHub</label> <input type="text"
								name="dappgit" maxlength="100"
								class="textinput textInput form-control" id="dappgit">

						</div>
						<div class="form-group ">
							<label class="control-label ">状态</label> <input type="hidden"
								id="dappstates" name="dappstates" value="0">
							<ul class="form-status">
								<li data-val="0" class="status live-color active ">已上线</li>
								<li data-val="1" class="status beta-color  ">Beta测试</li>
								<li data-val="2" class="status prototype-color  ">原型验证</li>
								<li data-val="3" class="status working-color  ">开发中</li>
								<li data-val="4" class="status concept-color  ">概念</li>
								<li data-val="5" class="status abandoned-color  ">废弃</li>
							</ul>
						</div>
						<div class="form-group ">
							<label class="control-label "><span class="required">*</span>标签</label>
							<select class="form-control" name="dappclassinfo"
								id="dappclassinfo">
								<c:forEach items="${list}" var="art">
									<option value="${art.Id}">${art.ClassName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>

				<div class="col-md-12">
					<input id="btnSave" type="submit"
						style="margin:0 auto; display: block"
						class="btn btn-primary col-md-4" onClick="AddSubmit()" value="确定">
				</div>

			</form>
		</div>
	</div>


	<!-- This is the page footer -->
	<footer class="text-muted">
		<div class="container">
			
		</div>
	</footer>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="../static/js/jquery_3.3.1_jquery.js"></script>
	<script src="../static/js/echarts_4.0.4_echarts.js"></script>
	<script src="../static/js/renderUtil.js"></script>
	<script src="../static/js/popper.min.js"></script>
	<script src="../static/js/bootstrap.min.js"></script>
	<script src="../static/js/holder.min.js"></script>
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

	<script>
		/* 	var dappstates =$('.form-status li').map(function(item){
			console.log('')
			console.log($(this).attr('data-val'))
			}); */
		function AddSubmit() {
			var dappname = $("#dappname").val(); //名称
			if (dappname == "" || dappname == null) {
				alert("请输入名称");
				return;
			}
			var dappemail = $("#dappemail").val(); //邮件
			if (dappemail == null || dappemail == "") {
				alert("请填写邮箱!");
				return;
			}
			var dappresume = $("#dappresume").val(); //概述
			if (dappresume == null || dappresume == "") {
				alert("请描述概述!");
				return;
			}
			var dappexplain = $("#dappexplain").val(); //描述
			if (dappexplain == "" || dappexplain == null) {
				alert("请填写产品详情!");
				return;
			}
			var dappweb = $("#dappweb").val(); //官方地址
			if (dappweb == "" || dappweb == null) {
				alert("请填写地址!");
				return;
			}
			var dapplogo = $("#dapplogo").val(); //图片url
			var dappowner = $("#dappowner").val(); //作者
			if (dappowner == null || dappowner == "") {
				alert("请输入作者!");
				return;
			}
			var dappaddress = $("#dappaddress").val(); //合约地址
			if(dappaddress == null || dappaddress == ""){
				alert("请输入应用地址!");
				return;
			}
			var dappweibo = $("#dappweibo").val(); //微博信息
			var dapptelegram = $("#dapptelegram").val(); //TELEGRAM信息
			var ddappwechat = $("#ddappwechat").val(); //微信信息
			var dappgit = $("#dappgit").val(); //GITHUB信息
			var dappchaininfo = $("#dappchaininfo").val(); //主链信息
			var dappstates = $('.form-status .active').attr('data-val'); //状态
			var dappclassinfo = $("#dappclassinfo").val(); //分类
			if (dappclassinfo == null || dappclassinfo == "") {
				alert("请选择标签!");
				return;
			}
	
	
			var data = "dappname=" + dappname +
				"&dappemail=" + dappemail +
				"&dappresume=" + dappresume +
				"&dappexplain=" + dappexplain +
				"&dappweb=" + dappweb +
				"&dapplogo=" + dapplogo +
				"&dappowner=" + dappowner +
				"&dappaddress=" + dappaddress +
				"&dappweibo=" + dappweibo +
				"&dapptelegram=" + dapptelegram +
				"&ddappwechat=" + ddappwechat +
				"&dappgit=" + dappgit +
				"&dappchaininfo=" + dappchaininfo +
				"&dappstates=" + dappstates +
				"&dappclassinfo=" + dappclassinfo;
			$.ajax({
				url : "InsertApplication.do",
				data : data,
				type : "get",
				dataType : "json",
				success : function(data) {
					if(data.resultVo.resultData == 1){
						alert("添加成功!");
						document.location.href="/qtt-web-mall/home/ListHome.do"
					}
				},
				error : function(err) {}
			})
		}
	</script>


</body>
</html>