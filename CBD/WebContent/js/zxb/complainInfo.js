
var clickType;
$(function(){
	//点击投诉生效
	$("#complainAccept").click(function(){
		clickType=$(this).val();
		goToSolveComplain();
	});
	//点击投诉无效
	$("#complainDeny").click(function(){
		clickType=$(this).val();
		goToSolveComplain();
	});
	//点击暂缓处理
	$("#complainPostpone").click(function(){
		clickType=$(this).val();
		goToSolveComplain();
	});
});
function goToSolveComplain(){
	location.href="solveComplain?complaintCheckedId="+$("#checkedComplainId").val()+"&clickType="+clickType;
}