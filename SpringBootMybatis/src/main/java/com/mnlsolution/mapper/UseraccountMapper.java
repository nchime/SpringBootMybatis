package com.mnlsolution.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mnlsolution.domain.Useraccount;

public interface  UseraccountMapper {

	// @Insert("INSERT into village(id,name,district) VALUES(#{vid},
	// #{villageName}, #{district})")

	@Insert("insert into useraccount(loginid, passwd, email, username, regdate, upddate) value(#{loginid}, #{passwd}, #{email}, #{username}, #{regdate}, #{upddate})")
	int insertUseraccount(Useraccount useraccount);
	
	@Select("select useridx, loginid, passwd, email, username, regdate, upddate from useraccount") 	
	List<Useraccount> selectUseraccount();   

	@Select("select useridx, loginid, passwd, email, username, regdate, upddate from useraccount where loginid = #{loginid}") 	
	Useraccount selectOneUseraccount(String loginid);   

	@Update("update useraccount set upddate=#{upddate}, username=#{username} where loginid = #{loginid}") 
	void updateUseraccount(Useraccount useraccount);

	@Delete("delete from useraccount where loginid = #{loginid}") 
	void deleteUseraccount(String loginid);

	

}
