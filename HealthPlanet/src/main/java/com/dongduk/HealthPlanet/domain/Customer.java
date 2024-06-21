package com.dongduk.HealthPlanet.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="CUSTOMER")
@Getter @Setter
public class Customer implements Serializable {
    @Id
//    @SequenceGenerator(name="USER_SEQ_GENERATOR",
//    sequenceName="USER_SEQUENCE", initialValue=100, allocationSize=10)
//    @GeneratedValue(strategy=GenerationType.SEQUENCE,
//    generator="USER_SEQ_GENERATOR")
    private int id;
    private String custid;
    private String custpw;
    private String custname;
    private String phone;
    
    public Customer() {}
    
    public Customer(int id, String custid, String custpw, String custname, String phone) {
        super();
        this.id = id;
        this.custid = custid;
        this.custpw = custpw;
        this.custname = custname;
        this.phone = phone;
    }

}