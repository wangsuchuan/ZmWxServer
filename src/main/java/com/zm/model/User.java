package com.zm.model;

import java.io.Serializable;

/**
 * Created by wangchuan on 19/1/21.
 */
public class User implements Serializable{

    private static final long serialVersionUID = -6703020646177098331L;
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
