package com.quangcao.bai4.Delete;

import com.google.gson.annotations.SerializedName;

public class ProductDelete {
    private String pid;

    public ProductDelete() {
    }

    public ProductDelete(String pid) {
        this.pid = pid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
