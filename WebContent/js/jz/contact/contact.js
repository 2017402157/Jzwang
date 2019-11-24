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
	  
	  
	  
})


