<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>全天链 区块链应用商店</title>

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
						<form class="query" action="ListHome.do" method="get"
							id="queryForm" accept-charset="UTF-8">
							<input type="text" name="username" class="form-control"
								id="username">
						    <input class="btn btn-primary"
								type="button" id="cbutton" value="查询">
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
	<!-- This is the page body -->
	<main role="main" class="">

		<div class="album py-5 bg-light ">
			<div class="container ">

				<div class="row">
					<div
						class="col-xs-12 col-sm-12 col-md-12 col-lg-12 statusModul appInfo live"
						data-id="3">
						<div class="card box-shadow ">
								<a href="" id="sta"><i
								class="dappfont direction icon-zuoce"></i></a>
							 <a
								href="" id="end"><i
								class="dappfont direction icon-fangxiang"></i></a>
							<div class="card-body">		

								<div class="title ">
									<h4>${map.DappName}</h4>
									<p class="card-text">${map.DappResume}</p>

									<a href="${map.DappWeb}?qtt_source=qtl"
										target="_blank" class="submit-myApp"> 查看官网 </a>

								</div>
								<hr>

								<div class="info">
									<div class="status">
										<p class="status-text">${map.StateName}</p>
										<ul>

										</ul>
									</div>
									<section class="section">
										<p style="white-space:pre-line">${map.DappExplain}</p>

										<div class="detail row" style="padding: 0; margin: 0">
											<div class="col-xs-12 col-sm-12 col-md-4 col-lg-3">
												<table class="table">
													<tbody>
														<tr>
															<td>24小时交易额</td>
															<td>708.61</td>
														</tr>
														<tr>
															<td>7天交易额</td>
															<td>5,746.98</td>
														</tr>
														<tr>
															<td>24小时交易笔数</td>
															<td>5109</td>
														</tr>
														<tr>
															<td>7天交易笔数</td>
															<td>27453</td>
														</tr>
														<tr>
															<td>日活</td>
															<td>1503</td>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="chart col-xs-12 col-sm-12 col-md- col-lg-9">

												<ol class="nav nav-tabs">
													<li class="nav-item"><a class="nav-link active"
														data-key="table">合约地址</a></li>
													<li class="nav-item"><a class="nav-link"
														data-key="chart">图表</a></li>
													
												</ol>

												<table class="table contracts" style="display: block;">
													<thead>
														<tr>
															<th>地址</th>
														</tr>
													</thead>
													<tbody>

														<tr>
															<td><a  target="_blank">${map.DappAddress}</a></td>
														</tr>

													</tbody>
												</table>

												<div class="dataChart" style="display: none;">
													<div class="btn-group" role="group"
														aria-label="Basic example">
														<button type="button" class="btn btn-secondary active"
															data-val="7d">7天</button>
														<button type="button" class="btn btn-secondary"
															data-val="24h">24小时</button>
														<button type="button" class="btn btn-secondary"
															data-val="1h">1小时</button>
													</div>
													<div id="detailChart" _echarts_instance_="ec_1532056834048"
														style="-webkit-tap-highlight-color: transparent; user-select: none; position: relative;">
														<div
															style="position: relative; overflow: hidden; width: 778px; height: 283px; padding: 0px; margin: 0px; border-width: 0px; cursor: default;">
															<canvas data-zr-dom-id="zr_0" width="778" height="283"
																style="position: absolute; left: 0px; top: 0px; width: 778px; height: 283px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); padding: 0px; margin: 0px; border-width: 0px;"></canvas>
														</div>
														<div
															style="position: absolute; display: none; border-style: solid; white-space: nowrap; z-index: 9999999; transition: left 0.4s cubic-bezier(0.23, 1, 0.32, 1), top 0.4s cubic-bezier(0.23, 1, 0.32, 1); background-color: rgba(50, 50, 50, 0.701961); border-width: 0px; border-color: rgb(51, 51, 51); border-radius: 4px; color: rgb(255, 255, 255); font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 14px; font-family: &quot;Microsoft YaHei&quot;; line-height: 21px; padding: 5px; left: 427px; top: 84px;">
															<div>
																<span
																	style="width: 10px; margin-right: 5px; border-radius: 10px; display:inline-block; height: 10px; background-color: #c23531"></span>交易笔数:
																5,645<br> <span
																	style="width: 10px; margin-right: 5px; border-radius: 10px; display:inline-block; height: 10px; background-color: #2f4554"></span>燃料费:
																1,370,314.21<br> <span
																	style="width: 10px; margin-right: 5px; border-radius: 10px; display:inline-block; height: 10px; background-color: #61a0a8"></span>交易金额:
																1,613.18<br>
															</div>
														</div>
													</div>
												</div>

											</div>
										</div>

										<ul>
											<li><b>开发者</b> <span>${map.DappOwner}</span></li>
											<li><b>提交时间</b> <span>${map.DappCreateDate}</span></li>
											<li><b>最后修改时间</b> <span>${map.DappUpdateDate}</span></li>
										</ul>

										<ul>
											<li><a target="_blank" href="/qtt-web-mall/home/ListHome.do?Classname=${map.ClassName}">#${map.ClassName}</a></li>
										</ul>

									</section>
								</div>

							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

	</main>
	<!-- This is the page footer -->
	<footer class="text-muted">
		<div class="container">
			
		</div>
	</footer>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="../static/js/hm.js"></script>
	<script src="../static/js/jquery_3.3.1_jquery.js"></script>
	<script src="../static/js/echarts_4.0.4_echarts.js"></script>
	<script src="../static/js/renderUtil.js"></script>
	<script src="../static/js/popper.min.js"></script>
	<script src="../static/js/bootstrap.min.js"></script>
	<script src="../static/js/holder.min.js"></script>
	<script type="text/javascript" src="../static/js/main.js"></script>


	<script src="../static/js/dapp_form.js"></script>
	<script type="text/javascript">
		$("#cbutton").click(function() {
			$("#queryForm").submit();
		})
	</script>
	<script >
	
	if(${mapend.RowID}>=${map.RowID}){
		document.getElementById("end").href="/qtt-web-mall/home/GerGoDetails.do?id="+${mapstart.RowID}
	}
	if(${mapstart.RowID}<=${map.RowID}){
		document.getElementById("sta").href="/qtt-web-mall/home/GerGoDetails.do?id="+${mapend.RowID}
	}
	if(${map.RowID} < ${mapend.RowID}){
		document.getElementById("end").href="/qtt-web-mall/home/GerGoDetails.do?id="+${map.RowID+1}
	}
	if(${map.RowID} > ${mapstart.RowID}){
	    document.getElementById("sta").href="/qtt-web-mall/home/GerGoDetails.do?id="+${map.RowID-1};
	}
		
	</script >

</body>
</html>