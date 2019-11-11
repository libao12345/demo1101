$(function(){
	$("aside ul li.active").click(function() {
		var nodeId = this.id;
		var subNodes = $("aside ul li[parentId="+nodeId+"]");
		if(subNodes.css("display")=="none") {
			//subNodes.css("display", "block");
			subNodes.slideDown();
		} else {
			//subNodes.css("display", "none");
			subNodes.slideUp();
		}
	});
});

/**
 * 重写alert提示框
 */
window.alert = function(title, message) {
	//设置标题
	$("#dialog .dialog-title").text(title);
	$("#dialog .dialog-message").text(message);
	//删除所有按钮
	$("#dialog .dialog-btns").empty();
	//创建按钮节点对象
	var sure = $('<input type="button" value="确 定" class="btn btn-primary input-sm" />');
	//添加确定按钮
	$("#dialog .dialog-btns").append(sure);
	//给确定按钮绑定事件
	sure.on("click", function() {
		//关闭对话框
		$("#dialogShadow").hide();
	});
	//显示对话框
	$("#dialogShadow").show();
}

/**
 * 重写选择对话框
 */
window.confirm = function(title, message, callback) {
	//设置标题
	$("#dialog .dialog-title").text(title);
	$("#dialog .dialog-message").text(message);
	//删除所有按钮
	$("#dialog .dialog-btns").empty();
	//创建按钮节点对象
	var sure = $('<input type="button" value="确 定" class="btn btn-primary input-sm" />');
	var cancel = $('<input type="button" value="取 消" class="btn btn-default input-sm" />');
	//添加确定按钮
	$("#dialog .dialog-btns").append(sure);
	$("#dialog .dialog-btns").append(cancel);
	//给确定按钮绑定事件
	sure.on("click", function() {
		$("#dialogShadow").hide();
		callback.call();
	});
	//给取消按钮绑定事件
	cancel.on("click", function() {
		//关闭对话框
		$("#dialogShadow").hide();
	});
	//显示对话框
	$("#dialogShadow").show();
}















