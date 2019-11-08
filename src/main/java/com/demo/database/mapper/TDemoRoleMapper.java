package com.demo.database.mapper;

import com.demo.database.data.TDemoRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 数据库访问角色表的映射接口
 * @author Libao
 * @version 1.0.0
 * @createTime 2019年11月07日 19:24：10
 */
public interface TDemoRoleMapper {

    @Results(id = "roleResultMap", value = {
            @Result(property = "roleId", column = "role_id"),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "roleDescribe", column = "role_describe"),
            @Result(property = "operTime", column = "oper_time")
    })
    @Select("select * from t_demo_role order by oper_time desc")
    public List<TDemoRole> query() throws Exception;

    @ResultMap("roleResultMap")
    @Select("select * from t_demo_role where role_name like CONCAT('%', #{roleName}, '%') order by oper_time desc")
    public List<TDemoRole> queryRole(String roleName) throws Exception;

    @ResultMap("roleResultMap")
    @Select("select * from t_demo_role where role_id=#{id}")
    public TDemoRole getById(String id) throws Exception;

    @Insert("insert into t_demo_role(role_name,role_describe,oper_time) " +
            "values(#{roleName},#{roleDescribe},#{operTime})")
    public void add(TDemoRole role) throws Exception;

    @Delete("delete from t_demo_role where role_id in(${value})")
    public void delete(String ids) throws Exception;

    @Update("update t_demo_role set role_name=#{roleName},role_describe=#{roleDescribe}," +
            "oper_time=#{operTime} where role_id=#{roleId}")
    public void update(TDemoRole role) throws Exception;
}
