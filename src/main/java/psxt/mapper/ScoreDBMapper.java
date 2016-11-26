package psxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import psxt.mode.Score;

public interface ScoreDBMapper {
	@Results({
		@Result(property="id",column="id",javaType=int.class,jdbcType=JdbcType.INTEGER),
		@Result(property="schoolId",column="schoolId",javaType=Integer.class,jdbcType=JdbcType.INTEGER),
		@Result(property="teacherId",column="teacherId",javaType=int.class,jdbcType=JdbcType.INTEGER),
		@Result(property="score",column="score",javaType=Integer.class,jdbcType=JdbcType.INTEGER)
	})
	@Select("select * from score_table where schoolId=#{schoolId} and teacherId=#{userId} ")
	public Score selectScoreByUserIdAndSchoolId(@Param("schoolId") int schoolId, @Param("userId")int userId);
	
	@Insert("insert into score_table values(0, #{score.score}, #{score.schoolId}, #{score.teacherId});")
	public boolean addScore(@Param("score") Score score);
	
	@Update("UPDATE score_table SET score= #{score} WHERE schoolId=#{schoolId} and teacherId=#{teacherId};")
	public boolean updateScore(@Param("score") int score, @Param("schoolId") int schoolId, @Param("teacherId") int teacherId);
	
	@Results({
		@Result(property="id",column="id",javaType=int.class,jdbcType=JdbcType.INTEGER),
		@Result(property="schoolId",column="schoolId",javaType=Integer.class,jdbcType=JdbcType.INTEGER),
		@Result(property="teacherId",column="teacherId",javaType=int.class,jdbcType=JdbcType.INTEGER),
		@Result(property="score",column="score",javaType=Integer.class,jdbcType=JdbcType.INTEGER)
	})
	@Select("select * from score_table where schoolId=#{schoolId} ")
	public List<Score> selectScoreBySchoolId(@Param("schoolId") int schoolId);
	
	
	
	
}
