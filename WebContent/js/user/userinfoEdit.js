var $;
layui.config({
	base : "js/"
}).use(['form','layer','jquery'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage;
		$ = layui.jquery;
		var id=$("input[name='id']").val();
		// 加载页面数据
		$.get("getUser?id="+id,function(data){	
			var d = data.m;
			var state;
	        // 执行加载数据的方法
			//修改页面从此更新页面
	        $("input[name='username']").val(d.username);
	        $("input[name='password']").val(d.password);
	        $("input[name='phone']").val(d.phone);
	        $.get("getRoles", function(data){
	        	var m = data.m;
	        	for(var i=0;i<m.length;i++){
	        		if(d.roleid == m[i].id){
	        			$("#roleId").append("<option selected='true' value='"+m[i].id+"'>"+m[i].rolename+"</option>");
	        		}
	        		else{
	        			$("#roleId").append("<option value='"+m[i].id+"'>"+m[i].rolename+"</option>");
	        		}
	        		form.render();
	        	}
	        });
	        $.get("getPostitions", function(data){
	        	var m = data.m;
	        	for(var i=0;i<m.length;i++){
	        		if(d.posititoned == m[i].id){
	        			$("#selectId").append("<option selected='true' value='"+m[i].id+"'>"+m[i].name+"</option>");
	        		}
	        		else{
	        			$("#selectId").append("<option value='"+m[i].id+"'>"+m[i].name+"</option>");
	        		}
	        	}
	        	form.render();
	        })
		});

 	form.on("submit(addUser)",function(data){console.log(data.field);
 		var index;
 		 $.ajax({// 异步请求返回给后台
	    	  url:'updateUser',
	    	  type:'POST',
	    	  data:data.field,
	    	  dataType:'json',
	    	  beforeSend: function(re){
	    		  index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
	          },
	    	  success:function(d){
	    			// 弹出loading
			    	top.layer.close(index);
			  		top.layer.msg("操作成功！");
			   		layer.closeAll("iframe");
			  	 		// 刷新父页面
			  	 	parent.location.reload();
		    		
	    	  },
	    	  error:function(XMLHttpRequest, textStatus, errorThrown){
	    		  top.layer.msg('操作失败！！！服务器有问题！！！！<br>请检测服务器是否启动？', {
	    		        time: 20000, // 20s后自动关闭
	    		        btn: ['知道了']
	    		      });
	           }
	      });
 		return false;
 	})
	
})
