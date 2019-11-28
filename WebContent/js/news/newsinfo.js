layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','table'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		table = layui.table,
		$ = layui.$;
//==================一个table实例================================
	  table.render({
	    elem: '#demo',//渲染对象
	    height: 'full-88',//表格高度
	    url: 'queryNews', //数据接口
	    where: {key: ''},//给后台传的参数
	    page: true, //开启分页
	    limit: 10,//每页显示信息条数
	    id: 'testReload',
	    cols: [[ //表头
	       {field: 'title', title: '标题', align:'center', sort: true, fixed: 'left'} 
	      ,{field: 'massage', title: '内容', align:'center'} 
	      ,{field: 'userid', title: '作者',align:'center' }
	      ,{field: 'creattime', title: '编写时间',align:'center' }
	      ,{field: 'releastime', title: '发布时间',align:'center' }
	      ,{field: 'status', title: '状态',align:'center',
	    	  templet: function(d){
	    		  var arr = new Array();
	    		  if(d.status == 0){
	    			  arr.push("<a class='layui-btn layui-btn-xs layui-bg-blue'><i class='layui-icon'>&#xe642;</i>发布中</a>");
	    		  }
	    		  else{
	    			  arr.push("<a class='layui-btn layui-btn-xs layui-bg-red'><i class='layui-icon'>&#xe642;</i>未审核</a>");
	    		  }
	    		  return arr.join("\n");
	    	  }
	      }
	      ,{field: 'type', title: '类型',align:'center' }
	      ,{field: 'outline', title: '概要',align:'center' }
	      ,{fixed: 'right', align:'center',title:'操作',
	    	  templet: function(d){
	    		  var arr=new Array();
	    		  arr.push("<a class='layui-btn layui-btn-xs' lay-event='edit'><i class='layui-icon'>&#xe642;</i>编辑</a>");
	    		  if(d.status != 0){
	    			  arr.push("<a class='layui-btn layui-btn-xs' lay-event='check'><i class='layui-icon'>&#xe642;</i>审核</a>");
	    		  }
	    		  else{
	    			  arr.push("<a class='layui-btn layui-btn-xs layui-bg-blue' lay-event='check'><i class='layui-icon'>&#xe642;</i>下架</a>");
	    		  }
	    		  arr.push("<a class='layui-btn layui-btn-xs layui-btn-danger' lay-event='del'><i class='layui-icon'></i>删除</a>");
	    		  return arr.join("\n");
	    	  }
	      }
	    ]]
	  });
	  
//====================点击【搜索】按钮事件===========================
  var active = {
		  reload : function() {
			  var demoReload = $('#demoReload');
							// 执行重载
			  table.reload('testReload', {
				  page : {
					  curr : 1// 重新从第 1 页开始
					  },
					  where : {//要查询的字段
						  key : demoReload.val(),
						  id : 11
						  }
					  });
			  }
  };
//绑定搜索事件
  $('.layui-btn').on('click', function() {
	  var type = $(this).data('type');
	  active[type] ? active[type].call(this) : '';
	  });
  
//=============绑定【添加】事件============================
//	$(window).one("resize",function(){
		$("#add_b").click(function(){
			var index = layui.layer.open({
				title : "【添加信息】",
				icon: 2,
				type : 2,
				skin: 'layui-layer-lan',
				area: ['800px', '600px'],
				content : "openAddNews",
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500)
				}
			})			
			layui.layer.full(index);
		})
//	}).resize();
  
//=======================监听工具条====================================
	table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
	  var data = obj.data; //获得当前行数据
	  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
	  var tr = obj.tr; //获得当前行 tr 的DOM对象
	 
	  if(layEvent === 'check'){ //查看
		  var index;
	 		 $.ajax({//异步请求返回给后台
		    	  url:'checkNews',
		    	  type:'POST',
		    	  data:{'id':data.id},
		    	  dataType:'json',
		    	  beforeSend: function(re){
		    		  index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
		          },
		    	  success:function(d){
		    			//弹出loading
				    	top.layer.close(index);
				  		top.layer.msg("审核通过！");
				  		 //刷新父页面
					   	active_op.reload();
			    		
		    	  },
		    	  error:function(XMLHttpRequest, textStatus, errorThrown){
		    		  top.layer.msg('操作失败！！！服务器有问题！！！！<br>请检测服务器是否启动？', {
		    		        time: 20000, //20s后自动关闭
		    		        btn: ['知道了']
		    		      });
		           }
		      });
	 		return false;
	  } else if(layEvent === 'del'){
		  layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
				var msgid;
				//向服务端发送删除指令
		 		 $.ajax({//异步请求返回给后台
			    	  url:'deleNews',
			    	  type:'POST',
			    	  data:{"id":data.id},
			    	  dataType:'json',
			    	  beforeSend: function(re){
			    		  msgid = top.layer.msg('数据处理中，请稍候',{icon: 16,time:false,shade:0.8});
			          },
			    	  success:function(d){
			    		  top.layer.close(msgid);
			    		  if(d.result==1){
			    			//弹出loading
						   		layer.closeAll("iframe");
						   		obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
						  	 //刷新父页面
						  	 	parent.location.reload();
			    		  }else{
			    			  top.layer.msg("操作失败！，数据库操作有问题！！");
			    		  }
				    		
			    	  },
			    	  error:function(XMLHttpRequest, textStatus, errorThrown){
			    		  top.layer.msg('操作失败！！！服务器有问题！！！！<br>请检测服务器是否启动？', {
			    		        time: 20000, //20s后自动关闭
			    		        btn: ['知道了']
			    		      });
			           }
			      });
		 //关闭当前提示	
	      layer.close(index);
	    });  
	  } else if(layEvent === 'edit'){ //编辑
		  var index = layui.layer.open({
              title : "修改信息",
              type : 2,
              skin: 'layui-layer-lan',
              area: ['800px', '600px'],
              content : "openEditNews?id="+data.id,
              success : function(layero, index){
                  setTimeout(function(){
                      layui.layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
                          tips: 3
                      });
                  },500)
              }
          })          
          layui.layer.full(index);
	  }
	})
})


