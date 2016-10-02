package homework.softuni.lecture3homework.entities;

import java.io.Serializable;

public class BlizzardGame implements Serializable{

    private int    yearOfRelease;
    private String title;
    private String type;

    public BlizzardGame(String title, int yearOfRelease, String type) {
        this.type          = type;
        this.title         = title;
        this.yearOfRelease = yearOfRelease;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
