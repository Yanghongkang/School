$(document).ready(function(){
	var li="";
	$.ajax({
		type:'post',
		async:true,
		url : '/user/index.do',
		success:function(data){
			$.each(data.resourceList,function(i, n){
				if(n.parentId==0){
					li+="<li class='dropdown'><a href='"+n.url+"'>"+n.resourceName+"</a></li>"
				}
			});
			//----------------Top mean
			var top='<div class="container-fluid">'+
			'			<div class="navbar-header">'+
			'				<a class="navbar-brand">AdminYhk</a>'+
			'			</div>'+
			'			<div class="collapse navbar-collapse navbar-collapse-example">'+
			'				<ul class="nav navbar-nav">'+
								li+
			'				</ul>'+
			'				<ul class="nav navbar-nav navbar-right">'+
			'					<li class="dropdown"><a href="your/nice/url"'+
			'						class="dropdown-toggle" data-toggle="dropdown">用户 <b'+
			'							class="caret"></b></a>'+
			'						<ul class="dropdown-menu" role="menu">'+
			'							<li><a href="your/nice/url">Javascript</a></li>'+
			'							<li class="divider"></li>'+
			'							<li><a href="#" class="logout">退出</a></li>'+
			'						</ul></li>'+
			'				</ul>'+
			'			</div>'+
			'		</div>';
			$(".navbar").append(top);
		}
	});
	$(".navbar").on("click",".logout",function(){
		alert("sas");
	});
})