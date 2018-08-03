<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<html lang="en">
<head>
<script
	src="https://hm.baidu.com/hm.js?bccb109f3920338432e264ac7fe0a6ef">
</script>
<script src="../static/js/hm.js"></script>
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
					title="dapp store" alt="logo">
					<h1 style="display: none">全天链 - 区块链应用商店</h1> <strong>全天链 -
						区块链应用商店</strong>
				</a>

				<ul class="nav navbar-nav navbar-right toggler-md-navbar ">
					<li>
						<form class="query" action="ListHome.do" method="get"
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

	<ul class="rightMenu">
		<li><i class="dappfont icon-logo-wechat"></i> <span> <img
				src="../static/images/wechart.jpg" title="微信公众号" alt="weichart">
		</span></li>
	</ul>
	<!-- appItemsList -->
	<div class="album py-5 bg-light appItems appItemsList">
		<div class="container ">
			<ul class="switchStyle">
				<c:forEach items="${con}" var="art">
					<li><span>今日新增:${art.coun}<b></b></span></li>
					<li><span>所有项目:${art.cn}<b></b></span></li>
				</c:forEach>
			</ul>


			<div class="apps list">
				<table class="table">
					<!-- 标题名称 -->
					<thead>
						<tr>
							<th>#</th>
							<th>名称</th>
							<th>状态</th>
							<th data-field="-static__dau">
								<div id="dauDown">
									日活 
								</div>
							</th>
							<th data-field="-static__tx_24h">
								<div id="txDown">
									24小时交易数 
								</div>
							</th>
							<th data-field="-static__volume_24h">
								<div id="volumeDown">
									24小时交易量 
								</div>
							</th>
							<th>描述</th>
						</tr>
					</thead>
					<tbody>
						<!-- 循环列表 -->
						<c:forEach items="${list.list}" var="arti" varStatus="ids">
							<tr>
								<td>${ids.index+1}<input type="hidden"
									value="${arti.RowID}" id="rowid" class="rowid"/></td>
								<td><a href="javascript:void(0);" onClick="Details('${arti.RowID}')" target="_blank" >
										${arti.DappName} </a></td>
								<td>
									<div class="live-color btn status">${arti.StateName}</div>
								</td>
								<td>${arti.PV_VALUE}</td>
								<td>${arti.TxNum_Value}</td>
								<td>${arti.TxValue_Value}</td>
								<td>${arti.ClassName}</td>
							</tr>
							
						</c:forEach>

					</tbody>
						<input type="hidden" value="${list.Page.CurrentPage}" id="CurrentPage"/>
						<input type="hidden" value="${list.Page.TotalPages}" id="TotalPages"/>
						<input type="hidden" value="${list.Page.IsFinished}" id="IsFinished"/>
				</table>
			</div>


			<div class="row loadMore" id="more">
				<button class="submit-myApp js-more" type="button" name="button" id="jz">加载更多</button>
			</div>
			

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
	<script type="text/javascript">
		$(document).ready(function(){
		 	var IsFinished = $("#IsFinished").val();
		 	if(IsFinished == 1){
		 		$(".js-more").hide()
		 	}
		});
	</script>
	
	<script type="text/javascript">
		$("#button").click(function() {
			$("#queryForm").submit();
		})
	</script>
	
	<!-- 排序 -->
	 <script>
		$("#dauDown").click(function(){
		 	var CurrentPage = $("#CurrentPage").val();
			document.location.href="/qtt-web-mall/home/ListHome.do?PV_VALUE=desc&&page="+CurrentPage;
		});
		
		$("#txDown").click(function(){
		 	var CurrentPage = $("#CurrentPage").val();
			document.location.href="/qtt-web-mall/home/ListHome.do?TxNum_Value=desc&&page="+CurrentPage;
		});
		
		$("#volumeDown").click(function(){
			 var CurrentPage = $("#CurrentPage").val();
			document.location.href="/qtt-web-mall/home/ListHome.do?TxValue_Value=desc&&page="+CurrentPage;
		});
	</script>
	
	<script type="text/javascript">
		
		//下一页  
      $("#jz").click(function(){
      var url = window.location.search;
       var CurrentPage = $("#CurrentPage").val();
           CurrentPage++
       var TotalPages = $("#TotalPages").val();   
      	if(CurrentPage <= TotalPages){
      		if (url.match(/\?[^\?&]+/) != null){
      			var px = url.match(/\?[^\?&]+/)[0].substr(1);
      			var tobo = CurrentPage - 1;
      			if(px == "PV_VALUE=desc"){
      				document.location.href="/qtt-web-mall/home/ListHome.do?PV_VALUE=desc&&page="+CurrentPage;
      			}else if(px == "TxNum_Value=desc"){
      				document.location.href="/qtt-web-mall/home/ListHome.do?TxNum_Value=desc&&page="+CurrentPage;
      			}else if(px == "TxValue_Value=desc"){
      				document.location.href="/qtt-web-mall/home/ListHome.do?TxValue_Value=desc&&page="+CurrentPage;
      			}else if(px == "page="+tobo){
      				document.location.href="/qtt-web-mall/home/ListHome.do?page="+CurrentPage;
      			}
      		}else{
      			document.location.href="/qtt-web-mall/home/ListHome.do?page="+CurrentPage;
      		}
      		
      	}
      }); 
      
      //详情   
    function Details(id){
    	document.location.href="/qtt-web-mall/home/GerGoDetails.do?id="+id;
    }
	</script>
	
	
	
	

</body>
</html>
