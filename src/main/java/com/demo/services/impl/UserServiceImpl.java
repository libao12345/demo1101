package com.demo.services.impl;

import com.demo.database.data.TDemoUser;
import com.demo.database.mapper.TDemoUserMapper;
import com.demo.services.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Libao
 * @version 1.0.0
 * @createTime 2019年11月04日 11:21：07
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private TDemoUserMapper userMapper;

    @Override
    public List<TDemoUser> query() throws Exception {
        List<TDemoUser> list = userMapper.query();
        return list;
    }

    @Override
    public List<TDemoUser> queryUser(String userName) throws Exception {
        List<TDemoUser> list = userMapper.queryUser(userName);
        return list;
    }

    @Override
    public List<TDemoUser> add(TDemoUser user) throws Exception {
        user.setOperTime(new Timestamp(System.currentTimeMillis()));
        userMapper.add(user);
        return query();
    }

    @Override
    public List<TDemoUser> delete(String ids) throws Exception {
        userMapper.delete(ids);
        return query();
    }

    @Override
    public TDemoUser getById(String id) throws Exception {
        TDemoUser user  = userMapper.getById(id);
        return user;
    }

    @Override
    public List<TDemoUser> update(TDemoUser user) throws Exception {
        user.setOperTime(new Timestamp(System.currentTimeMillis()));
        userMapper.update(user);
        return query();
    }
}
