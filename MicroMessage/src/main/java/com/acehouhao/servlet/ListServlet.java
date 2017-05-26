package com.acehouhao.servlet;

import com.acehouhao.bean.Message;
import com.acehouhao.service.ListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hao HOU on 2017/5/25.
 * 列表页面初始化控制
 */
public class ListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//设置编码
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        req.setAttribute("command", command);
        req.setAttribute("description",description);

        ListService listService = new ListService();


        req.setAttribute("messageList", listService.queryMessageList(command, description));
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req, resp);
    }
}
