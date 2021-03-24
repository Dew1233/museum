package com.yegol.museum.dao;

import com.yegol.museum.entity.Announcement;
import com.yegol.museum.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementDao {

    public List<Announcement> findAllByCid(String cid) {
        List<Announcement> list= new ArrayList<>();
        //获取连接
        try(Connection conn = DBUtils.getConn()){
            String sql = "select id,title,created from announcement where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(cid));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int aid = rs.getInt(1);
                String title = rs.getString(2);
                long created = rs.getLong(3);
                list.add(new Announcement(aid,title,created));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Announcement a) {
        //获取连接
        try(Connection conn = DBUtils.getConn()){
            String sql = "insert into announcement values(null,?,?,?,0,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,a.getTitle());
            ps.setString(2,a.getResource());
            ps.setString(3,a.getAcontent());
            ps.setString(4,a.getUrl());
            ps.setLong(5,a.getCreated());
            ps.setInt(6,a.getCategoryId());
            ps.executeUpdate();
            System.out.println("发布完成");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Announcement> findAll() {
        List<Announcement> list = new ArrayList<>();
       //获取连接
       try(Connection conn = DBUtils.getConn()){
           String sql = "select id,title,created from announcement";
           Statement s = conn.createStatement();
           ResultSet rs = s.executeQuery(sql);
           while (rs.next()){
               int id= rs.getInt(1);
               String title = rs.getString(2);
               long create =  rs.getLong(3);
               list.add(new Announcement(id,title,create));
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        return list;
    }
}
