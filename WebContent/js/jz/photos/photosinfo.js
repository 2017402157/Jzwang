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
		layui.each(d, function(index, item){
		     arr.push("<li><a href="+item.href+" >"+item.title+"</a></li>");
		      
	    });
		$("#myindex").append(arr.join(''));
		form.render();
	});
	//加载页面数据
	var photosinfoid=$("#photosinfoid").val();
	$.get("getPhotosInfo?id="+photosinfoid, function(data){
			var d = data.m;
			var arr = [];
			      arr.push("<div class='h3 font-weight-normal'>"+d.title+"</div>");
			      arr.push("<img class='img-fluid mt-4' src='"+d.photor+"' height='1080' width='619'/>");
			      arr.push("<div class='row mt-5'>");
			      arr.push("<div class='col-md-3'>");
			      arr.push("<div class='h5'>标签</div><p>标签</p><a class='mr-1 badge badge-primary' href='#'>图片</a>");
			      arr.push("<div class='h5 pt-4'>'Year'</div>");
			      arr.push("<p>年份</p>");
			      arr.push("<p>"+d.time.substring(0,4)+"</p>");
			      arr.push("</div>");
			      arr.push("<div class='col-md-9'>");
			      arr.push("<p>"+d.massage+"</p>");
			      arr.push("</div>");
			      arr.push("</div>");
			    
			$("#myphotosinfo").append(arr.join(''));//从html  渲染
			form.render();
		});
		
	  laypage.render({
		  elem: 'mypage' //注意，这里 是 ID，不用加 # 号页数
		  ,count: 50 //数据总数，从服务端得到
		  });
})
