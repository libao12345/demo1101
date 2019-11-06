package com.demo.services;

import com.demo.database.data.TDemoUser;

import java.util.List;

/**
 * @author Libao
 * @version 1.0.0
 * @createTime 2019年11月04日 11:20：29
 */
public interface IUserService {

    public List<TDemoUser> query() throws Exception;

    public List<TDemoUser> queryUser(String userName) throws Exception;

    public List<TDemoUser> add(TDemoUser user) throws Exception;

    public List<TDemoUser> delete(String ids) throws Exception;

    public TDemoUser getById(String id) throws Exception;

    public List<TDemoUser> update(TDemoUser user) throws Exception;

}
