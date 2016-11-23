package psxt.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;


import psxt.mode.User;



public interface UserDBMapper {
	@Results({
		@Result(property="userName",column="username",javaType=String.class,jdbcType=JdbcType.VARCHAR),
		@Result(property="password",column="password",javaType=String.class,jdbcType=JdbcType.VARCHAR),
		@Result(property="role",column="role",javaType=int.class,jdbcType=JdbcType.VARCHAR)
		
	})
	@Select("SELECT * FROM user_table where username=#{userName};")
	public User getUserByUserName(@Param("userName") String userName);
	
	

	

}
