package com.yegol.museum.dao;

import com.yegol.museum.entity.Category;
import com.yegol.museum.entity.ColCategory;
import com.yegol.museum.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ColCategoryDao {

    public List<ColCategory> findAll() {
        List<ColCategory> list = new ArrayList<>();
        //获取连接
        try(Connection conn = DBUtils.getConn()){
            String sql = "select * from colcategory";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                list.add(new ColCategory(id,name));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
