package com.acehouhao.dao;

import com.acehouhao.bean.Message;
import com.acehouhao.db.DBAccess;
import com.acehouhao.mapper.MessageMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hao HOU on 2017/5/25.
 * 和message表相关的数据库操作
 */
public class MessageDAO {
    public List<Message> queryMessageList(String command, String description) {
        DBAccess dbAccess = new DBAccess();
        List<Message> messageList = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
            messageList = messageMapper.queryMessageList(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return messageList;
    }

    /**
     * 单条删除
     * @param id
     */
    public void deleteOne(int id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
            messageMapper.deleteOne(id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteBatch(List<Integer> ids) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
            messageMapper.deleteBatch(ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void main(String[] args) {
        MessageDAO messageDAO = new MessageDAO();
        messageDAO.queryMessageList("段子", "头条");
    }
//    public List<Message> queryMessageList(String command, String description) {
//        List<Message> messageList = new ArrayList<>();
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/micro_message?serverTimezone=UTC&useSSL=false",
//                    "root","root");
//            StringBuilder sql = new StringBuilder("select ID, COMMAND, DESCRIPTION, CONTENT from message where 1 = 1");
//            List<String> paramList = new ArrayList<>();
//            if (command != null && !"".equals(command.trim())) {
//                sql.append(" and COMMAND=?");
//                paramList.add(command);
//            }
//            if (description != null && !"".equals(description.trim())) {
//                sql.append(" and DESCRIPTION like '%' ? '%'");
//                paramList.add(description);
//            }
//            PreparedStatement statement = conn.prepareStatement(sql.toString());
//            for (int i = 0; i < paramList.size(); i++) {
//                statement.setString(i + 1, paramList.get(i));
//            }
//            ResultSet rs = statement.executeQuery();
//
//            while (rs.next()) {
//                Message message = new Message();
//                message.setId(rs.getString("ID"));
//                message.setCommand(rs.getString("COMMAND"));
//                message.setDescription(rs.getString("DESCRIPTION"));
//                message.setContent(rs.getString("CONTENT"));
//                messageList.add(message);
//            }
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return messageList;
//    }
}
