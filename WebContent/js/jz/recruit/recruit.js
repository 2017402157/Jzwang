layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form,
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage,
	$ = layui.jquery;
	
	//加载页面数据
	$.get("getRecruit", function(data){
			var d = data.m;
			var arr = [];
			    layui.each(d, function(index, item){
			      
			      arr.push("<h1>");
			      arr.push("2131231241");
			      arr.push("</h1>");
			      
			    });
			    
			$("#myrecruit").append(arr.join(''));
			form.render();
		});
		
	  laypage.render({
		  elem: 'mypage' //注意，这里 是 ID，不用加 # 号
		  ,count: 50 //数据总数，从服务端得到
		  });
})


