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
		
	var uploadInst = upload.render({
	    elem: '#upschool'
	    ,url: '../upload/uploadImg'
	    ,multiple:false
	    ,before: function(obj){
	      //预读本地文件示例，不支持ie8
	      obj.preview(function(index, file, result){
	    	  $('#demo1').attr('src', result); //图片链接（base64）
	    	  $('#demoText').append('<a class="layui-upload-img" id="upload_img_'+index+'"><span><i class="iconfont">&#xe601;</i></span><img style="width:500px;height:300px;" src="'+ result +'" alt="'+ file.name +'"></a>');
	      });
	    }
	    ,done: function(res){
	      //如果上传失败
	      if(res.code == 0){
	    	  $('#img').val(res.data.src);
	        
	      }else{
	    	  return layer.msg('上传失败:'+res.msg);
	      }
	      //上传成功
	    }
	    ,error: function(){
	      //演示失败状态，并实现重传
	      var demoText = $('#demoText');
	      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
	      demoText.find('.demo-reload').on('click', function(){
	        uploadInst.upload();
	      });
	    }
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
	 	});
	 	form.on("submit(add)",function(data){
	 		console.log(data.field);
	 		 $.ajax({//异步请求返回给后台
		    	  url:'addrecruitment',
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


