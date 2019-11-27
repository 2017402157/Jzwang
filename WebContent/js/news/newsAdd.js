var $;
layui.config({
	base : "js/"
}).use(['form','layer','jquery', 'laydate', 'layedit', 'upload'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage;
		$ = layui.$
		,laydate = layui.laydate;
//		var layedit = layui.layedit;
//		layedit.set({
//			uploadImage: {
//				url: '../upload/uploadImg',
//				type: 'post'
//			}
//		})
//		var texts = layedit.build('demo');
//		form.verify({
//			massage: function(data){
//				return layedit.sync(texts);
//			}
//		}); 
//		$.get("getUsers", function(data){
//			var m = data.m;
//			for(var i=0;i<m.length;i++){
//				$("#selectId").append("<option value='"+m[i].id+"'>"+m[i].username+"</option>");
//			}
//			form.render();
//		});
		$.get("getTypes", function(data){
			var m=data.m;
			for(var i=0;i<m.length;i++){
				$("#typeid").append("<option value='"+m[i].id+"'>"+m[i].name+"</option>");
			}
			form.render();
		});
	
	
		
 	form.on("submit(add)",function(data){
 		var index;
 		 $.ajax({//异步请求返回给后台
	    	  url:'saveNews',
	    	  type:'POST',
	    	  data:data.field,
	    	  dataType:'json',
	    	  beforeSend: function(re){
	    		  index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
	          },
	    	  success:function(d){
	    			//弹出loading
			    	top.layer.close(index);
			  		top.layer.msg("添加成功！");
			   		layer.closeAll("iframe");
			  	 		//刷新父页面
			  	 	parent.location.reload();
		    		
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