/*
 * 获取管理员所分配的项目
 */
var all = 0;//所有项目
var graded = 1;//已评价
var notgrade = 2;//未评价

var judgeshowProject = null;

/*
 * 显示大创项目
 */
var projectList = [{
	id : "id",
	school:"school",
	dir : "dir",
	score:"score"
}];

function getproject(){
	var kind = 0;
	$.ajax({
		url : '/psxt/judgeshowproject',
		cache:false,
		type : 'get',
		dataType : 'text',
		success : function(data) {
			$("#contains").html(data);
			updateProjectList();
		}
	});
}

function updateProjectList(){
		$.ajax({
			url:'/psxt/gradeprojectpage',
			cache:false,
			type:'get',
			dataType:'text',
			success:function(data){
				$("#projectTable_div").html(data);//填充html
				getProjectList();//填充数据
			}
		});
	
		//kind=0;
	//getProjectList(kind);
}

function getProjectList(){
//	console.log(123);
	$.ajax({
		url:'/psxt/getprojectlist',
		cache:false,
		type:'get',
		dataType:'json',
		//获取所有项目!!!!!!!!!!
		success:function(data){
		//	if(judgeshowProject == null)
		//	{
//				alert("@@@@@");
				judgeshowProject = new Vue({
					el:'#projectTable',
					data:{
						projectList:projectList
					}
				});
		//	}
			
//			for(var index in data){
//				if(data[index]!=null &&data[index].dir !=null)
//					data[index].attachmentId = "/getattachement/"+data[index].attachmentId;
//			}
			judgeshowProject.projectList = data;
		//	alert("####");
		}
	})
}

/*
 * 评委为项目打分
 */
function grade(object){
	var schoolId = $(object).attr("id");
	var score = $("#"+"score_"+schoolId).val();
	if(score.trim()==""){
		alert("请输入数字");
		return;
	}

	//alert("#### + "+score);
	$.ajax({
		url:"/psxt/addjudgement",
		cache:false,
		type:"post",
		dataType:"json",
		data:{
			schoolId:schoolId,
			score:score
		},
		success:function(response){
			if(response.code == "0"){    		
				alert("评分成功");
				updateProjectList();
			}
			else if(response.code == "1"){
				alert(response.message);
			}
		}
	});
}


