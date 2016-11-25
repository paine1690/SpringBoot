package psxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import psxt.mode.ScoreMessage;
import psxt.mode.User;



public interface UserDBMapper {
	@Results({
		@Result(property="userName",column="username",javaType=String.class,jdbcType=JdbcType.VARCHAR),
		@Result(property="password",column="password",javaType=String.class,jdbcType=JdbcType.VARCHAR),
		@Result(property="role",column="role",javaType=int.class,jdbcType=JdbcType.VARCHAR)
		
	})
	@Select("SELECT * FROM user_table where username=#{userName};")
	public User getUserByUserName(@Param("userName") String userName);
	
	
	
	@Results({
		@Result(property="id",column="id",javaType=int.class,jdbcType=JdbcType.VARCHAR),
		@Result(property="userName",column="username",javaType=String.class,jdbcType=JdbcType.VARCHAR),
		@Result(property="password",column="password",javaType=String.class,jdbcType=JdbcType.VARCHAR),
		@Result(property="school",column="school",javaType=String.class,jdbcType=JdbcType.VARCHAR),
		@Result(property="role",column="role",javaType=int.class,jdbcType=JdbcType.VARCHAR),
		@Result(property="dir",column="dir",javaType=String.class,jdbcType=JdbcType.VARCHAR)
		
	})
	@Select("SELECT * FROM user_table where role=#{role};")
	public List<User> getUserByRole(@Param("role") int role);
	
	
	@Update("update user_table set userName=#{userName},password=#{password} where id=#{id};")
	public boolean changeNameOrPassword(@Param("id") int id,@Param("userName") String userName, @Param("password") String password);
	
	
	@Update("update user_table set userName=#{userName},password=#{password},remark=#{remark} where id=#{id};")
	public boolean changeNameOrPassworORemark(@Param("id") int id,@Param("userName") String userName, @Param("password") String password, @Param("remark") String remark);
	
	
	@Insert("INSERT INTO `user_table` (`userName`, `password`, `remark`, `role`) "
			+ "VALUES (#{userName}, #{password}, #{remark}, #{role});")
	public boolean addNewAccount(@Param("userName") String userName, @Param("password") String password, @Param("remark") String remark, @Param("role") int role);
	
	@Select("SELECT * FROM user_table where id=#{userId};")
	public User getUserById(@Param("userId") int userId) ;
	
	@Update("update user_table set dir=#{fileDir} where id=#{userId};")
	public boolean updateFileDirByUserId(@Param("fileDir") String fileDir, @Param("userId") int userId);
	
	

	
	@Results({
		@Result(property="id",column="id",javaType=int.class,jdbcType=JdbcType.INTEGER),
		@Result(property="school",column="school",javaType=String.class,jdbcType=JdbcType.VARCHAR),
		@Result(property="score",column="score",javaType=int.class,jdbcType=JdbcType.INTEGER),
		@Result(property="dir",column="dir",javaType=String.class,jdbcType=JdbcType.VARCHAR)
		
	})
	@Select("SELECT user_table.id, school, dir, score from user_table  LEFT JOIN score_table ON user_table.id = score_table.schoolId AND score_table.teacherId = #{userId}  WHERE `group`= #{group} AND role = 2 ;")
	public List<ScoreMessage> selectProjectMessageByGroupAndUser(@Param("group") int group, @Param("userId") int userId);

	@Update("UPDATE `psxt`.`user_table` SET `group`=#{group} WHERE `id`=#{id};")
	public boolean changeGroup(@Param("id") int id, @Param("group") int group);

}
