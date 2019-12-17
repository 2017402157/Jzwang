var $;
layui.config({
	base : "js/"
}).use(['form','layer','jquery'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage;
		$ = layui.jquery;
		
		var id=$("input[name='id']").val();
		$.get("getInvite?id="+id, function(data){
				var d = data.result;
				var arr = [];
					arr.push("<h1>"+d.title+"</h1>");
					arr.push("<p class='time'>时间："+d.releasetime+"</p>");
					arr.push("<div>电话："+d.phone+"</div>");
					arr.push("<div>名字："+d.name+"</div>");
					arr.push("<div>工作经验："+d.workpro+"</div>");
					arr.push("<div>地址："+d.addr+"</div>");
					arr.push("<div>公司："+d.company+"</div>");
					arr.push("<div>数量"+d.number+"</div>");
					arr.push("<div>公司简介："+d.brief+"</div>");
					arr.push("<div>qq："+d.qq+"</div>");
					arr.push("<div>微信："+d.weixin+"</div>");
					arr.push("<div>联系人："+d.linkman+"</div>");
					arr.push("<div>职位："+d.position+"</div>");
				    
				$("#test").append(arr.join(''));
				form.render();
			});
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
			$("input[name='releasetime']").val(m.releasetime);
			$("input[name='pageview']").val(m.pageview);
			$("input[name='label']").val(m.label);
			$("input[name='name']").val(m.company);
			$("input[name='brief']").val(m.brief);
			$("input[name='releastime']").val(m.releastime);
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
			
			$.get("getCompanys", function(data){
				var d = data.m;
				for(var i=0;i<d.length;i++){
					if(m.company==d[i].id){
						$("#companyid").append("<option selected='true' value='"+d[i].id+"'>"+d[i].name+"</option>");
    				}else{
    					$("#companyid").append("<option value='"+d[i].id+"'>"+d[i].name+"</option>");
    				}
				}
				form.render();
			});
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
