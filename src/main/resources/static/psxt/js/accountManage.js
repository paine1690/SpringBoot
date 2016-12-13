
/*function accountManage() {
	setAccountMangePage();
}

function setAccountMangePage() {
	$.ajax({
		url : '/dcnh/getaccountmanagepage',
		type : 'get',
		dataType : 'text',
		success : function(data) {
			$("#contains").html(data);
		}
	});
}

function addNewAccount() {

	var userName = $("#userName").val();
	var school = $("#school").val();
	var password1 = $("#password1").val();
	var password2 = $("#password2").val();
	if (!check()) {
		return;
	}
	$.ajax({
		url : '/dcnh/addnewuser',
		type : 'post',
		dataType : 'json',
		success : function(data) {
			if (data.code == 0) {
				alert("添加成功");
				clear();
			} else {
				alert(data.message);
			}
		}
	});
}

function check() {
	var userName = $("#userName").val();
	var school = $("#school").val();
	var password1 = $("#password1").val();
	var password2 = $("#password2").val();

	if (school == "" || school == null) {
		alert("学校信息不能为空");
		return false;
	}

	if (password1 != password2) {
		alert("密码不一致");
		return false;
	}

	if (userName == "" || userName == null) {
		alert("用户名不能为空");
		return false;
	}
}

function clear() {
	$("#userName").val("");
	$("#school").val("");
	$("#password1").val("");
	$("#password2").val("");
}*/



var userInfo = null;

$(function () {
	$("#teacherPersonalInfo").click(function () {
		getInfoPage();
	});
});

//请求到用户信息页面
function getInfoPage(){
	console.log(2233);
	$.ajax({
		url : '/psxt/getTeacherUserInfoPage',
		type : 'get',
		dataType : 'text',
		success : function (data) {
			$("#contains").html(data);
			//提交修改绑定事件
			$("#submitInfo").click(function () {
				changeInfo();
			})
			//填写用户信息，账户名，文件名，密码
			getInfo();
		}
	})
}
//加载用户信息,根据用户id，获取其他信息
function getInfo() {
	var params = {
		userName : username
	}
	$.ajax({
		url: '/psxt/getUserInfoByUsername',
		type: 'post',
		dataType: 'json',
		data: params,
		success: function (msg) {
			userInfo = new Vue({
				el : "#personInfoPage",
				data : {
					school : msg.school,
					dir : msg.dir,
					password : msg.password,
					username : msg.userName
				},

			})
		},
		error: function(){
			alert(arguments[1]);
		}
	});
}
//个人信息，“修改”事件
function changeInfo(){
	var params = {
		id : userId,
		password :$("#changePassword").val(),
		userName : userInfo.username

	}
	$.ajax({
		url: '/psxt/changeNameOrPassword',
		type: 'post',
		dataType: 'json',
		data: params,
		success: function () {
			alert("修改成功");
		},
		error: function(){
			alert(arguments[1]);
		}
	});
}

/*function modalAlert(str) {
	console.log($("#alertModal"));
	$("#alertModal").modal("hide");
	$("#alertContent").html(str);
	$("#alertModal").modal("show");
}*/



