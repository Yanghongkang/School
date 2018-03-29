$(document).ready(function() {
	$.post("./user/index.do", function(data) {
		var list = data.resourceList;
		var parent;
		$.each(list, function(i, n) {
			parent = "<li><a><i class='icon icon-time'></i>"+n.resourceName+"</a>";
			if(n.childResource.length>0){
				parent+="<ul>";
				$.each(n.childResource, function(i, m) {
					parent+="<li><a href='"+m.url+"'>"+m.resourceName+"</a></li>"
				});
				parent+="</ul>";
			}
		});
		parent+="</li>";
		console.log(parent);
		$("#treeMenu").append(parent);
		$("#treeMenu").tree();
		var top = '<div class="container-fluid">'+
		'			<div class="navbar-header">'+
		'				<a class="navbar-brand" href="your/nice/url">ZUI</a>'+
		'			</div>'+
		'			<div class="collapse navbar-collapse navbar-collapse-example">'+
		'				<div>'+
		'					<ul class="nav navbar-nav navbar-right">'+
		'					<li><a href="your/nice/url">Druid控制台</a></li>'+
		'						<li class="dropdown"><a href="#" class="dropdown-toggle"'+
		'							data-toggle="dropdown">'+data.userName+'<b class="caret"></b></a>'+
		'							<ul class="dropdown-menu" role="menu">'+
		'								<li><a href="your/nice/url">修改个人资料</a></li>'+
		'								<li class="divider"></li>'+
		'								<li><a href="your/nice/url">退出</a></li>'+
		'							</ul></li>'+
		'					</ul>'+
		'				</div>'+
		'			</div>'+
		'		</div>';
		$("#top").append(top);
	});
});