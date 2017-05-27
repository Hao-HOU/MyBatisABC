package com.acehouhao.mapper;

import com.acehouhao.bean.Message;

import java.util.List;

/**
 * Created by Hao HOU on 2017/5/27.
 * 与Message对应的映射文件
 */
public interface MessageMapper {
    public List<Message> queryMessageList(Message message);
    public void deleteOne(int id);
    public void deleteBatch(List<Integer> ids);
}
