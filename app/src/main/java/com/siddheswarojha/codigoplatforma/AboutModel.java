package com.siddheswarojha.codigoplatforma;

public class AboutModel {
    String Name;

    public AboutModel(String name, String github, String img) {
        Name = name;
        Github = github;
        this.img = img;
    }

    public AboutModel() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGithub() {
        return Github;
    }

    public void setGithub(String github) {
        Github = github;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    String Github;
    String img;
}
