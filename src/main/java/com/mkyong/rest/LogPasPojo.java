package com.mkyong.rest;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name="USER_DETAILS")
public class LogPasPojo {


    @Id @GeneratedValue

    private int userId;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private String login;
    private String pass; //it will store answer message or cancel message




}
