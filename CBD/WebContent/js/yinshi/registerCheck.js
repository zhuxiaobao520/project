$(function() {
	$("#registerBtn").click(function(){
		var dragHtml=$(".drag_text").html();
		if(dragHtml!="验证通过"){
			alert("请滑动验证码验证！")
			return;
		}
		$("#signupForm").submit();
	})
})
$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
  $("#signupForm").validate({	  
	  rules: {
      userName: {
        required: true,
        minlength: 4
      },
      userPassword: {
        required: true,
        minlength: 6
      },
      userRealName: {
        required: true,
        minlength: 2
      },
      userAddress: {
          required: true,
          minlength: 2,
      },
      userPhone: {
        required: true,
        minlength: 11
      },
      userIdCard: {
          required: true,
          minlength:18
      },
      userProfession: {
          required: true,
          minlength: 2
      },
      userEmail: {
        required: true,
        email: true
      },
    },
    messages: {
      userName: {
        required: "请输入用户名",
        minlength: "用户名为4到25个字母，数字或下划线"
      },
      userPassword: {
        required: "请输入密码",
        minlength: "密码长度不能小于 6个字母"
      },
      userRealName: {
        required: "请真实姓名",
        minlength: "姓名为2个及以上的字符"
      },
      userAddress: {
          required: "请输入家庭住址",
          minlength: "家庭住址至少2个字符"
      },
      userPhone: {
          required: "请输入联系电话",
          minlength: "请输入有效的11位联系电话"
      },
      userIdCard: {
          required: "请输入18位身份证号码",
          minlength: "身份证为18位数字"
      },
      userProfession: {
          required: "请输入你的职业描述",
          minlength: "职业描述至少2个字符"
      },
      userEmail: "请输入一个正确的邮箱"
     }
    })
});