layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form,
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage,
	$ = layui.jquery;
	
	//加载页面数据
	$.get("getPhotos", function(data){
			var d = data.m;
			var arr = [];
			    layui.each(d, function(index, item){
			   
			   
			      arr.push("<h1>");
			      arr.push("131213131");
			      arr.push("</h1>");
			    
			    
			    });
			    
			$("#myphotos").append(arr.join(''));//从html  渲染
			form.render();
		});
		
	  laypage.render({
		  elem: 'mypage' //注意，这里 是 ID，不用加 # 号页数
		  ,count: 50 //数据总数，从服务端得到
		  });
})
