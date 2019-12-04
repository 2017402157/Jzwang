layui.config({
	base : "js/"
}).use(['form','element','layer','jquery','table'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		element = layui.element,
		table = layui.table,
		$ = layui.jquery;
	//============================获取新闻数量=======================================
	$.get("getNewscount" , function(data){
		var d = data.m;
		var arr = [];
		layui.each(d, function(index, item){
			arr.push("<div class='stat-digit'>"+item.data+"</div>");
		});
		$("#news").append(arr.join(''));
		form.render();
	});
	
	$.get("getMessagecount" , function(data){
		var d = data.m;
		var arr = [];
		layui.each(d, function(index, item){
			arr.push("<div class='stat-digit'>"+item.data+"</div>");
		});
		$("#massage").append(arr.join(''));
		form.render();
	});
	$.get("getUsercount" , function(data){
		var d = data.m;
		var arr = [];
		layui.each(d, function(index, item){
			arr.push("<div class='stat-digit'>"+item.data+"</div>");
		});
		$("#user").append(arr.join(''));
		form.render();
	});
	$.get("getShowcount" , function(data){
		var d = data.m;
		var arr = [];
		layui.each(d, function(index, item){
			arr.push("<div class='stat-digit'>"+item.data+"</div>");
		});
		$("#show").append(arr.join(''));
		form.render();
	});
	
	table.render({
	    elem: '#masseage',//渲染对象
	    height: 'full-88',//表格高度
	    url: 'queryMessage', //数据接口
	    where: {key: ''},//给后台传的参数
	    page: true, //开启分页
	    limit: 10,//每页显示信息条数
	    cols: [[ //表头
	       {field: 'massage', title: '内容', align:'center', sort: true, fixed: 'left'} 
	      ,{field: 'username', title: '留言者',align:'center' }
	      ,{field: 'phone', title: '电话',align:'center' }
	      ,{field: 'time', title: '留言时间',align:'center', fixed: 'right' }
	    ]]
	  });
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('pie_echarts'));
	// 指定图表的配置项和数据
	option = {
			title: {
	            text: '新闻分布',
	            x: 'left'
	        },
	        tooltip: {
	            trigger: 'item',
	            formatter: "{a} <br/>{b} : {c} ({d}%)"
	        },
	        color: ['#CD5C5C', '#00CED1', '#9ACD32', '#FFC0CB'],
	        stillShowZeroSum: false,
	        series: [
	            {
	                type: 'pie',
	                radius: '80%',
	                center: ['60%', '60%'],
	                data: [],
	                itemStyle: {
	                    emphasis: {
	                        shadowBlur: 10,
	                        shadowOffsetX: 0,
	                        shadowColor: 'rgba(128, 128, 128, 0.5)'
	                    }
	                }
	            }
	        ]	
	};
	// 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
	$.get('getBinTuinfo').done(function(data){
		myChart.setOption({
			series: [{
				name: '新闻',
				data: data.tb
			}]
		});
	});
    
    
    var myChart1 = echarts.init(document.getElementById('speedChartMain'));
	option = {
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['发布数量']
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    toolbox: {
		        feature: {
		            saveAsImage: {}
		        }
		    },
		    xAxis: {
		        type: 'category',
		        boundaryGap: false,
		        data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
		    },
		    yAxis: {

		        type: 'value'
		    },
		    series: [
		        {
		            name:'发布数量',
		            type:'line',
		            data:[]
		        }
		    ]
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart1.setOption(option);
		$.get('getTubiaoinfo').done(function(data){
			myChart1.setOption({
				series: [{
					name: '招聘',
					data: data.td
					
				}]
			});
		});
 })


