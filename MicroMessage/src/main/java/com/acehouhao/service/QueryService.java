package com.acehouhao.service;

import com.acehouhao.bean.Message;
import com.acehouhao.dao.MessageDAO;
import com.acehouhao.util.Iconst;

import java.util.List;

/**
 * Created by Hao HOU on 2017/5/26.
 */
public class QueryService {
    public List<Message> queryMessageList(String command,String description) {
        MessageDAO messageDao = new MessageDAO();
        return messageDao.queryMessageList(command, description);
    }

    /**
     * 通过指令查询自动回复的内容
     * @param command 指令
     * @return 自动回复的内容
     */
    public String queryByCommand(String command) {
        MessageDAO messageDao = new MessageDAO();
        List<Message> messageList;
        if(Iconst.HELP_COMMAND.equals(command)) {
            messageList = messageDao.queryMessageList(null, null);
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < messageList.size(); i++) {
                if(i != 0) {
                    result.append("<br/>");
                }
                result.append("回复[" + messageList.get(i).getCommand() + "]可以查看" + messageList.get(i).getDescription());
            }
            return result.toString();
        }
        messageList = messageDao.queryMessageList(command, null);
        if(messageList.size() > 0) {
            return messageList.get(0).getContent();
        }
        return Iconst.NO_MATCHING_CONTENT;
    }
}
