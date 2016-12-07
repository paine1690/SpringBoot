/*
 * 获取管理员所分配的项目
 */
function onload(){
		  $.ajax({
		      url: '/psxt/getuserinfo',
		      type: 'get',
		      dataType: 'json',
		      success: function(data){
		    	  $("#userName").html(data.school+" 欢迎您");
		    	  getaddProjectPage();
		      }
		    });
		}

function getaddProjectPage(){
//	console.log(1234);
	$.ajax({
		  url: '/psxt/getaddprojectbutton',
	      type: 'get',
	      dataType: 'text',
	      success: function(data){
	    	  $("#contains").html(data);
	    	  addProject();
	      	}
	      });
}
	
function addProject() {
		setAddPrjctPage();
	}
	
	function setAddPrjctPage(){
	//	console.log(111);
		$.ajax({
			url : '/psxt/getaddprjctpage',
			type : 'get',
			dataType : 'text',
			success : function(data) {	
				console.log(22);
				$("#add_prjct_container").html(data);
				$("#attachement_file").fileinput({
					language : 'zh',
					allowedFileExtensions : [ "zip", "rar"], 
					uploadUrl : "/psxt/uploadattachement",
					uploadAsync : true,
					showPreview : false,
					removeClass : "btn btn-danger",
					showUpload: true, //是否显示上传按钮
				});
				//绑定上传文件的事件回调
				initFileInputEvent();
			},
		error : function(data){
			console.log(00);
			window.location.href = "/psxt";
		}
		});
	}
	function initFileInputEvent() {
		$("#attachement_file").on("fileuploaded", function(event, data, previewId, index) {
			var rep = data.response;
			console.log("response  "+rep);
			console.log("responseMessage  "+rep.message);
			if(rep == null || rep.code == "1") {
				modalAlert("附件上传失败，请重新尝试！" + rep.message);
				return;
			}
			//设置附件ID隐藏表单域
			$("#attachementId").val(rep.message);
			modalAlert("附件上传成功！");
		} );
		$("#attachement_file").on("fileuploaderror", function(event, data, msg) {
			$("#attachementId").val("");
			modalAlert(msg);
		} );
	}
	

	function modalAlert(str) {
		console.log($("#alertModal"));
		$("#alertModal").modal("hide");
		$("#alertContent").html(str);
		$("#alertModal").modal("show");
	}

	//上传文件
	function uploadFile0() {
		console.log($("#mform").serializeArray());
		$("#attachement_file").fileinput("upload");
	}
	




