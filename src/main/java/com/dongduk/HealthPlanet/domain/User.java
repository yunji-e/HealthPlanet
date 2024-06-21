package com.dongduk.HealthPlanet.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
    private int id;

    private String custid;
    private String custpw;
    private String custname;
    private String phone;

    public User() {
    }

    public User(String custid, String custpw, String custname, String phone) {
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


