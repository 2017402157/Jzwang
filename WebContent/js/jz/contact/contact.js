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
	$.get("getContact", function(data){
			var d = data.m;
			var arr = [];
			    layui.each(d, function(index, item){
			      
			      arr.push("<li class='li1'>"+item.addr+"</li>");
			      arr.push("<li class='li2'>"+item.phone+"");
			      arr.push("</a></li>");
			      arr.push("<li class='li3'><a href='mailto:"+item.email+"'>"+item.email+"</a></li>");
			      
			    
			      
			    });
			    
			$("#mycontact").append(arr.join(''));
			form.render();
		});
		
	  laypage.render({
		  elem: 'mypage' //注意，这里 是 ID，不用加 # 号
		  ,count: 50 //数据总数，从服务端得到
		  });
})


