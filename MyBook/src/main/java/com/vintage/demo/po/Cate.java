package com.vintage.demo.po;

public class Cate {
    private Integer id;
    private String category;

    @Override
    public String toString() {
        return "Cate{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }
}
