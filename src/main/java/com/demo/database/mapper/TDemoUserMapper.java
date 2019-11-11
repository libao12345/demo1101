package com.demo.database.mapper;

import com.demo.database.data.TDemoUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 数据库访问用户表映射接口
 * @author Libao
 * @version 1.0.0
 * @createTime 2019年11月04日 10:56：07
 */
public interface TDemoUserMapper {

    @Results(id = "userResultMap", value = {
            @Result(property = "userId", column = "user_id", id = true),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPassword", column = "user_password"),
            @Result(property = "userGender", column = "user_gender"),
            @Result(property = "operTime", column = "oper_time"),
            @Result(property = "tdemoRole", column = "role_id",
                one=@One(select = "com.demo.database.mapper.TDemoRoleMapper.getById"))
    })
    @Select("select * from t_demo_user order by oper_time desc")
    public List<TDemoUser> query() throws Exception;

    @ResultMap("userResultMap")
    @Select("select * from t_demo_user where user_name like CONCAT('%', #{userName}, '%') order by oper_time desc")
    public List<TDemoUser> queryUser(String userName) throws Exception;

    @ResultMap("userResultMap")
    @Select("select * from t_demo_user where user_id=#{id}")
    public TDemoUser getById(String id) throws Exception;

    @Insert("insert into t_demo_user(user_name,user_password,user_gender,role_id,oper_time) " +
            "values(#{userName},#{userPassword},#{userGender},#{tdemoRole.roleId},#{operTime})")
    public void add(TDemoUser user) throws Exception;

    @Delete("delete from t_demo_user where user_id in(${value})")
    public void delete(String ids) throws Exception;

    @Update("update t_demo_user set user_name=#{userName},user_password=#{userPassword}," +
            "user_gender=#{userGender},role_id=#{tdemoRole.roleId},oper_time=#{operTime} where user_id=#{userId}")
    public void update(TDemoUser user) throws Exception;

}
