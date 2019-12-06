$.get("getNewsTotal", function(data){
		var total=data.total[0].total;
		 console.log("get:"+total); //得到当前页，以便向服务端请求对应页的数据。
		 
		 layui.config({
				base : "js/"
			}).use(['jquery','laypage','form'],function(){
				var laypage = layui.laypage,
				form = layui.form,
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
	
	laypage.render({
		  elem: 'mypage' //注意，这里 是 ID，不用加 # 号
		  ,count: total //数据总数，从服务端得到
		  ,limit:8
		  ,jump: function(obj, first){
			    //obj包含了当前分页的所有参数，比如：
			    console.log(total); //得到当前页，以便向服务端请求对应页的数据。
			    console.log(obj.limit); //得到每页显示的条数
	
	//加载页面数据
	$.get("getRecruit?page="+obj.curr+"&limit="+obj.limit, function(data){
			var d = data.m;
			var arr = [];
			    layui.each(d, function(index, item){
			    	arr.push("<il>");
			    	arr.push("<div class='job-box'>");
			    	arr.push("<div class='col-md-5 col-sm-5 col-xs-12'>");
			    	arr.push("<div class='job-title-box'>");
			    	arr.push("<div class='job-title'>"+item.name+"</div><span class='comp-name'>工作地址："+item.addr+"</span></a>");
			    	arr.push("</div>");
			    	arr.push("</div>");
			    	arr.push("<div class='col-md-2 col-sm-2 col-xs-6'>");
			    	arr.push("<div class='job-location'><i class='fa fa-location-arrow'></i>招聘人数："+item.number+"</div>");
			    	arr.push("</div>");
			    	arr.push("<div class='col-md-2 col-sm-2 col-xs-6'>");
			    	arr.push("<div class='job-type jt-full-time-color'><i class='fa fa-clock-o'></i> "+item.worktime+"</div>");
			    	arr.push("</div>");
			    	arr.push("<div class='col-md-2 col-sm-2 col-xs-12'>");
			    	arr.push("<a href='openRecruitInfo?id="+item.id+"'><button class='btn btn-primary btn-custom'>查看详情</button></a>");
			    	arr.push("</div>");
			    	arr.push("</div>");
			    	arr.push("</il>");
			    });
			    
			$("#myrecruit").append(arr.join(''));
			form.render();
		});
	//首次不执行
    if(!first){
      //do something
    	$('#myrecruit').empty();
    }
  }
	  
		  });
})
});

