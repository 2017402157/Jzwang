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
		
	  
	 	form.on("submit(jobadd)",function(data){
	 		console.log(data.field);
	 		 $.ajax({//异步请求返回给后台
		    	  url:'addjob',
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


