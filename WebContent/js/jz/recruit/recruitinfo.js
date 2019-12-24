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
		layui.each(d, function(index, item){
		     arr.push("<li><a href="+item.href+" >"+item.title+"</a></li>");
		      
	    });
		$("#myindex").append(arr.join(''));
		form.render();
	});
	//加载页面数据
	var recruitinfoid=$("#recruitinfoid").val();
	$.get("getRecruitInfo?id="+recruitinfoid, function(data){
			var d = data.m;
			var arr = [];
				arr.push("<div class='job-short-detail'>");
				arr.push("<div class='heading-inner'>");
				arr.push("<p class='title'>职位详情</p>");
				arr.push("</div>");
				arr.push("<div class='col-md-12 col-sm-12 col-xs-12 nopadding'>");
				arr.push("<dl>");
				arr.push("<dt>工作类型：</dt>");
				arr.push("<dd>"+d.name+"</dd>");
				arr.push("<dt>工作经验：</dt>");
				arr.push("<dd>"+d.workexp+"</dd>");
				arr.push("<dt>工作时间：</dt>");
				arr.push("<dd>"+d.worktime+"</dd>");
				arr.push("<dt>发表于：</dt>");
				arr.push("<dd>"+d.releasetime+"</dd>");
				arr.push("<dt>招聘人数:</dt>");
				arr.push("<dd>"+d.number+"</dd>");
				arr.push("<dt>工作位置：</dt>");
				arr.push("<dd>"+d.addr+"</dd>");
				arr.push("<dt>薪水：</dt>");
				arr.push("<dd>"+d.reward+"</dd>");
				arr.push("<dt>联系电话：</dt>");
				arr.push("<dd>"+d.phone+"</dd>");
				arr.push("</dl>");
				arr.push("</div>");
				arr.push("</div>");
				arr.push("<div class='heading-inner'>");
				arr.push("<p class='title'>职位描述</p>");
				arr.push("</div>");
				arr.push("<div class='job-desc job-detail-boxes'>");
				arr.push("<p>");
				arr.push(""+d.workpro+"");
				arr.push("</p>");
				arr.push("</div>");
				arr.push("</div>");
			$("#myrecruitinfo").append(arr.join(''));
			form.render();
		});
		
	  laypage.render({
		  elem: 'mypage' //注意，这里 是 ID，不用加 # 号
		  ,count: 50 //数据总数，从服务端得到
		  });
})


