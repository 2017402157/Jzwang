$.get("getPhotoTotal", function(data){
		var total=data.total[0].total;
		 console.log("get:"+total); //得到当前页，以便向服务端请求对应页的数据。

		 layui.config({
				base : "js/"
			}).use(['jquery','laypage','form'],function(){
				var laypage = layui.laypage,
				form = layui.form,
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
	
	laypage.render({
		  elem: 'mypage' //注意，这里 是 ID，不用加 # 号
		  ,count: total //数据总数，从服务端得到
		  ,limit:6
		  ,jump: function(obj, first){
			    //obj包含了当前分页的所有参数，比如：
			    console.log(total); //得到当前页，以便向服务端请求对应页的数据。
			    console.log(obj.limit); //得到每页显示的条数
			    
			  //首次不执行
			    if(!first){
			      //do something
			    	$('#myphotos').empty();
			    }
				//加载页面数据
				$.get("getPhotos?page="+obj.curr+"&limit="+obj.limit, function(data){
						var d = data.m;
						var arr = [];
						    layui.each(d, function(index, item){
						      arr.push("<li>");
						      arr.push("<div class='card' data-groups='[&quot;nature&quot;]'><a href='openPhotosInfo?id="+item.id+"'>");
						      arr.push("<figure class='pp-effect'>");
						      arr.push("<img class='img-fluid' src='"+item.photor+"' alt='Nature'/>");
						      arr.push("<figcaption>");
						      arr.push("<div class='h4'>"+item.title+"</div>");
						      arr.push("<p>"+item.time+"</p>");
						      arr.push("</figcaption>");
						      arr.push("</figure></a></div>");
						      arr.push("</il>");
						    });
						    
						$("#myphotos").append(arr.join(''));//从html  渲染
						form.render();
					});
		
				
	}
	  });
	//  console.log($('#total').val()); //得到当前页，以便向服务端请求对应页的数据。
})
});
