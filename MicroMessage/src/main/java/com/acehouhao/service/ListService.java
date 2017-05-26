package com.acehouhao.service;

import com.acehouhao.bean.Message;
import com.acehouhao.dao.MessageDAO;

import java.util.List;

/**
 * Created by Hao HOU on 2017/5/25.
 * 列表相关的业务功能
 */
public class ListService {
    public List<Message> queryMessageList(String command, String description) {
        MessageDAO messageDAO = new MessageDAO();
        return messageDAO.queryMessageList(command, description);
    }
}
