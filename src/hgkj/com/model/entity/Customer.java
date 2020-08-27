package hgkj.com.model.entity;

public class Customer {
   private int customerID;
   private String account;
   private String name;
    private String   password;
    private String gender;
    private String   identityID;
    private  String tel;
    private int   type;

    public Customer() {
    }



    public Customer(String account, String name, String password, String gender, String identityID, String tel) {
        this.account = account;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.identityID = identityID;
        this.tel = tel;
    }

    public Customer(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentityID() {
        return identityID;
    }

    public void setIdentityID(String identityID) {
        this.identityID = identityID;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
