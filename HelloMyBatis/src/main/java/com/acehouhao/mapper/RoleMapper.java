package com.acehouhao.mapper;

import com.acehouhao.po.Role;

/**
 * Created by Hao HOU on 2017/5/19.
 */
public interface RoleMapper {
    public Role getRole(Long id);
    public int deleteRole(Long id);
    public int insertRole(Role role);
}
