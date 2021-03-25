package com.yegol.museum.controller;

import com.yegol.museum.dao.AnnouncementDao;
import com.yegol.museum.entity.Announcement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@MultipartConfig
@WebServlet(name = "SendServlet",urlPatterns = "/send")
public class SendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String title = req.getParameter("title");
        String resource = req.getParameter("resource");
        String acontent = req.getParameter("acontent");
        String categoryId = req.getParameter("categoryId");
        System.out.println(title+":"+resource+":"+acontent+":"+categoryId);


//        参数封装到通知类中
        Announcement a = new Announcement(0,title,resource,acontent,
                0,System.currentTimeMillis(),
                Integer.parseInt(categoryId));
        AnnouncementDao dao = new AnnouncementDao();
        dao.insert(a);
        resp.sendRedirect("/home");
    }
}
