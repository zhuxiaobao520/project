$(function(){
	$("#fasongtongzhi").click(function(){
		var hid = $("#hid").val();
		var yuanyin = $("#yuanyin").val();
		var userid = $("#userid").val();
		if (yuanyin == ""||yuanyin == undefined||yuanyin==null) {
			alert("请输入原因");
		}else{
			location.href="insertMessage?id="+hid+"&userid="+userid+"&yuanyin="+yuanyin;
		}
	});
});