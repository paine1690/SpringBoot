package psxt.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import psxt.mode.Score;

public interface ScoreDBMapper {
	@Select("select * from score_table where schoolId=#{schoolId} and teacherId=#{userId} ")
public Score selectScoreByUserIdAndSchoolId(@Param("schoolId") int schoolId, @Param("userId")int userId);
}
