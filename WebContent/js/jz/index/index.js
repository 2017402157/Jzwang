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
	$.get("getNewsListTop", function(data){
			var d = data.m;
			var arr = [];
			    layui.each(d, function(index, item){
			      arr.push("<li>");
			      arr.push("<div class='pad'>");
			      arr.push("<div class='txt'> <span><em>"+item.releastime.substring(5,10)+"</em>"+item.releastime.substring(0,4)+"</span>");
				      arr.push("<h3><a href='openNewsInfo?id="+item.id+"'>"+item.title+"</a></h3>");
			      arr.push("<p style='display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 3;overflow: hidden;'>"+item.outline+"</p>");
			      arr.push("<a href='openNewsInfo?id="+item.id+"'  class='more'></a> </div>");
			      arr.push("</div>");
			      arr.push("</li>");
			    });
			$("#myindexnews").append(arr.join(''));
			form.render();
		});
	//加载页面数据
	$.get("getRecruitListTop", function(data){
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
			$("#myindexrecruit").append(arr.join(''));
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
		
	  
	 	form.on("submit(add)",function(data){
	 		console.log(data.field);
	 		 $.ajax({//异步请求返回给后台
		    	  url:'addContact',
		    	  type:'POST',
		    	  data:data.field,
		    	  dataType:'json',
		    	  success:function(d){
		    		
		    		//墨绿深蓝风

		    		  layer.alert('感谢您的来信，我们会第一时间于您联系，谢谢！', {
		    		    skin: 'layui-layer-molv' //样式类名
		    		    ,closeBtn: 0
		    		    ,anim: 4 //动画类型
		    		  }, function(){
		    			  parent.location.reload();	
		    		    });
				  	
		    	  },
		    	  error:function(XMLHttpRequest, textStatus, errorThrown){
		    		  top.layer.msg('保存失败！！！服务器有问题！！！！<br>请检测服务器是否启动？', {
		    		        time: 20000, //20s后自动关闭
		    		        btn: ['知道了']
		    		      });
		           }
		      });
	 		 
	 		
	 		return false;
	 	})
		
	  laypage.render({
		  elem: 'mypage' //注意，这里 是 ID，不用加 # 号
		  ,count: 50 //数据总数，从服务端得到
		  });
})