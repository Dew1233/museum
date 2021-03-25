package com.yegol.museum.controller;

import com.yegol.museum.dao.AnnouncementDao;
import com.yegol.museum.dao.CategoryDao;
import com.yegol.museum.entity.Announcement;
import com.yegol.museum.entity.Category;
import com.yegol.museum.utils.ThUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailServlet",urlPatterns = "/detail")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        AnnouncementDao dao = new AnnouncementDao();
        Announcement announcement = dao.findById(id);
        Context context = new Context();
        context.setVariable("announcement",announcement);

//        查询所有分类
        CategoryDao cdao = new CategoryDao();
        List<Category> list = cdao.findAll();
        context.setVariable("list",list);
        ThUtils.print("detail.html",context,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
