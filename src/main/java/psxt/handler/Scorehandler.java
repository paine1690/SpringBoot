package psxt.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psxt.dbservive.UserDBService;
import psxt.mapper.ScoreDBMapper;
import psxt.mode.Result;
import psxt.mode.Score;
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

}
