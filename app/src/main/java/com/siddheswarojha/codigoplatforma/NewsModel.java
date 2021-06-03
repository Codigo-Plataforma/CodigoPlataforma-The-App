package com.siddheswarojha.codigoplatforma;

public class NewsModel {
    String news,pic,date;

    public NewsModel() {
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NewsModel(String news, String pic, String date) {
        this.news = news;
        this.pic = pic;
        this.date = date;
    }
}
