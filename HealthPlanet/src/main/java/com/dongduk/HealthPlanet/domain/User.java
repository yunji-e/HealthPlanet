package com.dongduk.HealthPlanet.domain;

public class User {
    private int id;
    private String custid;
    private String custpw;
    private String custname;
    private String phone;
    
    public User() {}
    
    public User(int id, String custid, String custpw, String custname, String phone) {
        super();
        this.id = id;
        this.custid = custid;
        this.custpw = custpw;
        this.custname = custname;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getCustpw() {
        return custpw;
    }

    public void setCustpw(String custpw) {
        this.custpw = custpw;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
