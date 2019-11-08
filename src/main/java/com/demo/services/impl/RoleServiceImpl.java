package com.demo.services.impl;

import com.demo.database.data.TDemoRole;
import com.demo.database.mapper.TDemoRoleMapper;
import com.demo.services.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Libao
 * @version 1.0.0
 * @createTime 2019年11月07日 19:39：21
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Resource
    private TDemoRoleMapper roleMapper;

    @Override
    public List<TDemoRole> query() throws Exception {
        List<TDemoRole> list = roleMapper.query();
        return list;
    }

    @Override
    public List<TDemoRole> queryRole(String roleName) throws Exception {
        List<TDemoRole> list = roleMapper.queryRole(roleName);
        return list;
    }

    @Override
    public List<TDemoRole> add(TDemoRole role) throws Exception {
        role.setOperTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(role.getRoleName()+" "+role.getRoleDescribe());
        roleMapper.add(role);
        return query();
    }

    @Override
    public List<TDemoRole> delete(String ids) throws Exception {
        roleMapper.delete(ids);
        return query();
    }

    @Override
    public TDemoRole getById(String id) throws Exception {
        TDemoRole role = roleMapper.getById(id);
        return role;
    }

    @Override
    public List<TDemoRole> update(TDemoRole role) throws Exception {
        role.setOperTime(new Timestamp(System.currentTimeMillis()));
        roleMapper.update(role);
        return query();
    }
}
