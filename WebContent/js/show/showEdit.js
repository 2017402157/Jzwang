var $;
layui.config({
	base : "js/"
}).use(['form','layer','jquery', 'upload'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage;
		$ = layui.jquery;
		upload = layui.upload;
		
		var id=$("input[name='id']").val();
		//加载页面数据
		$.get("getShow?id="+id, function(data){
			var m=data.result;
//			var obj = $.parseJSON(m.permission);
	        //执行加载数据的方法
			$("input[name='title']").val(m.title);
			$("input[name='massage']").val(m.massage);
			$("#demoText").append('<img src="'+ m.photor +'" alt="'+ m.id +'" class="layui-upload-img">');
			$("input[name='photor']").val(m.photor);
		})
		
		var uploadInst = upload.render({
			elem: '#upschool',
			url: '../upload/uploadImg',
			multiple: false,
			before: function(obj){
				obj.preview(function(index, file, result){
					$('#demo1').attr('src', result); //图片链接（base64）
			    	  $('#demoText').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">');
				});
			},
			done: function(res){
			      //如果上传失败
			      if(res.code == 0){
			    	  $('#img').val(res.data.src);
			        
			      }else{
			    	  return layer.msg('上传失败:'+res.msg);
			      }
			      //上传成功
			    },
			    error: function(){
			      //演示失败状态，并实现重传
			      var demoText = $('#demoText');
			      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
			      demoText.find('.demo-reload').on('click', function(){
			        uploadInst.upload();
			      });
			    }
		});

 	form.on("submit(update)",function(data){
 		var index;
 		 $.ajax({//异步请求返回给后台
	    	  url:'updateShow',
	    	  type:'POST',
	    	  data:data.field,
	    	  dataType:'json',
	    	  beforeSend: function(re){
	    		  index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
	          },
	    	  success:function(d){
	    			//弹出loading
			    	top.layer.close(index);
			  		top.layer.msg("操作成功！");
			   		layer.closeAll("iframe");
			  	 		//刷新父页面
			  	 	parent.location.reload();
		    		
	    	  },
	    	  error:function(XMLHttpRequest, textStatus, errorThrown){
	    		  top.layer.msg('操作失败！！！服务器有问题！！！！<br>请检测服务器是否启动？', {
	    		        time: 20000, //20s后自动关闭
	    		        btn: ['知道了']
	    		      });
	           }
	      });
 		return false;
 	})
	
})
