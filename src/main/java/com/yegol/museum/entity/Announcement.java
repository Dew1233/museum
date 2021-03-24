package com.yegol.museum.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Announcement {
    private int id;
    private String title;
    private String resource;
    private String acontent;
    private int viewCount;
    private String url;
    private long created;
    private int categoryId;

    public String getCreatedStr(){
//        创建日期格式化对象
        SimpleDateFormat f =
                new SimpleDateFormat("yyyy-MM-dd");
//        发布通知时间戳转换为日期对象
        Date date = new Date(this.created);
        return f.format(date);
    }
    public Announcement() {
    }

    public Announcement(int id, String title, long created) {
        this.id = id;
        this.title = title;
        this.created = created;
    }

    public Announcement(int id, String title, String resource, String acontent, int viewCount, String url, long created, int categoryId) {
        this.id = id;
        this.title = title;
        this.resource = resource;
        this.acontent = acontent;
        this.viewCount = viewCount;
        this.url = url;
        this.created = created;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAcontent() {
        return acontent;
    }

    public void setAcontent(String acontent) {
        this.acontent = acontent;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", resource='" + resource + '\'' +
                ", acontent='" + acontent + '\'' +
                ", viewCount=" + viewCount +
                ", url='" + url + '\'' +
                ", created=" + created +
                ", categoryId=" + categoryId +
                '}';
    }
}
