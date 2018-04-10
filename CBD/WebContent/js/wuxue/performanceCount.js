var time=10000;
$(function() {
	getAjax();
	$("#time").change(function(){
		/**
		 * 每次改变统计间隔时间就停止之前的setInterval方法
		 */
		clearInterval(interval);
		time=$("#time option:selected").val();
		time=time*1000;
		/**
		 * 时间改变后重新设置setInterval方法的时间间隔
		 */
		interval=setInterval("getAjax()", time);	
	});
	var interval= setInterval("getAjax()", time);	
});

function getAjax() {
	$.getJSON("/CBD/performanceCount", // 请求的url地址
	{}, getAjaxData); // 回调函数

}

// 定义接收Ajax回调函数
function getAjaxData(performanceInfo) {

	var allPath = performanceInfo[0];
	var allElapseTime = performanceInfo[1];
	/**
	 * 控制报表中显示数据的数量，使其只显示5条记录
	 */
	var pathX = [];
	var elapseTimeY = [];

	if (allPath.length > 6) {
		for (var i = allPath.length - 5; i < allPath.length; i++) {
			pathX.push(allPath[i]);
		}
	} else {
		pathX = allPath;
	}
	
	if (allElapseTime.length > 6) {
		for (var i = allElapseTime.length - 5; i < allElapseTime.length; i++) {
			elapseTimeY.push(allElapseTime[i]);
		}
	} else {
		elapseTimeY = allElapseTime;
	}
	
	/**
	 * 实例容器
	 */
	var dom = document.getElementById("container");

	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	option = {
		/**
		 * 提示框，鼠标悬浮交互时的信息提示
		 */
		tooltip : {
			trigger : 'axis',
			formatter : pathX
		},

		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		xAxis : {
			type : 'category',
			axisLabel : {
				/**
				 * 使横坐标显示完全
				 */
				interval : 0,
				/**
				 * 设置字体倾斜
				 * 倾斜度 -90 至 90 ，默认为0
				 */
				rotate :22,
				margin : 2,
				textStyle : {
					fontWeight : "bolder",
					color : "#000000"
				},
			},
			data : pathX
		},
		yAxis : {
			type : 'value'
		},
		/**
		 * 给出Y轴数据，elapseTimeY
		 */
		series : [ {
			data : elapseTimeY,
			type : 'line'
		} ]
	};
	if (option && typeof option === "object") {
		/**
		 * 设置图表实例的配置项以及数据，万能接口，所有参数和数据的修改都可以通过setOption完成， ECharts
		 * 会合并新的参数和数据，然后刷新图表。 如果开启动画的话，ECharts 找到两组数据之间的差异然后通过合适的动画去表现数据的变化。
		 */
		myChart.setOption(option, true);
	}

}