package com.yegol.museum.dao;


import com.yegol.museum.entity.Announcement;
import com.yegol.museum.entity.Collection;
import com.yegol.museum.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CollectionDao {
    public void insert(Collection a) {
        //获取连接
        try(Connection conn = DBUtils.getConn()){
            String sql = "insert into collection values(null,?,?,?,0,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,a.getTitle());
            ps.setString(2,a.getResource());
            ps.setString(3,a.getAcontent());
            ps.setLong(4,a.getCreated());
            ps.setString(5,a.getUrl());
            ps.setInt(6,a.getCollectionId());
            ps.executeUpdate();
            System.out.println("发布完成");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
