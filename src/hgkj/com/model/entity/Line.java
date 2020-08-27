package hgkj.com.model.entity;

import java.io.Serializable;

public class Line implements Serializable {
    private String lineID;
     private String lineTypeID;
    private String lineName;
     private  String days;
    private String vehicle;
    private String introduction;
    private String reason;
     private String arrange;
    private double price;
     private int teamBuy;
    private double teamBuyPrice;
    private String  beginTime;
    private  String endTime;
    private  String onTime;
    private Picture picture;

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getLineID() {
        return lineID;
    }

    public void setLineID(String lineID) {
        this.lineID = lineID;
    }

    public String getLineTypeID() {
        return lineTypeID;
    }

    public void setLineTypeID(String lineTypeID) {
        this.lineTypeID = lineTypeID;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getArrange() {
        return arrange;
    }

    public void setArrange(String arrange) {
        this.arrange = arrange;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTeamBuy() {
        return teamBuy;
    }

    public void setTeamBuy(int teamBuy) {
        this.teamBuy = teamBuy;
    }

    public double getTeamBuyPrice() {
        return teamBuyPrice;
    }

    public void setTeamBuyPrice(double teamBuyPrice) {
        this.teamBuyPrice = teamBuyPrice;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOnTime() {
        return onTime;
    }

    public void setOnTime(String onTime) {
        this.onTime = onTime;
    }
}
