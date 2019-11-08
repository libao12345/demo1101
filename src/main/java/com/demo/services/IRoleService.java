package com.demo.services;

import com.demo.database.data.TDemoRole;
import java.util.List;

/**
 * @author Libao
 * @version 1.0.0
 * @createTime 2019年11月07日 19:38：00
 */
public interface IRoleService {

    public List<TDemoRole> query() throws Exception;

    public List<TDemoRole> queryRole(String roleName) throws Exception;

    public List<TDemoRole> add(TDemoRole role) throws Exception;

    public List<TDemoRole> delete(String ids) throws Exception;

    public TDemoRole getById(String id) throws Exception;

    public List<TDemoRole> update(TDemoRole role) throws Exception;

}
