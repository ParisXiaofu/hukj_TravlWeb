package hgkj.com.model.entity;

import java.io.Serializable;

public class Orderdetail implements Serializable {
    private  String odID;
    private int customerID;
    private String  lineNames;
     private double prices;
    private  String orderDate;
    private  String travelDate;
    private double total;
    private String lineID;
    private int touristID;
    private Line line;
    private Picture picture;
    private Customer customer;

    public Orderdetail() {
    }

    public Orderdetail( int customerID, String lineNames, double prices, String orderDate, String travelDate, double total, String lineID, int touristID) {
        this.customerID = customerID;
        this.lineNames = lineNames;
        this.prices = prices;
        this.orderDate = orderDate;
        this.travelDate = travelDate;
        this.total = total;
        this.lineID = lineID;
        this.touristID = touristID;
    }

    public Orderdetail(String odID, String lineNames, String orderDate, double total) {
        this.odID = odID;
        this.lineNames = lineNames;
        this.orderDate = orderDate;
        this.total = total;
    }

    public Orderdetail(String odID, int customerID, String lineNames, double prices, String orderDate, String travelDate, double total, String lineID, Line line, Picture picture, Customer customer) {
        this.odID = odID;
        this.customerID = customerID;
        this.lineNames = lineNames;
        this.prices = prices;
        this.orderDate = orderDate;
        this.travelDate = travelDate;
        this.total = total;
        this.lineID = lineID;
        this.line = line;
        this.picture = picture;
        this.customer = customer;
    }

    public int getTouristID() {
        return touristID;
    }

    public void setTouristID(int touristID) {
        this.touristID = touristID;
    }

    public String getOdID() {
        return odID;
    }

    public void setOdID(String odID) {
        this.odID = odID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getLineNames() {
        return lineNames;
    }

    public void setLineNames(String lineNames) {
        this.lineNames = lineNames;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getLineID() {
        return lineID;
    }

    public void setLineID(String lineID) {
        this.lineID = lineID;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
