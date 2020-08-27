package hgkj.com.model.entity;

import java.io.Serializable;

public class Picture implements Serializable {
    private  int pictureID;
    private  String picintroduction;
    private String name;
    private String lineID;

    public Picture() {
    }

    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
        this.pictureID = pictureID;
    }

    public String getPicintroduction() {
        return picintroduction;
    }

    public void setPicintroduction(String picintroduction) {
        this.picintroduction = picintroduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLineID() {
        return lineID;
    }

    public void setLineID(String lineID) {
        this.lineID = lineID;
    }
}
