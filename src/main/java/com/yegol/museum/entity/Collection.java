package com.yegol.museum.entity;

public class Collection {
    private int id;
    private String title;
    private String resource;
    private String acontent;
    private int viewCount;
    private String url;
    private long created;
    private int collectionId;

    public Collection() {
    }

    public Collection(int id, String title, String resource, String acontent, int viewCount, String url, long created, int collectionId) {

        this.id = id;
        this.title = title;
        this.resource = resource;
        this.acontent = acontent;
        this.viewCount = viewCount;
        this.url = url;
        this.created = created;
        this.collectionId = collectionId;
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

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    @Override
    public String  toString() {
        return "Collection{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", resource='" + resource + '\'' +
                ", acontent='" + acontent + '\'' +
                ", viewCount=" + viewCount +
                ", url='" + url + '\'' +
                ", created=" + created +
                ", collectionId=" + collectionId +
                '}';
    }
}
