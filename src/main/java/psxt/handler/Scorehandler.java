package psxt.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psxt.dbservive.UserDBService;
import psxt.mapper.ScoreDBMapper;
import psxt.mode.Result;
import psxt.mode.Score;
import psxt.mode.TeacherGrade;
import psxt.mode.User;

@Component
public class Scorehandler {
	
	@Autowired
	private UserDBService userDBService;
	
	@Autowired
	private ScoreDBMapper scoreDBMapper;
	
	public List<Result> getAllScore(){
		System.out.println("fsdfh");
		List<User> allSchool=userDBService.getUsersByRole(2);
		Map<User, List<Score>> map=new HashMap<User, List<Score>>(allSchool.size());
		for(User school: allSchool){
			map.put(school, scoreDBMapper.selectScoreBySchoolId(school.getId()));
		}		
		List<Result> re=new ArrayList<Result>(map.size());
		Set<Entry<User, List<Score>>> en=map.entrySet();
		for(Entry<User, List<Score>> entry: en){
			Result temp=new Result();
			temp.setSchool(entry.getKey().getSchool());
			temp.setGroup(entry.getKey().getGroup());
			List<Score> score=entry.getValue();
			temp.setCnt(score.size());
			float finalScore=(float) 0.0;			
			for(Score s: score){
				finalScore+=s.getScore();
			}			
			if(score.size()!=0){
				finalScore/=score.size();
			}
			
			
			temp.setScore(finalScore);
			re.add(temp);
		}
		
		for(Result r: re){
			System.out.println(r.getSchool()+" "+r.getGroup()+" "+r.getCnt()+" "+r.getScore());
		}
		Collections.sort(re, new Comparator<Result>(){
			@Override
			public int compare(Result r1, Result r2) {
				return Float.compare(r2.getScore(), r1.getScore());
			}
			
		});
		return re;
	}
	
	
	
	
	/**
	 * 获取每个专家的学校分组的评审情况
	 * @return
	 */
	public List<TeacherGrade> getTeacherGradeList(){
		List<User> teacherUsers = userDBService.getUsersByRole(3);
		List<TeacherGrade> teacherGrades = new ArrayList<>();
		
		for(User user : teacherUsers){
			TeacherGrade teacherGrade = new TeacherGrade();
			teacherGrade.setUser(user);
			List<User> schoolGroup = userDBService.getSchoolGroupOfTeacher(user.getGroup());
			teacherGrade.setGroup(schoolGroup);
			//获取专家评审过的所有学校分组
			List<Integer> scoredSchoolIds = userDBService.getSchoolOfUnscoredByTeacher(user.getId());
			//遍历一遍schoolGroup,将在schoolGroup不在unscoredSchoolIds中的学校存入到另一个list中
			//首先将schoolGroup按照id字段进行排序
			Collections.sort(schoolGroup, new Comparator<User>() {

				@Override
				public int compare(User o1, User o2) {
					// TODO Auto-generated method stub
					return o1.getId() - o2.getId();
				}
				
			});
			List<User> unscored = new ArrayList<>();
			int j = 0;
			if(scoredSchoolIds.size() == 0){
				teacherGrade.setUnscore(schoolGroup);
			}
			else {
				for(int i = 0; i< schoolGroup.size(); i++){
					if(j < scoredSchoolIds.size()){
						if(schoolGroup.get(i).getId() != scoredSchoolIds.get(j)){
							unscored.add(schoolGroup.get(i));
						}
						else {
							j++;
						}
					}
					else {
						unscored.add(schoolGroup.get(i));
					}
				}
				teacherGrade.setUnscore(unscored);
			}
			teacherGrades.add(teacherGrade);
		}
		System.err.println(teacherGrades.size());
		return teacherGrades;
	}

}
