package com.yegol.museum.controller;

import com.yegol.museum.dao.AnnouncementDao;
import com.yegol.museum.dao.CollectionDao;
import com.yegol.museum.entity.Announcement;
import com.yegol.museum.entity.Collection;

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
@WebServlet(name = "addCollectionServlet",urlPatterns = "/addcollection")
public class addCollectionServlet extends HttpServlet {
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
        String collectionId = req.getParameter("collectionId");
        System.out.println(title+":"+resource+":"+acontent+":"+collectionId);
        //        上传图片
        Part part = req.getPart("file");
        System.out.println(part);
        String info = part.getHeader("content-disposition");
//        System.out.println(info);
        String suffix =  info.substring(info.lastIndexOf("."),info.length()-1);
        String fileName = UUID.randomUUID()+suffix;
        String path = req.getServletContext().getRealPath("images/");
//        得到日期
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String dateStr = f.format(date);
//        System.out.println("日期："+dateStr);
//        System.out.println("完整路径："+path+dateStr);
        new File(path+dateStr).mkdirs();
        part.write(path+dateStr+fileName);

//        参数封装到通知类中
      Collection a = new Collection(0,title,resource,acontent,0,"images/"+dateStr+fileName,System.currentTimeMillis(),Integer.parseInt(collectionId));

      CollectionDao dao = new CollectionDao();
      dao.insert(a);
        resp.sendRedirect("/home");
    }

}
