layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form,
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage,
	$ = layui.jquery;
	
	//加载菜单栏
	$.getJSON("../json/indexnvs.json", function(data){
		var d = data;
		var arr = [];
		var arr2 = [];
		     arr.push("<li><a href="+item.href+" >"+item.title+"</a></li>");
		     arr2.push("<li><a href="+item.href+" class='v1'>"+item.title+"</a></li>");
		$("#myindex").append(arr.join(''));
		$("#myindex2").append(arr2.join(''));
		form.render();
	});
	//加载页面数据
	$.get("getNewsListTop", function(data){
			var d = data.m;
			var arr = [];
			    layui.each(d, function(index, item){
			      arr.push("<li>");
			      arr.push("<div class='pad'>");
			      arr.push("<div class='txt'> <span><em>"+item.releastime.substring(5,10)+"</em>"+item.releastime.substring(0,4)+"</span>");
			      arr.push("<h3><a href='openNewsInfo?id="+item.id+"' >"+item.title+"</a></h3>");
			      arr.push("<p style='display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 5;overflow: hidden;'>"+item.outline+"</p>");
			      arr.push("<a href='openNewsInfo?id="+item.id+"'  class='more'></a> </div>");
			      arr.push("</div>");
			      arr.push("</li>");
			    });
			$("#myindexnews").append(arr.join(''));
			form.render();
		});
		
	  laypage.render({
		  elem: 'mypage' //注意，这里 是 ID，不用加 # 号
		  ,count: 50 //数据总数，从服务端得到
		  });
})