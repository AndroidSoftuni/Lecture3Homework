package homework.softuni.lecture3homework.entities;

import java.io.Serializable;

public class News implements Serializable{

    private String newsTitle;
    private String newsContent;
    private String newsSubtitle;

    public News() {
    }

    public News(String newsTitle, String newsSubtitle, String newsContent) {
        this.newsTitle    = newsTitle;
        this.newsContent  = newsContent;
        this.newsSubtitle = newsSubtitle;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsSubtitle() {
        return newsSubtitle;
    }

    public void setNewsSubtitle(String newsSubtitle) {
        this.newsSubtitle = newsSubtitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
}
