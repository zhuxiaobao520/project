/*
 * 判断登录类型，并跳转到不同的页面控制器
 */
$(function(){
	//点击不同登录修改隐藏域登录类型，-1表示个人用户登录、0表示管理员登录、1表示企业用户登录
	$("#userLogin").click(function(){
		$("#loginTypeHidden").val("-1");
		$(this).css("color","blue");
		$(this).siblings().css("color","#444")
	})
	$("#companyLogin").click(function(){
		$("#loginTypeHidden").val("1");
		$(this).css("color","blue");
		$(this).siblings().css("color","#444")
	})
	$("#adminLogin").click(function(){
		$("#loginTypeHidden").val("0");
		$(this).css("color","blue");
		$(this).siblings().css("color","#444")
	})
	
	//给登录按钮添加事件，根据隐藏域中值的不同，来修改表单提交的路径
	$("#loginBtn").click(function(){
		//获取隐藏域中的值
		var type = $("#loginTypeHidden").val();
		if(type == -1){
			$("#loginForm").attr("action","userLogin");
		}else if(type == 1){
			$("#loginForm").attr("action","companyLogin");
		}else if(type == 0){
			$("#loginForm").attr("action","admLogin");
		}		
		var account=$("#account").val();
		var password=$("#password").val();
		var dragHtml=$(".drag_text").html();
		if(account==""){
			alert("请输入用户名！")
			return;
		}
		if(password==""){
			alert("请输入密码！")
			return;
		}
		if(dragHtml!="验证通过"){
			alert("请滑动验证码验证！")
			return;
		}
		$("#loginForm").submit();
	})
	
	
})