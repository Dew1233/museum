package com.yegol.museum.controller;

import com.yegol.museum.dao.CategoryDao;
import com.yegol.museum.dao.ColCategoryDao;
import com.yegol.museum.entity.Category;
import com.yegol.museum.entity.ColCategory;
import com.yegol.museum.utils.ThUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowCollectionServlet",urlPatterns = "/showcollection")
public class ShowCollectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
//        查询所有分类
        ColCategoryDao dao = new ColCategoryDao();
        List<ColCategory> list = dao.findAll();
        context.setVariable("list",list);

        ThUtils.print("addcollection.html",context,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}