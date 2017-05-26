package com.acehouhao.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Hao HOU on 2017/5/26.
 */
public class DBAccess {
    public SqlSession getSqlSession() throws IOException {
        //通过配置文件获取数据库连接信息
        Reader reader = Resources.getResourceAsReader("config/Configuration.xml");
        //通过配置信息构建一个SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //通过SqlSessionFactory打开一个数据库会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
