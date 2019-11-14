package com.vintage.demo.po;

public class Book {
    private Integer id;
    private Integer categoryId;
    private String bname;
    private String cname;
    private String picture;

    @Override
    public String toString() {
        return "Cate{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", bname='" + bname + '\'' +
                ", cname='" + cname + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getBname() {
        return bname;
    }

    public String getCname() {
        return cname;
    }

    public String getPicture() {
        return picture;
    }
}
