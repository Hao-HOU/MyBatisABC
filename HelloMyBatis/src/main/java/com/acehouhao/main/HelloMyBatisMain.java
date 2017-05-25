package com.acehouhao.main;

import com.acehouhao.mapper.RoleMapper;
import com.acehouhao.po.Role;
import com.acehouhao.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hao HOU on 2017/5/19.
 */
public class HelloMyBatisMain {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("meet");
            role.setNote("tea");
            roleMapper.insertRole(role);
            System.out.println(role.getId());
//            roleMapper.deleteRole(4L);
            roleMapper.findRoleByMap("te", "te");
            sqlSession.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
