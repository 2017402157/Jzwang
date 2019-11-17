var $;
layui.config({
	base : "js/"
}).use(['form','layer','jquery', 'laydate', 'layedit', 'upload'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage;
		$ = layui.$
		,laydate = layui.laydate;
		layedit = layui.layedit;
		
		var texts = layedit.build('demo', {
			height:535,
			uploadImage:{
				url:"../../json/newsImg.json"
			}
		}); 
		
		$.get("getUsers", function(data){
			var m = data.m;
			for(var i=0;i<m.length;i++){
				$("#selectId").append("<option value='"+m[i].id+"'>"+m[i].username+"</option>");
			}
			form.render();
		});
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
 		 
 		loading = layer.load(2, {
            shade: [0.2, '#000'] //0.2透明度的白色背景
        });

 		 
 		 data.field.id = GetUerParam("id");
 		 data.field.demo = layedit.getContent(texts);
 		$.post(url, JSON.stringify(data.field), function (result) {
            layer.close(loading);
            if (result.code == 0) {
                layer.msg(result.msg, {icon: 1, time: 1000}, function () {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    parent.location.reload();
                });
            } else {
                layer.msg(result.msg, {icon: 2, anim: 6, time: 1000});
            }
        });
 		return false;
 	})
	
})