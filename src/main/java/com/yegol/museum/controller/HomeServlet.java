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

@WebServlet(name = "HomeServlet",urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
        //        得到传递过来的分类id
        String cid = req.getParameter("cid");

        Context context = new Context();
//       分类
        CategoryDao dao = new CategoryDao();
        List<Category> list = dao.findAll();

        context.setVariable("list",list);
//通知
        AnnouncementDao adao = new AnnouncementDao();
//        添加通知类的数据 通过adao将数据查找出来 获取所有的数据
        if(cid!=null){
            List<Announcement> alist = adao.findAllByCid(cid);
            context.setVariable("alist",alist);
        }else {
            List<Announcement> alist = adao.findAll();
            context.setVariable("alist",alist);
        }
        ThUtils.print("home.html",context,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
