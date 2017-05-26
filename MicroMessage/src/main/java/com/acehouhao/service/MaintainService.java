package com.acehouhao.service;

import com.acehouhao.dao.MessageDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hao HOU on 2017/5/26.
 */
public class MaintainService {
    /**
     * 单条删除
     * @param id
     */
    public void deleteOne(String id) {
        if (id != null && !"".equals(id)) {
            MessageDAO messageDAO = new MessageDAO();
            messageDAO.deleteOne(Integer.valueOf(id));
        }
    }

    /**
     * 批量删除
     */
    public void deleteBatch(String[] ids) {
        MessageDAO messageDAO = new MessageDAO();
        List<Integer> idList = new ArrayList<>();
        for (String id : ids) {
            idList.add(Integer.valueOf(id));
        }
        messageDAO.deleteBatch(idList);
    }
}
