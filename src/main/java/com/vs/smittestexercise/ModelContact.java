package com.vs.smittestexercise;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class ModelContact implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "contact_name")
    private String contact_name;

    @Column(name = "contact_keyword")
    private String contact_keyword;

    @Column(name = "contact_phonenumber")
    private String contact_phonenumber;

    protected ModelContact() {
    }

    public long getId() {
        return id;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_keyword() {
        return contact_keyword;
    }

    public void setContact_keyword(String contact_keyword) {
        this.contact_keyword = contact_keyword;
    }

    public String getContact_phonenumber() {
        return contact_phonenumber;
    }

    public void setContact_phonenumber(String contact_phonenumber) {
        this.contact_phonenumber = contact_phonenumber;
    }

    @Override
    public String toString() {
        return " Contact [id = " + id + ", contact_name = " + contact_name + ", contact_keyword = " + contact_keyword + ", contact_phonenumber = " + contact_phonenumber + "] ";
    }

}
