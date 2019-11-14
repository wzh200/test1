package com.vintage.demo.po;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable {
    //当前页
    private long total;
    //当前页记录
    private List rows;

    public PageBean(long total, List result) {
        this.total = total;
        this.rows = result;
    }

    @Override
    public String toString() {
        return "Page{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public List getRows() {
        return rows;
    }
}
