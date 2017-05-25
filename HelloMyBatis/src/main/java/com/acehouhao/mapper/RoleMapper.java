package com.acehouhao.mapper;

import com.acehouhao.po.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Hao HOU on 2017/5/19.
 */
public interface RoleMapper {
    public Role getRole(Long id);
    public int deleteRole(Long id);
    public int insertRole(Role role);
    public List<Role> findRoleByMap(@Param("roleName") String roleName, @Param("note") String note);
}
