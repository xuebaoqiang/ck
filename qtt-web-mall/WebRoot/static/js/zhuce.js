//查询
$("#button").click(function() {
			$("#queryForm").submit();
})

//验证用户名
function messuser(){
	var uname = $("#uname").val();
	$.ajax({
		type:"GET",
		url:"/qtt-web-mall/registered/ValidationUser.do",
		data:{
			'uname':uname
		},
		dataType:"json",
		success:function(data){
			if(data.resultVo.resultData == 1){
				document.getElementById("user").innerText="用户名已存在!";
			}else{
				document.getElementById("user").innerText="";
			}
		}
	})
}

//验证密码
function messyz(){
	var password = $("#password").val();
	var passwordto = $("#passwordto").val();
	if(passwordto != password){
		document.getElementById("a").innerText="密码与第一次不符合";
	}else{
		document.getElementById("a").innerText="";
	}
}


//注册提交
$("#btnSave").click(function(){
		var uname = $("#uname").val();
		var password = $("#password").val();
		var email = $("#email").val();
		var ethurl = $("#ethurl").val();
		
		if(uname == null || uname == ""){
			alert("请输入用户名!");
			return;
		}
		if(password == null || password == ""){
			alert("请输入密码!");
			return;
		}
		if(email == null || email == ""){
			alert("请输入邮箱!");
			return;
		}
		 var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		 if(!myreg.test(email)){
			 alert("请输入有效的邮箱地址!");
			 return;
		 }
		 var s = /^0[xX][0-9a-zA-Z]{40}$/;
		 if(!s.test(ethurl)&&ethurl.length < 42){
			 alert("请填写正确的ETH地址!");
			 return;
		 }
		 
			$.ajax({
				type:"GET",
				url:"/qtt-web-mall/registered/InsertRegistered.do",
				data:{
					'uname':uname,
					'password':password,
					'email':email,
					'ethurl':ethurl
				},
				dataType:"json",
				success:function(data){
					if(data.resultVo.resultData ==1){
						alert("注册成功!");
						document.location.href="/qtt-web-mall/login/GoLogin.do"
					}
				}
			})
			
})
