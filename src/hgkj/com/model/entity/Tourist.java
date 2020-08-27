package hgkj.com.model.entity;

import java.io.Serializable;

public class Tourist implements Serializable {
    private String touristID;
    private String IDCard;
    private  String tel;
    private String  realName;

    public Tourist() {
    }

    public Tourist(String IDCard, String tel, String realName) {
        this.IDCard = IDCard;
        this.tel = tel;
        this.realName = realName;
    }

    public String getTouristID() {
        return touristID;
    }

    public void setTouristID(String touristID) {
        this.touristID = touristID;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
