$(function(){
	$("#tongzhishuangfang").click(function(){
		var agreementNo = $("#agreementNo").val();
		if(agreementNo == ""){
			alert("请输入合同编号");
		}else{
			var agreementCarportId = $("#agreementCarportId").val();
			var agreementBuyInfoId = $("#agreementBuyInfoId").val();
			location.href="tongzhishuangfang?agreementCarportId="
				+agreementCarportId+"&agreementBuyInfoId="
				+agreementBuyInfoId+"&agreementNo="+agreementNo;
		}
	});
});

