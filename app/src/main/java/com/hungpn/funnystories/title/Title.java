package com.hungpn.funnystories.title;

public class Title {
    private String name;
    private int id;
    private int idStory;


    public Title(String name, int id,int idStory) {
        this.name = name;
        this.id = id;
        this.idStory = idStory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdStory() {
        return idStory;
    }

    public void setIdStory(int idStory) {
        this.idStory = idStory;
    }
}
