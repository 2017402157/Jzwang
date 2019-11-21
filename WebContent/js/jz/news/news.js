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
	$.get("getNews", function(data){
			var d = data.m;
			var arr = [];
			    layui.each(d, function(index, item){
			      arr.push('<li>');
			      arr.push("<div class='pad'>");
			      arr.push("<div class='pic'>");
			      arr.push("<a href='openNewsInfo?id='111' >");
			      arr.push("<img src='../../uploads/news/1604211611180.png'  alt='"+item.title+"'>");
			      arr.push("</a></div>");
			      arr.push("<div class='bor'>");
			      arr.push("<div class='txt'>");
			      arr.push("<div class='title'>");
			      arr.push("<span><em>01/18</em>2019</span>");
			      arr.push("<h3><a href='openNewsInfo?id='111' >"+item.title+"</a></h3>");
			      arr.push("</div>");
			      arr.push("<a href='openNewsInfo?id='111'   style='color:#666;'>");
			      arr.push("<p>"+item.massage+"</p>");
			      arr.push("</a> </div>");
			      arr.push("<div class='more'><a href='openNewsInfo?id='111'   class='r'>查看更多 ></a></div>");
			      arr.push("</div></div>");
			      arr.push('</li>');
			    });
			    
			$("#list").append(arr.join(''));
			form.render();
		});
		
	  laypage.render({
		  elem: 'mypage' //注意，这里 是 ID，不用加 # 号
		  ,count: 50 //数据总数，从服务端得到
		  });
})


