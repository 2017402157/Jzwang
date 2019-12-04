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
		layui.each(d, function(index, item){
		     arr.push("<li><a href="+item.href+" >"+item.title+"</a></li>");
		     arr2.push("<li><a href="+item.href+" class='v1'>"+item.title+"</a></li>");
		});
		$("#myindex").append(arr.join(''));
		$("#myindex2").append(arr2.join(''));
		form.render();
	});
	//加载页面数据
	$.get("getPhotos", function(data){
			var d = data.m;
			var arr = [];
			    layui.each(d, function(index, item){
			      arr.push("<li>");
			      arr.push("<div class='card' data-groups='[&quot;nature&quot;]'><a href='openPhotosInfo?id="+item.id+"'>");
			      arr.push("<figure class='pp-effect'>");
			      arr.push("<img class='img-fluid' src='"+item.photor+"' alt='Nature'/>");
			      arr.push("<figcaption>");
			      arr.push("<div class='h4'>"+item.title+"</div>");
			      arr.push("<p>"+item.time+"</p>");
			      arr.push("</figcaption>");
			      arr.push("</figure></a></div>");
			      arr.push("</il>");
			    });
			    
			$("#myphotos").append(arr.join(''));//从html  渲染
			form.render();
		});
		
	  laypage.render({
		  elem: 'mypage' //注意，这里 是 ID，不用加 # 号页数
		  ,count: 50 //数据总数，从服务端得到
		  });
})
