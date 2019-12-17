var $;
layui.config({
	base : "js/"
}).use(['form','layer','jquery'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage;
		$ = layui.jquery;
		
		var id=$("input[name='id']").val();
		//加载页面数据
		$.get("getInvite?id="+id, function(data){
			var m=data.result;
//			var obj = $.parseJSON(m.permission);
	        //执行加载数据的方法
			$("input[name='name']").val(m.name);
			$("input[name='workpro']").val(m.workpro);
			$("input[name='addr']").val(m.addr);
			$("input[name='number']").val(m.number);
			$("input[name='workexp']").val(m.workexp);
			$("input[name='education']").val(m.education);
			$("input[name='worktime']").val(m.worktime);
			$("input[name='reward']").val(m.reward);
			$("input[name='company']").val(m.company);
			$("input[name='type']").val(m.type);
			$("input[name='settle']").val(m.settle);
			$("input[name='creattime']").val(m.creattime);
			$("input[name='brief']").val(m.brief);
			$("input[name='linkman']").val(m.linkman);
			$("input[name='position']").val(m.position);
			$("input[name='datum']").val(m.datum);
			$("input[name='email']").val(m.email);
			$("input[name='weixin']").val(m.weixin);
			$("input[name='releasetime']").val(m.releasetime);
			$("input[name='phone']").val(m.phone);
		});

 	form.on("submit(update)",function(data){
 		var index;
 		 $.ajax({//异步请求返回给后台
	    	  url:'updateInvite',
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
