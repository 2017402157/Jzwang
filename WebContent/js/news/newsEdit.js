var $;
layui.config({
	base : "js/"
}).use(['form','layer','jquery', 'layedit'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage;
		$ = layui.jquery;
		layedit = layui.layedit;
		
		
		var id=$("input[name='id']").val();
		//加载页面数据
		$.get("getNews?id="+id, function(data){
			var m=data.result;
//			var obj = $.parseJSON(m.permission);
	        //执行加载数据的方法
			$("input[name='title']").val(m.title);
			$("input[name='massage']").val(m.massage);
			form.render();
			$.get("getUsers", function(data){
				var d = data.m;
				for(var i=0;i<d.length;i++){
					if(d[i].id==m.userid){
						$("#selectId").append("<option selected='true' value='"+d[i].id+"'>"+d[i].username+"</option>");
    				}else{
    					$("#selectId").append("<option value='"+d[i].id+"'>"+d[i].username+"</option>");
    				}
				}
				form.render();
			});
			$.get("getTypes", function(data){
				var d = data.m;
				for(var i=0;i<d.length;i++){
					if(d[i].id==m.type){
						$("#typeid").append("<option selected='true' value='"+d[i].id+"'>"+d[i].name+"</option>");
    				}else{
    					$("#typeid").append("<option value='"+d[i].id+"'>"+d[i].name+"</option>");
    				}
				}
				form.render();
			});
			var texts = layedit.build('demo');
			layedit.setContent(texts,m.massage);
			form.verify({
				massage: function(data){
					layedit.sync(texts);
				}
			});
		});
		
		
 	form.on("submit(update)",function(data){
 		var index;
 		 $.ajax({//异步请求返回给后台
	    	  url:'updateNews',
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
